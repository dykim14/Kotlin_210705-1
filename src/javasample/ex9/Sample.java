package javasample.ex9;

/*
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
*/
// > static final Cursor INSTANCE = new Cursor()
//  : 프로그램이 시작되는 시점에 초기화가 수행됩니다.
//    싱글톤의 생성 비용이 클 경우, 프로그램의 시작 속도에 악영향을 미칩니다.
//   ; 처음 접근되는 시점(getInstance)에 객체를 생성해야 합니다.
//    => Lazy Initialization(지연 초기화)

class Cursor {
    private static Cursor sInstance = null;

    private Cursor() {
    }

    public static Cursor getInstance() {
        if (sInstance == null) {
            sInstance = new Cursor();
        }
        return sInstance;
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
