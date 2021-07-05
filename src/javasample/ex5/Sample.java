package javasample.ex5;


// import ex5.User;  // Kotlin

public class Sample {
    public static void main(String[] args) {
        User user = new User("Tom", 42);
        String name = user.getName();
        int age = user.getAge();

        // user.setAge(10);
        // user.setName("Bob");
    }
}
