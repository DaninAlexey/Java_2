package lesson6;

import lesson6.client.Network;

import java.io.IOException;
import java.util.Scanner;
import java.util.function.Consumer;

public class DZclient {

    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        Network net = new Network();
        boolean result = net.connect();
        if (!result) {
            System.out.println("Не удалось подключиться к серверу");
            return;
        }

        writeMessage(net);
        net.waitMessage(new Consumer<String>() {
            @Override
            public void accept(String receivedMessage) {
                System.out.println("-Сервер- " + receivedMessage);
            }
        });
    }

    private static void writeMessage(Network net) {

        Thread sendingThread = new Thread(() ->{
            while (true) {
                String sendMessage = scanner.nextLine();
                if (sendMessage.equals("/end"))
                {
                    net.close();
                    return;}
                try {
                    net.sendMessage(sendMessage);
                } catch (IOException e) {
                    e.printStackTrace();
                    System.err.println("Не удалось отправить сообщение");
                }
            }
        });
        sendingThread.start();
    }
}
