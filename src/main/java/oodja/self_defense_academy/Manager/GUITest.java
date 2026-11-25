/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.java_assigment;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Austin
 */
public class GUITest {
     public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Code-Only GUI");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(700, 300);
            frame.setLayout(new BorderLayout());

            JLabel label = new JLabel("Enter Name:");
            JTextField textField = new JTextField(15);
            JButton button = new JButton("Submit");
            JPanel panel = new JPanel();
            panel.setSize(700, 150);
            
            JLabel bot_label = new JLabel("This is bottom");
            JPanel bot_pnl = new JPanel();
            bot_pnl.setSize(700, 150);
            button.addActionListener(e -> 
                JOptionPane.showMessageDialog(frame, "Hello, " + textField.getText())
            );

            panel.add(label);
            panel.add(textField);
            panel.add(button);
            bot_pnl.add(bot_label);
            frame.add(panel, BorderLayout.NORTH);
            frame.add(bot_pnl, BorderLayout.SOUTH);
            frame.setVisible(true);
        });
    }
}
