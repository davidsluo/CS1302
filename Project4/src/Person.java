import java.util.Calendar;
import java.util.Date;

/**
 * Created by David on 11/21/2016.
 */
public class Person implements Comparable<Person>{

    private String   firstName;
    private String   lastName;
    private int      id;
    private Date birthDate;

    public Person(String firstName, String lastName, int id, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;

        try {
            assert id < 10000;
            assert id > -1;
            this.id = id;
        } catch (AssertionError e) {
            throw new IllegalArgumentException("ID must be 4 digits.");
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return String.format(
                "%1$04d %2$s %3$s %4$tm-%4$td-%4$tY",
                getId(), getFirstName(), getLastName(), getBirthDate());
    }

    /**
     * @param other
     * @return 0 if equal
     *         1 if this ID > other ID
     *         -1 if this ID < other ID
     */
    @Override
    public int compareTo(Person other) {
        return Integer.compare(this.getId(), other.getId());
    }

    @Override
    public boolean equals(Object other) {
        try {
            return 0 == compareTo((Person) other);
        } catch (Exception e) {
            return false;
        }
    }
}
