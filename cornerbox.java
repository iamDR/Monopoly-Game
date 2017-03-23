import java.util.*;
class cornerbox extends notBuyable
{
	public int toPay , chanceMiss;

	public box next=null;
	public String name;
	Scanner scan = new Scanner(System.in);
	MonopolyGui dialog=new MonopolyGui();

	cornerbox(int toPay , int chanceMiss ,String name)
	{
		this.toPay = toPay;
		this.chanceMiss = chanceMiss;
		this.name=name;
	}

	boolean canPlay()
	{
		return true;
	}
	
	String getName()
	{
		return name;
	}
	
	void onland(Player p)
	{
		switch(p.getcurr().getName())
		{
			case "start":
				break;
			
			case "jail":
				if(p.canPlay()){
				p.changePlay(-3);}
				int x=dialog.opReturn(p.name+" You landed on Jail Would you like to \n 1: pay rs 300 or \n 2: miss a total of 3 chances?");
				if(x==1 && p.money >300){
					p.money -=300 ;
					dialog.formLabel("  Your fine has been accepted . You can move out on your next turn");
					p.changePlay(4);}
				else{
					dialog.formLabel("  You missed a turn");
					p.changePlay(1);
				}	
				break;
			
			case "club":
				if(p.canPlay()){
				p.changePlay(-3);
				dialog.showMess(p.name+" You are having lot of fun. Entry fee rs 250. You'll stay here for 2 chances wont you?");
				p.money -= 250 ;}
				p.changePlay(1);
				break;
		
			case "restH":
				if(p.canPlay()){
				p.changePlay(-3); dialog.showMess("  Travelling a lot so you take a vacation in a nice resort . Tariff rs 125 per chance");}
				p.money -= 125;
				p.changePlay(1);
				break;
			
			default:
				System.out.println("Your code sucks");
		}
	}
}