package lesson6.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.function.Consumer;

public class Network {
    public static final int SERVER_PORT = 8192;
    public static final String SERVER_HOST = "localHost";

    private int port;
    private String host;
    Socket socket;
    DataInputStream inputStream;
    DataOutputStream outputStream;


    public Network(int port, String host) {
        this.port = port;
        this.host = host;
    }

    public Network() {
        this(SERVER_PORT, SERVER_HOST);
    }

    public boolean connect() {
        try {
            this.socket = new Socket(host, port);
            this.inputStream = new DataInputStream(socket.getInputStream());
            this.outputStream = new DataOutputStream(socket.getOutputStream());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Не удалось установить соединение");
            return false;
        }
    }

    public void sendMessage(String message) throws IOException {
        try {
            outputStream.writeUTF(message);
        } catch (IOException e) {
            System.err.println("Не удалось отправить сообщение");
            throw e;
        }
    }

    public void waitMessage(Consumer<String> messageHandler)
    {  Thread thread = new Thread(() ->{
        while (true)
        {
            try {
                String message = this.inputStream.readUTF();
                messageHandler.accept(message);
            } catch (IOException e) {
                System.out.println("сетевое соединение разорвано");
                break;
            }
        }
    });
        thread.setDaemon(true);
        thread.start();
    }

    public void close()
    {
        try {
            this.socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
