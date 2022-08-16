package GUIController;

import APIs.SceneChanger;
import client.Client;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.UnknownHostException;

public class ShowContentGUI {
    @FXML
    public ImageView backButton;
    @FXML
    public ImageView image;

    SceneChanger sceneChanger = new SceneChanger();

    public void initialize() throws UnknownHostException {
        byte[] buffer = Client.getInstance().getChatController().getFiles().get(Client.getInstance().getCurrentFile());
        image.setImage(new Image(new ByteArrayInputStream(buffer)));
    }

    public void goToChat(MouseEvent mouseEvent) throws IOException {
        sceneChanger.changeScene(mouseEvent, "Chat.fxml");
    }
}
