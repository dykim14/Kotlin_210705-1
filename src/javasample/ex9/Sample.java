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

/*
class Cursor {
    private static Cursor sInstance = null;

    private Cursor() {
    }

    // > 여러 개의 스레드에서 동시에 getInstance가 수행될 경우,
    //   문제가 발생할 수 있습니다.
    //   => 지연 초기화 방식은 스레드 안전성을 고려해야 합니다.

    public static Cursor getInstance() {
        synchronized (Cursor.class) {
            if (sInstance == null) {
                sInstance = new Cursor();
            }
        }
        return sInstance;
    }


    // > 동기화 블록은 첫 생성 시점에 대해서만 필요합니다.
    //   이후에 참조에 대해서 매번 동기화가 수행되므로, 전체적인 프로그램의
    //   성능에 악영향을 미칠 수 있습니다.
    //   => DCLP(Double Checked Locking Pattern)
    //    : 처음 생성 시점에 대해서만 동기화 블록을 수행한다.
    public static Cursor getInstance() {
        if (sInstance == null) {
            synchronized (Cursor.class) {
                if (sInstance == null) {
                    sInstance = new Cursor();
                }
            }
        }
        return sInstance;
    }
}
*/

// > 코드가 선언적이지 않다.
//   IODH(Initialization-on-demand holder) idiom
//   : 자바에서 가장 많이 사용하는 싱글톤
//
//   JLS(자바 언어 명세)
//  1) static final 필드에 대한 초기화는 스레드 안전성을 보장합니다.
//  2) 중첩 클래스의 정적 필드는 처음 접근되는 시점에 초기화가 수행됩니다.
class Cursor {
    private static class Singleton {
        private static final Cursor INSTANCE = new Cursor();
    }

    private Cursor() {
    }

    public static Cursor getInstance() {
        return Singleton.INSTANCE;
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
