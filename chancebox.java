import  java.util.Random;
class chancebox extends notBuyable
{
	public String name;
	Random ran = new Random();
	
	chancebox(String name){
		this.name=name;
	}
	
	String getName()
	{
		return name;
	}
	
	void onland(Player pl)
	{
		int d=dice();
		int monchan=0;
		
		switch(d)
		{
			case 1:
				monchan= -500;
				break;
			case 2:
				monchan= 500;
				break;
			case 3:
				monchan= -400;
				break;
			case 4:
				monchan= 400;
				break;
			case 5:
				monchan= -300;
				break;
			case 6:
				monchan= 300;
				break;
			default:
				System.out.println("Your code sucks");
		}
		pl.setMon(pl.getMon()+monchan);
		
	}
	
	int dice()
	{
		int x =ran.nextInt(5)+1;
		System.out.println("dice : "+x);
		return x;
	}
}