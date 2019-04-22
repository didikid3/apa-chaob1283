//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block implements Collidable
{
  private int xSpeed;
  private int ySpeed;

  public Ball()
  {
    super(200,200);
    xSpeed = 3;
    ySpeed = 1;
  }
  public Ball(int xPos,int yPos)
  {
    super(xPos,yPos);
    xSpeed = 2;
    ySpeed = 1;
  }
  public Ball(int xPos, int yPos, int xSp,int ySp)
  {
    super(xPos, yPos);
    xSpeed = xSp;
    ySpeed = ySp;
  }
  public Ball(int xPos, int yPos, int w, int h, Color c)
  {
    super(xPos, yPos,w,h,c);
    xSpeed = 2;
    ySpeed = 1;
  }
  public Ball(int xPos,int yPos,int w, int h,Color c, int xSp, int ySp)
  {
    super(xPos,yPos,w,h,c);
    xSpeed = xSp;
    ySpeed = ySp;
  }


  public void setXSpeed(int x)
  {
    xSpeed = x;
  }
  public void setYSpeed(int y)
  {
    ySpeed = y;
  }
	
  public boolean didCollideLeft()
  {

    if(getX() <=0)
      return true;
  }
  public boolean didCollideRight(int x)
  {
    if(getX() >= x -obj.getWidth())
      return true;
  }
  public boolean didCollideTop()
  {
    if(getY()<=0)
      return true;
  }
  public boolean didCollideBottom(int x)
  {
    if(getY() >= x - obj.getHeight())
      return true;
  }
   
  
  public void moveAndDraw(Graphics window)
  {
    //draw a white ball at old ball location
    draw(window, Color.white);

    setX(getX()+xSpeed);
    setY(getY()+ySpeed);
    //draw the ball at its new location
    draw(window);
  }
   
  public boolean equals(Object obj)
  {
    Ball compare = (Ball)obj;
    if(xSpeed== compare.getXSpeed())
    {
      if(ySpeed == compare.getYSpeed())
      {
        if(super.equals(obj))
          return true;
      }
    }
    return false;
  }   

  //add the get methods
  public int getXSpeed()
  {
    return xSpeed;
  }
  public int getYSpeed()
  {
    return ySpeed;
  }
  //add a toString() method
  public String toString()
  {
    return super.toString() + " "+ getXSpeed() + getYSpeed();
  }
}
