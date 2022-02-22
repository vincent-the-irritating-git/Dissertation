package dissertation;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import server_side.Message;
import server_side.Protocol;

import java.io.IOException;


public class Main extends Application {

    @FXML
    private Pane pane;

    public Main() throws IOException {}

    //==================================================================//

    //==================================================================

    @Override
    public void start(Stage stage) {

        Protocol p       = new Protocol();
        Message  message = new Message("is-registered?");
        p.protocolToUse(message);
        if (p.getM().getMessage().equals("true")) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource(
                    "fxml//body.fxml"));
                Scene scene = new Scene(root, 744, 615);

                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return;

        } else {
            try {
                Parent root = FXMLLoader.load(getClass().getResource(
                    "fxml//NewRegister.fxml"));
                Scene scene = new Scene(root, 600, 400);
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //our FXMLLoader
    public Object getLoader(String fxmlName){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "fxml" +
                "//"+fxmlName+
                ".fxml"));
            Parent root = loader.load();
            //Get controller of bodyController
            Object ad = loader.getController();
            return ad;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //converts the boolean to a string character
    public static String veganBoolean(int x) {
        if (x == 0) {
            return "Ve";
        } else
            return "V";
    }

    public static void openNewWindow(Parent root) {
        Stage stage = new Stage();
        try {
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
        stage.show();
    }


}