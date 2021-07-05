package javasample.ex3;

// User.java
// public class User

// Object.equals에 대한 재정의를 통해 객체 동등성 판단을 수행할 수 있습니다.
class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        // 1. 참조 동등성 판단
        if (this == obj) {
            return true;
        }

        // 2. null 객체는 동등성이 판단될 수 없습니다.
        if (obj == null) {
            return false;
        }

        // 3. obj 객체가 User 객체인지 판단해야 합니다.
        // 1) instanceOf
        //    - User 객체의 자식 클래스도 허용한다.
        if (!(obj instanceof User)) {
            return false;
        }
        // 2) class 비교
        //    - User 객체의 자식 클래스는 허용하지 않는다.
        /*
        if (obj.getClass() != User.class) {
            return false;
        }
        */

        // 4. obj를 User 객체 타입으로 캐스팅해야 합니다.
        User other = (User) obj;

        // 5. 동등성 판단을 수행하면 됩니다.
        return name.equals(other.name) && age == other.age;
    }
}


public class Sample {
    public static void main(String[] args) {
        User user1 = new User("Tom", 42);
        User user2 = new User("Tom", 42);
        // User user2 = user1;

        if (user1 == user2) {
            System.out.println("참조 동등합니다.");
        } else {
            System.out.println("참조 동등하지 않습니다.");
        }

        // 객체 동등성 판단을 위해서는, equals에 대한 정의가 필요합니다.
        if (user1.equals(user2)) {
            System.out.println("객체 동등합니다.");
        } else {
            System.out.println("객체 동등하지 않습니다.");
        }
    }
}
