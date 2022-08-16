package GUIController;

import APIs.SceneChanger;
import client.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import response.Response;
import response.ResponseStatus;
import users.User;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;

public class LoginGUI {
    @FXML
    TextField usernameTextField;
    @FXML
    TextField passwordTextField;
    @FXML
    Button loginButton;
    @FXML
    Label errorLabel;

    SceneChanger sceneChanger = new SceneChanger();

    public void login(ActionEvent actionEvent) throws IOException {
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();
        Response response = Client.getInstance().login(username,password);
        System.out.println(response.toString());
        if(response.getResponseStatus().equals(ResponseStatus.OK)){
            HashMap<String, Object> data =response.getData();
            List<String> contacts = (List<String>) data.get("Contacts");
            System.out.println(contacts);
            List<String> chats = (List<String>) data.get("Chats");
            System.out.println(chats);
            Client.getInstance().setContacts(contacts);
            Client.getInstance().setChats(chats);
            sceneChanger.changeScene(actionEvent,"Contacts.fxml");
        }
        else {
            errorLabel.setText("Invalid login");
        }
    }
}
