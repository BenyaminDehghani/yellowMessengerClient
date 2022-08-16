package GUIController;

import APIs.ImageSender;
import APIs.SceneChanger;
import client.Client;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DataFormat;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import response.Response;

import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;


public class ChatGUI {
    @FXML
    ImageView contactImage;
    @FXML
    Label contactName;
    @FXML
    ImageView backButton;
    @FXML
    ListView<String> messagesListView;
    @FXML
    TextField messageTextField;
    @FXML
    ImageView sendButton;
    @FXML
    ImageView attachButton;

    File sendingFile;
    DataFormat sendingFileDataFormat;

    SceneChanger sceneChanger = new SceneChanger();
    
    public void initialize() throws UnknownHostException {
        messageTextField.setText("Message");
        messagesListView.getItems().clear();
        contactImage.setImage(new Image(System.getProperty("user.dir")+"\\src\\main\\resources\\"+ Client.getInstance().getChatController().getImageURl().split("Files/")[1].replace('/','\\')));
        contactName.setText(Client.getInstance().getChatController().getContactName());
        messagesListView.getItems().addAll(Client.getInstance().getChatController().getMessages());
        System.out.println(Client.getInstance().getChatController().toString());
    }

    public void getFile(DragEvent mouseEvent) {
        if(mouseEvent.getDragboard().hasFiles()) {
            sendingFileDataFormat = DataFormat.IMAGE;
            mouseEvent.acceptTransferModes(TransferMode.ANY);
        }
    }

    public void send(MouseEvent mouseEvent) throws UnknownHostException {
        String text = messageTextField.getText();
        sendMessage(text);
    }

    private void sendMessage(String text) throws UnknownHostException {
        if(!text.contains(".")){
            Response response = Client.getInstance().sendTextMessageRequest(text);
            System.out.println(response.toString());
            double id = (double) response.getData().get("id");
            String messageText = (String) response.getData().get("text");
            String messageSender = (String) response.getData().get("sender");
            String messageDate = (String) response.getData().get("date");
            String message = messageSender+" "+(int)Math.floor(id)+"\n"+messageText+"\n"+messageDate;

            Client.getInstance().getChatController().addMessage(message);
            initialize();
        }
        else if(sendingFileDataFormat.equals(DataFormat.IMAGE)){
            String content = ImageSender.encode(sendingFile);
            Response response = Client.getInstance().sendImageMessageRequest(text, content);
            double id = (double) response.getData().get("id");
            String messageText = (String) response.getData().get("text");
            String messageSender = (String) response.getData().get("sender");
            String messageDate = (String) response.getData().get("date");
            String messageContent = (String) response.getData().get("content");
            String message = messageSender+" "+(int)Math.floor(id)+"\n"+messageText+"\n"+messageDate;

            Client.getInstance().getChatController().addMessage(message);
            Client.getInstance().getChatController().addFile((int)Math.floor(id),ImageSender.decode(messageContent));
            initialize();
        }
    }

    public void goToChats(MouseEvent mouseEvent) throws IOException {
        sceneChanger.changeScene(mouseEvent,"Chats.fxml");
    }

    public void openFile(MouseEvent mouseEvent) throws IOException {
        if(Client.getInstance().getChatController().getFiles().keySet().contains(Integer.parseInt(messagesListView.getSelectionModel().getSelectedItem().split("\n")[0].split(" ")[1]))) {
            Client.getInstance().setCurrentFile(Integer.parseInt(messagesListView.getSelectionModel().getSelectedItem().split("\n")[0].split(" ")[1]));
            sceneChanger.changeScene(mouseEvent, "ShowContent.fxml");
        }
    }

    public void attach(DragEvent dragEvent) {
        List<File> files = dragEvent.getDragboard().getFiles();
        sendingFile = files.get(0);
        messageTextField.setText(sendingFile.getName());
    }
}
