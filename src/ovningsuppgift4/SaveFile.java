package ovningsuppgift4;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SaveFile extends MouseAdapter {

    JTextField textField;
    JTextArea textArea;

    public SaveFile(JTextField textField, JTextArea textArea) {
        this.textField = textField;
        this.textArea = textArea;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String fileName = textField.getText();
        Path filePath = Paths.get(fileName);
        try{
            if(!Files.exists(filePath)) {
                Files.createFile(filePath);
            }
            BufferedWriter bw = Files.newBufferedWriter(filePath);
            textArea.write(bw);
            bw.close();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
