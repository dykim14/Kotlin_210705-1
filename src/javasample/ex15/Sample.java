package javasample.ex15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);

        // Java Immutable Collection
        // => Runtime
        //   : Decorator Pattern
        list = Collections.unmodifiableList(list);

        // UnsupportedOperationException
        // list.add(100);
        //  : 런타임에 문제가 발생합니다.

        for (Integer e : list) {
            System.out.println(e);
        }
    }
}
