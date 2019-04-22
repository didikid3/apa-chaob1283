//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class SpeedUpBall extends Ball
{

  //instance variables

  public SpeedUpBall()
  {
    super();
  }

  public SpeedUpBall(int x, int y)
  {
    super(x,y);
  }


  public SpeedUpBall(int x, int y, int xSpd, int ySpd)
  {
    super(x,y,10,10,Color.red,xSpd,ySpd);
  }

  public SpeedUpBall(int x, int y, int wid, int ht, int xSpd, int ySpd)
  {
    super(x,y,wid,ht,Color.red,xSpd,ySpd);
  }

  public SpeedUpBall(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
  {
    super(x,y,wid,ht,col,xSpd,ySpd);
  }

  public void setXSpeed( int xSpd )
  {
    setXSpeed(xSpd);
  }

  public void setYSpeed( int ySpd )
  {
    setYSpeed(ySpd);
  }
}

