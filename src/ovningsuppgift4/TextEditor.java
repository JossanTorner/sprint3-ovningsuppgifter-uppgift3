package ovningsuppgift4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;

public class TextEditor extends JFrame {

    JPanel panel = new JPanel();
    JPanel northPanel = new JPanel();

    JLabel fileNameLabel = new JLabel("File name:");
    JTextField fileNameTextField = new JTextField(10);
    JButton openButton = new JButton("Open");
    JButton saveButton = new JButton("Save");
    JButton printButton = new JButton("Print");
    JButton exitButton = new JButton("Exit");

    JPanel southPanel = new JPanel();
    JTextArea textArea = new JTextArea(20,40);

    public TextEditor() {

        this.add(panel);
        panel.setLayout(new BorderLayout());
        panel.add(northPanel, BorderLayout.NORTH);
        northPanel.setLayout(new FlowLayout());
        northPanel.add(fileNameLabel);
        northPanel.add(fileNameTextField);
        northPanel.add(openButton);
        northPanel.add(saveButton);
        northPanel.add(printButton);
        northPanel.add(exitButton);

        panel.add(southPanel, BorderLayout.SOUTH);
        southPanel.setLayout(new FlowLayout());
        southPanel.add(textArea);

        openButton.addMouseListener(new OpenFile(fileNameTextField, textArea));
        saveButton.addMouseListener(new SaveFile(fileNameTextField, textArea));

        printButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    textArea.print();
                }
                catch (PrinterException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });

        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
    }
}
