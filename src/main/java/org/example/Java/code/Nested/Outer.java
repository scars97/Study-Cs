package org.example.Java.code.Nested;

public class Outer {

    int outerField = 1;

    class Inner {
        int innerField = 2;
        class Local {
            public void localMethod() {
                System.out.println("Local.localMethod");
            }
        }
    }

    static class Static {
        int staticField = 3;
        public void staticMethod() {
            System.out.println("Static.staticMethod");
        }
    }
}
