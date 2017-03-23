/*import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.Dimension;
import java.awt.Graphics;*/
import java.awt.event.*;  
import java.awt.*;  
import javax.swing.*;  
import java.util.Random;
class Board
{
	public MonopolyGui Gui;
	public box mumbai = new city(2300 , 230 , "mumbai");
	public box ahmedabad = new city(1700 ,170, "ahmedabad");
	public box jaipur = new city(1500 , 150,"jaipur");
	public box jhansi = new city(1400 , 130 ,"jhansi");
	public box delhi = new city(2500 , 250 , "delhi");
	public box chandigarh = new city(2000 , 200 , "chandigarh");
	public box kolkata = new city(2100 , 210 , "kolkata");
	public box wasseypur = new Wasseypur(100000 , 1000 , "wasseypur");
	public box bhub = new city(1300 , 130 , "bhub");
	public box guwahati = new city(1500 , 150 , "guwahati");
	public box hyderabad = new city(1800 , 180 , "hyderabad");
	public box chennai = new city(2000,200 , "chennai");
	public box bangalore = new city(2400,240,"bangalore");
	public box goa = new city(1900,190,"goa");
		
	public box airlines = new businessbox(4000,800 , "airlines");
	public box steamer = new businessbox(3500,700 , "steamer");
	public box steel = new businessbox(3700,740 , "steel");
	public box tvchan = new businessbox(3000,600 , "tvchan");
	public box elec = new businessbox(3700,750 , "elec");
	public box radsta = new businessbox(2000 , 400 , "radsta");
	public box busserv = new businessbox(3500 , 700 , "busserv");
	public box start = new cornerbox(-500 , 0 , "start");
	public box jail=new cornerbox(300 , 3 , "jail");
	public box club=new cornerbox(500 , 1 , "club");
	public box restH=new cornerbox(-250 , 1 , "restH");
	public box chance1=new chancebox("chance1");
	public box chance2=new chancebox("chance2");
	public box cashTax=new taxbox("cashTax");
	public box propTax=new taxbox("propTax");
	public box currBox[] ;
	public Player player[];
	MonopolyGui dialog=new MonopolyGui();
	Board(int noPlayers)
	{
		start.next=mumbai;
		mumbai.next=chance1;
		chance1.next=ahmedabad;
		ahmedabad.next=steel;
		steel.next=jaipur;
		jaipur.next=elec;
		elec.next=jail;
		
		jail.next=chandigarh;
		chandigarh.next=cashTax;
		cashTax.next=delhi;
		delhi.next=tvchan;
		tvchan.next=jhansi;
		jhansi.next=busserv;
		busserv.next=club;
		
		club.next=kolkata;
		kolkata.next=chance2;
		chance2.next=bhub;
		bhub.next=steamer;
		steamer.next=guwahati;
		guwahati.next=wasseypur;
		wasseypur.next=restH;
		
		restH.next=hyderabad;
		hyderabad.next=propTax;
		propTax.next=chennai;
		chennai.next=radsta;
		radsta.next=bangalore;
		bangalore.next=airlines;
		airlines.next=start;


		currBox = new box[noPlayers];

		player = new Player[noPlayers];
		for(int i=0;i<noPlayers;i++)
			player[i]=new Player(start);
		
		Gui = new MonopolyGui(player);
		int i=60;
		while(i>0)
		{
			//Gui.b1.setEnabled(true);
			Gui.mouseclick();
			if(Gui.state)
			{
				System.out.println(Gui.d.getText());
				int dice=Integer.parseInt(Gui.d.getText());
				Gui.d.setText(dice + "");
				System.out.println(dice);
				move(i-- , dice);
				//Gui.d.setText(" ");
			}
			Gui.state=false;
		}
	}
	
	void move(int nop , int d)
	{
		int n = nop % player.length;
		dialog.formLabel(" "+" "+" "+player[n].getName() +"'s chance");
		//JOptionPane.showMessageDialog(f, " "+" "+" "+player[n].getName() +"'s chance");//this will be used when player chance ends
		if(player[n].canPlay()){
				//method to show traversal
				Gui.showTraversal(n,d);
		for(int i=0 ;i<d;i++){
			player[n].setcurr(player[n].getcurr().next);
			if(player[n].getcurr().name=="start"){
				player[n].money+=1500;
				System.out.println("You just crossed start and recieved rs 1500");
			}
		}}
			System.out.println(player[n].getcurr().getName());
			player[n].getcurr().onland(player[n]);
			player[n].showStatus();
		
	}

}
