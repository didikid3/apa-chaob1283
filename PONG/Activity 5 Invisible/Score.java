import java.awt.*;

public class Score
{
  private int left;
  private int right;

  public Score()
  {
    left = 0;
    right = 0;
  }

  public int getL()
  {
    return left;
  }
  public int getR()
  {
    return right;
  }

  public void setL(int x)
  {
     left = x;
  }
  public void setR(int x)
  {
    right = x;
  }

  public void displayScore(Graphics window)
  {
    Graphics2D w = (Graphics2D)window;
    w.setColor(Color.WHITE);
    w.fillRect(390,440,70,100);
    w.setColor(Color.BLACK);
    w.drawString(left+" : "+right,400 , 540);
  }

  public String toString()
  {
    return left+" "+right;
  }
}