import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
/**
 * Objective: Homework lab week 7
 * Algorithm:. create a simple calculator
 *Input and Output:
 * Created by: Gia Nguyen
 * Date: 4/69/2022
 * Version: 1.0
 */
public class SimpleCalculator  extends Application{
	public void start(Stage primaryStage) {
		//create a flow pane
		FlowPane pane = new FlowPane();
		pane.setHgap(2);
		// create three text field for the user to enter
		TextField tfNumber1 = new TextField();
		TextField tfNumber2 = new TextField();
		TextField tfResult = new TextField();
		//modify the prefered column count of the text fields
		tfNumber1.setPrefColumnCount(3);
		tfNumber2.setPrefColumnCount(3);
		tfResult.setPrefColumnCount(3);
		//add texts fields to the flow pane
		pane.getChildren().addAll(new Label("Number 1: "), tfNumber1,new Label("Number 2: "), tfNumber2,
				new Label("Result: "), tfResult); 
		//create an Hbox to store the buttons
		HBox hBox = new HBox(5);
		Button btAdd = new Button("Add");
		Button btSubtract = new Button("Subtract");
		Button btMultiply = new Button("Multiply");
		Button btDivide = new Button("Divide");
		//set alignment of HBoxto center
		hBox.setAlignment(Pos.CENTER);
		hBox.getChildren().addAll(btAdd,btSubtract,btMultiply,btDivide);
		//create an border pane
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(pane);
		borderPane.setBottom(hBox);
		//create a scene and add the border pane to that
		Scene scene = new Scene(borderPane, 250,150);
		primaryStage.setTitle("Simple Calculator");
		primaryStage.setScene(scene);
		primaryStage.show();
		//creatre EventHandlers for each buttons.
		btAdd.setOnAction( e -> {
			tfResult.setText(Double.parseDouble(tfNumber1.getText())+ Double.parseDouble(tfNumber2.getText())+"");
		});
		btSubtract.setOnAction( e -> {
			tfResult.setText(Double.parseDouble(tfNumber1.getText())- Double.parseDouble(tfNumber2.getText())+"");
		});
		btMultiply.setOnAction( e -> {
			tfResult.setText(Double.parseDouble(tfNumber1.getText())* Double.parseDouble(tfNumber2.getText())+"");
		});
		btDivide.setOnAction( e -> {
			tfResult.setText(Double.parseDouble(tfNumber1.getText())/ Double.parseDouble(tfNumber2.getText())+"");
		});
	
	}
	public static void main(String[] args) {
        launch(args);//launch application
    }
}
