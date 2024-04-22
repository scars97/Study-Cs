package org.example.Java.code.Nested;

public class Outer {

    class Inner {
        class Local {
            public void localMethod() {
                System.out.println("Local.localMethod");
            }
        }
    }

    static class Static {
        public void staticMethod() {
            System.out.println("Static.staticMethod");
        }
    }
}
