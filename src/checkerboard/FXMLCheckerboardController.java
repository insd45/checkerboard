/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author iansmith
 */
public class FXMLCheckerboardController implements Initializable, Startable {
    
    private Stage stage;
    
    private final int numRows = 8;
    private final int numColumns = 8;
    
    private Checkerboard checkerboard;
    private AnchorPane anchorPane;
    
    @FXML
    private VBox vBox;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @Override
    public void start(Stage stage){
        this.stage = stage;
        
        checkerboard = new Checkerboard(numRows, numColumns, 60, 60);
        
        vBox.getChildren().add(checkerboard.getBoard());
        
        ChangeListener<Number> lambdaChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
            refresh(); //DRY principle
        };
        
        this.stage.widthProperty().addListener(lambdaChangeListener);
        this.stage.heightProperty().addListener(lambdaChangeListener);
        
        refresh();
        
        anchorPane = checkerboard.getBoard();
    }
    
    public void refresh(){
        checkerboard.build(vBox.getWidth(), vBox.getHeight() - 30); //-30 for menu
    }
    
    @FXML
    private void sixteenBySixteen(){
        vBox.getChildren().remove(checkerboard.getBoard());
        checkerboard = new Checkerboard(16, 16, 60, 60, checkerboard.getLightColor(), checkerboard.getDarkColor());
        vBox.getChildren().add(checkerboard.getBoard());
        refresh();
    }
    
    @FXML
    private void tenByTen(){
        vBox.getChildren().remove(checkerboard.getBoard());
        checkerboard = new Checkerboard(10, 10, 60, 60, checkerboard.getLightColor(), checkerboard.getDarkColor());
        vBox.getChildren().add(checkerboard.getBoard());
        refresh();
    }
    
    @FXML
    private void eightByEight(){
        vBox.getChildren().remove(checkerboard.getBoard());
        checkerboard = new Checkerboard(8, 8, 60, 60, checkerboard.getLightColor(), checkerboard.getDarkColor());
        vBox.getChildren().add(checkerboard.getBoard());
        refresh();
    }
    
    @FXML
    private void threeByThree(){
        vBox.getChildren().remove(checkerboard.getBoard());
        checkerboard = new Checkerboard(3, 3, 60, 60, checkerboard.getLightColor(), checkerboard.getDarkColor());
        vBox.getChildren().add(checkerboard.getBoard());
        refresh();
    }
    
    @FXML
    private void turnBlue(){
        vBox.getChildren().remove(checkerboard.getBoard());
        checkerboard = new Checkerboard(checkerboard.getNumRows(), checkerboard.getNumCols(), 60, 60, Color.SKYBLUE, Color.DARKBLUE);
        vBox.getChildren().add(checkerboard.getBoard());
        refresh();
    }
    
    @FXML
    private void turnRed(){
        vBox.getChildren().remove(checkerboard.getBoard());
        checkerboard = new Checkerboard(checkerboard.getNumRows(), checkerboard.getNumCols(), 60, 60, Color.RED, Color.BLACK);
        vBox.getChildren().add(checkerboard.getBoard());
        refresh();
    }
}
