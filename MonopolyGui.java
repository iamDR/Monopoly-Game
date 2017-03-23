import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.*;  
import java.awt.*;  
import javax.swing.*;  
public class MonopolyGui
{
	public JButton b1;
	public JLabel d;
	public boolean state;
	public int plc;
	public JLabel[] pmon;
	public JLabel[] pcur;
	Player[] p;
	JLabel[] coins;
	public int[] tk;
	JFrame f=new JFrame();

	void formLabel(String message)
	{
		JLabel custom=new JLabel();
		custom.setText(message);
		custom.setBounds(600,400,600,300);
		f.add(custom);
	}
	int opReturn(String message)
		{
			return Integer.parseInt(JOptionPane.showInputDialog(f,message));
		}
	void showMess(String message)
	{
		JOptionPane.showMessageDialog(f,message);
	}
	MonopolyGui()
	{

	}
	MonopolyGui(Player[] player)  
	{
	p=player;
	plc=player.length;
	tk=new int[plc]; 
/*
	JLabel s1=new JLabel();
	JLabel s2=new JLabel();
	s1.setBackground(color[i]);s1.setOpaque(true);
	s2.setBackground(Color.blue);s2.setOpaque(true);
	s1.setBounds(30,680,30,30);
	s2.setBounds(85,680,30,30);
	f.add(s1);f.add(s2);*/

	Color color[] = {Color.red, Color.blue , Color.green , Color.yellow , Color.orange, Color.white};
	coins=new JLabel[player.length];
	//JLabel s2=new JLabel();
	int coinsst =30;
	for(int i=0 ; i<player.length ; i++)
	{
		coins[i]=new JLabel();
		coins[i].setBackground(color[i]);coins[i].setOpaque(true);
		//s2.setBackground(color[i]);s2.setOpaque(true);
		coins[i].setBounds(coinsst,666,30,30);
		//s2.setBounds(85,680,30,30);
		f.add(coins[i]);//f.add(s2);
		coinsst+=30;
		tk[i]=0;
	}
	int height = 150 ;
	JLabel pdet[]=new JLabel[player.length];
	pmon=new JLabel[player.length];
	
	
	for(int i=0 ; i<player.length ; i++)
	{
		pdet[i]=new JLabel(player[i].getName()); //changed

		pdet[i].setBackground(color[i]);pdet[i].setOpaque(true);

		pdet[i].setBounds(800,height,120,25);

		f.add(pdet[i]);//f.add(p2);
		
		pmon[i]=new JLabel(player[i].getMon()+"");
		pmon[i].setBackground(color[i]);pmon[i].setOpaque(true);
		pmon[i].setBounds(920,height,120,25);

		f.add(pmon[i]);//f.add(p2);
		height +=20;
	}
	
	
	int curst=350;
	JLabel cur=new JLabel("Current");
	cur.setBounds(350,150,player.length*70,25);
	f.add(cur);
	
	pcur=new JLabel[player.length];
	for(int i=0 ; i<player.length ; i++)
	{
		pcur[i]=new JLabel(player[i].getcurr().getName());

		pcur[i].setBackground(color[i]);pcur[i].setOpaque(true);

		pcur[i].setBounds(350 + 70*i,175,70,25);

		f.add(pcur[i]);
	}
	
	b1=new JButton("Roll Dice!");						
	b1.setBounds(950,height+40,110,30);
	f.add(b1);

	
	JLabel cash=new JLabel("Cash");
	//JLabel prop=new JLabel("Property");
	cash.setBounds(920,125,120,25);
	//prop.setBounds(1040,125,120,25);
	f.add(cash);//f.add(prop);

  	d=new JLabel("");
	d.setBackground(Color.green);d.setOpaque(true);
	d.setBounds(890,height+40,30,30);
	//change
	state=false;
	b1.setEnabled(false);


	f.add(d);
		JOptionPane.showMessageDialog(f, "Welcome to Monopoly Game!!");//this will be used when player chance ends
	

	JLabel ic1=new JLabel(new ImageIcon(new ImageIcon("start.jpg").getImage().getScaledInstance(170, 89,Image.SCALE_DEFAULT)));
	ic1.setBounds(0,621,170,89); 
	JLabel ic2=new JLabel(new ImageIcon(new ImageIcon("airlines.jpg").getImage().getScaledInstance(170, 89,Image.SCALE_DEFAULT)));
	ic2.setBounds(170,621,170,89); 
	JLabel ic3=new JLabel(new ImageIcon(new ImageIcon("bengaluru.jpg").getImage().getScaledInstance(170, 89,Image.SCALE_DEFAULT)));
	ic3.setBounds(340,621,170,89); 
	JLabel ic4=new JLabel(new ImageIcon(new ImageIcon("radio.jpg").getImage().getScaledInstance(170, 89,Image.SCALE_DEFAULT)));
	ic4.setBounds(510,621,170,89); 
	JLabel ic5=new JLabel(new ImageIcon(new ImageIcon("chennai.jpg").getImage().getScaledInstance(170, 89,Image.SCALE_DEFAULT)));
	ic5.setBounds(680,621,170,89); 
	JLabel ic6=new JLabel(new ImageIcon(new ImageIcon("tax.jpg").getImage().getScaledInstance(170, 89,Image.SCALE_DEFAULT)));
	ic6.setBounds(850,621,170,89); 
	JLabel ic7=new JLabel(new ImageIcon(new ImageIcon("hyderabad.jpg").getImage().getScaledInstance(170, 89,Image.SCALE_DEFAULT)));
	ic7.setBounds(1020,621,170,89); 
	JLabel ic8=new JLabel(new ImageIcon(new ImageIcon("rest.jpg").getImage().getScaledInstance(170, 89,Image.SCALE_DEFAULT)));
	ic8.setBounds(1190,621,170,89); 
	JLabel ic9=new JLabel(new ImageIcon(new ImageIcon("wasseypur.jpg").getImage().getScaledInstance(170,89,Image.SCALE_DEFAULT)));
	ic9.setBounds(1190,534,170,89); 
	JLabel ic10=new JLabel(new ImageIcon(new ImageIcon("guwahati.jpg").getImage().getScaledInstance(170, 89,Image.SCALE_DEFAULT)));
	ic10.setBounds(1190,445,170,89); 
	JLabel ic11=new JLabel(new ImageIcon(new ImageIcon("steamer.jpg").getImage().getScaledInstance(170, 89,Image.SCALE_DEFAULT)));
	ic11.setBounds(1190,356,170,89); 
	JLabel ic12=new JLabel(new ImageIcon(new ImageIcon("bhubaneshwar.jpg").getImage().getScaledInstance(170, 89,Image.SCALE_DEFAULT)));
	ic12.setBounds(1190,267,170,89); 
	JLabel ic13=new JLabel(new ImageIcon(new ImageIcon("chance.jpg").getImage().getScaledInstance(170, 89,Image.SCALE_DEFAULT)));
	ic13.setBounds(1190,178,170,89); 
	JLabel ic14=new JLabel(new ImageIcon(new ImageIcon("kolkata.jpg").getImage().getScaledInstance(170, 89,Image.SCALE_DEFAULT)));
	ic14.setBounds(1190,89,170,89); 
	JLabel ic15=new JLabel(new ImageIcon(new ImageIcon("club.jpg").getImage().getScaledInstance(170, 89,Image.SCALE_DEFAULT)));
	ic15.setBounds(1190,0,170,89); 
	JLabel ic16=new JLabel(new ImageIcon(new ImageIcon("bus.jpg").getImage().getScaledInstance(170, 89,Image.SCALE_DEFAULT)));
	ic16.setBounds(1020,0,170,89); 
	JLabel ic17=new JLabel(new ImageIcon(new ImageIcon("jhansi.jpg").getImage().getScaledInstance(170, 89,Image.SCALE_DEFAULT)));
	ic17.setBounds(850,0,170,89); 
	JLabel ic18=new JLabel(new ImageIcon(new ImageIcon("tv.jpg").getImage().getScaledInstance(170, 89,Image.SCALE_DEFAULT)));
	ic18.setBounds(680,0,170,89); 
	JLabel ic19=new JLabel(new ImageIcon(new ImageIcon("delhi.jpg").getImage().getScaledInstance(170, 89,Image.SCALE_DEFAULT)));
	ic19.setBounds(510,0,170,89); 
	JLabel ic20=new JLabel(new ImageIcon(new ImageIcon("ctax.jpg").getImage().getScaledInstance(170, 89,Image.SCALE_DEFAULT)));
	ic20.setBounds(340,0,170,89); 
	JLabel ic21=new JLabel(new ImageIcon(new ImageIcon("chandigarh.jpg").getImage().getScaledInstance(170, 89,Image.SCALE_DEFAULT)));
	ic21.setBounds(170,0,170,89);
	JLabel ic22=new JLabel(new ImageIcon(new ImageIcon("jail.jpg").getImage().getScaledInstance(170, 89,Image.SCALE_DEFAULT)));
	ic22.setBounds(0,0,170,89);
	JLabel ic23=new JLabel(new ImageIcon(new ImageIcon("elec.jpg").getImage().getScaledInstance(170, 89,Image.SCALE_DEFAULT)));
	ic23.setBounds(0,89,170,89); 
	JLabel ic24=new JLabel(new ImageIcon(new ImageIcon("jaipur.jpg").getImage().getScaledInstance(170, 89,Image.SCALE_DEFAULT)));
	ic24.setBounds(0,178,170,89); 
	JLabel ic25=new JLabel(new ImageIcon(new ImageIcon("steel.jpg").getImage().getScaledInstance(170, 89,Image.SCALE_DEFAULT)));
	ic25.setBounds(0,267,170,89); 
	JLabel ic26=new JLabel(new ImageIcon(new ImageIcon("ahmedabad.jpg").getImage().getScaledInstance(170, 89,Image.SCALE_DEFAULT)));
	ic26.setBounds(0,356,170,89); 
	JLabel ic27=new JLabel(new ImageIcon(new ImageIcon("chance.jpg").getImage().getScaledInstance(170, 89,Image.SCALE_DEFAULT)));
	ic27.setBounds(0,445,170,89); 
	JLabel ic28=new JLabel(new ImageIcon(new ImageIcon("mumbai.jpg").getImage().getScaledInstance(170, 89,Image.SCALE_DEFAULT)));
	ic28.setBounds(0,534,170,89);
	JLabel ic29=new JLabel(new ImageIcon(new ImageIcon("index.jpg").getImage().getScaledInstance(1,1,Image.SCALE_DEFAULT)));
	ic29.setBounds(323,323,81,81);
	f.add(ic1);f.add(ic2);f.add(ic3);f.add(ic4);f.add(ic5);f.add(ic6);f.add(ic7);f.add(ic8);f.add(ic9);f.add(ic10);f.add(ic11);f.add(ic12);
	f.add(ic13);f.add(ic14);f.add(ic15);f.add(ic16);f.add(ic17);f.add(ic18);f.add(ic19);f.add(ic20);f.add(ic21);f.add(ic22);
	f.add(ic23);f.add(ic24);f.add(ic25);f.add(ic26);f.add(ic27);f.add(ic28);f.add(ic29);
	f.setSize(1366,768);  
	f.setExtendedState(JFrame.MAXIMIZED_BOTH);  
	f.setVisible(true);  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
  	}
	
