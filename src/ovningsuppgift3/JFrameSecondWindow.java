package ovningsuppgift3;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class JFrameSecondWindow extends JFrame {

    JPanel panel = new JPanel();
    JPanel soutPanel = new JPanel();
    JLabel sumLabel = new JLabel("Pris tillbaka:");
    String data[][] = {{"1000", ""},
            {"500", ""},
            {"200", ""},
            {"100", ""},
            {"50", ""},
            {"20", ""},
            {"10", ""},
            {"5", ""},
            {"2", ""},
            {"1", ""}};
    String header[] = {"Value", "How many"};

    public JFrameSecondWindow(List<Change> values, int amount) {

        List<Change> importedValues = values;
        for(int i = 0; i<data.length; i++) {
            for(Change change:importedValues){
                if((Integer.parseInt(data[i][0])) == change.getValue().value()){
                    data[i][1] = String.valueOf(change.getAmountOf());
                }
            }
        }

        this.add(panel);
        panel.setLayout(new BorderLayout());

        JTable table2 = new JTable(data, header);
        panel.add(table2, BorderLayout.CENTER);
        panel.add(table2.getTableHeader(), BorderLayout.NORTH);

        panel.add(soutPanel, BorderLayout.SOUTH);
        soutPanel.add(sumLabel, BorderLayout.WEST);
        sumLabel.setText(sumLabel.getText() + " " + amount);

        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
