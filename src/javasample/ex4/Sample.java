package javasample.ex4;

class User {
    protected String name;
}
// public class User: 외부에서 접근 가능한 클래스
// class User: 같은 패키지 안에서만 사용할 수 있는 클래스


public class Sample {
    public static void main(String[] args) {
        User user = new User();
        user.name = "Tom";
    }
}
