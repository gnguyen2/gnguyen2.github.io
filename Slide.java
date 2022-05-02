import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 * Objective: Homework lab week 8
 * Algorithm:. create a slides
 *Input and Output:
 * Created by: Gia Nguyen
 * Date: 4/69/2022
 * Version: 1.0
 */
public class Slide extends Application{
	public void start(Stage primaryStage) {
		//create a text object
		Text text = new Text(20,20, "JavaFX Programming");
		//create a horizontal slide
		Slider s1Horizontal = new Slider();
		s1Horizontal.setShowTickLabels(true);
		s1Horizontal.setShowTickMarks(true);
		//create a vertical slide
		Slider s1Vertical = new Slider();
		s1Vertical.setOrientation(Orientation.VERTICAL);
		s1Vertical.setShowTickLabels(true);
		s1Vertical.setShowTickMarks(true);
		s1Vertical.setValue(100);
		//create a pane to store the text node
		Pane paneForText = new Pane();
		paneForText.getChildren().add(text);
		//create a border pane to store slides and text pane
		BorderPane pane = new BorderPane();
		pane.setCenter(paneForText);
		pane.setBottom(s1Horizontal);
		pane.setRight(s1Vertical);
		//create EventHandlers for each slides.
		s1Horizontal.valueProperty().addListener(ov -> {
			text.setX(s1Horizontal.getValue()* paneForText.getWidth()/ s1Horizontal.getMax());
		});
		s1Vertical.valueProperty().addListener(ov -> {
			text.setY(s1Vertical.getMax()-(s1Vertical.getValue()* paneForText.getHeight()/ s1Vertical.getMax()));
		});
		//create a scene
		Scene scene = new Scene(pane,450,170);
		primaryStage.setTitle("Slider Demo");
		primaryStage.setScene(scene);
		primaryStage.show();	
	}
	public static void main(String[] args) {
		launch(args);
	}

}
