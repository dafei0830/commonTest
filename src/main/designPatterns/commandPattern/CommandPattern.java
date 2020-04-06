package commandPattern;

/**
 * @Author wuzhenfei
 * @Description
 * @Date 2019/11/23 11:27
 **/
public class CommandPattern {

    public static void main(String[] args) {
//        Invoker ir = new Invoker(new ConcreteCommand());
//        System.out.println("客户访问调用者的call()方法");
//        ir.call();
        Invoker ir2 = new Invoker(new ConcreteCommandB());
        System.out.println("客户访问调用者的call()方法");
        ir2.call();
    }
}

    //调用者
    class Invoker{
        private Command command;

        public Invoker(Command command){
            this.command=command;
        }

        public void setCommand(Command command){
            this.command = command;
        }

        public void call(){
            System.out.println("调用者执行命令command...");
            command.execute();
        }
    }

    //抽象命令
    interface Command{
        void execute();
    }

    //具体命令
    class ConcreteCommand implements Command{
        private ReceiverA receiver;
        ConcreteCommand(){
            receiver = new ReceiverA();
        }

        @Override
        public void execute() {
            receiver.action();
        }
    }

    //接收者
    class ReceiverA{
        public void action(){
            System.out.println("接收者A的action()方法被调用...");
        }
    }

    //具体命令2
    class ConcreteCommandB implements Command{
        private ReceiverB receiver;
        ConcreteCommandB(){
            receiver = new ReceiverB();
        }

        @Override
        public void execute() {
            receiver.action();
        }
    }

    //接收者2
    class ReceiverB{
        public void action(){
            System.out.println("接收者B的action()方法被调用...");
        }
    }

