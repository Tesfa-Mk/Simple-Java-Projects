package TicTacToe_Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TicTacToe extends JFrame implements ActionListener{
  String value_1, value_2;
  JPanel gameWindow = new JPanel();
  JPanel headerTexts = new JPanel();
  JLabel title = new JLabel("Tic Tac Toe Game");
  JLabel turn = new JLabel("Your Turn");
  GridLayout sec_1=new GridLayout(2,1);
  GridLayout sec_2=new GridLayout(3,3);
  JButton [][] buttons = new JButton[3][3];
  String [][] ButtonValues = {{"","",""},{"","",""},{"","",""}};

public TicTacToe(){
for(int i=0; i<3; i++){
  for (int j = 0; j<3; j++) {
    buttons[i][j] = new JButton(ButtonValues[i][j]);
    gameWindow.add(buttons[i][j]);
  }
}
gameWindow.setLayout(sec_2);
gameWindow.setBounds(20, 130, 400, 400);
headerTexts.setBounds(100, 20, 400, 50);
headerTexts.setLayout(sec_1);
headerTexts.add(title);
headerTexts.add(turn);
this.add(headerTexts);
this.add(gameWindow);
setLayout(null);
setSize(450,700);
setVisible(true);
setResizable(false);
setLocationRelativeTo(null);

}
public static void main(String[] args) {
  new TicTacToe();
  
}
@Override
public void actionPerformed(ActionEvent e) {
  // TODO Auto-generated method stub
  
}
}
