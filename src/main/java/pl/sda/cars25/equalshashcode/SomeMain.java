package pl.sda.cars25.equalshashcode;

public class SomeMain {
    public static void main(String[] args) {
//        method1();
        method2();
    }

    private static void method2() {
        System.out.println("--------");
        SomeObject o1 = new SomeObject(new String("aaa"));
        SomeObject o2 = new SomeObject(new String("aaa"));
        OtherObject o3 = new OtherObject("aaa");
        SomeObject o4 = null;
        SomeObject o5 = new XtraObject("aaa");

        System.out.println(o1.equals(o2)); //true
        System.out.println(o1.equals(o1)); //true
        System.out.println(o1.equals(o4)); //false
        System.out.println(o1.equals(o3)); //false
        System.out.println(o1.equals(o5));
    }

    private static void method1() {
        SomeObject a = new SomeObject("a");
        SomeObject b = a;
        SomeObject c = new SomeObject("a");
        System.out.println(b.equals(a));
        System.out.println(c.equals(a));
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(c.hashCode());


        Long n1 = 2L;
        long n2 = 2L;
        System.out.println(n1.equals(n2));
//        System.out.println(n2.equals(n1));
        System.out.println(a.equals(n2));
    }
}
