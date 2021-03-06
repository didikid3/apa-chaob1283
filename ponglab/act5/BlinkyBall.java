//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class BlinkyBall extends Ball
{

  //constructors
  public BlinkyBall()
  {
    super();
  }

  public BlinkyBall(int x, int y)
  {
    super(x,y);
  }

  public BlinkyBall(int x, int y, int wid, int ht)
  {
    super(x,y,wid,ht,Color.red);
  }

  public BlinkyBall(int x, int y, int wid, int ht, int xSpd, int ySpd)
  {
    super(x,y,wid,ht,Color.red,xSpd,ySpd);
  }

  public BlinkyBall(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
  {
    super(x,y,wid,ht,col,xSpd,ySpd);
  }

  public Color randomColor()
  {
    int r = (int)(Math.random()*255);
    int g = (int)(Math.random()*255);
    int b = (int)(Math.random()*255);
    return new Color(r,g,b);
  }

  public void moveAndDraw(Graphics window)
  {
    //draw a white ball at old ball location
    draw(window, Color.white);

    setX(getPosX()+getXSpeed());
    setY(getPosY()+getYSpeed());
    //draw the ball at its new location
    draw(window,randomColor());
  }
  public void moveAndDrawINVIS(Graphics window)
  {
    //draw a white ball at old ball location
    draw(window, Color.white);

    setX(getPosX()+getXSpeed());
    setY(getPosY()+getYSpeed());
    //draw the ball at its new location
    draw(window,Color.white);
  }
}