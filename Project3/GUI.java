/*
 * Filename: GUI.java
 * Author: Herman Mann
 * Date: 05/08/2022
 * Description: Class to create GUI for the application and implements the runnable and
 * change listener
 */
//Package
package cmsc335_project3_hermanmann;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Class to create GUI for the application and implements the runnable and
 * change listener
 *
 */
public class GUI extends JFrame implements Runnable, ChangeListener {

    /**
     * Main entry point of the project and to call the project related
     * operations
     *
     * @param args- command line arguments
     */
    public static void main(String[] args) {
        test = new GUI();
        test.displayGUI();
        gui = new Thread(test);

        Thread time = new Thread(new Time());
        time.start();
    }

    static GUI test;

    //Declare and initialize variables and objects
    private JButton start = new JButton(AppResources.MSG_START);
    private JButton pause = new JButton(AppResources.MSG_PAUSE);
    private JButton stop = new JButton(AppResources.MSG_STOP);

    static JSlider vehicle1Slider = new JSlider(0, 3000);
    static JSlider vehicle2Slider = new JSlider(0, 3000);
    static JSlider vehicle3Slider = new JSlider(0, 3000);
    static JSlider vehicle4Slider = new JSlider(0, 3000);

    private static boolean isRunning;
    private static final AtomicBoolean isSimulatorRunning = new AtomicBoolean(false);

    static JLabel timeText = new JLabel();
    static JLabel trafficAtext = new JLabel();
    static JLabel trafficBtext = new JLabel();
    static JLabel trafficCtext = new JLabel();

    Intersection intersection1 = new Intersection(AppResources.MSG_THREAD_1, trafficAtext);
    Intersection intersection2 = new Intersection(AppResources.MSG_THREAD_2, trafficBtext);
    Intersection intersection3 = new Intersection(AppResources.MSG_THREAD_3, trafficCtext);

    Vehicle vehicle1 = new Vehicle(AppResources.MSG_VEHICLE_1_THREAD, 300, 0);
    Vehicle vehicle2 = new Vehicle(AppResources.MSG_VEHICLE_2_THREAD, 1000, 0);
    Vehicle vehicle3 = new Vehicle(AppResources.MSG_VEHICLE_3_THREAD, 2000, 1000);
    Vehicle vehicle4 = new Vehicle(AppResources.MSG_VEHICLE_4_THREAD, 2000, 1000);

    Vehicle[] vehicleArray = {vehicle1, vehicle2, vehicle3, vehicle4};
    Intersection[] intersectionArray = {intersection1, intersection2, intersection3};
    static Thread gui;

    Object[][] trafficData = {
        {AppResources.MSG_VEHICLE_1, vehicle1.getPosition(), 0, 0},
        {AppResources.MSG_VEHICLE_2, vehicle2.getPosition(), 0, 0},
        {AppResources.MSG_VEHICLE_3, vehicle3.getPosition(), 0, 0},
        {AppResources.MSG_VEHICLE_4, vehicle4.getPosition(), 0, 0}
    };

    //Table for displaying data
    String[] columnNames = {AppResources.MSG_VEHICLE, AppResources.MSG_X_POS, AppResources.MSG_Y_POS, AppResources.MSG_SPEED};
    JTable dataTable = new JTable(trafficData, columnNames);

    /**
     * Constructor to construct the GUI
     */
    public GUI() {
        super(AppResources.MSG_TITLE);
        isRunning = Thread.currentThread().isAlive();
        generateGUI();
        setButtons();
    }

