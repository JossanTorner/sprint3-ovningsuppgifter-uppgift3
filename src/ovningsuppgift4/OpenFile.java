package ovningsuppgift4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class OpenFile extends MouseAdapter {

    JTextField textField;
    JTextArea textArea;

    public OpenFile(JTextField textField, JTextArea textArea) {
        this.textField = textField;
        this.textArea = textArea;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        String fileName = textField.getText();
        Path filePath = Paths.get(fileName);
        try{
            if(Files.exists(filePath)) {
                BufferedReader br = Files.newBufferedReader(filePath);
                textArea.read(br, null);
                br.close();
            }
            else{
                JFrame frame = new JFrame("Open file error");
                JLabel label = new JLabel("File not found");
                frame.setLayout(new BorderLayout());
                frame.add(label, BorderLayout.CENTER);

                frame.setVisible(true);
                frame.setSize(200,200);
                frame.setLocationRelativeTo(null);
            }
        }
        catch (IOException ex){
            ex.printStackTrace();
        }

    }

}
