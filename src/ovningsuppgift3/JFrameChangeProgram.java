package ovningsuppgift3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class JFrameChangeProgram extends JFrame implements ActionListener {

    List<JCheckBox> checkBoxes = new ArrayList<>();

    JPanel panel = new JPanel();

    JPanel northPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JPanel southPanel = new JPanel();
    JPanel eastPanel = new JPanel();

    JTextField price = new JTextField(3);
    JTextField amountPayed = new JTextField(3);
    JLabel priceLabel = new JLabel("Price:");
    JLabel amountPayedLabel = new JLabel("Amount Payed:");

    JCheckBox thousands = new JCheckBox("1000");
    JCheckBox fivehundreds = new JCheckBox("500");
    JCheckBox twohundreds = new JCheckBox("200");
    JCheckBox hundreds = new JCheckBox("100");
    JCheckBox fifties = new JCheckBox("50");
    JCheckBox twenties = new JCheckBox("20");
    JCheckBox tens = new JCheckBox("10");
    JCheckBox fives = new JCheckBox("5");
    JCheckBox twos = new JCheckBox("2");
    JCheckBox ones = new JCheckBox("1");

    JButton button = new JButton("Beräkna");

    JTextArea textArea1 = new JTextArea();
    JTextArea textArea2 =  new JTextArea();

    public JFrameChangeProgram() {

        this.add(panel);

        panel.setLayout(new BorderLayout());
        panel.add(northPanel, BorderLayout.NORTH);
        panel.add(centerPanel, BorderLayout.CENTER);
        panel.add(southPanel, BorderLayout.SOUTH);
        panel.add(eastPanel, BorderLayout.EAST);

        northPanel.setLayout(new GridLayout(2, 1));
        northPanel.add(priceLabel);
        northPanel.add(price);
        northPanel.add(amountPayedLabel);
        northPanel.add(amountPayed);

        centerPanel.setLayout(new GridLayout(2,3));

        centerPanel.add(thousands);
        centerPanel.add(fivehundreds);
        centerPanel.add(twohundreds);
        centerPanel.add(hundreds);
        centerPanel.add(fifties);
        centerPanel.add(twenties);
        centerPanel.add(tens);
        centerPanel.add(fives);
        centerPanel.add(twos);
        centerPanel.add(ones);

        southPanel.add(button);

        button.addActionListener(this);

        checkBoxes.add(thousands);
        checkBoxes.add(fivehundreds);
        checkBoxes.add(twohundreds);
        checkBoxes.add(hundreds);
        checkBoxes.add(fifties);
        checkBoxes.add(twenties);
        checkBoxes.add(tens);
        checkBoxes.add(fives);
        checkBoxes.add(twos);
        checkBoxes.add(ones);

        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        ArrayList<Integer> values = new ArrayList<>();
        for(JCheckBox checkbox : checkBoxes){
            if (checkbox.isSelected()){
                values.add(Integer.parseInt(checkbox.getText()));
            }
        }

        ChangeCalculator calculator = new ChangeCalculator();
        int changeAmount = calculator.calculateChangeAmount(Integer.parseInt(amountPayed.getText()), Integer.parseInt(price.getText()));
        System.out.println(changeAmount);


        List<Change> listOfChange = calculator.getChange(changeAmount, values);
        for(Change change : listOfChange){
            System.out.println(change.getValue() + ": " + change.getAmountOf());
        }

        textArea1.setText(Integer.toString(changeAmount));

        for(Change change : listOfChange){
            textArea2.setText(textArea2.getText() + " " + change.getAmountOf() + ": " + change.getValue());
        }

        JFrameSecondWindow window = new JFrameSecondWindow(listOfChange, changeAmount);
    }


    public static void main(String[] args) {
        JFrameChangeProgram frame = new JFrameChangeProgram();
    }
}
