/*
 * Filename: Square.java
 * Author: Herman Mann
 * Date: 04/10/2022
 * Description: Class to handle the square related methods and extend the TwoDimensionalShape class
 */
//Package
package cmsc335_project2_hermanmann;

import java.awt.Graphics;

/**
 * Class to handle the square related methods and extend the TwoDimensionalShape
 * class
 */
public class Square extends TwoDimensionalShape {

    //Side of square
    double side;

    /**
     * Constructor of the class to initialize values and invoke the parent class
     * constructor
     *
     * @param side - side of a square
     */
    public Square(double side) {
        super(AppResources.MSG_SQUARE);
        this.side = side;
    }

    /**
     * To override the parent class method and calculate the area
     */
    @Override
    public void calculateArea() {
        this.area = side * side;
    }

    /**
     * To draw and paint shape of the two dimensional shape. It will
     * override by the child classes
     *
     * @param g - graphics object
     */
    @Override
    public void paintComponent(Graphics g) {
        g.drawRect(0, 0, (int) side, (int) side);
    }

}
