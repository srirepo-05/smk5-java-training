package com.example.employeemanagement.controller;

import com.example.employeemanagement.dto.EmployeeRequestDTO;
import com.example.employeemanagement.dto.EmployeeResponseDTO;
import com.example.employeemanagement.dto.RaiseSalaryDTO;
import com.example.employeemanagement.exception.NoEmployeesException;
import com.example.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

/**
 * EmployeeWebController - Handles all Thymeleaf web page requests.
 *
 * This controller renders HTML pages (views) using Thymeleaf templates.
 * It is separate from the REST API controller so both can coexist.
 *
 * Pages handled:
 * - GET  /login           -> Login page
 * - GET  /employees       -> All employees list
 * - GET  /employees/new   -> Create employee form
 * - POST /employees/new   -> Submit create employee form
 * - GET  /employees/raise/{id} -> Raise salary form
 * - POST /employees/raise/{id} -> Submit raise salary form
 */
@Controller
public class EmployeeWebController {

    // Injecting the service layer for business logic
    @Autowired
    private EmployeeService employeeService;

    // =========================================================
    // ROOT REDIRECT
    // =========================================================

    /**
     * GET /
     *
     * Redirects the root URL to the employees list page.
     *
     * @return redirect to /employees
     */
    @GetMapping("/")
    public String root() {
        return "redirect:/employees";
    }

    // =========================================================
    // LOGIN PAGE
    // =========================================================

    /**
     * GET /login
     *
     * Displays the custom login page.
     * Spring Security automatically handles form submission to this URL.
     *
     * @return the name of the Thymeleaf template (login.html)
     */
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    // =========================================================
    // EMPLOYEES LIST PAGE
    // =========================================================

    /**
     * GET /employees
     *
     * Displays a table of all employees.
     * If no employees exist, passes an info message to the view instead.
     *
     * @param model - Spring MVC model used to pass data to the template
     * @return the name of the Thymeleaf template (employees.html)
     */
    @GetMapping("/employees")
    public String listAllEmployees(Model model) {
        try {
            List<EmployeeResponseDTO> employees = employeeService.getAllEmployees();
            model.addAttribute("employees", employees);
        } catch (NoEmployeesException e) {
            // No employees yet — pass an empty list and a message
            model.addAttribute("employees", List.of());
            model.addAttribute("noEmployeesMessage", "No employees found. Create one to get started!");
        }
        return "employees";
    }

    // =========================================================
    // CREATE EMPLOYEE FORM
    // =========================================================

    /**
     * GET /employees/new
     *
     * Displays the Create Employee form.
     * Adds a blank EmployeeRequestDTO to the model so Thymeleaf can bind form fields.
     *
     * @param model - Spring MVC model
     * @return the name of the Thymeleaf template (create-employee.html)
     */
    @GetMapping("/employees/new")
    public String showCreateEmployeeForm(Model model) {
        model.addAttribute("employeeRequest", new EmployeeRequestDTO());
        return "create-employee";
    }

    /**
     * POST /employees/new
     *
     * Handles the Create Employee form submission.
     * Calls the service to validate and save the employee.
     * On success: redirects to /employees with a success flash message.
     * On error:   re-renders the form with the error message.
     *
     * @param requestDTO         - the form data bound to EmployeeRequestDTO
     * @param redirectAttributes - used to pass flash messages across redirects
     * @param model              - used to pass error messages back to the form
     * @return redirect to /employees on success, or re-renders form on error
     */
    @PostMapping("/employees/new")
    public String createEmployee(@ModelAttribute("employeeRequest") EmployeeRequestDTO requestDTO,
                                 RedirectAttributes redirectAttributes,
                                 Model model) {
        try {
            EmployeeResponseDTO created = employeeService.createEmployee(requestDTO);
            redirectAttributes.addFlashAttribute("successMessage",
                "Employee \"" + created.getName() + "\" created successfully with salary ₹" + created.getSalary() + "!");
            return "redirect:/employees";
        } catch (Exception e) {
            // Pass the error back to the form so the user sees what went wrong
            model.addAttribute("errorMessage", e.getMessage());
            return "create-employee";
        }
    }

    // =========================================================
    // RAISE SALARY FORM
    // =========================================================

    /**
     * GET /employees/raise/{id}
     *
     * Displays the Raise Salary form for the given employee ID.
     * Fetches the employee's current details to show on the form.
     *
     * @param id    - the employee ID from the URL path
     * @param model - Spring MVC model
     * @return the name of the Thymeleaf template (raise-salary.html)
     */
    @GetMapping("/employees/raise/{id}")
    public String showRaiseSalaryForm(@PathVariable Long id, Model model) {
        try {
            // Fetch employee details to display on the form
            List<EmployeeResponseDTO> employees = employeeService.getAllEmployees();
            EmployeeResponseDTO employee = employees.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NoEmployeesException("Employee with ID " + id + " not found!"));

            model.addAttribute("employee", employee);
            model.addAttribute("raiseSalaryRequest", new RaiseSalaryDTO());
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
        }
        return "raise-salary";
    }

    /**
     * POST /employees/raise/{id}
     *
     * Handles the Raise Salary form submission.
     * Calls the service to validate and apply the salary raise.
     * On success: redirects to /employees with a success flash message.
     * On error:   re-renders the raise salary form with the error message.
     *
     * @param id                 - the employee ID from the URL path
     * @param raiseSalaryDTO     - the form data bound to RaiseSalaryDTO
     * @param redirectAttributes - used to pass flash messages across redirects
     * @param model              - used to pass error messages back to the form
     * @return redirect to /employees on success, or re-renders form on error
     */
    @PostMapping("/employees/raise/{id}")
    public String raiseSalary(@PathVariable Long id,
                              @ModelAttribute("raiseSalaryRequest") RaiseSalaryDTO raiseSalaryDTO,
                              RedirectAttributes redirectAttributes,
                              Model model) {
        try {
            Map<String, Object> result = employeeService.raiseSalary(id, raiseSalaryDTO);
            redirectAttributes.addFlashAttribute("successMessage",
                "Salary raised for \"" + result.get("name") + "\"! " +
                "New salary: ₹" + result.get("newSalary") +
                " (+" + result.get("raisePercentage") + "%)");
            return "redirect:/employees";
        } catch (Exception e) {
            // Re-fetch employee info to re-populate the form
            try {
                List<EmployeeResponseDTO> employees = employeeService.getAllEmployees();
                EmployeeResponseDTO employee = employees.stream()
                    .filter(emp -> emp.getId().equals(id))
                    .findFirst()
                    .orElse(null);
                model.addAttribute("employee", employee);
            } catch (Exception ignored) {}

            model.addAttribute("raiseSalaryRequest", raiseSalaryDTO);
            model.addAttribute("errorMessage", e.getMessage());
            return "raise-salary";
        }
    }
}
