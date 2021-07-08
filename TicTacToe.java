import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class TicTacToe implements ActionListener
{
	Random random = new Random();
	JFrame frame = new JFrame("TicTacToe Game");
	JPanel titlepanel = new JPanel();
	JPanel buttonpanel = new JPanel();
	JPanel keypanel = new JPanel();
	JLabel label = new JLabel();
	JButton[] buttons = new JButton[9];
	JButton reset = new JButton("Reset");
	JButton exit = new JButton("Exit");
	boolean player1Turn;

	TicTacToe()
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,800);
		frame.setBackground(Color.BLACK);
		frame.getContentPane();//.setBackground(Color.BLACK);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		label.setBackground(Color.WHITE);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Ink Free",Font.BOLD,75));
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setText("Tic Tac Toe");
		label.setOpaque(true);
  
		titlepanel.setLayout(new BorderLayout());
		titlepanel.setBounds(0,0,600,100);
  
		buttonpanel.setLayout(new GridLayout(3,3));
		buttonpanel.setBounds(0,100,600,600);
		buttonpanel.setBackground(Color.BLACK);
  
		keypanel.setLayout(new GridLayout(1,2));
		keypanel.setBounds(0,700,600,100);
 
		int x=0; 
		int y=100;
		int j=0;  
		for(int i=0;i<=8;i++,x+=200,j++)
		{  
			buttons[i] = new JButton();  
			if(j==3)  
			{
				j=0; 
				y+=200; 
				x=0;
			}  
			buttons[i].setBounds(x,y,200,200);
			buttons[i].setBackground(Color.BLACK);
			//buttons[i].setForeground(Color.WHITE);
			buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));	
			buttons[i].addActionListener(this);
			buttonpanel.add(buttons[i]);
			//buttons[i].setOpaque(false);
		}
		
		reset.setBackground(Color.WHITE);
		reset.setForeground(Color.BLACK);
		exit.setBackground(Color.WHITE);
		exit.setForeground(Color.BLACK);
		
		reset.setBounds(0,700,300,300);  
		exit.setBounds(300,700,300,300);  

		keypanel.add(reset);  
		reset.addActionListener(this);
		reset.setFont(new Font("Ink Free",Font.BOLD,50));
	
		keypanel.add(exit);
		exit.addActionListener(this);
		exit.setFont(new Font("Ink Free",Font.BOLD,50));
  
		titlepanel.add(label);
		frame.add(titlepanel,BorderLayout.NORTH);
		frame.add(buttonpanel);
		frame.add(keypanel,BorderLayout.SOUTH);
		
		firstTurn();
    }

 
public void actionPerformed(ActionEvent e) 
{
	for(int i=0;i<9;i++)//checking each 9 buttons
	{
		if(e.getSource()==buttons[i]) 
		{
			if(player1Turn) 
			{
				if(buttons[i].getText() == "") 
				{
					buttons[i].setForeground(Color.RED);
					buttons[i].setText("X");
					player1Turn = false;
					label.setText("O turn");
					check();
				}
			}
			else 
			{
				if(buttons[i].getText() == "")
				{
					buttons[i].setForeground(Color.BLUE);
					buttons[i].setText("O");
					player1Turn = true;
					label.setText("X turn");
					check();
				}
			}
		}   
	}
	if(e.getSource() == reset)
	{
		frame.dispose();
		new TicTacToe();
	}
	if(e.getSource() == exit)
	{
		System.exit(0);
	}
}
 
public void firstTurn() 
{
	try 
	{
		Thread.sleep(10000);//2 sec
    }catch (InterruptedException e)
	{
		e.printStackTrace();
	}
	//player1Turn=true;
	//label.setText("X turn");
	if(random.nextInt(1) == 0) 
	{
		player1Turn=true;
		label.setText("X turn");
	}
	else 
	{
		player1Turn=false;
		label.setText("O turn");
	}
}
 
