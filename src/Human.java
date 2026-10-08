import java.util.*;


public class Human implements Comparable<Human>{
    private String firstname;
    private String lastname;
    private int age;

    public Human(String firstname, String lastname, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo (Human other) {
        int result = this.lastname.compareTo(other.lastname);
        if (result != 0) return result;

        result = this.firstname.compareTo(other.firstname);
        if (result != 0) return result;

        return Integer.compare(this.age, other.age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return age == human.age &&
                Objects.equals(firstname, human.firstname) &&
                Objects.equals(lastname, human.lastname);
    }

    /**
     * hashCode должен быть согласован с equals.
     */
    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, age);
    }

    @Override
    public String toString() {
        return String.format("%-10s %-10s %2d", firstname, lastname, age);
    }


}
