package java8Test;

/**
 * @Author wuzhenfei
 * @Description
 * @Date 2020/3/26 15:31
 **/
public class Java8Test {
    public static void main(String[] args) {
        Java8Test tester = new Java8Test();

        // 类型声明
        MathOperation addition = (int a, int b)->a+b;

        System.out.println("10 +5  = " + tester.operate(10,5,addition));

        GreetingService greetingService1 = message -> System.out.println("Hello = " + message);

        greetingService1.sayMessage("Runoob");

    }

    interface MathOperation{
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }
}
