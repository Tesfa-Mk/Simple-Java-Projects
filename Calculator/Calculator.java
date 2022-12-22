import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Calculator extends JFrame implements ActionListener {
  JPanel tpanel = new JPanel();
  JPanel bpanel = new JPanel();
  GridLayout button_grid=new GridLayout(6,3);
  String operand_1="",operand_2="",operator="";
  JTextArea display_area=new JTextArea(20,20);
  String[] bvalue={"1","2","3","4","5","6","7","8","9","0","*","+","-","/","c","=","%"};
 JButton [] buttons=new JButton[17];

  public Calculator(){
    for(int i=0;i<bvalue.length;i++){
      buttons[i]=new JButton(bvalue[i]);
      buttons[i].addActionListener(this);
      bpanel.add(buttons[i]);}
    operand_1=operand_2=operator="";
    setLayout(null);
    tpanel.setBounds(10,2,300,50);
    tpanel.add(display_area);
    bpanel.setBounds(20,70,300,300);
    bpanel.setLayout(button_grid);
    this.add(tpanel);
    this.add(bpanel);
    setSize(400,500);
    setVisible(true);
  }
  public static void main(String[] args) {
    new Calculator();
  }
  @Override
  public void actionPerformed(ActionEvent e) {
  String a=e.getActionCommand();
  if(a.charAt(0) <= '9' && a.charAt(0) >= '0') {
    if (!operator.equals("") &&!operand_2.equals("") && !operand_1.equals("")){
      operand_1 = operand_2 = operator= "";
    }
    if (operator.equals(""))
        operand_1 = operand_1 + a;
    else
        operand_2 = operand_2 + a;
    display_area.setText(operand_1 + operator + operand_2);
    }
  else if (a.equals("c")){
    operand_1 = operand_2 = operator= "";
    display_area.setText(operand_1 + operator + operand_2);
  } else if (a.equals("=")) {
    if (operator.equals("")|| operand_2.equals("")){
      return;
    }
    double result;
    if (operator.equals("+"))
      result=(Double.parseDouble(operand_1)) + (Double.parseDouble(operand_2));
    else if (operator.equals("-"))
      result=(Double.parseDouble(operand_1)) - (Double.parseDouble(operand_2));
    else if (operator.equals("*"))
      result=(Double.parseDouble(operand_1)) * (Double.parseDouble(operand_2));
    else if (operator.equals("%"))
      result=(Double.parseDouble(operand_1)) % (Double.parseDouble(operand_2));
    else
      result=(Double.parseDouble(operand_1)) / (Double.parseDouble(operand_2));
    display_area.setText(operand_1 + operator + operand_2 + " = "+ result);
    operand_1=Double.toString(result);
  }
  else{
    if (operator.equals("")|| operand_2.equals("")){
        operator=a;
      display_area.setText(operand_1 + operator + operand_2 );
    }
    else if (!operand_1.equals("")){
      operand_2="";
      operator=a;
      display_area.setText(operand_1 + operator + operand_2 );
    }
    else{
      double result;
      if (operator.equals("+"))
        result=(Double.parseDouble(operand_1)) + (Double.parseDouble(operand_2));
      else if (operator.equals("-"))
        result=(Double.parseDouble(operand_1)) - (Double.parseDouble(operand_2));
      else if (operator.equals("*"))
        result=(Double.parseDouble(operand_1)) * (Double.parseDouble(operand_2));
      else if (operator.equals("%"))
        result=(Double.parseDouble(operand_1)) % (Double.parseDouble(operand_2));
      else
        result=(Double.parseDouble(operand_1)) / (Double.parseDouble(operand_2));
      display_area.setText(operand_1 + operator + operand_2 + " = "+ result);
      operand_1=Double.toString(result);
    }
  }

  }
}
