import java.util.ArrayList;
import java.util.Random;

/**
 * This class represents a player in the game of
 * Go Fish.  Note:  Follow the rules as noted
 * in the method headings and in the GoFish
 * class.
 * 
 * 
 * @Randeep Singh, Emma Phillips, Eric Mannato 
 * @Project 1 
 */
public class GoFishPlayer
{
    //A player draws up to 5 cards to start
    //the game and before the player's turn
    //to ask "Do you have a...?"
    private final int MAX_CARDS = 5;

    //Name of the player
    private String name;

    //The deck used to play the game.
    private Deck deck;

    //The cards in the player's hand.
    private ArrayList<Card> hand;

    //The cards the player has dicarded in their pairs pile.
    //The player with the most pairs at the end of the game wins.
    private ArrayList<Card> pairs;

    //Random number generator used to pick the next 
    //card to ask "Do you have a...?"
    private Random rand;

    /**
     * Constructs a new GoFishPlayer of the input name and
     * playing the game with the input deck.  The player
     * should have a full hand once constructed.
     * 
     * @param deck The deck the game is being played with.
     * @param name The name of the player.
     */
    public GoFishPlayer(Deck deck, String name)
    {
        this.name = name;
        this.hand = new ArrayList<Card>();
        for (int i = 0; i <= 5; i++) {
            hand.add(deck.deal());
        }
    }

    /**
     * Returns the name of the player.
     * 
     * @return The name of the player.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Returns the number of pairs in the player
     * has discarded.
     * 
     * @return The number of pairs the player has
     * discarded.
     */
    public int getPairCount()
    {
        return pairs.size()/2;
    }

    /**
     * Returns a comma separated list of pairs the
     * player has discarded.
     * 
     * @return A comma separated list of pairs the
     * player has discarded.
     */
    public String getPairs()
    {
        String str = "";
        int i = 0;
        for (Card Card : pairs) {
            str += pairs.get(i).getRankName() + " of " + pairs.get(i).getSuit() + " , ";
            i++;
        }
        return str;
    }

    /**
     *  Removes any pairs from the player's hand and puts
     *  them in the player's discarded pairs.
     */
    private void discardPairs()
    {
        ArrayList temp = new ArrayList<Card>();
        Card tempCard = null;
        for (int i = 0; i < hand.size(); i++) {
            tempCard= hand.get(i);
            temp.add(tempCard);
            hand.remove(tempCard);
            if (hand.contains(tempCard)) {
                pairs.add(tempCard); }
            else{
                hand.add(tempCard);
            }
        }
    }

    /**
     * Draws cards from the deck, discarding pairs, until the
     * player has MAX_CARDS in their hand or there are no
     * more cards left in the deck.
     */
    public void makeFullHand()
    {
        while (hand.size() < MAX_CARDS && deck.numCardsNotDealt() != 0) {
            hand.add(deck.deal());
            discardPairs();
        }
    }

    /**
     * Adds the input card to the player's hand, 
     * discarding any pairs.  If the player discards
     * all cards in their hand, draws another full hand.
     * 
     * @param card The card to add the the player's hand.
     */
    public void addCard(Card card)
    {
        hand.add(card);
        discardPairs();
        if (hand.size() == 0) {
            makeFullHand();
        }
    }

    /**
     * If there is still at least one card remaining in
     * the deck, adds a card from the deck to the player's
     * hand, discarding any pairs.  If the player discards
     * all cards in their hand, draws another full hand.
     */
    public void addCard()
    {
        if (deck.numCardsNotDealt()!= 0) {
            hand.add(deck.deal());
            discardPairs();
        }
    }

    /**
     * Returns the number of cards in the player's hand.
     * 
     * @return The number of cards in the player's hand.
     */
    public int cardsInHand()
    {
        return hand.size();
    }

    /**
     * Ensures the player has a full hand (as long as there are
     * cards in the deck to make a full hand).  Then, returns
     * a random card from the player's hand without removing it
     * from the player's hand.  If the player
     * has no cards, returns null.
     * 
     * @return A random card from the player's hand (without 
     * removing it) and null if the player has no cards.
     */
    public Card selectCard()
    {
        Random rand = new Random(hand.size());
        int i = rand.nextInt();
        if ((deck.numCardsNotDealt() >= 5) && (hand.size() == 5)) {
            return hand.get(i);
        }
        else if (hand.size() == 0) {
            return null;
        }
        return null;
    }

    /**
     * If the player has a card if the input rank, returns the card, 
     * removing it from the player's hand.  Otherwise, returns null.
     * 
     * @param rank The rank of the requested card.
     * @return A card matching the same rank as the input rank
     * and null if no such card exists.
     */
    public Card giveCard(int rank)
    {
        Card result = null;
        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i).getRank() == rank)
            {
                result = hand.get(i);
            }
            else 
            {
                result = null;   
            }
        }
        return result;
    }

    /**
     * Returns a comma separated list of the cards in the player's hand.
     * 
     * @return A comma separated list of the cards in the player's hand.
     */
    public String toString()
    {
        String str = "";
        for (int i = 0; i <= hand.size(); i++)
        {
            str += hand.get(i).getRankName() + " of " + hand.get(i).getSuit() + ", ";
        }
        return str;
    }
}