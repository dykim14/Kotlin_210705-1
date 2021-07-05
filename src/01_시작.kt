// 01_시작.kt
// 1. 코틀린 언어 특징
//   - 간결함
//    : 자바에서 발생하는 보일러플레이트(상용구)를 제거합니다.
//   - 안전함
//    : "null"을 안전하게 다루는 방법을 제공합니다.
//    => Nullable / Optional / Maybe

//       String a = null;
//       a.length          - NullPointerException
//      Kotlin
//         String - null 가능성이 없는 타입입니다.
//                  안전하게 사용할 수 있습니다.
//        String? - null 가능성이 있는 타입입니다.
//                  반드시 null check 이후에 사용해야 합니다.

//   - 상호운용성
//    : 자바로 작성된 코드를 코틀린에서 이용할 수 있고,
//      코틀린에서 작성된 코드를 자바에서 이용할 수 있습니다.

// 자바에서는 패키지를 작성할 때, 디렉토리에 대한 지정이 필요합니다.
// 코틀린은 필요하지 않습니다.
//  : 제품 코드에서는 디렉토리를 기반으로 패키지를 관리하는 것이 좋습니다.
package ex1

/*
// Hello.java
public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello, Java");
    }
}

public class Hello {
  public Hello();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
       3: ldc           #3                  // String Hello, Java
       5: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
       8: return
}
*/
// $ javac Hello.java
//   : Hello.class(Byte code) <- JVM(Java Virtual Machine)

// 코틀린은 전역 함수를 지원합니다.
fun main(args: Array<String>) {
    println("Hello, Kotlin")
}
/*

// fun main(args: Array<String>)
public final class HelloKt {
  public static final void main(java.lang.String[]);
    Code:
       0: aload_0
       1: ldc           #9                  // String args
       3: invokestatic  #15                 // Method kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
       6: ldc           #17                 // String Hello, Kotlin
       8: astore_1
       9: iconst_0
      10: istore_2
      11: getstatic     #23                 // Field java/lang/System.out:Ljava/io/PrintStream;
      14: aload_1
      15: invokevirtual #29                 // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
      18: return
}

// fun main()
public final class HelloKt {
  public static final void main();
    Code:
       0: ldc           #8                  // String Hello, Kotlin
       2: astore_0
       3: iconst_0
       4: istore_1
       5: getstatic     #14                 // Field java/lang/System.out:Ljava/io/PrintStream;
       8: aload_0
       9: invokevirtual #20                 // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
      12: return

  public static void main(java.lang.String[]);
    Code:
       0: invokestatic  #23                 // Method main:()V
       3: return
}

*/

// $ kotlinc Hello.kt
//  : HelloKt.class







