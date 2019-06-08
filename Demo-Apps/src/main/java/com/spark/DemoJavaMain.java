package com.spark;

public class DemoJavaMain {
    public static void main(String[] args) {
        System.out.println("Demo Java Main tst");

        System.out.println("# Arguments: " + args.length);
        for (int i = 0; i < args.length; i++) {
            System.out.println("Argument[" + i + "]: " + args[i]);
        }
    }
}