package GUIController;

import APIs.ImageSender;
import APIs.SceneChanger;
import client.Client;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import messages.Chat;
import messages.ChatController;
import response.Response;
import response.ResponseStatus;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;

public class ChatsGUI {
    @FXML
    ImageView contactsButton;
    @FXML
    ListView<String> chatsListView;

    SceneChanger sceneChanger = new SceneChanger();

    public void goToContacts(MouseEvent mouseEvent) throws IOException {
        sceneChanger.changeScene(mouseEvent,"Contacts.fxml");
    }

    public void initialize() throws UnknownHostException {
        chatsListView.getItems().addAll(Client.getInstance().getChats());
    }

    public void goToChat(MouseEvent mouseEvent) throws IOException {
        String chatName = chatsListView.getSelectionModel().getSelectedItem();
        String universityID = chatName.split("\n")[0].split(" ")[2];
        System.out.println(universityID);
        Response response = Client.getInstance().getChatRequest(universityID);
        System.out.println(response.getResponseStatus());
        if (response.getResponseStatus().equals(ResponseStatus.OK)){
            String imageUrl = (String) response.getData().get("pictureUrl");
            String contactName = (String) response.getData().get("name");
            List<String> messages = (List<String>) response.getData().get("messages");
            List<String> filesList = (List<String>) response.getData().get("files");
            System.out.println(messages.toString());
            System.out.println(filesList.toString());
            HashMap<Integer,byte[]> files = new HashMap<>();
            for (String file:filesList){
                files.put(Integer.parseInt(file.split(" ")[0]), ImageSender.decode(file.split(" ")[1]));
            }
            Client.getInstance().setChatController(new ChatController(imageUrl,contactName,messages,files));
            sceneChanger.changeScene(mouseEvent,"Chat.fxml");
        }
    }
}
