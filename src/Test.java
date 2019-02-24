class Base {
    public Base(String s){
        System.out.println("B");
    }
}


public class Test extends Base{
    public Test(String s) {
        super(s);
    }
}
