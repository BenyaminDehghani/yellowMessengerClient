package APIs;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneChanger {
    public void changeScene(ActionEvent actionEvent, String sceneName) throws IOException {
        Stage stage=(Stage)(((Node)(actionEvent.getSource())).getScene().getWindow());
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(sceneName));
        Parent root=loader.load();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void changeScene(MouseEvent mouseEvent, String sceneName) throws IOException {
        Stage stage=(Stage)(((Node)(mouseEvent.getSource())).getScene().getWindow());
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(sceneName));
        Parent root=loader.load();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void changeScene(Stage stage,String sceneName) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(sceneName));
        Parent root=loader.load();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
