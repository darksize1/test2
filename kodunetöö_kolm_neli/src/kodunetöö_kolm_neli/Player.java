package kodunetöö_kolm_neli;

public class Player {
	/**
	 * mängija nimi.
	 */
	private String name;
	
	/**
	 * mängija praeguse käe kaardid.
	 */
	private Card[] hand = new Card[10];
	
	/**
	 * mitu kaarti on mängijal praegusel käel.
	 */
	private int numCards;
	
	/**
	 * mänguri constructor.
	 */
	public Player(String theName) {
		
		this.name = theName;
		
		// tühjendab mängija käe
		this.emptyHand();
		
	}
	
	/**
	 * mängija käe tühjendamine.
	 */
	public void emptyHand() {
		
		for (int c = 0; c < 10; c++) {
			this.hand[c] = null;
		}
		this.numCards = 0;
		
	}
	
	/**
	 * lisab mänijale kätte kaarte.
	 * 
	 * @param aCard	kaart mille lisab
	 * @return		kas uue käe summa on suurem või võrdne 21 ga
	 */
	public boolean addCard(Card aCard) {
		
		// prindib errori kui mängijal on juba maksimaalne kodus kaarte , ei tohiks kunagi juhtuda 
		
		if (this.numCards == 10) {
			System.err.printf("%s's hand already has 10 cards; " + 
					"cannot add another\n", this.name);
			System.exit(1);
		}

		// lisab kätte kaarte ja tagastab kogukäe summa
		this.hand[this.numCards] = aCard;
		this.numCards++;
		
		return (this.getHandSum() <= 21);
	}
	
	/**
	 * saam mängijal käes olevate kaartide summa.
	 * 
	 * @return summa
	 */
	public int getHandSum() {
		
		int handSum = 0;
		int cardNum;
		int numAces = 0;
		
		// kalkuleerib iga kaardi osaluse kogu käe summast
		for (int c = 0; c < this.numCards; c++) {
			
			// saab kaardi arvu
			cardNum = this.hand[c].getNumber();
			
			if (cardNum == 1) { // äss
				numAces++;
				handSum += 11;
			} else if(cardNum > 10) { // pildiga kaart
				handSum += 10;
			} else {
				handSum += cardNum;
			}
		}
		
		// kui meil on ässad ja meie summa on suurem kui 21 , muudab ässa/de suuruse  hoopis 1
		
		while (handSum > 21 && numAces > 0) {
			handSum -= 10;
			numAces--;
		}
		
		return handSum;
		
	}
	
	/**
	 * prindib kaardid mis on mängija käes
	 * 
	 * @param näitab esimest kaarti olenemata kas see on peidetud v mitte
	 */
	public void printHand(boolean showFirstCard) {
		
		System.out.printf("%s's cards:\n", this.name);
		for (int c = 0; c < this.numCards; c++) {
			if (c == 0 && !showFirstCard) {
				System.out.println("  [hidden]");
			} else {
				System.out.printf("  %s\n", this.hand[c].toString());
			}
		}
		
	}

}
