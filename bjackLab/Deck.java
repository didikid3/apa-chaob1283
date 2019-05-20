//Name -
//Date -
//Class -
//Lab  - 

import java.util.ArrayList;
import java.util.Collections;

public class Deck
{
  public static final int NUMFACES = 13;
  public static final int NUMSUITS = 4;
  public static final int NUMCARDS = 52;

  public static final String SUITS[] = {"CLUBS","SPADES","DIAMONDS","HEARTS"};

  private int topCardIndex;
  private ArrayList<Card> stackOfCards;

  public Deck ()
  {
    stackOfCards = new ArrayList<Card>();
    topCardIndex = NUMCARDS - 1;

    for(int s = 0; s<NUMSUITS; s++)
    {
      for(int f = 1; f<=NUMFACES; f++)
      {
        stackOfCards.add(new BlackJackCard(f,SUITS[s]));
      }
    }
  }

  public void shuffle ()
  {
    topCardIndex = NUMCARDS - 1;
    for (int i = topCardIndex; i >= 1; i--)
    {
      int num = (int)(Math.random()*(i+1));
      Card temp = stackOfCards.get(i);
      stackOfCards.set(i,stackOfCards.get(num));
      stackOfCards.set(num, temp);
    }
  }

  //accessors
  public int size ()
  {
    return stackOfCards.size();
  }

  public int numCardsLeft()
  {
    return topCardIndex + 1;
  }

  public Card nextCard()
  {
    return stackOfCards.get(topCardIndex--);
  }

  public String toString()
  {
    return stackOfCards + "   topCardIndex = " + topCardIndex;
  } 
}