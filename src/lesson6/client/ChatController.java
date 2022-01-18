package lesson6.client;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.function.Consumer;

public class ChatController {

    private Network network;
    private ChatApplication2 application;

    @FXML
    private TextArea textArea;
    @FXML
    private TextField textField;
    @FXML
    private Button sendButton;
    @FXML
    public ListView<String> userList;

    public void sendMessage() {
        String message = textField.getText();
        appendMessageToChat(message);
        try {
            network.sendMessage(message);
        } catch (IOException e) {
            application.showErrorDialog("ошибка передачи данных по сети");
            e.printStackTrace();
        }
    }

    private void appendMessageToChat(String message) {
        if (!message.isEmpty()) {
            textArea.appendText(message + System.lineSeparator());
            textField.clear();
        }
    }

    public void setNetwork(Network network) {
        this.network = network;

        network.waitMessage(new Consumer<String>() {
            @Override
            public void accept(String message) {
                appendMessageToChat(message);
            }
        });
    }

    public void setApplication(ChatApplication2 application) {
        this.application = application;
    }
}