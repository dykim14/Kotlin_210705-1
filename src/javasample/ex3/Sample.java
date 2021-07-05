package javasample.ex3;

// User.java
// public class User
class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}


public class Sample {
    public static void main(String[] args) {
        User user1 = new User("Tom", 42);
        User user2 = new User("Tom", 42);

        if (user1 == user2) {
            System.out.println("참조 동등합니다.");
        } else {
            System.out.println("참조 동등하지 않습니다.");
        }


    }
}
