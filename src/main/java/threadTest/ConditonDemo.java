package threadTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author wuzhenfei
 * @Description
 * @Date 2020/3/30 14:11
 **/
public class ConditonDemo {
    volatile int key = 0;
    Lock l = new ReentrantLock();
    Condition c = l.newCondition();

    public static  void main(String[] args){
        ConditonDemo demo = new ConditonDemo();
        new Thread(demo.new A()).start();
        new Thread(demo.new B()).start();
    }

    class A implements Runnable{
        @Override
        public void run() {
            int i = 10;
            while(i > 0){
                l.lock();
                try{
                    if (key == 1) {
                        System.out.println("A is Running");
                        System.out.println("A is Running");
                        i--;
                        key = 0;
                        c.signal();
                    } else {
                        c.awaitUninterruptibly();
                    }
                }
                finally{
                    l.unlock();
                }
            }
        }

    }

    class B implements Runnable{
        @Override
        public void run() {
            int i = 10;
            while(i > 0){
                l.lock();
                try{
                    if(key == 0){
                        System.out.println("B is Running");
                        i--;
                        key = 1;
                        c.signal();
                    }else{
                        c.awaitUninterruptibly();
                    }

                }
                finally{
                    l.unlock();
                }
            }
        }
    }
}