    /**
     * To display the GUI
     */
    public void displayGUI() {
        setSize(700, 400);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * To generate the GUI for the application
     */
    public void generateGUI() {

        JLabel welcome = new JLabel(AppResources.MSG_WELCOME);
        JLabel welcome2 = new JLabel(AppResources.MSG_HEADER);

        JLabel time = new JLabel(AppResources.MSG_CURRENT_TIME);
        JLabel trafficLightA = new JLabel(AppResources.MSG_INTERSECTION_1);
        JLabel trafficLightB = new JLabel(AppResources.MSG_INTERSECTION_2);
        JLabel trafficLightC = new JLabel(AppResources.MSG_INTERSECTION_3);

        vehicle1Slider.addChangeListener(this);
        vehicle2Slider.addChangeListener(this);
        vehicle3Slider.addChangeListener(this);
        vehicle4Slider.addChangeListener(this);

        vehicle1Slider.setValue(vehicle1.getPosition());
        vehicle2Slider.setValue(vehicle2.getPosition());
        vehicle3Slider.setValue(vehicle3.getPosition());
        vehicle4Slider.setValue(vehicle4.getPosition());

        vehicle1Slider.setMajorTickSpacing(1000);
        vehicle1Slider.setPaintTicks(true);

        vehicle2Slider.setMajorTickSpacing(1000);
        vehicle2Slider.setPaintTicks(true);

        dataTable.setPreferredScrollableViewportSize(new Dimension(400, 70));
        dataTable.setFillsViewportHeight(true);

        JPanel dataPanel = new JPanel();

        JScrollPane scrollPane = new JScrollPane(dataTable);
        dataPanel.add(scrollPane);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addContainerGap(30, 30)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(welcome)
                        .addComponent(welcome2)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(start)
                                        .addComponent(pause)
                                        .addComponent(stop)
                                        .addComponent(time)
                                        .addComponent(timeText)))
                        .addComponent(vehicle1Slider)
                        .addComponent(vehicle2Slider)
                        .addComponent(vehicle3Slider)
                        .addComponent(vehicle4Slider)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(trafficLightA)
                                        .addComponent(trafficAtext)
                                        .addContainerGap(20, 20)
                                        .addComponent(trafficLightB)
                                        .addComponent(trafficBtext)
                                        .addContainerGap(20, 20)
                                        .addComponent(trafficLightC)
                                        .addComponent(trafficCtext))
                                .addComponent(dataPanel)))
                .addContainerGap(30, 30)
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createSequentialGroup()
                        .addComponent(welcome)
                        .addComponent(welcome2))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(time)
                        .addComponent(timeText))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(start)
                        .addComponent(pause)
                        .addComponent(stop))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(vehicle1Slider)
                        .addComponent(vehicle2Slider)
                        .addComponent(vehicle3Slider)
                        .addComponent(vehicle4Slider))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(trafficLightA)
                        .addComponent(trafficAtext)
                        .addComponent(trafficLightB)
                        .addComponent(trafficBtext)
                        .addComponent(trafficLightC)
                        .addComponent(trafficCtext))
                .addComponent(dataPanel)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addGap(20, 20, 20))
                .addGap(20, 20, 20)
        );

        pack();
    }

    /**
     * To set buttons and action listener for buttons
     */
    public void setButtons() {
        start.addActionListener((ActionEvent e) -> {
            if (!isSimulatorRunning.get()) {
                System.out.println(Thread.currentThread().getName() + AppResources.MSG_START_CALLING);

                if (gui.isAlive()) {
                    gui = null;
                }
                gui = new Thread(test);
                gui.start();

                intersection1.start();
                intersection2.start();
                intersection3.start();

                vehicle1.start();
                vehicle2.start();
                vehicle3.start();
                vehicle4.start();

            }
            isSimulatorRunning.set(true);
        });

        pause.addActionListener((ActionEvent e) -> {
            if (isSimulatorRunning.get()) {
                for (Vehicle v : vehicleArray) {
                    v.suspend();
                    System.out.println(Thread.currentThread().getName() + AppResources.MSG_SUSPEND_CALLING);
                }
                for (Intersection v : intersectionArray) {
                    v.interrupt();
                    v.suspend();
                }

                pause.setText(AppResources.MSG_CONTINUE);
                isSimulatorRunning.set(false);
            } else {
                for (Vehicle v : vehicleArray) {
                    if (v.suspended.get()) {
                        v.resume();
                        System.out.println(Thread.currentThread().getName() + AppResources.MSG_RESUME_CALLING);
                    }
                }
                for (Intersection v : intersectionArray) {
                    v.resume();
                }
                pause.setText(AppResources.MSG_PAUSE);
                isSimulatorRunning.set(true);
            }
        });

        stop.addActionListener((ActionEvent e) -> {
            if (isSimulatorRunning.get()) {
                System.out.println(Thread.currentThread().getName() + AppResources.MSG_STOP_CALLING);
                for (Vehicle v : vehicleArray) {
                    v.stop();
                    v = null;
                }
                for (Intersection v : intersectionArray) {
                    v.stop();
                    v = null;
                }
                isSimulatorRunning.set(false);
            }
        });
    }

    /**
     * To update the state change value with slider value
     *
     * @param e - change event
     */
    @Override
    public void stateChanged(ChangeEvent e) {
        //Update slider value to traffic data
        trafficData[0][1] = vehicle1Slider.getValue();
        trafficData[1][1] = vehicle2Slider.getValue();
        trafficData[2][1] = vehicle3Slider.getValue();
        trafficData[3][1] = vehicle4Slider.getValue();
        //Update speed
        trafficData[0][3] = vehicle1.getSpeed() + AppResources.MSG_SPEED_UNIT;
        trafficData[1][3] = vehicle2.getSpeed() + AppResources.MSG_SPEED_UNIT;
        trafficData[2][3] = vehicle3.getSpeed() + AppResources.MSG_SPEED_UNIT;
        trafficData[3][3] = vehicle4.getSpeed() + AppResources.MSG_SPEED_UNIT;
        //Update table
        dataTable.repaint();
    }

    /**
     * To get the data and set light and vehicle
     */
    public void getData() {
        if (isSimulatorRunning.get()) {
            //Get colors for intersections, if Red check xPosition
            switch (intersection1.getColor()) {
                case AppResources.MSG_RED:
                    for (Vehicle v : vehicleArray) {
                        //If vehicle xPosition is within 500 meters and light is red, set suspend to true for vehicle to wait
                        if (v.getPosition() > 500 && v.getPosition() < 1000) {
                            v.atLight.set(true);
                        }
                    }
                    break;
                case AppResources.MSG_GREEN:
                    for (Vehicle v : vehicleArray) {
                        if (v.atLight.get()) {
                            v.resume();
                        }
                    }
                    break;
            }

            switch (intersection2.getColor()) {
                case AppResources.MSG_RED:
                    for (Vehicle v : vehicleArray) {
                        //If vehicle xPosition is within 500 meters and light is red, set suspend to true for vehicle to wait
                        if (v.getPosition() > 1500 && v.getPosition() < 2000) {
                            v.atLight.set(true);
                        }
                    }
                    break;
                case AppResources.MSG_GREEN:
                    for (Vehicle v : vehicleArray) {
                        if (v.atLight.get()) {
                            v.resume();
                        }
                    }
                    break;
            }

            switch (intersection3.getColor()) {
                case AppResources.MSG_RED:
                    for (Vehicle v : vehicleArray) {
                        //If vehicle xPosition is within 500 meters and light is red, set suspend to true for vehicle to wait
                        if (v.getPosition() > 2500 && v.getPosition() < 3000) {
                            v.atLight.set(true);
                        }
                    }
                    break;
                case AppResources.MSG_GREEN:
                    for (Vehicle v : vehicleArray) {
                        if (v.atLight.get()) {
                            v.resume();
                        }
                    }
                    break;
            }
        }

    }

    /**
     * To run the vehicle slider of the simulator
     */
    @Override
    public void run() {
        while (isRunning) {
            //While running, if simulation is running, set vehicle sliders to vehicle xPosition and get data
            if (isSimulatorRunning.get()) {
                vehicle1Slider.setValue(vehicle1.getPosition());
                vehicle2Slider.setValue(vehicle2.getPosition());
                vehicle3Slider.setValue(vehicle3.getPosition());
                vehicle4Slider.setValue(vehicle4.getPosition());

                getData();
            }
        }
    }
}
