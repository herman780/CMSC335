/*
 * Filename: GUI.java
 * Author: Herman Mann
 * Date: 04/10/2022
 * Description: Class to handle the GUI based user interaction. It has the main method and print related operations.
 * User enter the selected choice and the specific operation is performed by the application. 
 * It will construct a Java Swing GUI that uses event handlers and listeners while expanding 
 * on the project 1 Shape theme
 */
//Package
package cmsc335_project2_hermanmann;

//Import files
import java.awt.Component;
import java.awt.ItemSelectable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 * Class to handle the GUI based user interaction. It has the main method and
 * print related operations. User enter the selected choice and the specific
 * operation is performed by the application. It will construct a Java Swing GUI
 * that uses event handlers and listeners while expanding on the project 1 Shape
 * theme
 */
public class GUI extends JFrame {

    //Declare and initialize variables and components
    private JButton jButtonDraw;
    private JComboBox<String> jComboBoxShapes;
    private JLabel jLabelSelectShape;
    private JLabel jLabelInput1;
    private JLabel jLabelInput2;
    private JLabel jLabelInput3;
    private JLabel jLabelResult;
    private JPanel jPanelInput;
    private JTextField jTextFieldInput1;
    private JTextField jTextFieldInput2;
    private JTextField jTextFieldInput3;
    private JTextField jTextFieldResult;

    private String itemSelected = "";
    private Component lastComponent;
    List<Boolean> listLabels = new ArrayList<>(AppResources.INPUT_MAX_SIZE);
    List<Boolean> listTextFields = new ArrayList<>(AppResources.INPUT_MAX_SIZE);

    /**
     * Main entry point of the project and to call the project related
     * operations
     *
     * @param args- command line arguments
     */
    public static void main(String[] args) {
        GUI project2GUI = new GUI();
        project2GUI.initialize();
        project2GUI.defaultInputsSettings();
        project2GUI.setVisible(true);
    }

    /**
     * To initialize the GUI components and controls with associated events and
     * properties
     */
    public void initialize() {
        this.setSize(750, 800);
        this.setTitle(AppResources.MSG_TITLE);

        jLabelSelectShape = new JLabel();
        jComboBoxShapes = new JComboBox<>();
        jPanelInput = new JPanel();
        jButtonDraw = new JButton();
        jLabelInput1 = new JLabel();
        jTextFieldInput1 = new JTextField();
        jLabelInput2 = new JLabel();
        jTextFieldInput2 = new JTextField();
        jLabelInput3 = new JLabel();
        jTextFieldInput3 = new JTextField();
        jLabelResult = new JLabel();
        jTextFieldResult = new JTextField();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font(AppResources.MSG_FONT_FAMILY, 1, 14));

        jLabelSelectShape.setFont(getFont());
        jLabelSelectShape.setText(AppResources.MSG_SELECT_SHAPE);

        jComboBoxShapes.setModel(new DefaultComboBoxModel<>(new String[]{
            AppResources.MSG_SELECT_PLEASE, AppResources.MSG_CIRCLE, AppResources.MSG_CONE, AppResources.MSG_CUBE, AppResources.MSG_CYLINDER,
            AppResources.MSG_RECTANGLE, AppResources.MSG_SPHERE, AppResources.MSG_SQUARE, AppResources.MSG_TORUS, AppResources.MSG_TRIANGLE}));

