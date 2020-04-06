package threadTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author wuzhenfei
 * @Description
 * @Date 2019/12/25 17:37
 **/
public class ThreadPoolTest {

    public static void main(String[] args) {
        //创建一个固定大小的线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(3);

//指派 5个任务
        for (int i = 0; i < 10; i++) {
            Runnable runn = () -> {
                Thread t = Thread.currentThread();
                System.out.println(t + "正在运行任务!");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(t + "执行任务完毕");
            };
            threadPool.execute(runn);
        }
//停止线程池
        threadPool.shutdown();
    }
}
