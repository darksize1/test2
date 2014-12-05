package kodunetöö_kolm_neli;

public class Card {
	/**
	 * üks neljast võimalikust kaardi mastist.
	 */
	private Suit mySuit;
	
	/**
	 * selle kaardi number, kus äss = 1, ja poiss-kuningas = 11-13
	 */
	private int myNumber;
	
	
	/**
	 * kaardi konstruktor.
	 * 
	 * @param aSuit		kaardi mast
	 * @param aNumber	kaardi number, kus poiss-kuningas = 11-13 ja 
	 * 					äss = 1
	 */
	public Card(Suit aSuit, int aNumber){
		
		this.mySuit = aSuit;
		this.myNumber = aNumber;
	}
	
	/**
	 * tagastab kaardi numbri.
	 * 
	 * @return number
	 */
	public int getNumber(){
		return this.myNumber;
	}
	
	/**
	 *  käib üle toString() meetodiga et anda masti numbri string sellele kaaardile . 
	 * 
	 * @return string mis kirjeldab kaardi numbrit ja masti.
	 */
	public String toString(){
		
		String numStr = "Error";
		
		switch(this.myNumber){
		
			case 2:
				numStr = "Two";
				break;
			case 3: 
				numStr = "Three";
				break;
			case 4:
				numStr = "Four";
				break;
			case 5:
				numStr = "Five";
				break;
			case 6:
				numStr = "Six";
				break;
			case 7:
				numStr = "Seven";
				break;
			case 8:
				numStr = "Eight";
				break;
			case 9:
				numStr = "Nine";
				break;
			case 10:
				numStr = "Ten";
				break;
			case 11:
				numStr = "Jack";
				break;
			case 12:
				numStr = "Queen";
				break;
			case 13:
				numStr = "King";
				break;
			case 1:
				numStr = "Ace";
				break;
			}
		
		return numStr + " of " + mySuit.toString();
	}

}
