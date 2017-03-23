class taxbox extends notBuyable
{
	public String name;
	
	taxbox(String name){
		this.name=name;
	}
	
	int calcamt(Player x)
	{
		int amount=(int)(x.getMon() * 0.01);
		int i=0;
		while(x.owns[i]!=null)
		{
			amount+=x.owns[i++].cost;
		}

		return amount;
	}

	void onland(Player p)
	{
		p.setMon(p.getMon() - calcamt(p));
	}

	String getName()
	{
		return name;
	}
}