import java.util.LinkedList;
import java.util.Iterator;
import java.util.ListIterator;
public class LinkedlistDemo {
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.add("C");
		linkedList.add("A");
		linkedList.add("E");
		linkedList.add("D");
		linkedList.add("F");
		linkedList.add(new Integer(101));
		linkedList.add(null);
		linkedList.add("A");
		System.out.println(linkedList);
		
		linkedList.add(3, "B");
		System.out.println(linkedList);
		
		String s1 = (String) linkedList.get(3);
		System.out.println("sdf  " + s1);
		
		linkedList.remove("F");
		System.out.println(linkedList);
		
		linkedList.remove(1);
		System.out.println(linkedList);
		//using iterator
		System.out.print("1.Iterator: ");
        Iterator<Object> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            Object e = iterator.next();
            System.out.print(e + " ");
        }
        System.out.println();
        System.out.println("------------------------------------");
        //using list iterator
        System.out.print("2.ListIterator forward: "); // Renumbered from 3 to 2
        ListIterator<Object> listIterator = linkedList.listIterator();
        while (listIterator.hasNext()) {
            Object e = listIterator.next();
            System.out.print(e + " ");
        }
        System.out.println();
        System.out.println("------------------------------------");
 
        System.out.print("3.ListIterator backward: "); // Renumbered from 4 to 3
        // The listIterator is now at the end of the list after the forward iteration,
        // so we can immediately start iterating backward.
        while (listIterator.hasPrevious()) {
            Object e = listIterator.previous();
            System.out.print(e + " ");
        }
        System.out.println();
        System.out.println("------------------------------------");
    }
	
}