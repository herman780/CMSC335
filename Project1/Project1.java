/*
 * Filename: Project1.java
 * Author: Herman Mann
 * Date: 03/27/2022
 * Description: Class to handle the console based user interaction. It has the main method and print related operations.
 * User enter the selected choice and the specific operation is performed by the application.
 */
//Package
package cmsc335_project1_hermanmann;

//Import files
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Class to handle the console based user interaction. It has the main method
 * and print related operations. User enter the selected choice and the specific
 * operation is performed by the application.
 */
public class Project1 {

    //Scanner input object
    Scanner scanner = new Scanner(System.in);

    /**
     * Main entry point of the project and to call the project related
     * operations
     *
     * @param args- command line arguments
     */
    public static void main(String[] args) {
        Project1 project = new Project1();
        project.performOperations();
    }

    /**
     * To perform the menu operations
     */
    public void performOperations() {
        char continueChoice;
        boolean isExit = false;
        System.out.println(AppResources.MSG_HEADER);
        do {
            printMenuOptions();
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    performCircleOperation();
                    break;
                case 2:
                    performRectangleOperation();
                    break;
                case 3:
                    performSquareOperation();
                    break;
                case 4:
                    performTriangleOperation();
                    break;
                case 5:
                    performSphereOperation();
                    break;
                case 6:
                    performCubeOperation();
                    break;
                case 7:
                    performConeOperation();
                    break;
                case 8:
                    performCylinderOperation();
                    break;
                case 9:
                    performTorusOperation();
                    break;
                case 10:
                    printFooter();
                    isExit = true;
                    break;
                default:
                    System.out.println(AppResources.MSG_PRINT_SELECTED_MENU_OPTION_ERROR);
                    break;
            }
            if (isExit) {
                break;
            }
            continueChoice = validateContinueSelection();
        } while (continueChoice == AppResources.MSG_PRINT_CONTINUE_YES);

    }

    /**
     * To perform and print circle related operations
     */
    public void performCircleOperation() {
        printSelectedOption(AppResources.MSG_CIRCLE);
        System.out.println(AppResources.MSG_PRINT_ENTER_RADIUS);
        double radius = scanner.nextDouble();
        Circle circle = new Circle(radius);
        circle.calculateArea();
        printArea(AppResources.MSG_CIRCLE, circle.getArea());
    }

    /**
     * To perform and print rectangle related operations
     */
    public void performRectangleOperation() {
        printSelectedOption(AppResources.MSG_RECTANGLE);
        System.out.println(AppResources.MSG_PRINT_ENTER_LENGTH);
        double length = scanner.nextDouble();
        System.out.println(AppResources.MSG_PRINT_ENTER_WIDTH);
        double width = scanner.nextDouble();
        Rectangle rectangle = new Rectangle(length, width);
        rectangle.calculateArea();
        printArea(AppResources.MSG_RECTANGLE, rectangle.getArea());
    }

    /**
     * To perform and print square related operations
     */
    public void performSquareOperation() {
        printSelectedOption(AppResources.MSG_SQUARE);
        System.out.println(AppResources.MSG_PRINT_ENTER_SIDE);
        double side = scanner.nextDouble();
        Square square = new Square(side);
        square.calculateArea();
        printArea(AppResources.MSG_SQUARE, square.getArea());
    }

    /**
     * To perform and print triangle related operations
     */
    public void performTriangleOperation() {
        printSelectedOption(AppResources.MSG_TRIANGLE);
        System.out.println(AppResources.MSG_PRINT_ENTER_BASE);
        double base = scanner.nextDouble();
        System.out.println(AppResources.MSG_PRINT_ENTER_HEIGHT);
        double height = scanner.nextDouble();
        Triangle triangle = new Triangle(base, height);
        triangle.calculateArea();
        printArea(AppResources.MSG_TRIANGLE, triangle.getArea());
    }

    /**
     * To perform and print sphere related operations
     */
    public void performSphereOperation() {
        printSelectedOption(AppResources.MSG_SPHERE);
        System.out.println(AppResources.MSG_PRINT_ENTER_RADIUS);
        double radius = scanner.nextDouble();
        Sphere sphere = new Sphere(radius);
        sphere.calculateVolume();
        printVolume(AppResources.MSG_SPHERE, sphere.getVolume());
    }

    /**
     * To perform and print cube related operations
     */
    public void performCubeOperation() {
        printSelectedOption(AppResources.MSG_CUBE);
        System.out.println(AppResources.MSG_PRINT_ENTER_SIDE);
        double side = scanner.nextDouble();
        Cube cube = new Cube(side);
        cube.calculateVolume();
        printVolume(AppResources.MSG_CUBE, cube.getVolume());
    }

    /**
     * To perform and print cone related operations
     */
    public void performConeOperation() {
        printSelectedOption(AppResources.MSG_CONE);
        System.out.println(AppResources.MSG_PRINT_ENTER_RADIUS);
        double radius = scanner.nextDouble();
        System.out.println(AppResources.MSG_PRINT_ENTER_HEIGHT);
        double height = scanner.nextDouble();
        Cone cone = new Cone(radius, height);
        cone.calculateVolume();
        printVolume(AppResources.MSG_CONE, cone.getVolume());
    }

    /**
     * To perform and print cylinder related operations
     */
    public void performCylinderOperation() {
        printSelectedOption(AppResources.MSG_CYLINDER);
        System.out.println(AppResources.MSG_PRINT_ENTER_RADIUS);
        double radius = scanner.nextDouble();
        System.out.println(AppResources.MSG_PRINT_ENTER_HEIGHT);
        double height = scanner.nextDouble();
        Cylinder cylinder = new Cylinder(radius, height);
        cylinder.calculateVolume();
        printVolume(AppResources.MSG_CYLINDER, cylinder.getVolume());
    }

    /**
     * To perform and print torus related operations
     */
    public void performTorusOperation() {
        printSelectedOption(AppResources.MSG_TORUS);
        System.out.println(AppResources.MSG_PRINT_ENTER_MINOR_RADIUS);
        double radius1 = scanner.nextDouble();
        System.out.println(AppResources.MSG_PRINT_ENTER_MAJOR_RADIUS);
        double radius2 = scanner.nextDouble();
        Torus torus = new Torus(radius1, radius2);
        torus.calculateVolume();
        printVolume(AppResources.MSG_TORUS, torus.getVolume());
    }

    /**
     * To print the selected option name
     *
     * @param optionName- selected option name
     */
    public void printSelectedOption(String optionName) {
        System.out.println(String.format(AppResources.MSG_PRINT_SELECTED_OPTION_FORMAT, optionName));
    }

    /**
     * To print the area of the selected option name
     *
     * @param optionName - selected option name
     * @param area - area of the selected option
     */
    public void printArea(String optionName, double area) {
        System.out.println(String.format(AppResources.MSG_PRINT_AREA_FORMAT, optionName, area));
    }

    /**
     * To print the volume of the selected option name
     *
     * @param optionName - selected option name
     * @param volume - volume of the selected option
     */
    public void printVolume(String optionName, double volume) {
        System.out.println(String.format(AppResources.MSG_PRINT_VOLUME_FORMAT, optionName, volume));
    }

    /**
     * To print the footer information in specific format
     */
    public void printFooter() {
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(AppResources.MSG_DATE_MONTH_FORMAT);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(AppResources.MSG_DATE_DAY_FORMAT);
        DateFormat dateFormat = new SimpleDateFormat(AppResources.MSG_DATE_TIME_FORMAT);
        Date date = new Date();
        String dateString = dateFormat.format(date);
        System.out.println(String.format(AppResources.MSG_PRINT_FOOTER_FORMAT, simpleDateFormat1.format(date), simpleDateFormat2.format(date), dateString));
    }

    /**
     * To validate the continue selection
     *
     * @return - the choice of continue selection
     */
    public char validateContinueSelection() {
        scanner.nextLine();
        System.out.println(AppResources.MSG_PRINT_CONTINUE);
        char continueChoice = Character.toUpperCase(scanner.nextLine().charAt(0));
        do {
            if (continueChoice != AppResources.MSG_PRINT_CONTINUE_YES && continueChoice != AppResources.MSG_PRINT_CONTINUE_NO) {
                System.out.println(AppResources.MSG_PRINT_SELECTED_OPTION_ERROR);
                continueChoice = Character.toUpperCase(scanner.nextLine().charAt(0));
            }
        } while (continueChoice != AppResources.MSG_PRINT_CONTINUE_YES && continueChoice != AppResources.MSG_PRINT_CONTINUE_NO);
        return continueChoice;
    }

    /**
     * To print the menu options
     */
    public void printMenuOptions() {
        System.out.println(AppResources.MSG_PRINT_SELECTED_MENU_OPTION);
        System.out.println(AppResources.MSG_PRINT_MENU_OPTION_1);
        System.out.println(AppResources.MSG_PRINT_MENU_OPTION_2);
        System.out.println(AppResources.MSG_PRINT_MENU_OPTION_3);
        System.out.println(AppResources.MSG_PRINT_MENU_OPTION_4);
        System.out.println(AppResources.MSG_PRINT_MENU_OPTION_5);
        System.out.println(AppResources.MSG_PRINT_MENU_OPTION_6);
        System.out.println(AppResources.MSG_PRINT_MENU_OPTION_7);
        System.out.println(AppResources.MSG_PRINT_MENU_OPTION_8);
        System.out.println(AppResources.MSG_PRINT_MENU_OPTION_9);
        System.out.println(AppResources.MSG_PRINT_MENU_OPTION_10);
    }
}
