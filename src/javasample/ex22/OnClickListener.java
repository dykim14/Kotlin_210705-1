package javasample.ex22;

// 하나의 메소드를 가지는 인터페이스를 "함수형 인터페이스" 라고 합니다.
@FunctionalInterface
public interface OnClickListener {
    void onClick();
}

class Button {
    private OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener listener) {
        this.onClickListener = listener;
    }

    public void click() {
        if (onClickListener != null)
            onClickListener.onClick();
    }
}

class Sample {
    public static void main(String[] args) {
        Button button = new Button();

        // Java
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick() {
                System.out.println("Button click");
            }
        });

        // 익명의 객체를 통해 구현하는 인터페이스가 하나의 메소드를 가지고 있을 경우,
        // 람다 표현식을 사용할 수 있습니다.
        // : Java 1.8
        button.setOnClickListener(() -> {
            System.out.println("Button click!");
        });


        button.click();
    }
}