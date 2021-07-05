package javasample.ex6;

interface Clickable {
    // int N = 10;
    // public static int N = 10

    void click();

    // Java 8 - default method(defender method)
    default void showOff() {
        System.out.println("Clickable");
    }
}

//class Button implements Clickable {
//    @Override
//    public void click() {
//
//    }
//}


public class Sample {
    public static void main(String[] args) {

    }
}
