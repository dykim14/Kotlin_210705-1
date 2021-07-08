package com.lge.sampleapp.javasample;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
// 용도 2가지
// 1) 자바에서 null 안정성을 위한 체크를 위해서 사용됩니다. - Android Lint
// 2) 코틀린에서 타입을 결정하는 목적으로 사용합니다.
//    @NonNull String   -> String
//    @Nullable String  -> String?
//    String            -> String! (그냥 사용해도 되지만, 위험할 수도 있다.)

public class Sample {
    public static void print1(@NonNull String name) {
        int length = name.length();
    }

    // Method invocation 'length' may produce 'NullPointerException'
    public static void print2(@Nullable String name) {
        int length = name.length();
    }

    public static void print3(String name) {}
}
