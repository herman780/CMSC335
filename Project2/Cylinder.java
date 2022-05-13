/*
 * Filename: Cylinder.java
 * Author: Herman Mann
 * Date: 04/10/2022
 * Description: Class to handle the Cylinder related methods and extend the ThreeDimensionalShape class
 */
//Package
package cmsc335_project2_hermanmann;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

/**
 * Class to handle the Cylinder related methods and extend the
 * ThreeDimensionalShape class
 */
public class Cylinder extends ThreeDimensionalShape {

    //Radius of the cylinder
    double radius;
    //Height of the cylinder
    double height;

    /**
     * Constructor of the class to initialize values and invoke the parent class
     * constructor
     *
     * @param radius - radius of the cylinder
     * @param height - height of the cylinder
     */
    public Cylinder(double radius, double height) {
        super(AppResources.MSG_CYLINDER);
        this.radius = radius;
        this.height = height;
    }

    /**
     * To override the parent class method and calculate the volume
     */
    @Override
    public void calculateVolume() {
        this.volume = (AppResources.PI * radius * radius * height);
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
