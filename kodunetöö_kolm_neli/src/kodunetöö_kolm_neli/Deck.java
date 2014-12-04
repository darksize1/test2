package kodunetöö_kolm_neli;

import java.util.Random;

/**
 * kaardipakk.
 */
public class Deck {

	/**
	 * array kaarditest pakkis , kus ülemine kaart on esimese indeksiga.
	 */
	private Card[] myCards;
	
	/**
	 * number palju kaarte on hetkel pakkis.
	 */
	private int numCards;
	
	/**
	 * pakk kus tavaliselt on 52 kaarti ja ei segata pakki.
	 */
	public Deck(){
		
		// kutsub järgmise pakki ja määrab defineerib ära selle pakki ilma segamata
		this(1, false);
	}
	
	/**
	 *  määrab ära palju pake on ühes suures pakkis ja kas see peaks olema segatud või mitte 
	 * 
	 * @param numDecks	mitu üksikut pakki on ühes suures pakkis
	 * @param shuffle	segada või mitte segada
	 */
	public Deck(int numDecks, boolean shuffle){
		
		this.numCards = numDecks * 52;
		this.myCards = new Card[this.numCards];
		
		// kaardi indeks
		int c = 0;
		
		// for igaks pakkiks
		for (int d = 0; d < numDecks; d++) {
			
			// for igaks mastiks
			for (int s = 0; s < 4; s++) {
				
				// for iga number
				for (int n = 1; n <= 13; n++) {
					
					// lisab uue kaardi kaardipakki
					this.myCards[c] = new Card(Suit.values()[s], n);
					
					// kaardi indeksi juurdekasv
					c++;
					
				}
			}
		}
		
		// segab kui vajalik
		if (shuffle) {
			this.shuffle();
		}
		
	}
	
	/**
	 * segab pakki suvaliselt vahetades kaardi paare
	 */
	public void shuffle(){
		
		// paneb random numbri generaatori tööle
		Random rng = new Random();
		
		// ajutine kaart
		Card temp;
		
		int j;
		for (int i = 0; i < this.numCards; i++){
			
			//saab kaardi millega ta kaardi i vahetab
			j = rng.nextInt(this.numCards);
			
			// teeb vahetuse
			temp = this.myCards[i];
			this.myCards[i] = this.myCards[j];
			this.myCards[j] = temp;
		}
		
	}
	
	/**
	 *jagab uue kaardi kaardi algusest
	 * 
	 * @return	jagatud kaart
	 */
	public Card dealNextCard() {
		
		// võtab ülemise kaardi
		Card top = this.myCards[0];
		
		// paneb ülejäänud kaardid ükshaaval vasakule 
		for (int c = 1; c < this.numCards; c++) {
			this.myCards[c-1] = this.myCards[c];
		}
		this.myCards[this.numCards-1] = null;
		
		// kaartide number
		this.numCards--;
		
		// return ülemise kaardi
		return top;
		
	}
	
	/**
	 * prindib ülemised kaardid.
	 * 
	 * @param numToPrint	kaartide number kaardi paki algusest mis tuleb printida
	 */
	public void printDeck(int numToPrint) {
		
		// prindib ülemised kaardid 
		for (int c = 0; c < numToPrint; c++) {
			System.out.printf("% 3d/%d) %s\n", c + 1, this.numCards, 
					this.myCards[c].toString());
		}
		
		System.out.printf("         [%d others]\n\n", this.numCards-numToPrint);
		
	}
	
}