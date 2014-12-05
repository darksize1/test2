package kodunetöö_kolm_neli;

import java.util.Scanner;

public class GameRunner {

	public static void main(String[] args) {
		
		// muutujad
		Scanner sc = new Scanner(System.in);
		Deck theDeck = new Deck(1, true);
		
		// mängijate nimed
		Player me = new Player("Martin");
		Player dealer = new Player("Dealer");
		
		// jagab igale mängijale kaks kaarti
		me.addCard(theDeck.dealNextCard());
		dealer.addCard(theDeck.dealNextCard());
		me.addCard(theDeck.dealNextCard());
		dealer.addCard(theDeck.dealNextCard());
		
		// igle mängijale sama palju kaarte
		System.out.println("Cards are dealt\n");
		me.printHand(true);
		dealer.printHand(false);
		System.out.println("\n");
		
		// annab märku kui iga mängija lõptab uue kaardi küsimise
		boolean meDone = false;
		boolean dealerDone = false;
		String ans;
		
		while(!meDone || !dealerDone) {
			
			// mängija käik
			if(!meDone){
				System.out.print("Hit or Stay? (Enter H or S): ");
				ans = sc.next();
				System.out.println();
				
				// kui mängija võtab kaardi juurde
				if(ans.compareToIgnoreCase("H") == 0) {
					
					// lisab uue kaardi ja vaatab kas mängija on läbi või mitte
					meDone = !me.addCard(theDeck.dealNextCard());
					me.printHand(true);
				}
				else{
					meDone = true;
				}
			}
			
			// Diileri kord
			if(!dealerDone) {
				if(dealer.getHandSum() < 17){
					System.out.println("The Dealer hits\n");
					dealerDone = !dealer.addCard(theDeck.dealNextCard());
					dealer.printHand(false);
				}
				else {
					System.out.println("The Dealer stays\n");
					dealerDone = true;
				}
			}
			
			System.out.println();
		}
		
		// close scanner
		sc.close();
		
		// prindib viimased käed
		me.printHand(true);
		dealer.printHand(true);
		
		int mySum = me.getHandSum();
		int dealerSum = dealer.getHandSum();
		
		if(mySum > dealerSum && mySum <= 21 || dealerSum > 21){
			System.out.println("You win!");
		}
		else{
			System.out.println("Dealer wins!");
		}

	}

}