        jComboBoxShapes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxShapesActionPerformed(evt);
            }
        });

        jPanelInput.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jButtonDraw.setBackground(new java.awt.Color(51, 255, 51));
        jButtonDraw.setFont(new java.awt.Font(AppResources.MSG_FONT_FAMILY, 1, 18));
        jButtonDraw.setForeground(new java.awt.Color(255, 255, 255));
        jButtonDraw.setText(AppResources.MSG_DRAW);
        jButtonDraw.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 51, 255), new java.awt.Color(0, 51, 255), new java.awt.Color(0, 51, 255), new java.awt.Color(0, 51, 255)));
        jButtonDraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDrawActionPerformed(evt);
            }
        });

        jLabelInput1.setText("");
        jTextFieldInput1.setText("");
        jLabelInput2.setText("");
        jTextFieldInput2.setText("");
        jLabelInput3.setText("");
        jTextFieldInput3.setText("");
        jLabelResult.setText(AppResources.MSG_PRINT_ENTER_PARAMETERS);
        jTextFieldResult.setText("");

        GroupLayout jPanelInputLayout = new GroupLayout(jPanelInput);
        jPanelInput.setLayout(jPanelInputLayout);
        jPanelInputLayout.setHorizontalGroup(
                jPanelInputLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelInputLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelInputLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelInput2)
                                        .addComponent(jLabelInput1)
                                        .addComponent(jLabelInput3)
                                        .addComponent(jLabelResult))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                                .addGroup(jPanelInputLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanelInputLayout.createSequentialGroup()
                                                .addComponent(jTextFieldInput1, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
                                                .addGap(180, 180, 180))
                                        .addGroup(jPanelInputLayout.createSequentialGroup()
                                                .addGroup(jPanelInputLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextFieldInput2, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextFieldInput3, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextFieldResult, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButtonDraw, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                                                .addGap(32, 32, 32))))
        );
        jPanelInputLayout.setVerticalGroup(
                jPanelInputLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelInputLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(jPanelInputLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabelInput1)
                                        .addComponent(jTextFieldInput1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanelInputLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelInputLayout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanelInputLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jTextFieldInput2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabelInput2))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanelInputLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jTextFieldInput3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabelInput3))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanelInputLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jTextFieldResult, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabelResult)))
                                        .addGroup(jPanelInputLayout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addComponent(jButtonDraw, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(21, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabelSelectShape)
                                                .addGap(80, 80, 80)
                                                .addComponent(jComboBoxShapes, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(jPanelInput, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelSelectShape)
                                        .addComponent(jComboBoxShapes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jPanelInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(382, Short.MAX_VALUE))
        );

        pack();

    }

    /**
     * To perform action associated with combo box of shapes
     *
     * @param evt - combo box event
     */
    private void jComboBoxShapesActionPerformed(java.awt.event.ActionEvent evt) {
        ItemSelectable itemSelectable = (ItemSelectable) evt.getSource();
        itemSelected = (String) itemSelectable.getSelectedObjects()[0];
        performActions(false);
    }

    /**
     * To perform action associated with draw button of shape
     *
     * @param evt - button event
     */
    private void jButtonDrawActionPerformed(java.awt.event.ActionEvent evt) {
        performActions(true);
    }

    /**
     * To perform action based of the selected shape
     *
     * @param isButton - True if button related actions
     */
    public void performActions(boolean isButton) {
        removeComponents();
        switch (itemSelected) {
            case AppResources.MSG_CIRCLE:
                if (isButton) {
                    performCircleOperation();
                } else {
                    inputCircleParameters();
                }
                break;
            case AppResources.MSG_RECTANGLE:
                if (isButton) {
                    performRectangleOperation();
                } else {
                    inputRectangleParameters();
                }
                break;
            case AppResources.MSG_SQUARE:
                if (isButton) {
                    performSquareOperation();
                } else {
                    inputSquareParameters();
                }
                break;
            case AppResources.MSG_TRIANGLE:
                if (isButton) {
                    performTriangleOperation();
                } else {
                    inputTriangleParameters();
                }
                break;
            case AppResources.MSG_CONE:
                if (isButton) {
                    performConeOperation();
                } else {
                    inputConeParameters();
                }
                break;
            case AppResources.MSG_CUBE:
                if (isButton) {
                    performCubeOperation();
                } else {
                    inputCubeParameters();
                }
                break;
            case AppResources.MSG_CYLINDER:
                if (isButton) {
                    performCylinderOperation();
                } else {
                    inputCylinderParameters();
                }
                break;
            case AppResources.MSG_SPHERE:
                if (isButton) {
                    performSphereOperation();
                } else {
                    inputSphereParameters();
                }
                break;
            case AppResources.MSG_TORUS:
                if (isButton) {
                    performTorusOperation();
                } else {
                    inputTorusParameters();
                }
                break;
            default:
                defaultInputsSettings();
                break;
        }
        this.repaint();
    }

    /**
     * To remove components
     */
    public void removeComponents() {
        if (lastComponent != null) {
            this.remove(lastComponent);
        }
    }

    /**
     * To show error message dialog
     *
     * @param errorMsg - error message
     */
    public void ShowErrorMessage(String errorMsg) {
        JOptionPane.showMessageDialog(this, errorMsg, AppResources.MSG_ERROR_TITLE, JOptionPane.ERROR_MESSAGE);
        jTextFieldResult.setText("");
        jLabelResult.setVisible(false);
        jTextFieldResult.setVisible(false);
    }

    /**
     * To set input parameters for circle
     */
    public void inputCircleParameters() {
        setOneInputVisibility(AppResources.MSG_PRINT_ENTER_RADIUS);
    }

    /**
     * To perform and print circle related operations
     */
    public void performCircleOperation() {
        try {
            double radius = Double.parseDouble(jTextFieldInput1.getText());
            validateInput(radius);
            Circle circle = new Circle(radius);
            circle.calculateArea();
            this.add(circle);
            lastComponent = circle;
            setOperationResult(AppResources.MSG_CIRCLE + AppResources.MSG_AREA, circle.getArea());
        } catch (NumberFormatException numberFormatException) {
            ShowErrorMessage(numberFormatException.getMessage());
        } catch (Exception ex) {
            ShowErrorMessage(ex.getMessage());
        }
    }

    /**
     * To set input parameters for rectangle
     */
    public void inputRectangleParameters() {
        setTwoInputFields(AppResources.MSG_PRINT_ENTER_LENGTH, AppResources.MSG_PRINT_ENTER_WIDTH);
    }

    /**
     * To perform and print rectangle related operations
     */
    public void performRectangleOperation() {
        try {
            double length = Double.parseDouble(jTextFieldInput1.getText());
            double width = Double.parseDouble(jTextFieldInput2.getText());
            validateInput(length, width);
            Rectangle rectangle = new Rectangle(length, width);
            rectangle.calculateArea();
            this.add(rectangle);
            lastComponent = rectangle;
            setOperationResult(AppResources.MSG_RECTANGLE + AppResources.MSG_AREA, rectangle.getArea());
        } catch (NumberFormatException numberFormatException) {
            ShowErrorMessage(numberFormatException.getMessage());
        } catch (Exception ex) {
            ShowErrorMessage(ex.getMessage());
        }
    }

    /**
     * To set input parameters for square
     */
    public void inputSquareParameters() {
        setOneInputVisibility(AppResources.MSG_PRINT_ENTER_SIDE);

    }

    /**
     * To perform and print square related operations
     */
    public void performSquareOperation() {
        try {
            double side = Double.parseDouble(jTextFieldInput1.getText());
            validateInput(side);
            Square square = new Square(side);
            square.calculateArea();
            this.add(square);
            lastComponent = square;
            setOperationResult(AppResources.MSG_SQUARE + AppResources.MSG_AREA, square.getArea());
        } catch (NumberFormatException numberFormatException) {
            ShowErrorMessage(numberFormatException.getMessage());
        } catch (Exception ex) {
            ShowErrorMessage(ex.getMessage());
        }
    }

    /**
     * To set input parameters for triangle
     */
    public void inputTriangleParameters() {
        setTwoInputFields(AppResources.MSG_PRINT_ENTER_HEIGHT, AppResources.MSG_PRINT_ENTER_BASE);
    }

    /**
     * To perform and print triangle related operations
     */
    public void performTriangleOperation() {
        try {
            double base = Double.parseDouble(jTextFieldInput1.getText());
            double height = Double.parseDouble(jTextFieldInput2.getText());
            validateInput(base, height);
            Triangle triangle = new Triangle(base, height);
            triangle.calculateArea();
            this.add(triangle);
            lastComponent = triangle;
            setOperationResult(AppResources.MSG_TRIANGLE + AppResources.MSG_AREA, triangle.getArea());
        } catch (NumberFormatException numberFormatException) {
            ShowErrorMessage(numberFormatException.getMessage());
        } catch (Exception ex) {
            ShowErrorMessage(ex.getMessage());
        }
    }

    /**
     * To set input parameters for sphere
     */
    public void inputSphereParameters() {
        setOneInputVisibility(AppResources.MSG_PRINT_ENTER_RADIUS);
    }

    /**
     * To perform and print sphere related operations
     */
    public void performSphereOperation() {
        try {
            double radius = Double.parseDouble(jTextFieldInput1.getText());
            validateInput(radius);
            Sphere sphere = new Sphere(radius);
            sphere.setImageFileName("Sphere_30.png");
            sphere.calculateVolume();
            this.add(sphere);
            lastComponent = sphere;
            setOperationResult(AppResources.MSG_SPHERE + AppResources.MSG_VOLUME, sphere.getVolume());
        } catch (NumberFormatException numberFormatException) {
            ShowErrorMessage(numberFormatException.getMessage());
        } catch (Exception ex) {
            ShowErrorMessage(ex.getMessage());
        }
    }

    /**
     * To set input parameters for cube
     */
    public void inputCubeParameters() {
        setOneInputVisibility(AppResources.MSG_PRINT_ENTER_SIDE);
    }

    /**
     * To perform and print cube related operations
     */
    public void performCubeOperation() {
        try {
            double side = Double.parseDouble(jTextFieldInput1.getText());
            validateInput(side);
            Cube cube = new Cube(side);
            cube.setImageFileName("Cube_30.png");
            cube.calculateVolume();
            this.add(cube);
            lastComponent = cube;
            setOperationResult(AppResources.MSG_SPHERE + AppResources.MSG_VOLUME, cube.getVolume());
        } catch (NumberFormatException numberFormatException) {
            ShowErrorMessage(numberFormatException.getMessage());
        } catch (Exception ex) {
            ShowErrorMessage(ex.getMessage());
        }
    }

    /**
     * To set input parameters for cone
     */
    public void inputConeParameters() {
        setTwoInputFields(AppResources.MSG_PRINT_ENTER_RADIUS, AppResources.MSG_PRINT_ENTER_HEIGHT);
    }

    /**
     * To perform and print cone related operations
     */
    public void performConeOperation() {
        try {
            double radius = Double.parseDouble(jTextFieldInput1.getText());
            double height = Double.parseDouble(jTextFieldInput2.getText());
            validateInput(radius, height);
            Cone cone = new Cone(radius, height);
            cone.setImageFileName("Cone_30.png");
            cone.calculateVolume();
            this.add(cone);
            lastComponent = cone;
            setOperationResult(AppResources.MSG_CONE + AppResources.MSG_VOLUME, cone.getVolume());
        } catch (NumberFormatException numberFormatException) {
            ShowErrorMessage(numberFormatException.getMessage());
        } catch (Exception ex) {
            ShowErrorMessage(ex.getMessage());
        }
    }

    /**
     * To set input parameters for cylinder
     */
    public void inputCylinderParameters() {
        setTwoInputFields(AppResources.MSG_PRINT_ENTER_RADIUS, AppResources.MSG_PRINT_ENTER_HEIGHT);
    }

    /**
     * To perform and print cylinder related operations
     */
    public void performCylinderOperation() {
        try {
            double radius = Double.parseDouble(jTextFieldInput1.getText());
            double height = Double.parseDouble(jTextFieldInput2.getText());
            validateInput(radius, height);
            Cylinder cylinder = new Cylinder(radius, height);
            cylinder.setImageFileName("Cylinder_30_70.png");
            cylinder.calculateVolume();
            this.add(cylinder);
            lastComponent = cylinder;
            setOperationResult(AppResources.MSG_CYLINDER + AppResources.MSG_VOLUME, cylinder.getVolume());
        } catch (NumberFormatException numberFormatException) {
            ShowErrorMessage(numberFormatException.getMessage());
        } catch (Exception ex) {
            ShowErrorMessage(ex.getMessage());
        }
    }

    /**
     * To set input parameters for torus
     */
    public void inputTorusParameters() {
        setTwoInputFields(AppResources.MSG_PRINT_ENTER_MINOR_RADIUS, AppResources.MSG_PRINT_ENTER_MAJOR_RADIUS);
    }

    /**
     * To perform and print torus related operations
     */
    public void performTorusOperation() {
        try {
            double radius1 = Double.parseDouble(jTextFieldInput1.getText());
            double radius2 = Double.parseDouble(jTextFieldInput2.getText());
            validateInput(radius1, radius2);
            Torus torus = new Torus(radius1, radius2);
            torus.setImageFileName("Torus_30.png");
            torus.calculateVolume();
            this.add(torus);
            lastComponent = torus;
            setOperationResult(AppResources.MSG_TORUS + AppResources.MSG_VOLUME, torus.getVolume());
        } catch (NumberFormatException numberFormatException) {
            ShowErrorMessage(numberFormatException.getMessage());
        } catch (Exception ex) {
            ShowErrorMessage(ex.getMessage());
        }
    }

    /**
     * To initialize the collection of input labels and text fields
     */
    public void initInputs() {
        listLabels.clear();
        listTextFields.clear();
        for (int i = 0; i < AppResources.INPUT_MAX_SIZE; i++) {
            listLabels.add(false);
            listTextFields.add(false);
        }
    }

    /**
     * To set input panel and components visibility
     *
     * @param isPanelVisible - True if input panel is visible
     */
    public void setInputPanelVisibility(boolean isPanelVisible) {
        jPanelInput.setVisible(isPanelVisible);

        jLabelInput1.setVisible(listLabels.get(0));
        jLabelInput2.setVisible(listLabels.get(1));
        jLabelInput3.setVisible(listLabels.get(2));
        jLabelResult.setVisible(listLabels.get(3));

        jTextFieldInput1.setVisible(listLabels.get(0));
        jTextFieldInput2.setVisible(listLabels.get(1));
        jTextFieldInput3.setVisible(listLabels.get(2));
        jTextFieldResult.setVisible(listLabels.get(3));

    }

    /**
     * To set one input field content and visibility
     *
     * @param input1Msg - input 1 message
     */
    public void setOneInputVisibility(String input1Msg) {
        defaultInputsSettings();
        jLabelInput1.setText(input1Msg);
        initInputs();
        listLabels.set(0, true);
        listTextFields.set(0, true);
        setInputPanelVisibility(true);

    }

    /**
     * To set two input fields content and visibility
     *
     * @param input1Msg - input 1 message
     * @param input2Msg - input 1 message
     */
    public void setTwoInputFields(String input1Msg, String input2Msg) {
        defaultInputsSettings();
        jLabelInput1.setText(input1Msg);
        jLabelInput2.setText(input2Msg);
        initInputs();
        listLabels.set(0, true);
        listLabels.set(1, true);
        listTextFields.set(0, true);
        listTextFields.set(1, true);
        setInputPanelVisibility(true);
    }

    /**
     * To set default user input fields
     */
    public void defaultInputsSettings() {
        jPanelInput.setVisible(true);

        jLabelInput1.setVisible(false);
        jLabelInput2.setVisible(false);
        jLabelInput3.setVisible(false);
        jLabelResult.setText(AppResources.MSG_PRINT_ENTER_PARAMETERS);
        jLabelResult.setVisible(true);

        jTextFieldInput1.setVisible(false);
        jTextFieldInput1.setText("");
        jTextFieldInput2.setVisible(false);
        jTextFieldInput2.setText("");
        jTextFieldInput3.setVisible(false);
        jTextFieldInput3.setText("");
        jTextFieldResult.setVisible(true);
        jTextFieldResult.setText("");
        jTextFieldResult.setEditable(false);

    }

    /**
     * To set operation result messages
     *
     * @param resultMsg - result message
     * @param resultValue - result value
     */
    public void setOperationResult(String resultMsg, double resultValue) {
        jLabelResult.setText(resultMsg);
        jTextFieldResult.setText(String.format(AppResources.MSG_PRINT_RESULT_FORMAT, resultValue));
        jLabelResult.setVisible(true);
        jTextFieldResult.setVisible(true);
    }

    /**
     * To validate input for a positive value
     * 
     * @param input - input value
     * @throws Exception - input should be a positive number
     */
    public void validateInput(double input) throws Exception {
        if (input <= 0) {
            throw new Exception("Input should be a positive number");
        }
    }

    /**
     * To validate two inputs for a positive value
     * @param input1 - input1 value
     * @param input2 - input2 value
     * @throws Exception - input should be a positive number
     */
    public void validateInput(double input1, double input2) throws Exception {
        validateInput(input1);
        validateInput(input2);
    }
}
