import java.util.ArrayList;
import java.util.Random;
/**
 * Creates a deck that can be dealt, shuffled, return how many card left to be dealt, and what such cards are.
 *
 * @author Randeep Singh 
 * @version 3/12/2020
 */
public class Deck
{
    public static final int NUMOFCARDS = 52;
    public ArrayList <Card> cards;

    /**
     * Adds the given suit and makes 13 cards to the ArrayList of cards.
     * 
     * @param suit The given suit to make 13 cards of. e.g ACE of SPADES
     */
    private void addSuit(Suit suit)
    {
        for (int i = 0; i < 13; i++)
        {
            cards.add(new Card(i,suit));  
        }
    }

    /**
     * Makes and add 13 cards for each suit into the ArrayList of cards.
     */
    public Deck() {
        cards = new ArrayList <Card>();
        addSuit(Suit.HEARTS);
        addSuit(Suit.DIAMONDS);
        addSuit(Suit.SPADES);
        addSuit(Suit.CLUBS);
    }

    /**
     * Shuffles the cards within the ArrayList of cards..
     */
    public void shuffle() {
        Random rand = new Random();
        ArrayList temp = new ArrayList <Card>();
        Card tempCard;
        int i;
        while (cards.size() != 0)
        {
            i = rand.nextInt(cards.size());
            tempCard = cards.get(i);
            cards.remove(i);
            temp.add(tempCard);
        }
        cards = temp;
    }

    /**
     * Deals the cards and removes it from the deck.
     */
    public Card deal() {
        Card temp;
        if (cards.size() != 0) {
            temp = cards.get(0);
            cards.remove(0);
            return temp;
        }
        else {
            return null;   
        }
    }

    /**
     * Returns the number of cards left in the deck.
     */
    public int numCardsNotDealt() {
        return cards.size();
    }

    /**
     * Returns which cards are left to be dealt in a (rank + " of " suit) manner.
     */
    @Override
    public String toString() {
        int i = 0;
        String str = "";
        for (Card Card : cards)
        {
            str += cards.get(i).getRankName() + " of " + cards.get(i).getSuit() + " ";
            i++;
        }
        return str;
    }
}

