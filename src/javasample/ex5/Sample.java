package javasample.ex5;

/*
class User {
    // Backing Field: 저장하기 위한 메모리 공간을 할당하는 변수
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 접근자 메소드
    // - getter
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // - setter
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
*/


import ex5.User;  // Kotlin

public class Sample {
    public static void main(String[] args) {
        User user = new User("Tom", 42);
        String name = user.getName();
        int age = user.getAge();

        // user.setAge(10);
        user.setName("Bob");
    }
}
