import java.util.*;
class Player
{
	public buyable[] owns=new buyable[21];
	int money;
	String name;
	box current;
	Scanner scan=new Scanner(System.in);
	int canPlayCounter=0;
	public Player(box st)
	{
		System.out.println("Enter name");
		name=scan.next();
		money=5000;
		current=st;
	}
	
	box getcurr(){
		return current;
	}
	
	void setcurr(box c){
		current=c;
	}
	
	int getMon()
	{
		return money;
	}
	
	void setMon(int m)
	{
		money = m ;
	}
	
	void showStatus()
	{
		System.out.println("Your money :"+ money );
	}
	
	String getName()
	{
		return name;
	}
	
	boolean canPlay()
	{
		return canPlayCounter == 0;
	}
	
	void changePlay(int i)
	{
		canPlayCounter-=i;
		if(canPlayCounter<0)
			canPlayCounter=0;
	}
}