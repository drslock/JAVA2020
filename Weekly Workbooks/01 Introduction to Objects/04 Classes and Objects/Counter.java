public class Counter {

    int count;

    public static void main(String[] args) {
        /*init a new counter*/
        Counter myCounter = new Counter(52);
        myCounter.increment();
        System.out.println(myCounter.returnCountVal());

        /*this is for string*/
        String code = new String("Hello");
        System.out.println(code);
        /*shorthand*/
        String code1 = "Hello1";
        System.out.println(code1);
        /*substring*/
        System.out.println(code1.substring(0,3));
    
    }    

    public Counter(int startVal) {
        this.count = startVal;
    }
    
    public Counter() {
        this.count = 0;
    }
    
    void increment() {
        this.count++;
    }

    int returnCountVal() {
        return this.count;
    }

}

