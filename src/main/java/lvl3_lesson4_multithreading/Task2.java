package lvl3_lesson4_multithreading;

public class Task2 {
    //2. Создать MFU c функциями, сканирования, печати и ксерокопирования

    public void run(){
        MFU mfu = new MFU();
        Thread t1 = new Thread(() -> {
            mfu.scan();
        });
        Thread t2 = new Thread(() -> {
            mfu.print();
        });
        Thread t3 = new Thread(() -> {
            mfu.xerocopy();
        });
        t1.start();
        t2.start();
        t3.start();
    }


    public class MFU{

        Object scan = new Object();
        Object print = new Object();

        public void scan(){
            System.out.println("Сканирование");
            synchronized (scan){
                try {
                    System.out.println("Сканирование: положили образец");
                    Thread.sleep(100);
                    System.out.println("Сканирование: отправили по сети");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void print(){
            System.out.println("Печать");
            synchronized (print){
                try {
                    Thread.sleep(100);
                    System.out.println("Печать листа");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void xerocopy(){
            System.out.println("Ксерокопирование");
            synchronized (scan){
                try {
                    Thread.sleep(100);
                    System.out.println("Ксерокопирование положили образец");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (print){
                    try {
                        Thread.sleep(100);
                        System.out.println("Ксерокопирование получили копию");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
