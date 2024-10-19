/*
 * YES, interfaces can extend multiple interfaces but classes CANNOT extend multiple classes
 * In case, 2 interfaces which are extended give same method default impls ==> compile time error
 * Then we must override in our derived interface.
 * In case, 2 interfaces which are extended give one gives default impl and other leaves abstract ==> compile time error
 * Then we must override in our derived interface or call using I1.super.methodName()
 * If both don't give impls ==> No errors as class will 100% resolve ambiguity while overriding.
 */


interface A{
    public default void test(){
        System.out.println("A");
    }
}

interface B{
    public void test();
}

class C implements A, B{
    public void test(){ // required if one of the interface doesn't give impl and also if both give it.
       A.super.test(); // required if need to force implementation
    }
}


public class InterfaceDiamondProblem {
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        C c = new C();
        c.test();
    }
}
