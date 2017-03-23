import java.util.*;
class Monopoly
{
	/*static int dice()
	{
		Random ran = new Random();
		int x =ran.nextInt(5)+1;
		System.out.println("dice : "+x);
		return x;
	}*/
	
	public static void main(String[] args)
	{
		System.out.println("Welcome to Monopoly!!");
		System.out.println("Enter number of players");
		Scanner scan=new Scanner(System.in);
		Board board = new Board(scan.nextInt());
	}
}
