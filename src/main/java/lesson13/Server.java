package lesson13;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    private static int PORT = 8189;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Сервер запущен");

            try (Socket socket = server.accept()) {

                System.out.println("Клиент подключился");

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
                        System.out.println("Клиент отключился");
                        out.writeUTF("/end");
                        break;
                    }

                    System.out.println("Клиент " + str);
                    //out.writeUTF("echo: " + str);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
