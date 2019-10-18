import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void  main(String[] args)throws InterruptedException {
        int fileValue = 500;
        int speed = 20;
        CountDownLatch latch;
        Uploader u = new Uploader();
        Semaphore sem = new Semaphore(3, true);
        latch = new CountDownLatch(3);


        try {
            u.start();

            for (int i = 1; i <= 10; i++){
                Downloader d =  new Downloader(i, 100, sem);
                d.start();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {

        }

        while (latch.getCount() < 3){
            System.out.println("Грузим файл на сервер");
            Thread.sleep(1000);
            latch.countDown();
            Thread.sleep(1000);
            latch.countDown();
            Thread.sleep(1000);
            latch.countDown();

        }

    }
}
