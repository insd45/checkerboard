/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author ian
 */
public class Checkerboard {
    private double width;
    private double height;
    private int rows;
    private int columns;
    private double rectangleWidth;
    private double rectangleHeight;
    private AnchorPane anchorPane;
    //private Color[] colors = {Color.RED, Color.BLACK, Color.SKYBLUE, Color.DARKBLUE};
    private Color[] colors = new Color[2];
    
    public Checkerboard(int rows, int columns, double boardWidth, double boardHeight) {
        this.rows = rows;
        this.columns = columns;
        this.width = boardWidth;
        this.height = boardHeight;
        colors[0] = Color.RED;
        colors[1] = Color.BLACK;
       
        anchorPane = new AnchorPane();
    }
    
    //constructor 2
    public Checkerboard(int rows, int columns, double boardWidth, double boardHeight, Color lightColor, Color darkColor) {
        this(rows, columns, boardWidth, boardHeight);
        colors[0] = lightColor;
        colors[1] = darkColor;
       
        anchorPane = new AnchorPane();
    }
    
    public AnchorPane build(double width, double height) {
        clear();
        this.width = width;
        this.height = height;
        rectangleWidth = width / (double)columns;
        rectangleHeight = height / (double)rows;
        //rectangleWidth = width / (double)columns;
        //rectangleHeight = height / (double)rows;
        anchorPane.setPrefWidth(width);
        anchorPane.setPrefHeight(height);
        
        //Set colors
        int numColors = colors.length;
        
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col <columns; col++) {
                //Similar to dealing with random as done in class
                
                Color color;
                //Math: If the row and column number add to be even, it's a light color
                //If the row and column add together and are odd, it's a dark color
                if(((row + col) % 2) == 0){
                    //Even :: Light
                    color = colors[0];
                } else {
                    //Odd :: Dark
                    color = colors[1];
                }
                
                Rectangle rect = new Rectangle(rectangleWidth, rectangleHeight, color);
                AnchorPane.setTopAnchor(rect, (row * rectangleHeight));
                AnchorPane.setLeftAnchor(rect, (col * rectangleWidth));
                anchorPane.getChildren().add(rect);
            }
        }
        
        return anchorPane;
    }
    
    public void clear() {
        anchorPane.getChildren().clear();
    }
    
    public AnchorPane getBoard() {
        if(anchorPane != null){
            return anchorPane;
        } else {
            //Hasn't been built yet
            return null;
        }
    }
    
    public int getNumRows() {
        return rows;
    }
    
    public int getNumCols() {
        return columns;
    }
    
    public double getWidth() {
        return width;
    }
    
    public double getHeight() {
        return height;
    }
    
    public Color getLightColor() {
        return colors[0];
    }
    
    public Color getDarkColor() {
        return colors[1];
    }
    
    public double getRectangleWidth() {
        return rectangleWidth;
    }
    
    public double getRectangleHeight() {
        return rectangleHeight;
    }
    
}
