package TicTacToe_Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class TicTacToe extends JFrame implements ActionListener{
  JPanel gameWindow = new JPanel();
  JPanel headerTexts = new JPanel();
  JLabel turn = new JLabel("Tic Tac Toe");
  GridLayout sec_2=new GridLayout(3,3);
  JButton [] buttons = new JButton[9];
  boolean player_turn;
  Random random = new Random();
  
public TicTacToe(){
for(int i=0; i<9; i++){
    buttons[i] = new JButton();
    buttons[i].addActionListener(this);
    buttons[i].setFocusable(false);
    buttons[i].setFont(new Font("Andalus",Font.BOLD,100));
    buttons[i].setContentAreaFilled(false);
    gameWindow.add(buttons[i]);
}
gameWindow.setLayout(sec_2);
gameWindow.setBounds(20, 130, 400, 400);
headerTexts.setBounds(20, 20, 400, 100);
headerTexts.add(turn);
turn.setFont(new Font("Andalus",Font.BOLD,60));
gameWindow.setVisible(true);
this.add(headerTexts);
this.add(gameWindow);
setLayout(null);
setSize(450,700);
setVisible(true);
setResizable(false);
setLocationRelativeTo(null);
game_starter();
}
@Override
public void actionPerformed(ActionEvent e) {
  for (int i = 0; i < 9; i++) {
  if(e.getSource() == buttons[i]){
    if (player_turn){
    if(buttons[i].getText()==""){
      buttons[i].setText("X");
      buttons[i].setForeground(new Color(100,0,0));
      player_turn=false;
      turn.setText("O Turn");
      winChecker();
    }
    }
  else {
    if(buttons[i].getText()==""){
      buttons[i].setText("O");
      buttons[i].setForeground(new Color(0,100,100));
      player_turn=true;
      turn.setText("X Turn");
      winChecker();
    }
        }
      }
    }
}
public void xWins(int a, int b, int c){
  for(int i=0;i<9;i++) {
    buttons[i].setEnabled(false);
  }
  buttons[a].setForeground(new Color(255,200,0));
  buttons[b].setForeground(new Color(255,200,0));
  buttons[c].setForeground(new Color(255,200,0));
  buttons[a].setEnabled(true);
  buttons[b].setEnabled(true);
  buttons[c].setEnabled(true);
  turn.setText("X wins");
}
public void oWins(int a, int b, int c){
   for(int i=0;i<9;i++) {
	buttons[i].setEnabled(false);
}
  buttons[a].setForeground(new Color(255,200,0));
  buttons[b].setForeground(new Color(255,200,0));
  buttons[c].setForeground(new Color(255,200,0));
  buttons[a].setEnabled(true);
  buttons[b].setEnabled(true);
  buttons[c].setEnabled(true);
		turn.setText("O wins");
}
public void winChecker(){
  if(
				(buttons[0].getText()=="X") &&
				(buttons[1].getText()=="X") &&
				(buttons[2].getText()=="X")
				) {
			xWins(0,1,2);
		}
		if(
				(buttons[3].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[5].getText()=="X")
				) {
			xWins(3,4,5);
		}
		if(
				(buttons[6].getText()=="X") &&
				(buttons[7].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins(6,7,8);
		}
		if(
				(buttons[0].getText()=="X") &&
				(buttons[3].getText()=="X") &&
				(buttons[6].getText()=="X")
				) {
			xWins(0,3,6);
		}
		if(
				(buttons[1].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[7].getText()=="X")
				) {
			xWins(1,4,7);
		}
		if(
				(buttons[2].getText()=="X") &&
				(buttons[5].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins(2,5,8);
		}
		if(
				(buttons[0].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[8].getText()=="X")
				) {
			xWins(0,4,8);
		}
		if(
				(buttons[2].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[6].getText()=="X")
				) {
			xWins(2,4,6);
		}
		//check O win conditions
		if(
				(buttons[0].getText()=="O") &&
				(buttons[1].getText()=="O") &&
				(buttons[2].getText()=="O")
				) {
			oWins(0,1,2);
		}
		if(
				(buttons[3].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[5].getText()=="O")
				) {
			oWins(3,4,5);
		}
		if(
				(buttons[6].getText()=="O") &&
				(buttons[7].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins(6,7,8);
		}
		if(
				(buttons[0].getText()=="O") &&
				(buttons[3].getText()=="O") &&
				(buttons[6].getText()=="O")
				) {
			oWins(0,3,6);
		}
		if(
				(buttons[1].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[7].getText()=="O")
				) {
			oWins(1,4,7);
		}
		if(
				(buttons[2].getText()=="O") &&
				(buttons[5].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins(2,5,8);
		}
		if(
				(buttons[0].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[8].getText()=="O")
				) {
			oWins(0,4,8);
		}
		if(
				(buttons[2].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[6].getText()=="O")
				) {
			oWins(2,4,6);
		}
}

public void game_starter(){
  try {
    Thread.sleep(2000);
  } catch (InterruptedException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
  }
  if(random.nextInt(2) == 0){
    player_turn=true;
    turn.setText("X Turn");
  }
  else{
    player_turn=false;
    turn.setText("O Turn");
  }
}
public static void main(String[] args) {
  new TicTacToe();
}
}
