package javasample.ex8;

// 자바에서는 객체의 깊은 복사를 clone을 통해서 구현합니다.
//  - Object.clone()
//    : 메모리 복사하는 로직이 구현되어 있습니다.

class Point implements Cloneable {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // 1. Object.clone을 오버라이딩 합니다.
    // 2. protected -> public
    // 3. 예외를 내부적으로 처리하도록 변경해야 합니다.
    // 4. 캐스팅을 내부적으로 수행하도록 변경해야 합니다.
    //    부모 메소드의 반환타입을 하위 타입으로 변환하는 것을 허용합니다.
    //    => 공변 반환의 법칙
    // 5. Object.clone
    //     if (this instanceOf Cloneable) {
    //         복사수행
    //     }
    //    복사(clone)을 제공할 경우, 반드시 Cloneable의 인터페이스를
    //    구현해야 합니다.
    //    - mark-up interface
    //      : 기능을 제공하는 것이 아니라, 타입을 체크하기 위한 목적으로 사용한다.

    @Override
    public Point clone() {
        try {
            return (Point) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

// 라이브러리가 제공하는 클래스입니다.
class Car {
    private String name;

    public Car(String name) {
        this.name = name;
    }
}

// 사용자가 만든 클래스 입니다.
//  : clone을 구현하더라도, 제대로 복사가 수행되지 않습니다.
//  => 상속 계층에 있는 모든 클래스가 clone을 만족해야 복사가 제대로 수행될 수 있습니다.
class Truck extends Car implements Cloneable {
    private int color;

    public Truck(String name, int color) {
        super(name);
        this.color = color;
    }

    @Override
    public Truck clone() {
        try {
            return (Truck) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}

// 자바에서도 clone을 통해 복제를 수행하는 것아니라,
// "복사 생성자"를 이용하는 것이 좋습니다.
// => 자신과 동일한 타입의 인자를 받는 생성자
class Point2 {
    private int x;
    private int y;

    public Point2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point2(Point2 rhs) {
        this.x = rhs.x;
        this.y = rhs.y;
    }

    @Override
    public String toString() {
        return "Point2{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}


public class Sample {
    public static void main(String[] args) {
        // Point p1 = new Point(10, 20);
        // Point p2 = p1.clone();
        Point2 p1 = new Point2(10, 20);
        Point2 p2 = new Point2(p1);

        System.out.println(p1);
        System.out.println(p2);
    }
}
