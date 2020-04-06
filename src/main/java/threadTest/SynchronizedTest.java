package threadTest;

/**
 * @Author wuzhenfei
 * @Description
 * @Date 2019/12/25 11:11
 **/
public class SynchronizedTest {
    public static void main(String[] args) {
        final Table table = new Table();
        Thread t0 = new Thread() {
            public void run() {
                while (true) {
                    int bean = table.getBean();
                    System.out.println("执行t0中的yield");
                    Thread.yield();
                    System.out.println(getName() + ":" + bean);
                }
            }
        };
        Thread t1 = new Thread() {
            public void run() {
                while (true) {
                    int bean = table.getBean();
                    System.out.println("执行t1中的yield");
                    Thread.yield();
                    System.out.println(getName() + ":" + bean);
                }
            }
        };
        t0.start();
        t1.start();
    }

    static class Table {
        private int beans = 5;
        synchronized int getBean() {
            if (beans == 0) {
                throw new RuntimeException("没有豆子了!");
            }
            System.out.println("执行table中的yield");
            Thread.yield();
            return beans--;
        }
    }
}
