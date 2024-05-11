import javax.swing.*;
import java.util.Scanner;
import java.util.Timer;
import java.awt.*;
import java.awt.event.*;

public class Calculatorr implements ActionListener {
	JFrame frame;//declaring frame
	JTextField textField;
	JButton[] numberButtons = new JButton[10];//setting button numbers
	JButton[] functionButton = new JButton[9];//setting function buttons numbers
	JButton addButton,subButton,mulButton,divButton;// button name for future reference
	JButton decButton,equButton,delButton,clrButton,negButton;//function buttons name for future reference 
	JPanel panel;//declaring panel in the frame where all the buttons and texField will be 
	
	Font myFont = new Font("Ink Free",Font.BOLD,30);// properties of the font
	double num1=0,num2=0,result=0;//for switch case (to give functionality)
	char operator;// for operators like ('+' ,'-' ,'*' ,'/')
	
Calculatorr(){ // calculatorr method in which properties and Front end of the calculator will be
	frame = new JFrame("Calulator");//adding calculator's frame and properties
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// gives close minimize and full screen button
	frame.setSize(420,550);
	frame.setLayout(null);
	
	textField = new JTextField();//adding text field to the frame with properties
	textField.setBounds(50,25,300,50);
	textField.setFont(myFont);
	textField.setEditable(false); //so there will be no String allowed in the texField.
	
	addButton = new JButton("+");// adding buttons to the frame
	subButton = new JButton("-");
	mulButton = new JButton("*");
	divButton = new JButton("/");
	decButton = new JButton(".");
	equButton = new JButton("=");
	delButton = new JButton("DELETE");
	clrButton = new JButton("clear");
	negButton = new JButton("(-)");
	
	functionButton[0] = addButton; //adding function buttons to the frame
	functionButton[1] = subButton;
	functionButton[2] = mulButton;
	functionButton[3] = divButton;
	functionButton[4] = decButton;
	functionButton[5] = equButton;
	functionButton[6] = delButton;
	functionButton[7] = clrButton;
	functionButton[8] = negButton;
	
	
	for(int i =0;i<9;i++) { // giving font and adding action listener(whenever we clicked a button is alerted against ActionEvent)
		functionButton[i].addActionListener(this);
		functionButton[i].setFont(myFont);
		functionButton[i].setFocusable(false);//outline outside the button when you touch a button it gives an outline to it
		
	}
	
	for(int i =0;i<10;i++) {// adding values in button columns and adding action listener and font as well
		numberButtons[i]= new JButton(String.valueOf(i));
		numberButtons[i].addActionListener(this);
		numberButtons[i].setFont(myFont);
		numberButtons[i].setFocusable(false);
		
	}
	negButton.setBounds(50,430,100,50);//setting size for negative button
	delButton.setBounds(150,430,100,50);//setting size for delete button
	clrButton.setBounds(250,430,100,50);//setting size for clear button
	
	panel = new JPanel();//setting panel properties like its font and boundary,background,layout
	panel.setBounds(50,100,300,300);
	panel.setLayout(new GridLayout(4,4,10,10));
	panel.setBackground(Color.blue);
	
	panel.add(numberButtons[1]);//adding number and all the other buttons manually in the panel
	panel.add(numberButtons[2]);
	panel.add(numberButtons[3]);
	panel.add(addButton);
	panel.add(numberButtons[4]);
	panel.add(numberButtons[5]);
	panel.add(numberButtons[6]);
	panel.add(subButton);
	panel.add(numberButtons[7]);
	panel.add(numberButtons[8]);
	panel.add(numberButtons[9]);
	panel.add(mulButton);
	panel.add(decButton);
	panel.add(numberButtons[0]);
	panel.add(equButton);
	panel.add(divButton);
	
	
	frame.add(panel); // adding panel in the frame
	frame.add(negButton);//adding negbutton to the frame
	frame.add(delButton);//adding delbutton to the frame
	frame.add(clrButton);//adding clrbutton to the frame
	frame.add(textField);//adding textField to the frame
	frame.setVisible(true); //adding outline to the buttons true
	
}
	public static void main(String[] args) {// in main method we give functionality to each button 
	
		Calculatorr calc = new Calculatorr();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<10;i++) {//giving functionality to the textField
			if(e.getSource() == numberButtons[i]) {
				textField.setText(textField.getText().concat(String.valueOf(i)));
			}
		}
		
		if(e.getSource() == decButton) {//giving functionality to the decimaL BUTTON
			textField.setText(textField.getText().concat("."));
		}
		if(e.getSource() == addButton) {//giving functionality to the add button
			num1 = Double.parseDouble(textField.getText());
			operator = '+';
			textField.setText("");
		}
		if(e.getSource() == subButton) {//giving functionality to the subtract button
			num1 = Double.parseDouble(textField.getText());
			operator = '-';
			textField.setText("");
		}
		if(e.getSource() == mulButton) {//giving functionality to the multiply button
			num1 = Double.parseDouble(textField.getText());
			operator = '*';
			textField.setText("");
		}
		if(e.getSource() == divButton) {//giving functionality to the  division button
			num1 = Double.parseDouble(textField.getText());
			operator = '/';
			textField.setText("");
		}
		if(e.getSource() == equButton) {//giving functionality to the  equals button
			num2 = Double.parseDouble(textField.getText());
			switch(operator) {
			case'+':
			result = num1+num2;
			break;
			
			case'-':
				result = num1+num2;
				break;
				
			case'*':
				result = num1*num2;
				break;
				
			case'/':
				result = num1/num2;
				break;
						
			}
			textField.setText(String.valueOf(result));
			num1 = result;
		}
		if(e.getSource() == clrButton) {//giving functionality to the  clear button
			textField.setText("");
		}
		if(e.getSource() == delButton) {//giving functionality to the delete button
		String string = textField.getText();
			textField.setText("");
			for(int i =0;i<string.length()-1;i++) {
				textField.setText(textField.getText()+string.charAt(i));
			}
		}
		if(e.getSource() == negButton) {//giving functionality to the  negative button
			double temp = Double.parseDouble(textField.getText());
	temp *= -1;
	textField.setText(String.valueOf(temp));

}
	}}	
