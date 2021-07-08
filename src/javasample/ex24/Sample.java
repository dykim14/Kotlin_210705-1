package javasample.ex24;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

// > 비메모리 자원(파일 등)에 대해서는 명시적인 종료 메소드를 호출해야 합니다.

// 사용자가 작성한 클래스가 비메모리 자원을 이용하고 있다면,
// 명시적인 종료 메소드를 제공해야 한다.

// Try with resources 문법은 AutoCloseable 인터페이스를 구현해야 합니다.
class MyResource implements AutoCloseable {
    public MyResource() {
        System.out.println("자원 할당");
    }

    @Override
    public void close() {
        System.out.println("자원 해지");
    }

    public void process() {
        System.out.println("자원 사용");
    }
}


public class Sample {

    public static void main(String[] args) {

        try (FileOutputStream fos = new FileOutputStream("a.txt");
             BufferedOutputStream bos = new BufferedOutputStream(fos);
             DataOutputStream dos = new DataOutputStream(bos)) {

            dos.writeInt(42);
            dos.writeUTF("Hello");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /*
    public static void main(String[] args) {
        try (MyResource resource = new MyResource()) {
            resource.process();
        }
    }
    */


    /*
    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("a.txt");
        fos.write(42);

        fos.close();
    }
    */

    // Java 7 - Try with Resources
    /*
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("a.txt")) {
            fos.write(42);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    */

    /*
    public static void main(String[] args) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("a.txt");
            fos.write(42);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 예외와 상관없이 무조건 호출되어야 합니다.
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    */
}
