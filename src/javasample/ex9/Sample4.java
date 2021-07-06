package javasample.ex9;

interface MouseAdapter {
    void mouseClicked();

    void mouseEntered();
}

class Window {
    private MouseAdapter adapter;

    void setAdapter(MouseAdapter adapter) {
        this.adapter = adapter;
    }

    void click() {
        if (adapter != null)
            adapter.mouseClicked();
    }

    void enter() {
        if (adapter != null)
            adapter.mouseEntered();
    }
}

public class Sample4 {
    public static void main(String[] args) {
        Window window = new Window();

        final int n = 0;
        // Java의 클로저는 final 캡쳐를 수행합니다.
        window.setAdapter(new MouseAdapter() {
            @Override
            public void mouseClicked() {
                System.out.println("mouseClicked - " + n);
            }

            @Override
            public void mouseEntered() {
                System.out.println("mouseClicked");
            }
        });

        window.click();
        window.enter();
    }
}









