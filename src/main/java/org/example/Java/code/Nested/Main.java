package org.example.Java.code.Nested;

public class Main {

    public static void main(String[] args) {
        Outer outer = new Outer();

        Outer.Inner inner = outer.new Inner();

        Outer.Inner.Local local = inner.new Local();
        Outer.Inner.Local methodChainLocal = new Outer().new Inner().new Local();
        local.localMethod();
        methodChainLocal.localMethod();

        Outer.Static aStatic = new Outer.Static();
        aStatic.staticMethod();
    }
}
