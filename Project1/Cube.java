/*
 * Filename: Cube.java
 * Author: Herman Mann
 * Date: 03/27/2022
 * Description: Class to handle the Cube related methods and extend the ThreeDimensionalShape class
 */
//Package
package cmsc335_project1_hermanmann;

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

}
