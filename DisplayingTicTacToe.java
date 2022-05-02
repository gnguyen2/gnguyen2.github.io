/**
 * Objective: Homework lab week 7
 * Algorithm:. Display a tic-tac-toe board
 *Input and Output:
 * Created by: Gia Nguyen
 * Date: 3/27/2022
 * Version: 1.0
 */
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
public class DisplayingTicTacToe extends Application  {
    public void start(Stage primaryStage){
        Image imageX = new Image("image/x.png");//create an image and add the image view to pane. 
        Image imageO = new Image("image/o.png");//create an image and add the image view to pane.
        // Create a pane to hold the image view
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);//Sets the alignment of the node in the BorderPane.
        pane.setHgap(5);//set the horizontal gap between the nodes
        pane.setVgap(5); //set the vertical gap between the nodes
        // a for loop to display X and O
        for (int i = 0; i < 3; i++){
            for( int j = 0; j < 3;j++){
                int status = (int) (Math.random()* 2);
                if (status == 0){
                    pane.add(new ImageView(imageX), j, i);
                }
                else if (status == 1) pane.add(new ImageView(imageO), j, i);
            }
        }
        Scene scene = new Scene(pane);//create a scene
        primaryStage.setTitle("Display TicK Tack Toe");//set stage title
        primaryStage.setScene(scene);//set a scene
        primaryStage.show();//display stage
    }
    public static void main(String[] args) {
        launch(args);//launch application
    }
}

