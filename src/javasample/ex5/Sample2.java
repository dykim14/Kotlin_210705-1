package javasample.ex5;

class Person {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    // "Backing Field"가 없는 접근자 메소드
    public String getFullName() {
        return firstName + ", " + lastName;
    }

    public void setFullName(String fullName) {
        String[] arr = fullName.split(", ");
        firstName = arr[0];
        lastName = arr[1];
    }
}


public class Sample2 {
    public static void main(String[] args) {
        Person person = new Person("Gildong", "Hong");
        System.out.println(person.getFullName());
    }
}
