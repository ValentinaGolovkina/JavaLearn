package lesson13;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String SERVER_ADDRESS = "localhost";
    private static  final int SERVER_PORT = 8189;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try (Socket socket = new Socket(SERVER_ADDRESS,SERVER_PORT)) {
            System.out.println("Подключился к серверу");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                Thread readThread = new Thread(()->{
                    try{
                        while (true){
                            out.writeUTF(scanner.nextLine());
                        }
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }
                });
                readThread.setDaemon(true);
                readThread.start();


                while (true) {

                    String str = in.readUTF();
                    if (str.equals("/end")) {
                        System.out.println("Отключился от сервера");
                        out.writeUTF("/end");
                        break;
                    } else {
                    System.out.println("Сервер " + str);
                    }
                }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
