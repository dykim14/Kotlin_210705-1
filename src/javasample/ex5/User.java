package javasample.ex5;

// User.java
public class User {
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
        return name + ", Hello";
    }

    public int getAge() {
        return age;
    }

    // - setter
    private void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age + 1;
    }
}
