package javasample.ex3;

// 자바에서 생성자의 인자가 많을 경우, 객체를 생성하는 방법
// 1. Telescoping Constructor Pattern - Java's Idiom
//  : 생성자의 오버로딩을 통해 다양한 객체 초기화 방법을 제공합니다.

/*
class Person {
    private String name;
    private String address;
    private String phone;
    private int age;

    public Person(String name, String address, String phone, int age) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.age = age;
    }

    public Person(String name, String address, String phone) {
        this(name, address, phone, 0);
    }

    public Person(String name, String address) {
        this(name, address, null, 0);
    }

    public Person(String name) {
        this(name, null, null, 0);
    }
}


public class Sample2 {
    public static void main(String[] args) {
        String a = "Tom";
        String b = "Suwon";
        String c = "000-1111-2222";
        int d = 10;

        Person p1 = new Person("Tom", b, c, d);
        Person p2 = new Person(a, c, b);
    }
}
*/

// 2. Builder Pattern - Design Pattern

class Person {
    private String name;
    private String address;
    private String phone;
    private int age;

    private Person(Builder b) {
        this.name = b.name;
        this.address = b.address;
        this.phone = b.phone;
        this.age = b.age;
    }

    public static class Builder {
        private String name;
        private String address;
        private String phone;
        private int age;

        public Builder(String name) {
            this.name = name;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}

// Effective Java
// : 생성자의 인자가 많을 경우 빌더를 고려해라

public class Sample2 {
    public static void main(String[] args) {
        String a = "Tom";
        String b = "Suwon";
        String c = "000-1111-2222";
        int d = 10;

        // Person p1 = new Person("Tom", b, c, d);
        // Person p2 = new Person(a, c, b);

        Person person = new Person.Builder(a)
                .setAddress(b)
                .setPhone(c)
                .setAge(d)
                .build();
    }
}