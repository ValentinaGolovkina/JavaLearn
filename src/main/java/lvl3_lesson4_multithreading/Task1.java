package lvl3_lesson4_multithreading;

public class Task1 {
    private final Object mon = new Object();
    private volatile char currentLetter = 'A';

    public void print() {
        //1. Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз (порядок – ABСABСABС).
        // Используйте wait/notify/notifyAll.

        Thread t1 = new Thread(() -> {
            printA();
        });
        Thread t2 = new Thread(() -> {
            printB();
        });
        Thread t3 = new Thread(() -> {
            printС();
        });
        t1.start();
        t2.start();
        t3.start();
    }

    public void printA() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'A') {
                        mon.wait();
                    }
                    System.out.print("A");
                    currentLetter = 'B';
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printB() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'B') {
                        mon.wait();
                    }
                    System.out.print("B");
                    currentLetter = 'С';
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printС() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'С') {
                        mon.wait();
                    }
                    System.out.print("С");
                    currentLetter = 'A';
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
