package ovningsuppgift5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class GameFrame extends JFrame implements ActionListener {

    JPanel mainPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JLabel gameMessage =  new JLabel();

    JPanel userPanel = new JPanel();
    JPanel opponentPanel = new JPanel();

    JButton stenUser = new JButton("STEN");
    JButton saxUser = new JButton("SAX");
    JButton paseUser = new JButton("PÅSE");

    JButton stenOpponent = new JButton("STEN");
    JButton saxOpponent = new JButton("SAX");
    JButton paseOpponent = new JButton("PÅSE");

    List<JButton> opponentButtons = Arrays.asList(stenOpponent,saxOpponent,paseOpponent);

    JButton startButton = new JButton("START");

    public GameFrame() {

        this.add(mainPanel);

        setUpMainPanel();

        addButtonsToGamePanel(true);
        addButtonsToGamePanel(false);

        updateButtonAccess(true,false);
        updateButtonAccess(false,false);

        addActionListeners();

        setSize(300,300);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == startButton) {
            gameMessage.setText("VÄLJ SYMBOL");
            startButton.setEnabled(false);
            resetButtons();
            //användarens knappar ska bli tillgängliga
            updateButtonAccess(true,true);
        }

        if (e.getSource() == stenUser || e.getSource() == saxUser || e.getSource() == paseUser){

            GameUtil gameUtil = new GameUtil();

            //hämtar motståndarens valda symbol, sätter tillhörande knapp röd
            Symbol opponentSymbol = gameUtil.getRandomSymbol();
            setChosenOpponentButton(opponentSymbol);

            //hämtar knappen som tryckts på, samt texten på knappen, och gör den röd
            JButton clickedButton = (JButton) e.getSource();
            clickedButton.setBackground(Color.RED);
            String buttonText = e.getActionCommand();

            //hämtar användarens symbol och sätter in bådas i getWinner för att få vinnaren
            Symbol userSymbol = gameUtil.getUserSymbol(buttonText);
            Symbol winner = gameUtil.getWinner(userSymbol, opponentSymbol);

            //meddelar vem som vann eller om det blev oavgjort
            if (winner == null){
                gameMessage.setText("Det blev oavgjort.");
            }
            else{
                gameMessage.setText(winner + " vann!");
            }

            //resettar spelet
            updateButtonAccess(true,false);
            startButton.setEnabled(true);
        }
    }

    public void setChosenOpponentButton(Symbol opponentSymbol){
        for(JButton button: opponentButtons){
            if (opponentSymbol.toString().equals(button.getText())){
                button.setBackground(Color.RED);
            }
        }
    }

    public void resetButtons(){
        stenOpponent.setBackground(Color.white);
        saxOpponent.setBackground(Color.white);
        paseOpponent.setBackground(Color.white);
        stenUser.setBackground(Color.white);
        saxUser.setBackground(Color.white);
        paseUser.setBackground(Color.white);
    }

    public void updateButtonAccess(boolean user, boolean access){
        if (user){
            stenUser.setEnabled(access);
            saxUser.setEnabled(access);
            paseUser.setEnabled(access);
        }
        else{
            stenOpponent.setEnabled(access);
            saxOpponent.setEnabled(access);
            paseOpponent.setEnabled(access);
        }
    }

    public void addButtonsToGamePanel(boolean user){
        if (user){
            userPanel.add(stenUser);
            userPanel.add(saxUser);
            userPanel.add(paseUser);
        }
        else{
            opponentPanel.add(stenOpponent);
            opponentPanel.add(saxOpponent);
            opponentPanel.add(paseOpponent);
        }
    }

    public void setUpMainPanel(){
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        centerPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;

        centerPanel.add(startButton, gbc);
        centerPanel.add(gameMessage, gbc);

        mainPanel.add(userPanel, BorderLayout.SOUTH);
        mainPanel.add(opponentPanel, BorderLayout.NORTH);
    }

    public void addActionListeners(){
        stenUser.addActionListener(this);
        saxUser.addActionListener(this);
        paseUser.addActionListener(this);

        startButton.addActionListener(this);
    }

    public static void main(String[] args) {
        GameFrame gameFrame = new GameFrame();
    }

}
