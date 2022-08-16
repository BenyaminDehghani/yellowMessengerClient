package GUIController;

import APIs.SceneChanger;
import client.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import messages.Chat;
import response.Response;
import response.ResponseStatus;
import users.User;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class ContactsGUI {
    @FXML
    ImageView chatsButton;
    @FXML
    Button addButton;
    @FXML
    Button createChatButton;
    @FXML
    TextField universityIDTextField;
    @FXML
    ListView<String> contactsListView;
    @FXML
    Label errorLabel;

    List<String> contacts;

    SceneChanger sceneChanger = new SceneChanger();

    public void initialize() throws UnknownHostException {
        contacts = getContacts();
        contactsListView.getItems().addAll(contacts);
    }

    private List<String> getContacts() throws UnknownHostException {
        List<String> contactsList = new ArrayList<>();
        for (String username: Client.getInstance().getContacts()){
            contactsList.add(username);
        }
        return contactsList;
    }

    public void goToChats(MouseEvent mouseEvent) throws IOException {
        sceneChanger.changeScene(mouseEvent , "Chats.fxml");
    }

    public void addContact(ActionEvent actionEvent) throws UnknownHostException {
        String contactID = universityIDTextField.getText();
        Response response = Client.getInstance().requestForContact(contactID);
        if(response.getResponseStatus().equals(ResponseStatus.OK)){
            contactsListView.getItems().add((String) response.getData().get("Contact"));
        }
        else {
            errorLabel.setText(response.getErrorMessage());
        }
    }

    public void createChat(ActionEvent actionEvent) throws UnknownHostException {
        String contactID = contactsListView.getSelectionModel().getSelectedItem().split("\n")[1];
        Response response = Client.getInstance().createChatRequest(contactID);
        if(response.getResponseStatus().equals(ResponseStatus.OK)){
            String chatName = (String) response.getData().get("Chat");
            Client.getInstance().addChat(chatName);
        }
    }
}
