package methodAsParameter;

class Test implements Callable {
    public void call(int param, String name) {
        System.out.println( "Hello " + name + " " + param );
    }
}

class HelloWorld{
    public static void invoke(Callable callable, int param){
        callable.call(param, "Man");
    }
    public static void main(String []args){
        Callable cmd = new Test();
        invoke(cmd, 10);

    }
}
