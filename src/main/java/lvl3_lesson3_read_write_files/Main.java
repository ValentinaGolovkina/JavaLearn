package lvl3_lesson3_read_write_files;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //1.Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль;
        byte[] buf = new byte[50];

        try (FileInputStream in = new FileInputStream("src/main/java/lvl3_lesson3_read_write_files/demo.txt")) {
            int count;
            while ((count = in.read(buf)) > 0) {
                for (int i = 0; i < count; i++) {
                   // System.out.print((char) buf[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        //2. Последовательно сшить 5 файлов в один (файлы примерно 100 байт). Может пригодиться следующая конструкция:
        // ArrayList<InputStream> al = new ArrayList<>(); ... Enumeration<InputStream> e = Collections.enumeration(al);

        try {
            ArrayList<InputStream> al = new ArrayList<>();
            al.add(new FileInputStream("src/main/java/lvl3_lesson3_read_write_files/demo1.txt"));
            al.add(new FileInputStream("src/main/java/lvl3_lesson3_read_write_files/demo2.txt"));
            al.add(new FileInputStream("src/main/java/lvl3_lesson3_read_write_files/demo3.txt"));
            al.add(new FileInputStream("src/main/java/lvl3_lesson3_read_write_files/demo4.txt"));
            al.add(new FileInputStream("src/main/java/lvl3_lesson3_read_write_files/demo5.txt"));
            Enumeration<InputStream> e = Collections.enumeration(al);
            SequenceInputStream in = new SequenceInputStream(e);
            FileOutputStream out = new FileOutputStream("src/main/java/lvl3_lesson3_read_write_files/out.txt");
            int x;
            while ((x = in.read()) != -1) {
                out.write(x);
            }
            in.close();
            out.close();
        } catch (IOException e){
            e.printStackTrace();
        }


        //3. Написать консольное приложение, которое умеет постранично читать текстовые файлы (размером > 10 mb).
        // Вводим страницу (за страницу можно принять 1800 символов), программа выводит ее в консоль.
        // Контролируем время выполнения: программа не должна загружаться дольше 10 секунд, а чтение – занимать свыше 5 секунд.

        long t = System.currentTimeMillis();
        try (RandomAccessFile raf = new RandomAccessFile("src/main/java/lvl3_lesson3_read_write_files/book.txt", "r")) {
            System.out.println("Загрузка программы: " + (System.currentTimeMillis() - t));
            int page=-1;
            int length = (int) (raf.length()/1800);
            do {
                System.out.println("Введите страницу от 0 до "+length+": ");
                Scanner scanner = new Scanner(System.in);
                page = scanner.nextInt();
                System.out.println();
            } while ((page < 0) && (page > length));

            t = System.currentTimeMillis();
            raf.seek((page - 1) * 1800);
            byte[] arr = new byte[1800];
            int count;
            if ((count = raf.read(arr)) > 0) {
                    System.out.print(new String(arr, 0, count, "UTF-8"));
                    System.out.println();
                    System.out.println("чтение: " + (System.currentTimeMillis() - t));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
