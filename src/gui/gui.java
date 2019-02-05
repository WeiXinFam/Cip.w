package gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.util.Objects;


public class gui extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Stage stage1 = new Stage();
        stage1.setTitle("WELCOME");

        Image a = new Image(String.valueOf(gui.class.getResource("Cip.png")));
        ImageView view = new ImageView();
        view.setImage(a);
       // view.setOpacity(0.3);


        Group root = new Group(view);
        //name entered
        Label label1 = new Label("Name:");
        TextField txtF = new TextField();
        txtF.setPrefWidth(200);
        Button button = new Button("Start");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            }
        });
        HBox hb = new HBox();
        hb.getChildren().addAll(txtF);
        hb.setSpacing(10);
        hb.setLayoutX(150);
        hb.setLayoutY(300);
        HBox hb2 = new HBox();
        hb2.getChildren().addAll(button);
        hb2.setLayoutX(230);
        hb2.setLayoutY(350);

        root.getChildren().addAll(hb,hb2);


        Scene scene1 = new Scene(root, 500, 500);
        stage1.setScene(scene1);
        stage1.show();
    }
}
