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
    if(xSpd <0)
    {
      setXSpeed(xSpd-1);
    }
    else
    {
      setXSpeed(xSpd+1);
    }

  }

  public void setYSpeed( int ySpd )
  {
    if(ySpd <0)
    {
      setYSpeed(ySpd-1);
    }
    else
    {
      setYSpeed(ySpd+1);
    }
  }
}

