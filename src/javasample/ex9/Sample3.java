package javasample.ex9;

// JSON(Javascript Object Notation)
// {
//    "name": "Tom",
//    "age": 42
// }

// Gson(Google Json Serialization / Deserialization)
//  User(name="Tom", age=42) <=> { "name": "Tom", "age": 42 }
//                      : Reflection
//                      => 클래스의 모든 정보를 조회할 수 있고,
//                         데이터를 변경하거나 읽을 수 있습니다.

import com.google.gson.Gson;

class User {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class Sample3 {
    public static void main(String[] args) {
        String json = "{ \"name\": \"Tom\", \"age\": 42 }";

        Gson gson = new Gson();
        User user = gson.fromJson(json, User.class);

        System.out.println(user);
    }
}
