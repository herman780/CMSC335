/*
 * Filename: ThreeDimensionalShape.java
 * Author: Herman Mann
 * Date: 04/10/2022
 * Description: Class to handle the ThreeDimensionalShape related methods and extend the shape class
 */
//Package
package cmsc335_project2_hermanmann;

/**
 * Class to handle the ThreeDimensional related methods and extend the shape
 * class
 */
public class ThreeDimensionalShape extends Shape {

    //Volume of the three dimensional shape
    double volume;

    //Image file name;    
    String imageFileName;

    /**
     * Constructor of the class to initialize values and invoke the parent class
     * constructor
     *
     * @param name - name of the shape
     */
    public ThreeDimensionalShape(String name) {
        super(name, AppResources.THREE_DIMENSION);
    }

    /**
     * To get the volume of the three dimensional shape
     *
     * @return - volume of the shape
     */
    public double getVolume() {
        return volume;
    }

    /**
     * To calculate the volume of the three dimensional shape. It will override
     * by the child classes
     */
    public void calculateVolume() {
    }

    /**
     * To get image file name
     *
     * @return - image file name
     */
    public String getImageFileName() {
        return imageFileName;
    }

    /**
     * To set image file name
     *
     * @param imageFileName - image file name
     */
    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }
}