public void check() 
{
	if((buttons[0].getText()=="X") && (buttons[1].getText()=="X") && (buttons[2].getText()=="X")) 
	{
		xWins(0,1,2);
    }
    else if((buttons[3].getText()=="X") && (buttons[4].getText()=="X") && (buttons[5].getText()=="X"))
	{
        xWins(3,4,5);
    }
    else if((buttons[6].getText()=="X") && (buttons[7].getText()=="X") && (buttons[8].getText()=="X"))
    {
		xWins(6,7,8);
    }
    else if((buttons[0].getText()=="X") && (buttons[3].getText()=="X") && (buttons[6].getText()=="X")) 
	{
        xWins(0,3,6);
    }
    else if((buttons[1].getText()=="X") &&  (buttons[4].getText()=="X") && (buttons[7].getText()=="X")) 
	{
		xWins(1,4,7);
    }
    else if((buttons[2].getText()=="X") && (buttons[5].getText()=="X") && (buttons[8].getText()=="X")) 
	{
        xWins(2,5,8);
    }
    else if((buttons[0].getText()=="X") && (buttons[4].getText()=="X") && (buttons[8].getText()=="X")) 
	{
		xWins(0,4,8);
    }
    else if((buttons[2].getText()=="X") && (buttons[4].getText()=="X") && (buttons[6].getText()=="X"))
    {
		xWins(2,4,6);
    }
    else if((buttons[0].getText()=="O") && (buttons[1].getText()=="O") && (buttons[2].getText()=="O"))
    {
		oWins(0,1,2);
    }
    else if((buttons[3].getText()=="O") && (buttons[4].getText()=="O") && (buttons[5].getText()=="O"))
    {
		oWins(3,4,5);
    }
    else if((buttons[6].getText()=="O") && (buttons[7].getText()=="O") && (buttons[8].getText()=="O"))
    {
		oWins(6,7,8);
    }
    else if((buttons[0].getText()=="O") && (buttons[3].getText()=="O") && (buttons[6].getText()=="O"))
	{
		oWins(0,3,6);
	}
	else if((buttons[1].getText()=="O") && (buttons[4].getText()=="O") && (buttons[7].getText()=="O"))
    {
		oWins(1,4,7);
	}
	else if((buttons[2].getText()=="O") && (buttons[5].getText()=="O") && (buttons[8].getText()=="O")) 
	{
		oWins(2,5,8);
	}
	else if((buttons[0].getText()=="O") && (buttons[4].getText()=="O") && (buttons[8].getText()=="O"))
    {
		oWins(0,4,8);
	}
	else if((buttons[2].getText()=="O") && (buttons[4].getText()=="O") && (buttons[6].getText()=="O")) 
	{
		oWins(2,4,6);
	}
	else 
	{
		int checkTie = 0;
		for(JButton i : buttons) 
		{
			if(i.getText()=="O" || i.getText()=="X") 
			{
				checkTie++; 
			}
			if(checkTie==9) 
			{
				tie();
				//System.out.println("Tie");
			}
		}
	}
}
public void tie() 
{
	label.setText("It's a tie");
	JOptionPane.showMessageDialog(frame,"Game DRAW!!!\nPress Okay to continue");  
}
 
public void xWins(int a,int b,int c) 
{
	buttons[a].setBackground(Color.GREEN);
	buttons[b].setBackground(Color.GREEN);
	buttons[c].setBackground(Color.GREEN);
    for(int i=0;i<9;i++) 
	{
		buttons[i].setEnabled(false);
	}
	label.setText("X wins");
	JOptionPane.showMessageDialog(frame,"GAME OVER!!!\nPlayer X won\nPress Okay to continue");  
}
public void oWins(int a,int b,int c) 
{
	buttons[a].setBackground(Color.GREEN);
	buttons[b].setBackground(Color.GREEN);
	buttons[c].setBackground(Color.GREEN);
	for(int i=0;i<9;i++)
	{
		buttons[i].setEnabled(false);
	}
	label.setText("O wins");
	JOptionPane.showMessageDialog(frame,"GAME OVER!!!\nPlayer 0 won\nPress Okay to continue");  
}
public static void main(String[] args) 
{  
	new TicTacToe();  
}
}
