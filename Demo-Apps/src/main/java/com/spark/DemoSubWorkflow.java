package com.spark;

public class DemoSubWorkflow {
    public static void main(String[] args) {
        System.out.println("Demo Sub workflow");

        System.out.println("# Arguments: " + args.length);
        for (int i = 0; i < args.length; i++) {
            System.out.println("Argument[" + i + "]: " + args[i]);
        }
    }
}
