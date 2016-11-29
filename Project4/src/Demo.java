import LinkedList.SortedDoublyLinkedList;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A demo of SortedDoublyLinkedList using Person and Student objects
 *
 * @author David Luo
 */
public class Demo {


    public static void main(String[] args) {

        // Random data to test with
        Student benson = new Student("Benson", "Chau", 1, convertToDate(3, 13, 1978), "UGA");
        Student frank = new Student("Frank", "Smith", 2, convertToDate(1, 1, 2842), "Harvard");
        Student hawking = new Student("Stephen", "Hawking", 3, convertToDate(3, 2, 2981), "MIT");

        Person grandpa = new Person("Kyle", "Grandpa", 238, convertToDate(1, 1, 1997));
        Person rick = new Person("Rick", "Astley", 3841, convertToDate(2, 6, 1966));

        // Regular unsorted arrays for convenience.
        Person[] peopleArr = {
                grandpa, rick, benson, frank, hawking
        };
        Student[] studentsArr = {
                benson, hawking, frank
        };

        Person[] onlyPeopleArr = {
                grandpa, rick
        };
        Student[] onlyStudentsArr = {
                benson, frank, hawking
        };
        // Arbitrary scope
        {
            // studentList is a prefix of personList when sorted by ID
            SortedDoublyLinkedList<Person> peopleList = new SortedDoublyLinkedList<>();
            SortedDoublyLinkedList<Student> studentList = new SortedDoublyLinkedList<>();

            // Add data to lists
            System.out.println("Unordered People");
            fromArrayToList(peopleArr, peopleList);

            System.out.println("Unordered Students");
            fromArrayToList(studentsArr, studentList);

            // Testing rejection of duplicates and null objects
            System.out.println("Attempting to add duplicate entry: " + benson.toString());
            System.out.println("Succeeded?");
            System.out.println(peopleList.add(benson));

            System.out.println("Attempting to add null entry");
            System.out.println("Succeeded?");
            System.out.println(peopleList.add(null));

            // Test printList()
            System.out.println("People");
            peopleList.printList();
            System.out.println("Students");
            studentList.printList();

            // Test prefix
            System.out.println("Students prefix of People?");
            System.out.println(studentList.isPrefix(peopleList));
        }
        {
            SortedDoublyLinkedList<Student> onlyStudents = new SortedDoublyLinkedList<>();
            SortedDoublyLinkedList<Person> onlyPeople = new SortedDoublyLinkedList<>();

            fromArrayToList(onlyStudentsArr, onlyStudents);
            fromArrayToList(onlyPeopleArr, onlyPeople);

            // Test merge
            System.out.println("Just People");
            onlyPeople.printList();
            System.out.println("Just Students");
            onlyStudents.printList();

            SortedDoublyLinkedList<Person> merged = onlyPeople.merge(onlyStudents);

            System.out.println("Merged");
            merged.printList();
        }
        {
            SortedDoublyLinkedList<Person> allPeople = new SortedDoublyLinkedList<>();

            fromArrayToList(peopleArr, allPeople);

            Person bob = new Person("Bob", "Joe", 1254, convertToDate(1, 1, 3829));

            //Testing adding
            System.out.println("A list:");
            allPeople.printList();
            System.out.println("Adding Bob");
            allPeople.add(bob);
            System.out.println("The List again:");
            allPeople.printList();

            //Testing indexOf
            System.out.println("Getting index of Bob");
            System.out.println(allPeople.indexOf(bob));

            //Testing removing
            System.out.println("Removing Bob");
            allPeople.remove(bob);
            System.out.println("The List again:");
            allPeople.printList();

            //Testing Size
            System.out.println("Size of list: ");
            System.out.println(allPeople.size());

            //Testing get
            System.out.println("Getting by index...");
            for (int i = 0; i < allPeople.size(); i++) {
                System.out.println("Index: " + i);
                System.out.println(allPeople.get(i).toString());
            }

            //Testing isEmpty
            System.out.println("Is list empty?");
            System.out.println(allPeople.isEmpty());
            System.out.println("Removing everything in list.");
            for (Person p : allPeople) {
                System.out.println("Removing: " + p.toString());
                allPeople.remove(p);
            }
            System.out.println("The list:");
            allPeople.printList();
            System.out.println("Is list empty?");
            System.out.println(allPeople.isEmpty());
        }

        System.out.println("Demo finished.");
    }


    //Helper method
    public static void fromArrayToList(Object[] arr, SortedDoublyLinkedList list) {
        for (Object obj : arr) {
            try {
                if (!list.add((Comparable) obj)) {
                    System.out.println("Failed to add: " + obj.toString());
                }
            } catch (Exception e) {
                return;
            }
        }
    }

    // This is probably ugly.
    private static Date convertToDate(int month, int day, int year) {
        String date = String.format("%02d-%02d-%04d", month, day, year);

        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
}
