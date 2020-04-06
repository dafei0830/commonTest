package threadTest;

/**
 * @Author wuzhenfei
 * @Description
 * @Date 2019/12/17 10:21
 **/

// join的用发
public class UseJoin {
    private static class JumpQuery implements Runnable{
        private Thread thread;//用来插队的线程
        public JumpQuery (Thread thread) {
            this.thread = thread;
        }
        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " terminted.");
        }
    }

    public static void main(String[] args) {

        Thread previous = Thread.currentThread();
        //初始时，这个是主线程
        for(int i = 0; i < 10; i++) {
            //i=0是，previous是主线程，i=1时，previous是i=0这个线程
            Thread thread = new Thread(new JumpQuery(previous),String.valueOf(i));
            System.out.println(previous.getName() + "jump a queue the thread:" + thread.getName());
            thread.start();
            previous = thread;
        }
        try {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " termined.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
