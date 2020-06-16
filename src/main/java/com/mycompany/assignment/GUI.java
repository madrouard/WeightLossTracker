/*
 * This code is my own work. I did not get any help from any online resources such as Chegg.com;
 * From a classmate, or any other person other than the instructor for this course. I understand that getting 
 * outside help from this course other than from the instructor will result in a grade of 0 in this assignment
 * and other disciplinary action for academic dishonesty.
 */
package com.mycompany.assignment;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

/**
 *  Part 1, Communication: The user wanted an application to track calories and 
 *  a workout schedule.
 *  Part2, Quick Plan: I drew up a quick sketch of the potential GUI and used it
 *  as my base for planning
 *  Part 3, Modeling Quick Design: Along side this quick plan, I wrote out the 
 *  things the code itself would need to handle to make this app, mainly just 
 *  tracking the users calories and workouts
 *  Part 4, Construction of a prototype was handled in part 1
 *  Part 5, deployment and feedback: The user wanted to see an average of their
 *  entered calorie count.
 * 
 */
public class GUI implements ActionListener {
 
/**Declaring these outside the GUI constructor allows for more flexibility
     * when working with them later
     */
    
    int[] calories;
    
    JFrame frame;
    JPanel panel;
    JPanel panel2;
    JButton button;
    JButton calculate;
    JTextField text;
    JList list;
    JLabel monday;
    JLabel tuesday;
    JLabel wednesday;
    JLabel thursday;
    JLabel friday;
    JLabel saturday;
    JLabel sunday;
    JLabel average;
    JCheckBox exerciseMonday;
    JCheckBox exerciseTuesday;
    JCheckBox exerciseWednesday;
    JCheckBox exerciseThursday;
    JCheckBox exerciseFriday;
    JCheckBox exerciseSaturday;
    JCheckBox exerciseSunday;
    
    
    public GUI(){
        
        calories = new int[7];
        
        
        frame = new JFrame();
        frame.setBounds(300,350,720,480);
        
        button = new JButton("Enter Calorie Count");
        button.setBounds(300, 10, 120, 60);
        button.setActionCommand("None");
        button.addActionListener(this);
        
        
        calculate = new JButton("Calculate Average Calories");
        calculate.setBounds(600, 10, 120, 60);
        calculate.setActionCommand("calculate");
        calculate.addActionListener(this);
        
        average = new JLabel("Average: ");
        
        //Text display for the 
        monday = new JLabel("<html>Monday<br>Calories: ");
        tuesday = new JLabel("<html>Tuesday<br>Calories: ");
        wednesday = new JLabel("<html>Wednesday<br>Calories: ");
        thursday = new JLabel("<html>Thursday<br>Calories: ");
        friday = new JLabel("<html>Friday<br>Calories: ");
        saturday = new JLabel("<html>Saturday<br>Calories: ");
        sunday = new JLabel("<html>Sunday<br>Calories: ");
        
        exerciseMonday = new JCheckBox("Worked Out");
        exerciseTuesday = new JCheckBox("Worked Out");
        exerciseWednesday = new JCheckBox("Worked Out");
        exerciseThursday = new JCheckBox("Worked Out");
        exerciseFriday = new JCheckBox("Worked Out");
        exerciseSaturday = new JCheckBox("Worked Out");
        exerciseSunday = new JCheckBox("Worked Out");
        
        text = new JTextField(5);
        text.setBounds(10,10,80,40);
        
        
        
        //This panel handles the calorie input
        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setBounds(50,50,240,120);
        panel.add(text);
        panel.add(button);
        panel.add(calculate);
        panel.add(average);
        
        
        String days[] = new String[] {"Monday", "Tuesday", "Wendesday", "Thursday", "Friday", "Saturday", "Sunday"};
        list = new JList(days);
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        list.setVisibleRowCount(3);
        
        
        //Organizes the week into one panel
        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(0, 7, 50, 0));
        panel2.setBounds(50,50,240,120);
        panel2.add(monday);
        panel2.add(tuesday);
        panel2.add(wednesday);
        panel2.add(thursday);
        panel2.add(friday);
        panel2.add(saturday);
        panel2.add(sunday);
        panel2.add(exerciseMonday);
        panel2.add(exerciseTuesday);
        panel2.add(exerciseWednesday);
        panel2.add(exerciseThursday);
        panel2.add(exerciseFriday);
        panel2.add(exerciseSaturday);
        panel2.add(exerciseSunday);
        
        
        
        frame.add(panel, BorderLayout.PAGE_START);
        frame.add(panel2, BorderLayout.CENTER);
        frame.add(list, BorderLayout.WEST);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Our GUI");
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args){
        
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int selection = list.getSelectedIndex();
        switch (selection) {
            case 0: monday.setText("<html>Monday<br>Calories: " + text.getText());
                    calories[selection] = (Integer.valueOf(text.getText()));
                    break;
            case 1: tuesday.setText("<html>Tuesday<br>Calories: " + text.getText());
                    calories[selection] = (Integer.valueOf(text.getText()));
                    break;
            case 2: wednesday.setText("<html>Wednesday<br>Calories: " + text.getText());
                    calories[selection] = (Integer.valueOf(text.getText()));
                    break;
            case 3: thursday.setText("<html>Thursday<br>Calories: " + text.getText());
                    calories[selection] = (Integer.valueOf(text.getText()));
                    break;
            case 4: friday.setText("<html>Friday<br>Calories: " + text.getText());
                    calories[selection] = (Integer.valueOf(text.getText()));
                    break;
            case 5: saturday.setText("<html>Saturday<br>Calories: " + text.getText());
                    calories[selection] = (Integer.valueOf(text.getText()));
                    break;
            case 6: sunday.setText("<html>Sunday<br>Calories: " + text.getText());
                    calories[selection] = (Integer.valueOf(text.getText()));
                    break;
        }
        //This runs if a calculation is called and then edits the average label to display the correct text
        if ("calculate".equals(e.getActionCommand())){
            int total = 0;
            for(int i = 0; i < calories.length; i++){
                total = total + calories[i];
            }
            total = total / 7;
            average.setText("Average: " + total);
        }
    }    
}
