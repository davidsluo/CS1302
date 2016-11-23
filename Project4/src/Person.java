import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;

/**
 * Created by David on 11/21/2016.
 */
public class Person implements Comparable<Person>{

    private String   firstName;
    private String   lastName;
    private int      id;
    private Calendar birthDate;

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

    public Calendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Calendar birthDate) {
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
}
