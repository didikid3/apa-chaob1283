public class Dealer extends AbstractPlayer
{

  private Deck deck;
  
  public Dealer()
  {
    deck = new Deck();
  }

  public void shuffle()
  {
    deck.shuffle();
  }

  public Card deal()
  {
    return deck.nextCard();
  }

  public boolean hit()
  {
    addCardToHand(deal());
    return (getHandValue()<21); 
  }

}