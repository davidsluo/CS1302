/**
 * Created by David on 11/21/2016.
 */
public class Student extends Person {
    private String collegeName;

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String toString() {
        return super.toString() + " [" + getCollegeName() + "]";
    }
}
