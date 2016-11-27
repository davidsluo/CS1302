import LinkedList.SortedDoublyLinkedList;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by David on 11/21/2016.
 */
public class Demo {


    public static void main(String[] args) {
        SortedDoublyLinkedList<Person> peopleList = new SortedDoublyLinkedList<>();
        SortedDoublyLinkedList<Student> studentList = new SortedDoublyLinkedList<>();

        Student benson = new Student("Benson", "Chau", 1289, convertToDate(3, 13, 1978), "UGA");
        Person grandpa = new Person("Kyle", "Grandpa", 3340, convertToDate(1, 1, 1997));
        Person rick = new Person("Rick", "Astley", 3841, convertToDate(2, 6, 1966));
        Student frank = new Student("Frank", "Smith", 283, convertToDate(1, 1, 2842), "Harvard");
        Student hawking = new Student("Stephen", "Hawking", 3822, convertToDate(3, 2, 2981), "MIT");

        Person[] people = {
                grandpa, rick, benson, frank, hawking
        };

        for (Person p : people) {
            boolean success = peopleList.add(p);
        }

        peopleList.printList();

    }

    // This is probably ugly.
    public static Date convertToDate(int month, int day, int year) {
        String date = String.format("%02d-%02d-%04d", month, day, year);

        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
}
