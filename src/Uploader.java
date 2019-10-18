public class Uploader extends Thread {
    private int fileValue = 500;
    private int downloadSpeed;

    public void run(){
        try {
            System.out.println("Загрузчик начал выгружать файл на сервер");
            sleep(5000);
            System.out.println("Файл загружен на сервер");
            } catch (InterruptedException ie){
        }
    }
}
