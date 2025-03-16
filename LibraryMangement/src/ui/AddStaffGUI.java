package ui;

import feature.AddStaff;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStaffGUI extends JFrame {
    private JTextField staffIdField, nameField, roleField, emailField;

    public AddStaffGUI() {
        setTitle("Add Staff");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));

        // Labels and text fields
        add(new JLabel("Staff ID:"));
        staffIdField = new JTextField();
        add(staffIdField);

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Role:"));
        roleField = new JTextField();
        add(roleField);

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        // Buttons
        JButton addButton = new JButton("Add Staff");
        addButton.addActionListener(new AddStaffListener());
        add(addButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> dispose());
        add(cancelButton);

        setVisible(true);
    }

    private class AddStaffListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String staffId = staffIdField.getText();
            String name = nameField.getText();
            String role = roleField.getText();
            String email = emailField.getText();

            AddStaff addStaff = new AddStaff();
            if (addStaff.addStaff(staffId, name, role, email)) {
                JOptionPane.showMessageDialog(null, "Staff added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Failed to add the staff.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        new AddStaffGUI();
    }
}
