import java.util.*;
class city extends buyable
{
	int cost=0, houses=0 , hotels=0 , rent ;// colour  ;
	boolean sold = false;
	Scanner scan = new Scanner(System.in);
	public box next=null;
	//boolean mortgaged = false;
	public String name;

	Player owner = null;
	MonopolyGui dialog=new MonopolyGui();

	city(int cost , int rent , String name)
	{
		this.cost=cost;
		this.rent=rent;
		this.name=name;
	}

	void buy(Player x)
	{
		sold=true;
		owner = x;
		x.setMon(x.getMon()-cost);
	}

	void buildhouse()
	{
		if(houses==3)
			dialog.showMess("You can build a maximum of 3 houses in a city");
		else
			houses++;

		rent=calcrent();
	}

	void buildhotel()
	{
		if(hotels==1)
			dialog.showMess("You can build a just 1 hotel in a city");
		else
			hotels++;
		rent=calcrent();
	}

	int calcrent()
	{
		return rent+100*houses + 200*hotels;
	}
	
	void onland(Player p)
	{	
		if(sold)
		{
			if(p!=owner){
				dialog.showMess(p.name+" You have to pay rent of rs"+calcrent()+" to " + owner.getName()); 
				p.money -= calcrent();
				owner.money+= calcrent();}
			else{
				//System.out.println("You own this place . Would you like to \n 1: Build House \n 2: Build Hotel");
				int hh = dialog.opReturn("City: "+name+" Player: "+p.name+" You own this place . Would you like to \n 1: Build House \n 2: Build Hotel");
				if(hh==1)
					buildhouse();
				else if (hh==2)
					buildhotel();
			}}
		else{
			//System.out.println("Do you want to buy? 1.yes 2.no");
			int x=dialog.opReturn("City: "+name+" Player: "+p.name+" Do you want to buy? 1.yes 2.no");
			if(x==1){
				if(p.getMon()<cost){dialog.showMess("Too bad , you dont have the money");}
				else{buy(p); p.showStatus();}}
			}
	}
	String getName()
	{
		return name;
	}
}