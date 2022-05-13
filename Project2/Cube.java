/*
 * Filename: Cube.java
 * Author: Herman Mann
 * Date: 04/10/2022
 * Description: Class to handle the Cube related methods and extend the ThreeDimensionalShape class
 */
//Package
package cmsc335_project2_hermanmann;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

/**
 * Class to handle the Cube related methods and extend the ThreeDimensionalShape
 * class
 */
public class Cube extends ThreeDimensionalShape {

    //Side of the cube
    double side;

    /**
     * Constructor of the class to initialize values and invoke the parent class
     * constructor
     *
     * @param side - side of the cube
     */
    public Cube(double side) {
        super(AppResources.MSG_CUBE);
        this.side = side;
    }

    /**
     * To override the parent class method and calculate the volume
     */
    @Override
    public void calculateVolume() {
        this.volume = side * side * side;
    }

    /**
     * To draw and paint shape of the three dimensional shape as an image. It
     * will override by the child classes
     *
     * @param g - graphics object
     */
    @Override
    public void paintComponent(Graphics g) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage(this.imageFileName);
        g.drawImage(image, 6, 8, this);
    }

}
