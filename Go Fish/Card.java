
/**
 * Creates a card that has a rank and suit that can be called from other programs.
 *
 * @author Randeep Singh
 * @version 3/9/2020
 */
public class Card
{
    private int rank;
    private Suit suit;
    /**
     * Initializes the variables to be equal to the ones inputted by the user.
     * 
     * @param rank The rank of the card
     * @param suit The suit of the card
     */
    public Card (int rank, Suit suit) {
        this.rank = rank;
        this.suit = suit; 
    }

    /**
     * Returns the rank.
     */
    public int getRank () {
        return rank;
    }

    /**
     * Returns the suit.
     */
    Suit getSuit() {
        return suit;   
    }

    /**
     * Returns the rank name; e.g 1 -> ACE.
     */
    public String getRankName() {
        String rankName = "";
        switch (rank) {
            case(1): {
                rankName = "ACE";
                break;
            }
            case(2): {
                rankName = "2";
                break;
            }
            case(3): {
                rankName = "3";
                break;
            }
            case(4): {
                rankName = "4";
                break;
            }
            case(5): {
                rankName = "5";
                break;
            }
            case(6): {
                rankName = "6";
                break;
            }
            case(7): {
                rankName = "7";
                break;
            }
            case(8): {
                rankName = "8";
                break;
            }
            case(9): {
                rankName = "9";
                break;
            }
            case(10): {
                rankName = "10";
                break;
            }
            case(11): {
                rankName = "JACK";
                break;
            }case(12): {
                rankName = "QUEEN";
                break;
            }case(13): {
                rankName = "KING";
                break;
            }            
        }
        return rankName;
    }

    /**
     * Returns the rank and the suit in (rank + " of " + suit) manner. e.g (Ace of SPADES)
     */
    @Override
    public String toString() {
        return getRank() + " of " + suit;
    }
}
