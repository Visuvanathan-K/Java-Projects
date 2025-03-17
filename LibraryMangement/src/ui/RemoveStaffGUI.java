package ui;

import feature.RemoveStaff;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveStaffGUI extends JFrame {
    private JTextField staffIdField;

    public RemoveStaffGUI() {
        setTitle("Remove Staff");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(2, 2, 10, 10));

        add(new JLabel("Staff ID:"));
        staffIdField = new JTextField();
        add(staffIdField);

        JButton removeButton = new JButton("Remove Staff");
        removeButton.addActionListener(new RemoveStaffListener());
        add(removeButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> dispose());
        add(cancelButton);

        setVisible(true);
    }

    private class RemoveStaffListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String staffId = staffIdField.getText();

            if (staffId.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter a Staff ID.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            RemoveStaff removeStaff = new RemoveStaff();
            if (removeStaff.removeStaff(Integer.parseInt(staffId))) {
                JOptionPane.showMessageDialog(null, "Staff removed successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Failed to remove the staff. Check Staff ID.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        new RemoveStaffGUI();
    }
}