	public static int diceNum=0;
	public void mouseclick()
	{
		b1.setEnabled(true);
		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt) 
			{
				diceNum=1+(int)(Math.random() * 6);
				//d.setText(diceNum+"");
				//System.out.println(d.getText());
				state=true;
	//obj.dice=diceNum;	
				/*for(int i=0 ; i<plc ; i++)
				{
					pmon[i].setText(String.valueOf(p[i].getMon()));
					pcur[i].setText(String.valueOf(p[i].getcurr().getName()));
		//p.setText(String.valueOf(player[1].getMon()));
				}*/
				b1.setEnabled(false);
				//d.setText(diceNum+"");
			}
		});
		d.setText(diceNum+"");
		for(int i=0 ; i<plc ; i++)
				{
					pmon[i].setText(String.valueOf(p[i].getMon()));
					pcur[i].setText(String.valueOf(p[i].getcurr().getName()));
		//p.setText(String.valueOf(player[1].getMon()));
				}
		//System.out.println(d.getText());
	}	
	public void showTraversal(int n,int d)
	{
		if(tk[n]<7)
		{
			for(int i=1;i<=d;i++)
			{
				tk[n]++;
				if(tk[n]==8)
				{
					tk[n]=tk[n]%28;
					showTraversal(n,(d-i+1));tk[n]--;
					break;		
				}
				coins[n].setBounds(coins[n].getX(),(coins[n].getY()-89),30,30);
				try {Thread.sleep(1000);} 
				catch(InterruptedException ex) {Thread.currentThread().interrupt();}
			}
		}
		else if(7<=tk[n] && tk[n]<14)
		{
			for(int i=1;i<=d;i++)
			{
				tk[n]++;
				if(tk[n]==15)
				{
					tk[n]=tk[n]%28;
					showTraversal(n,(d-i+1));tk[n]--;
					break;		
				}
				coins[n].setBounds((coins[n].getX()+170),coins[n].getY(),30,30);
				try {Thread.sleep(1000);} 
				catch(InterruptedException ex) {Thread.currentThread().interrupt();}
			}
		}
		else if(14<=tk[n] && tk[n]<21)
		{
			for(int i=1;i<=d;i++)
			{
				tk[n]++;
				if(tk[n]==22)
				{
					tk[n]=tk[n]%28;
					showTraversal(n,(d-i+1));tk[n]--;
					break;		
				}
				coins[n].setBounds(coins[n].getX(),(coins[n].getY()+89),30,30);
				try {Thread.sleep(1000);} 
				catch(InterruptedException ex) {Thread.currentThread().interrupt();}
			}
		}
		else
		{
			for(int i=1;i<=d;i++)
			{
				tk[n]++;
				if(tk[n]>28)
				{
					tk[n]=tk[n]%28;
					showTraversal(n,(d-i+1));tk[n]--;
					break;		
				}
				coins[n].setBounds((coins[n].getX()-170),coins[n].getY(),30,30);
				try {Thread.sleep(1000);} 
				catch(InterruptedException ex) {Thread.currentThread().interrupt();}
			}
		}
	}
}
