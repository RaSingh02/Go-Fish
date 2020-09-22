import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * This program simulates the play of a game of Go Fish between two player.
 * 
 * When the game starts, the deck is shuffled.  Then, each player is dealt 
 * five cards from the same deck.  They remove their pairs (cards of the 
 * same rank) and continue to draw cards until they have 5 unique cards 
 * in their hand.  
 * 
 * Player1 1 goes first
 *      * Player 1 selects a card at random from their hand and asks 
 *        Player2 if they have a card of the same rank
 *      * If player2 has a card of the same rank, player 2 gives the 
 *        card to player1, player1 removes the pair from their hand
 *        and picks up cards, discarding pairs, until there are 5 
 *        unique cards in their hand again.  Player 1 goes again.
 *      * If player2 does not have a card of the same rank, player2
 *        tells player1 to "go fish."  Player1 picks up a card from
 *        the deck (therefore, it is possible for player 1 to have
 *        more than 5 cards in their hand).  Player1 discards any
 *        pairs and, if they discard all cards in thier hand,
 *        draws another full hand (as long as there are still cards
 *        in the deck to draw.)  Player 1's turn ends. 
 * Player 2 takes their turn as described above.
 * Play continues until there are no more cards in the deck and
 * neither player has any cards in their hand.
 * The winner of the game is the player who discarded the most pairs.
 * 
 * In this implementation, the winner or "tie" is reported to the 
 * terminal window, as are each player's pairs.  The play of the game is 
 * recorded in a text file named with each player's name, 
 * input as command line arguments.  E.g., if the input players'
 * names are Jack and Jill, the output file is named Jack_Jill.txt.
 * Any existing file of the same name is overwritten.
 * 
 * COMPLETE THE METHODS INDICATED
 * 
 * @author 
 * @version 
 */
public class GoFish
{    
    //A constant indicating player one's turn.
    //In this game, there are only two players,
    //so a turn value of 1 would indicate
    //player two's turn.
    private static final int PLAYER_ONES_TURN = 0;

    //Used to print the required output to the text file.
    private static PrintWriter pWriter;

    /**
     * Controls the play of the game as described.  
     * 
     * FOR THIS METHOD, COMPLETE THE MISSING CODE
     * 
     * @param args [0] = player one's name; [1] = player two's name
     */
    public static void main(String[] args)
    {
        //Declares and initialized the players and deck.  Sets
        //the variable tracking the player's turn to player1.
        Deck deck = new Deck();
        GoFishPlayer player1 = new GoFishPlayer(deck, player1);
        GoFishPlayer player2 = new GoFishPlayer(deck, player2);
        int turn = PLAYER_ONES_TURN;

        //Since we are writing to a file, we have to catch the 
        //java.io.IOException in the event we do not have permission
        //to create and write to the file.
        try{   
            //Create the file of the required name.
            File outFile = new File (//ADD THE FILE NAME HERE );
            //Open the printWriter to print to that file.  Any existing file of the
            //same name will be overwritten.
            pWriter = new PrintWriter (new FileWriter (outFile));

            //Play, taking turns according to the rules, until 
            //the game is over --> neither player has cards
            //(and there are no cards in the deck).  
            while(!gameOver(player1, player2))
            {        
                //Determine whose turn it is.
                //Call the playTurn method for that 
                //player's turn.
                //Update the turn variable to indicate
                //the next player's turn.
                
                //YOUR CODE HERE
            }
            //Close the printWriter to flush the buffer.
            pWriter.close();
        } catch (java.io.IOException jioe) {
            System.out.println("Cannot write to output file.");
        }

        //Print the required output to the terminal window.
        printWinnerOutput(player1, player2);
    }

    /**
     * Returns true if the game is over and false otherwise.  The
     * game is over if both player's have no cards in their hand.
     * 
     * @param player1 The first player.
     * @param player2 The second player.
     * @return True if the game is over and false otherwise.
     */
    private static boolean gameOver(GoFishPlayer player1, GoFishPlayer player2)
    {
        //YOUR CODE HERE
        return false;
    }

    /**
     * Controls the play for one player's turn, designated as p1.
     * 
     * p1 should call the method that ensures they have a full hand (if there are cards
     * remaining in the deck).  
     * p1 selects a card from their hand at random, without removing the card from their hand.
     * p1 asks "Do you have..."
     * p2 responds with the card ("Here is...") or "Go fish!"
     * If p2 had the card, p1 takes another turn.  Otherwise, p1's turn is over and the
     * method ends.
     * 
     * All appropriate output must be written to the output file.
     * 
     * @param deck The deck used in the game.
     * @param p1 The player whose turn it is to ask "Do you have..."  
     * @param p2 The player who gives a card or says "Go fish!"
     */
    private static void playTurn(Deck deck, GoFishPlayer p1, GoFishPlayer p2) throws java.io.IOException
    {
        //YOUR CODE HERE
    }

    /**
     * Prints the required output to the terminal window:
     * which player won followed by each player's discarded pairs.
     * 
     * @param player1 The first player.
     * @param player2 The second player.
     */
    private static void printWinnerOutput(GoFishPlayer player1, GoFishPlayer player2) 
    {
        //YOUR CODE HERE
    }
}
