package com.company;

enum Size { SMALL, MEDIUM, LARGE, EXTRA_LARGE };

public class Main {
    static final double CM_PER_INCH_ = 2.54;

    public static void main(String[] args) {
        String greeting = "Hello World";
        System.out.println(greeting);
        for (int i = 0; i < greeting.length(); i++)
            System.out.print("=");
        System.out.println();
        var val = 10;
        System.out.println(val);

        final double CM_PER_INCH = 2.54;

        System.out.println(CM_PER_INCH_);

        Size size = Size.SMALL;

        System.out.println(size);

        long lval = 10l;

        System.out.println("100_000_000");

        System.out.println(-11 % -3);

        System.out.println(Math.floorMod(-10, 3));
    }

    private void stringNotes() {
        String greeting = "Hello";
        String s = greeting.substring(0, 3); // 执行的是复制操作

    }
}
