package threadTest;

import java.util.concurrent.TimeUnit;

/**
 * @Author wuzhenfei
 * @Description
 * @Date 2019/12/25 17:26
 **/
public class WiteNotifyTest {
    private static boolean isFinish;
    private static final Object obj = new Object();

    public static void main(String[] args) {
        final Thread download = new Thread(() -> {
            System.out.println("down:开始下载图片...");
            for (int i = 1; i <= 100; i++) {
                System.out.println("down:" + i + "%");
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("down:图片下载完毕!");
            isFinish = true;
            //通知 show线程开始工作
            synchronized (obj) {
                obj.notify();
            }
        });

        Thread show = new Thread(() -> {
            System.out.println("show:开始显示图片...");
            synchronized (obj) {
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (!isFinish) {
                throw new RuntimeException("图片加载失败!");
            }
            System.out.println("show:图片显示完毕!");
        });
        download.start();
        show.start();
    }
}
