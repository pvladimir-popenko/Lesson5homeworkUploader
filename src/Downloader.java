import java.util.concurrent.Semaphore;

public class Downloader extends Thread {
    private int id;
    private Semaphore sem;
    private int downloadSpeed;

    public Downloader( int id, int downloadSpeed, Semaphore sem){
        this.downloadSpeed = downloadSpeed;
        this.id = id;
        this.sem = sem;
    }


    public void run(){
        try {
            sem.acquire();
            System.out.printf("Скачивающий № %d начинает скачивание\n", id);
            sleep(5000);
            System.out.printf("Скачивающий № %d закончил скачивание\n", id);
            sem.release();
            sleep(1000);
        }catch (InterruptedException ie){
            System.out.printf("у скачивающего № %d проблемы с интернетом\n", id);
        }
    }
}
