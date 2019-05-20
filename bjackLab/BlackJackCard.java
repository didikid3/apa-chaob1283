//Name -
//Date -
//Class -
//Lab  - 

public class BlackJackCard extends Card
{
  //constructors
  public BlackJackCard()
  {
    super();
  }
  public BlackJackCard(int f, String s)
  {
    super(f,s);
  }
  public int getValue()
  {
    if(getFace() == 1)
      return 11;
    else if(getFace() >= 10)
      return 10;
    else
      return getFace();
  }
  public String toString()
  {
    return super.toString() + " | Value = " + getValue();
  }
        
}