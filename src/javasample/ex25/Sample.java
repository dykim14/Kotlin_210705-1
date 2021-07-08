package javasample.ex25;

// Iterator Pattern(반복자 패턴)
//   의도: 컬렉션의 내부 구조에 상관없이 요소를 열거할 수 있는 객체

// 단일 연결 리스트
class SList<E> {
    private static class Node<E> {
        private E value;
        private Node<E> next;

        Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node<E> head = null;

    public void addFront(E value) {
        head = new Node(value, head);
    }

    public E front() {
        return head.value;
    }
}


public class Sample {
    public static void main(String[] args) {

    }
}
