import java.util.*;
class businessbox extends buyable 
{
	public int cost , rent;
	boolean sold = false;
	Scanner scan = new Scanner(System.in);
	public box next=null;
	Player owner=null;
	public String name;
	MonopolyGui dialog=new MonopolyGui();

	businessbox(int cost , int rent ,String name)
	{
		this.cost=cost;
		this.rent=rent;
		this.name=name;
	}

	void onland(Player p)
	{
		if(sold)
		{
			dialog.showMess(p.name+" You have to pay rent of rs"+rent+" to " + owner.getName()); 
			p.money -= rent;
			owner.money+= rent;
		}
		else{
			//System.out.println("Do you want to buy? 1.yes 2.no");
			int x=dialog.opReturn("Business: "+name+" Player: "+p.name+" Do you want to buy? 1.yes 2.no");
			if(x==1){
				if(p.getMon()<cost){dialog.showMess("Too bad , you dont have the money");}
				else{buy(p); p.showStatus();}}
			}
	}
	
	void buy(Player x)
	{
		sold=true;
		owner = x;
		x.setMon(x.getMon()-cost);
	}
	
	String getName()
	{
		return name;
	}
}