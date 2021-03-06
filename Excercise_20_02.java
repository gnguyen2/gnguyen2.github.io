import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Collections;
import java.util.LinkedList;
public class Excercise_20_02 extends Application {
	//**********************************
	//COSC 1337 Programming Fund II
	//Name: Gia Nguyen
	//Data: 4/17/2022
	//Homework 10
	//Spring 2022
	//***********************************
    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setScene(new Scene(new NumberListPane()));
        primaryStage.setTitle("Store numbers in linked list");
        primaryStage.show();
    }

    private class NumberListPane extends BorderPane {

        private Label lblNumber;
        private Label lblNotANumber;
        private TextField tfNumber;
        private TextArea taField;

        private LinkedList<Integer> list;

        private Button btnSort;
        private Button btnShuffle;
        private Button btnReverse;

        NumberListPane() {

            list = new LinkedList<>();

            // Top Node
            lblNumber = new Label("Enter a number:");

            lblNotANumber = new Label();
            lblNotANumber.setVisible(false);

            tfNumber = new TextField();
            tfNumber.setPrefColumnCount(4);

            HBox hBox = new HBox(10, lblNumber, tfNumber, lblNotANumber);
            hBox.setAlignment(Pos.CENTER);
            hBox.setPadding(new Insets(5));
            setTop(hBox);
            // End top node

            // Center Node
            taField = new TextArea();
            ScrollPane scrollPane = new ScrollPane(taField);
            scrollPane.setPrefHeight(100);
            setCenter(scrollPane);
            // End center Node

            // Bottom Node
            btnSort = new Button("Sort");
            btnReverse = new Button("Reverse");
            btnShuffle = new Button("Shuffle");
            hBox = new HBox(20, btnSort, btnReverse, btnShuffle);
            hBox.setAlignment(Pos.BASELINE_CENTER);
            hBox.setPadding(new Insets(5));
            setBottom(hBox);
            // End bottom node

            // Listeners
            tfNumber.setOnKeyPressed(e -> {
                if (e.getCode() == KeyCode.ENTER) {
                    int number;
                    try {
                        number = Integer.parseInt(tfNumber.getText());

                        if (lblNotANumber.isVisible())
                            lblNotANumber.setVisible(false);

                        if (!list.contains(number)) {
                            list.add(number);
                            appendTextArea();
                        } else {
                            lblNotANumber.setText("That's duplicate number!");
                            lblNotANumber.setVisible(true);
                        }

                    } catch (NumberFormatException ex) {
                        lblNotANumber.setText("Not a number!");
                        lblNotANumber.setVisible(true);
                    }
                }
            });

            btnShuffle.setOnMouseClicked(e-> {
                Collections.shuffle(list);
                refreshTextArea();
            });
            btnSort.setOnMouseClicked(e-> {
                Collections.sort(list);
                refreshTextArea();
            });
            btnReverse.setOnMouseClicked(e-> {
                Collections.reverse(list);
                refreshTextArea();
            });
        }

        private void refreshTextArea() {
            String string = "";
            for (Integer s : list) {
                string += s + " ";
            }
            taField.setText(string);
        }

        private void appendTextArea() {
            taField.appendText(" "+list.getLast());
        }
    }

    public static void main(String[] args) {
        Application.launch(args);
    }


}