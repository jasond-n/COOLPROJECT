

public class JailProperty extends Property {
	
	/**
	 * constructor that uses the property
	 * */
	public JailProperty(int price, Player owner, String name)
	{
		super(price, owner, name);
	}
	
	//updates player information based on their decision gathered from the gameController
	//runs different lines if they are in jail or not
	public void doActionBeforePlayerLeavingHere(Player player, int roll, Board board)
	{
//		Scanner sc = new Scanner(System.in);
//		System.out.println(player.getAvatar() + ", you are in the Jail now, do you want to pay 50 fine, and leave, type yes to pay, other any thing to not pay");
//		String answer = sc.next();
//		if(answer == "yes")
//		{
//			int roll = player.rollDice();
//			System.out.println("you just rolled " + roll);
//			
//		}
//		else
//		{
//			
//		}
//		
	
		
		if (player.getInJail() == true) {	
			//Scanner sc = new Scanner(System.in);
			//System.out.println("You are in jail. Would you like to pay $50 to get out this turn? (y/n)");
			
			if (player.getPlayerType().equals("human")) {
				
				String userInput = getUserInput();
				
				if (userInput.equalsIgnoreCase("y")) {
					player.loseMoney(50);
					player.setInJail(false);
					//System.out.println("Nice you are out of jail!");
					board.rollDice();
					
				}
				else {
					board.rollDice();
					if (board.isDouble()) {
						player.setInJail(false);
						//System.out.println("Hey you rolled a double! You are Free!");
						//player.movePosition(board.rollDice());
					}
					
				}
			}
			//computer player
			else {
				player.loseMoney(50);
				player.setInJail(false);
				//System.out.println("Nice you are out of jail!");
				board.rollDice();
			}
		}
	}
	
	//if they land on go to jail, they get sent to jail.
	public void doActionAfterPlayerLandingHere(Player player, int roll, Board board)
	{
		switch(player.getPosition())
		{
			case 10:
				//System.out.println(player.getAvatar() + " are passing the jail. Nothing happens.");
				break;
			case 30:
				//System.out.println(player.getAvatar() + " are going to the jail now. And you have to throw doubles on any of your next three turns.");
				player.movePosition(10);
				player.setInJail(true);
				
		}
		
	}
}