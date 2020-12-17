public class Test {
    public static void main(String[] args) {
        System.out.println(B.c);
    }
}
class A {
    static {
        System.out.println("A");
    }
}

class B extends A {
    static {
        System.out.println("B");
    }
    public static final String c = "C";
}
