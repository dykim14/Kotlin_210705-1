package javasample.ex9;

class Cursor {
    // 2. 1개의 객체 - 정적 필드
    private static final Cursor INSTANCE = new Cursor();

    // 1. private 생성자
    private Cursor() {
    }

    // 3. 동일한 방법을 통한 접근 메소드
    public static Cursor getInstance() {
        return INSTANCE;
    }
}

public class Sample {
    public static void main(String[] args) {
        Cursor c1 = Cursor.getInstance();
        Cursor c2 = Cursor.getInstance();

        System.out.println(c1);
        System.out.println(c2);
    }
}
