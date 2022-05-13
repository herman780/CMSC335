/*
 * Filename: Circle.java
 * Author: Herman Mann
 * Date: 04/10/2022
 * Description: Class to handle the circle related methods and extend the TwoDimensionalShape class
 */
//Package
package cmsc335_project2_hermanmann;

import java.awt.Graphics;

/**
 * Class to handle the circle related methods and extend the TwoDimensionalShape
 * class
 */
public class Circle extends TwoDimensionalShape {

    //Radius of the circle
    double radius;

    /**
     * Constructor of the class to initialize values and invoke the parent class
     * constructor
     *
     * @param radius - radius of circle
     */
    public Circle(double radius) {
        super(AppResources.MSG_CIRCLE);
        this.radius = radius;
    }

    /**
     * To override the parent class method and calculate the area
     */
    @Override
    public void calculateArea() {
        this.area = AppResources.PI * radius * radius;
    }

    /**
     * To draw and paint shape of the two dimensional shape. It will override by
     * the child classes
     *
     * @param g - graphics object
     */
    @Override
    public void paintComponent(Graphics g) {
        g.drawOval(0, 0, (int) radius, (int) radius);
    }
}
