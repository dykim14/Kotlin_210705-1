package javasample.ex6;

import java.io.*;

interface State extends Serializable {
}

interface View {
    State getCurrentState();

    void restoreState(State s);
}

class Button implements View {
    private int x;
    private int y;
    private int width;
    private int height;

    public Button(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    //  Inner class: class ButtonState
    //   : 외부 객체(Button 참조)의 참조를 소유하고 있습니다.

    // Nested class: static class ButtonState
    private static class ButtonState implements State {
        private int x;
        private int y;
        private int width;
        private int height;

        public ButtonState(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }
    }

    @Override
    public State getCurrentState() {
        return new ButtonState(x, y, width, height);
    }

    @Override
    public void restoreState(State s) {
        ButtonState state = (ButtonState) s;
        x = state.x;
        y = state.y;
        width = state.width;
        height = state.height;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Button{" +
                "x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}

public class Sample3 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // Sava State
        /*
        Button button = new Button(10, 20, 30, 40);
        State state = button.getCurrentState();

        FileOutputStream fos = new FileOutputStream("button.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(state);
        */

        Button button = new Button(30, 20, 10, 20);
        FileInputStream fis = new FileInputStream("button.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);

        State s = (State) ois.readObject();
        button.restoreState(s);

        System.out.println(button);
    }
}
