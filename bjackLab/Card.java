public abstract class Card
{
  public static final String FACES[] = {"ZERO","ACE","TWO","THREE","FOUR","FIVE","SIX","SEVEN","EIGHT","NINE","TEN","JACK","QUEEN","KING"};

  private String suit;
  private int face;

  //constructors
  public Card(){
    suit = "";
    face = 0;
  }
  public Card(int f, String s)
  {
    suit = s;
    face = f;
  }

  public void setSuit(String s)
  {
    suit = s;
  }
  public void setFace(int f)
  {
    face = f;
  }

  public String getSuit()
  {
    return suit;
  }
  public int getFace()
  {
    return face;
  }

  public abstract int getValue();

  public boolean equals(Object obj)
  {
    Card x = (Card)obj;
    if(x.getFace() == face && suit.equals(x.getSuit()))
    {
      return true;
    }
    return false;
  }

  public String toString()
  {
    return FACES[face] + " of " + suit;
  }
        
}