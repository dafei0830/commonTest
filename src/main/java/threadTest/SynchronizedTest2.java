package threadTest;

/**
 * @Author wuzhenfei
 * @Description
 * @Date 2019/12/25 17:19
 **/
public class SynchronizedTest2 {
    public static void main(String[] args) {
        final Shop shop = new Shop();
        Thread t1 = new Thread(shop::buy);
        Thread t2 = new Thread(shop::buy);
        Thread t3 = new Thread(shop::buy);
        Thread t4 = new Thread(shop::buy);
        Thread t5 = new Thread(shop::buy);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

    static class Shop {
        void buy() {
            try {
                Thread t = Thread.currentThread();
                System.out.println(t + "正在挑选衣服.");
                Thread.sleep(1000);
                synchronized (this) {
                    System.out.println(t + "正在试衣服.");
                    Thread.sleep(1000);
                }

                System.out.println(t + "结账离开.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
