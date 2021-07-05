package javasample.ex6;

import java.io.Serializable;

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

    private class ButtonState implements State {
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
    public static void main(String[] args) {

    }
}
