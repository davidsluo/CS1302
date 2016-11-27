import LinkedList.SortedDoublyLinkedList;

import java.util.Date;

/**
 * Created by David on 11/21/2016.
 */
public class Demo {


    public static void main(String[] args) {

        SortedDoublyLinkedList<Person> list = new SortedDoublyLinkedList<>();

        Person[] people = {
                new Student("Benson", "Chau", 1289, new Date(System.currentTimeMillis()), "UGA"),
                new Person("Kyle", "Grandpa", 3340, new Date(System.currentTimeMillis())),
                new Person("Rick", "Astley", 3841, new Date(System.currentTimeMillis()))
        };

        for (Person p : people) {
            boolean success = list.add(p);
        }

        list.printList();


    }
}
