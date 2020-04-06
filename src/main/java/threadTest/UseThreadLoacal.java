package threadTest;

/**
 * @Author wuzhenfei
 * @Description
 * @Date 2019/12/17 10:06
 **/
public class UseThreadLoacal {

    /**
     *初始ThreadLocal
     *底层用map实现
     *这里的Thread存放的是Integer类型的数据，假如说要用来存放一个超级庞大的数据，由于每个线程都有一个自己的副本，这样对内存的资源的占用是相当大的，所以ThreadLocal尽量用来存放比较小的数据。
     */
    static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 1;
        }
    };
    public void startThreadArray() {
        Thread[] threads = new Thread[3];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new TestThread(i));
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
    }

    public static class TestThread implements Runnable{
        int id;
        public TestThread(int id) {
            this.id = id;
        }
        @Override
        public void run() {
            Integer s = threadLocal.get();//获取变量的值
            System.out.println(Thread.currentThread().getName() +":"+ s);
            s = s + id;
            threadLocal.set(s);//把值写回去
            System.out.println(Thread.currentThread().getName() + ": " + threadLocal.get());
        }
    }

    public static void main(String[] args) {
        UseThreadLoacal useThreadLoacal = new UseThreadLoacal();
        useThreadLoacal.startThreadArray();
    }
}
