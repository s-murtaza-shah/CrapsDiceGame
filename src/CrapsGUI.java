import javax.swing.*;        // JCompoments
import javax.swing.border.*; // object borders
import java.awt.*;           // LayoutManagers/Fonts
import java.awt.event.*;     // ActionListeners
import java.text.*;          // NumberFormats

public class CrapsGUI extends JFrame implements ActionListener {
	
	static int money = 100, diceSum;
	
	JButton inst, rollBtn, add5Btn, minus5Btn, add1Btn, minus1Btn;
	JLabel title, cashLabel, betLabel, status, dice1pic, dice2pic, dice1Disp, dice2Disp;
	JTextField cashTF, betTF;
	ImageIcon[] die = new ImageIcon[7];
	
	CrapsGUI() {
		
		setSize(1200,550);
		setTitle("Craps Casino");
		
		for (int i = 0; i < 7; i++) {
			die[i] = new ImageIcon("dice"+(i)+".png");
		}
				
		rollBtn = new JButton(" ROLL ");
		rollBtn.setFont(new Font("Papyrus", Font.ITALIC, 40));
		
		Font btnFont = new Font("TImes New Roman", Font.PLAIN, 18);
		add5Btn = new JButton(" +5 ");
		add5Btn.setFont(btnFont);
		minus5Btn = new JButton(" -5 ");
		minus5Btn.setFont(btnFont);
		add1Btn = new JButton(" +1 ");
		add1Btn.setFont(btnFont);
		minus1Btn = new JButton(" -1 ");
		minus1Btn.setFont(btnFont);
		inst = new JButton("Instructions");
		inst.setFont(btnFont);
		
		inst.addActionListener(this);
		rollBtn.addActionListener(this);
		add5Btn.addActionListener(this);
		add1Btn.addActionListener(this);
		minus5Btn.addActionListener(this);
		minus1Btn.addActionListener(this);
		
		title = new JLabel("Craps Casino");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Comic Sans", Font.BOLD + Font.ITALIC, 50));
		title.setForeground(Color.BLUE);
		
		cashLabel = new JLabel("Cash");
		cashLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cashLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		
		betLabel = new JLabel("Bet");
		betLabel.setHorizontalAlignment(SwingConstants.CENTER);
		betLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		
		status = new JLabel("Enter your bet");
		status.setHorizontalAlignment(SwingConstants.CENTER);
		status.setFont(new Font("YU Gothic", Font.ITALIC, 20));
		
		dice1Disp = new JLabel("Dice 1 Roll . . .");
		dice1Disp.setHorizontalAlignment(SwingConstants.CENTER);
		dice1Disp.setFont(new Font("Papyrus", Font.BOLD, 25));
		dice2Disp = new JLabel("Dice 2 Roll . . . ");
		dice2Disp.setHorizontalAlignment(SwingConstants.CENTER);
		dice2Disp.setFont(new Font("Papyrus", Font.BOLD, 25));
		die[0] = new ImageIcon(new ImageIcon("dice0.png").getImage().getScaledInstance(112, 112, Image.SCALE_DEFAULT));
		dice1pic = new JLabel(die[0]);
		dice2pic = new JLabel(die[0]);
		
		cashTF = new JTextField(15);
		cashTF.setHorizontalAlignment(SwingConstants.RIGHT);
		cashTF.setText(String.valueOf(money));
		cashTF.setEditable(false);
		cashTF.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		betTF = new JTextField(15);
		betTF.setHorizontalAlignment(SwingConstants.RIGHT);
		betTF.setText("0");
		betTF.setEditable(false);
		betTF.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		if (Integer.parseInt(betTF.getText()) <= 0) {
			rollBtn.setEnabled(false);
		}
		
		JPanel cashP = new JPanel();
		cashP.setLayout(new GridLayout(2,1));
		cashP.add(cashLabel);
		cashP.add(cashTF);
		//cashP.setBackground(new Color(250, 234, 10));
		
		JPanel betP = new JPanel();
		betP.setLayout(new BorderLayout(5,15));
		//betP.setBackground(new Color(250, 234, 10));
		
		JPanel betDisP = new JPanel();
		betDisP.setLayout(new GridLayout(2,1));
		betDisP.add(betLabel);
		betDisP.add(betTF);
		//betDisP.setBackground(new Color(250, 234, 10));
		
		JPanel betBtns = new JPanel();
		betBtns.setLayout(new GridLayout(2,2, 5, 5));
		betBtns.add(add1Btn);
		betBtns.add(add5Btn);
		betBtns.add(minus1Btn);
		betBtns.add(minus5Btn);
		//betBtns.setBackground(new Color(250, 234, 10));
		
		betP.add("North", betDisP);
		betP.add("Center", betBtns);
		
		JPanel money = new JPanel();
		money.setLayout(new BorderLayout());
		money.add("North", cashP);
		money.add("South", betP);
		//money.setBackground(new Color(250, 234, 10));
		
		JPanel statusP = new JPanel();
		statusP.setLayout(new BorderLayout());
		statusP.add("Center", status);
		//statusP.setBackground(new Color(86, 240, 104));
		
		JPanel d1P = new JPanel();
		d1P.setLayout(new BorderLayout(20,10));
		d1P.add("North", dice1Disp);
		d1P.add("Center", dice1pic);
		//d1P.setBackground(new Color(121, 196, 237));
		
		JPanel d2P = new JPanel();
		d2P.setLayout(new BorderLayout());
		d2P.add("North", dice2Disp);
		d2P.add("South", dice2pic);
		//d2P.setBackground(new Color(121, 196, 237));
		
		JPanel diceP = new JPanel();
		diceP.setLayout(new BorderLayout(15,15));
		diceP.add("West", d1P);
		diceP.add("East", d2P);
		//diceP.setBackground(new Color(121, 196, 237));
		
		JPanel rollP = new JPanel();
		rollP.setLayout(new BorderLayout(5,95));
		rollP.add("North", diceP);
		rollP.add("Center", rollBtn);
		//rollP.setBackground(new Color(121, 196, 237));
		
		/**
		money.setBackground(new Color(250, 234, 10));
		statusP.setBackground(new Color(86, 240, 104));
		rollP.setBackground(new Color(121, 196, 237));		
		*/
		
		JPanel mainP = new JPanel();
		//mainP.setBackground(Color.LIGHT_GRAY);
		mainP.setLayout(new BorderLayout(20, 20));
		mainP.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		mainP.add("North", title);
		mainP.add("West", money);
		mainP.add("Center", statusP);
		mainP.add("East", rollP);
		mainP.add("South", inst);
	
		add(mainP);
		setResizable(false);
		setVisible(true);
		

	}
	
