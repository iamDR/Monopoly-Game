import java.util.Scanner;
abstract class box
{
	public box next;
	//public Node prev;
	
	public String name;

	boolean canPlay()
	{
		return true;
	}

	void setNext(box b)
	{
		next=b;
	}
	
	String getName()
	{
		return name;
	}
	
	abstract void onland(Player p);
}