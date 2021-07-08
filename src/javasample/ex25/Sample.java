package javasample.ex25;

// Iterator Pattern(반복자 패턴)
//   의도: 컬렉션의 내부 구조에 상관없이 요소를 열거할 수 있는 객체
//
//  약속된 인터페이스를 구현해야 합니다.
//   1) Iterator<E> : SListIterator<E>
//     boolean hasNext();
//         : 다음 요소가 존재하는지 여부를 확인한다.
//     E next();
//         : 현재 요소의 값을 반환하고, 다음 위치로 이동한다.

//   2) Iterable<E> : SList<E>
//      Iterator<T> iterator();
//        : 컬렉션을 순회하기 위한 반복자 객체를 반환합니다.

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

class SListIterator<E> implements Iterator<E> {
    private SList.Node<E> current;

    public SListIterator(SList.Node<E> current) {
        this.current = current;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public E next() {
        E ret = current.getValue();
        current = current.getNext();

        return ret;
    }
}

// 단일 연결 리스트
class SList<E> implements Iterable<E> {
    @Override
    public Iterator<E> iterator() {
        return new SListIterator<>(head);
    }

    static class Node<E> {
        private E value;
        private Node<E> next;

        Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }

        E getValue() {
            return value;
        }

        Node<E> getNext() {
            return next;
        }
    }

    private Node<E> head = null;

    public void addFront(E value) {
        head = new Node<>(value, head);
    }

    public E front() {
        return head.value;
    }
}

public class Sample {
    public static void main(String[] args) {
        // SList<Integer> s = new SList<>();
        // s.addFront(10);
        // s.addFront(20);
        // s.addFront(30);
        // System.out.println(s.front());

        List<Integer> s = Arrays.asList(10, 20, 30);

        Iterator<Integer> iterator = s.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Iterator 패턴을 구현한 컬렉션에 대해서
        // 향상된 for 구문을 사용할 수 있습니다.
        for (Integer e : s) {
            System.out.println(e);
        }

        // Java 8 에서는 많은 기능이 인터페이스의 기본 구현을 통해 제공됩니다.
        s.forEach(e -> {
            System.out.println(e);
        });

        // Java 8 - Method Reference
        s.forEach(System.out::println);
    }
}
