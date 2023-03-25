/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package salarycalculator;

/**
 *
 * @author jc
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SalaryCalculator extends JFrame implements ActionListener {
    private JTextField nameField, genderField, ageField, hoursField, daysField, rateField, dependentsField;
    private JTextArea resultTextArea;private JRadioButton maleRadioButton, femaleRadioButton;
    private ButtonGroup genderButtonGroup;
  
    
  
    private JLabel title;
    /**
     * @param args the command line arguments
     */
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        SalaryCalculator salarycalculator = new SalaryCalculator();
        
        
        
    }
   public SalaryCalculator() {
        // Set up the frame
        setTitle("Salary Calculator");
        setSize(900, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Set up the input fields and labels
        nameField = new JTextField(20);
        genderField = new JTextField(20);
        ageField = new JTextField(20);
        hoursField = new JTextField(20);
        daysField = new JTextField(20);
        rateField = new JTextField(20);
        dependentsField = new JTextField(20);
    
        title = new JLabel ("SALARY DEPENDENTS PROGRAM",SwingConstants.CENTER );
        title.setForeground(new Color(255,163,26));
        Font font = new Font("arial", Font.BOLD, 30);
        title.setFont(font);
        
        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");
        genderButtonGroup = new ButtonGroup();
        genderButtonGroup.add(maleRadioButton);
        genderButtonGroup.add(femaleRadioButton);
        
        
        JPanel inputPanel = new JPanel(new GridLayout(8, 10));
        inputPanel.add(new JLabel("Name:",SwingConstants.CENTER ));
        inputPanel.setBackground(Color.BLACK);
        inputPanel.add(nameField);
   
         inputPanel.add(new JLabel("Gender:",SwingConstants.CENTER));
       JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
       genderPanel.add(maleRadioButton);
        genderPanel.add(femaleRadioButton);
        
        
        inputPanel.add(genderPanel);
        inputPanel.add(new JLabel("Age:",SwingConstants.CENTER));
        inputPanel.add(ageField);
        inputPanel.add(new JLabel("No. of hours per day:",SwingConstants.CENTER));
        inputPanel.add(hoursField);
        inputPanel.add(new JLabel("No. of days per month:",SwingConstants.CENTER));
        inputPanel.add(daysField);
        inputPanel.add(new JLabel("Hourly rate:",SwingConstants.CENTER));
        inputPanel.add(rateField);
        inputPanel.add(new JLabel("No. of dependents:",SwingConstants.CENTER));
        inputPanel.add(dependentsField);
        
        
       Font font2 = new Font("verdana",Font.BOLD,16);
           for (Component c : inputPanel.getComponents()) {
        if (c instanceof JLabel) {
            c.setForeground(Color.WHITE);
            c.setFont(font2);
        }
    }
        // Set up the button
        
        Font font1 = new Font("",Font.BOLD,15);
        JButton calculateButton = new JButton("Calculate Salary");
        calculateButton.addActionListener(this);
        
           JButton clr = new JButton("Clear");
            calculateButton.setFont(font1);
         clr.setFont(font1);
        clr.addActionListener(this);
        
        
        // Set up the result text area
         Font font3 = new Font("verdana",Font.BOLD,15);
        resultTextArea = new JTextArea(10, 30);
        resultTextArea.setEditable(false);
       resultTextArea.setFont(font3);
       
       resultTextArea.setBackground(new Color(128,128,128));
  resultTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
   
        // Add the components to the frame
        JPanel btnpanel = new JPanel(new FlowLayout());
        btnpanel.add(calculateButton);
           btnpanel.add(clr);
           btnpanel.setBackground(Color.BLACK);
           
           JPanel area =  new JPanel (new FlowLayout());
           area.add(resultTextArea);
      area.setBackground(Color.BLACK);
           JScrollPane scrollPane = new JScrollPane(resultTextArea);
            
           scrollPane.setPreferredSize(new Dimension(400, 335));
        



            area.add(scrollPane);
        calculateButton.setBackground(new Color(255,163,26));
        clr.setBackground(new Color(255, 51, 51));
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.add(btnpanel, BorderLayout.SOUTH);
        mainPanel.add(title,BorderLayout.NORTH);
       mainPanel.setBackground(Color.BLACK);
       
        mainPanel.add(area, BorderLayout.EAST);
        add(mainPanel);
        
        // Show the frame
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
    // Get the input values
    
if (e.getActionCommand().equals("Clear")) {
nameField.setText("");
genderField.setText("");
ageField.setText("");
hoursField.setText("");
daysField.setText("");
rateField.setText("");
dependentsField.setText("");
resultTextArea.setText("");
maleRadioButton.setSelected(false);
femaleRadioButton.setSelected(false);
}

if (e.getActionCommand().equals("Calculate Salary")){
    String name = nameField.getText();
         String gender = "";
    if (maleRadioButton.isSelected()) {
        gender = "Male";
    } else if (femaleRadioButton.isSelected()) {
        gender = "Female";
    }
    int age = Integer.parseInt(ageField.getText());
    int hours = Integer.parseInt(hoursField.getText());
    int days = Integer.parseInt(daysField.getText());
    double rate = Double.parseDouble(rateField.getText());
    int dependents = Integer.parseInt(dependentsField.getText());

    // Calculate the additional payment based on the number of dependents
    double additionalPayment = 0.0;
    if (dependents < 1) {
        additionalPayment = 1000.0;
    } else if (dependents >= 2 && dependents <= 4) {
        additionalPayment = 2000.0;
    } else if (dependents >= 5) {
        additionalPayment = 4000.0;
    }

    // Calculate the deduction based on the gender
  double deduction = 0.0;
    if (gender.equals("Male")) {
        deduction = rate * hours * days * 0.015;
    } else if (gender.equals("Female")) {
        deduction = rate * hours * days * 0.025;
    }

    // Calculate the total salary
    double totalSalary = rate * hours * days + additionalPayment - deduction;

    // Display the results
    resultTextArea.append("Name: " + name + "\nGender: " + gender + "\nAge: " + age + "\nNo. of hours per day: " + hours
            + "\nNo. of days per month: " + days + "\nHourly rate: " + rate + "\nNo. of dependents: " + dependents
            + "\nAdditional payment total: " + additionalPayment + "\nTotal deduction: " + deduction
            + "\nTotal salary: " + totalSalary +"\n"+"\n"+"\n");

  

}
    
    
    
    
    
    


}
}