	public void actionPerformed(ActionEvent e) {
				
		if (e.getSource() == rollBtn) {
			
			int usrBet = Integer.parseInt(betTF.getText());
			
			if (status.getText().indexOf("again to win") == -1) {
				
				int[] diceRolls;
				
				diceRolls = setDiceImg();
				diceSum = diceRolls[0] + diceRolls[1];
				
				if (diceSum == 2 || diceSum == 3 || diceSum == 12) {
					
					money -= usrBet;
					
					if (money > 0) {
						status.setText("You lost your bet of $" + betTF.getText() + ". Enter bet again?");
					}
					else {
						status.setText("GAME OVER, YOU LOST ALL YOUR MONEY!");
					}
					rollBtn.setEnabled(false);
					cashTF.setText(String.valueOf(money));
					betTF.setText("0");
					
					minus5Btn.setEnabled(true);
					minus1Btn.setEnabled(true);
					add5Btn.setEnabled(true);
					add1Btn.setEnabled(true);
					
				}
				else if (diceSum == 7 || diceSum == 11) {
					money += usrBet;
					status.setText("You won the bet of $" + betTF.getText() + ". Enter bet again?");
					rollBtn.setEnabled(false);
					cashTF.setText(String.valueOf(money));
					betTF.setText("0");
					
					minus5Btn.setEnabled(true);
					minus1Btn.setEnabled(true);
					add5Btn.setEnabled(true);
					add1Btn.setEnabled(true);
				}
				else {
					status.setText("Roll " + diceSum + " again to win!");
					minus5Btn.setEnabled(false);
					minus1Btn.setEnabled(false);
					add5Btn.setEnabled(false);
					add1Btn.setEnabled(false);
				}
				
			}
			else if (status.getText().indexOf("again to win") != -1) {
				
				int[] diceRolls2 = setDiceImg();
				int diceSum2 = diceRolls2[0] + diceRolls2[1];
				
				if (diceSum2 == diceSum) {
					money += usrBet;
					status.setText("You won the bet of $" + betTF.getText() + ". Enter bet again?");
					rollBtn.setEnabled(false);
					cashTF.setText(String.valueOf(money));
					betTF.setText("0");		
					
					minus5Btn.setEnabled(true);
					minus1Btn.setEnabled(true);
					add5Btn.setEnabled(true);
					add1Btn.setEnabled(true);
				}
				else if (diceSum2 == 7 || diceSum == 11) {
					money -= usrBet;
					
					if (money > 0) {
						status.setText("You lost your bet of $" + betTF.getText() + ". Enter bet again?");
					}
					else {
						status.setText("GAME OVER, YOU LOST ALL YOUR MONEY!");
					}
					rollBtn.setEnabled(false);
					cashTF.setText(String.valueOf(money));
					betTF.setText("0");
					
					minus5Btn.setEnabled(true);
					minus1Btn.setEnabled(true);
					add5Btn.setEnabled(true);
					add1Btn.setEnabled(true);
				}
				else {
					minus5Btn.setEnabled(false);
					minus1Btn.setEnabled(false);
					add5Btn.setEnabled(false);
					add1Btn.setEnabled(false);
				}
			}
		}
		else if (e.getSource() == add5Btn) {
			if (Integer.parseInt(betTF.getText()) <= money-5) {
				int set = Integer.parseInt(betTF.getText()) + 5;
				betTF.setText(String.valueOf(set));
				rollBtn.setEnabled(true);
			}
		}
		else if (e.getSource() == add1Btn) {
			if (Integer.parseInt(betTF.getText()) <= money-1) {
				int set = Integer.parseInt(betTF.getText()) + 1;
				betTF.setText(String.valueOf(set));
				rollBtn.setEnabled(true);
			}
		}
		else if (e.getSource() == minus5Btn) {
			if (Integer.parseInt(betTF.getText())-5 >= 0) {
				int set = Integer.parseInt(betTF.getText()) - 5;
				betTF.setText(String.valueOf(set));
			}
			if (betTF.getText().equals("0")) {
				rollBtn.setEnabled(false);
			}
		}
		else if (e.getSource() == minus1Btn) {
			if (Integer.parseInt(betTF.getText())-1 >= 0) {
				int set = Integer.parseInt(betTF.getText()) - 1;
				betTF.setText(String.valueOf(set));
			}
			if (betTF.getText().equals("0")) {
				rollBtn.setEnabled(false);
			}
		}
		else if (e.getSource() == inst) {
			JOptionPane.showMessageDialog(inst, "Welcome to Murtaza's Craps Dice Game!\n=====================================\n"
					+ "This is an entertaining dice game where you have to bet money (less or equal"
					+ "\nto the money you have). \n\nRoll 7 or 11 on first try to win, or roll 2, 3, or 12"
					+"\non first try to lose. \n\nRoll any other number and it becomes your point. Keep"
					+"\non rolling until you get your point, but if you roll a 7 or 11 in the process,"
					+ "\nyou lose. \n\nIf you win, you get the money you bet, you lose, you lose the money"
					+"\nyou bet. \n\nIf you run out of money ($0), you lose and the game is over!"
					+"\n\nTo continue, just press OK.");
		}
	}
		
	
	protected int[] setDiceImg() {
		
		int roll1 = (int)(Math.random()*6)+1;
		int roll2 = (int)(Math.random()*6)+1;
		
		dice1pic.setIcon(die[roll1]);
		dice2pic.setIcon(die[roll2]);
		
		int[] arr = {roll1, roll2};
		
		return arr;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CrapsGUI();
	}

}
