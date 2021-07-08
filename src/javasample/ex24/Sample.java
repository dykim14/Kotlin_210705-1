package javasample.ex24;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// 비메모리 자원(파일 등)에 대해서는 명시적인 종료 메소드를 호출해야 합니다.

public class Sample {
    /*
    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("a.txt");
        fos.write(42);

        fos.close();
    }
    */

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
}
