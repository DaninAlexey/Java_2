package lesson6.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {

    public static final int PORT = 8192;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Сервер начал работу. Ожидание новых подключений");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Клиент подключился");
            DataInputStream input = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());

            writeMessage(output, clientSocket);
            processClientConnection(input, output);
        } catch (IOException e) {
            System.err.println("Ошибка подключения к порту");
            e.printStackTrace();
        }
    }

    private static void processClientConnection(DataInputStream input, DataOutputStream output) throws IOException {

        while (true) {
            try {
                String message = input.readUTF();
                if (message.equals("/end"))
                    break;
                System.out.println("-Клиент- " + message);
//                output.writeUTF("Echo " + message);
            } catch (IOException e) {
                System.out.println("Соединение было закрыто");
                break;
            }
        }

    }

    private static void writeMessage(DataOutputStream output, Socket clientSocket) {
        Scanner scanner = new Scanner(System.in);
        Thread sendingThread = new Thread(() -> {
            while (true) {
                String sendMessage = scanner.nextLine();
                if (sendMessage.equals("/end")) {
                    try {
                        clientSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.err.println("Ошибка при закрытии соединения с клиентом");
                    }
                    return;
                }
                try {
                    output.writeUTF(sendMessage);
                } catch (IOException e) {
                    e.printStackTrace();
                    System.err.println("Не удалось отправить сообщение");
                }
            }
        });
//      sendingThread.setDaemon(true);
        sendingThread.start();
    }
}
