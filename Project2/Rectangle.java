/*
 * Filename: Rectangle.java
 * Author: Herman Mann
 * Date: 04/10/2022
 * Description: Class to handle the rectangle related methods and extend the TwoDimensionalShape class
 */
//Package
package cmsc335_project2_hermanmann;

import java.awt.Graphics;

/**
 * Class to handle the rectangle related methods and extend the
 * TwoDimensionalShape class
 */
public class Rectangle extends TwoDimensionalShape {

    //Length of rectangle
    double length;
    //Width of rectangle
    double width;

    /**
     * Constructor of the class to initialize values and invoke the parent class
     * constructor
     *
     * @param length- length of rectangle
     * @param width- width of rectangle
     */
    public Rectangle(double length, double width) {
        super(AppResources.MSG_RECTANGLE);
        this.length = length;
        this.width = width;
    }

    /**
     * To override the parent class method and calculate the area
     */
    @Override
    public void calculateArea() {
        this.area = length * width;
    }

    /**
     * To draw and paint shape of the two dimensional shape. It will override by
     * the child classes
     *
     * @param g - graphics object
     */
    @Override
    public void paintComponent(Graphics g) {
        g.drawRect(0, 0, (int) length, (int) width);
    }
}
