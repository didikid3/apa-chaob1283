//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Alien extends MovingThing
{
  private int speed;
  private Image image;

  public Alien()
  {
    this(0,0,50,50,0);
  }

  public Alien(int x, int y)
  {
    this(x,y,50,50,0);
  }

  public Alien(int x, int y, int s)
  {
    this(x,y,50,50,s);
  }

  public Alien(int x, int y, int w, int h, int s)
  {
    super(x, y, w, h);
    speed=s;
    try
    {
      URL url = getClass().getResource("alien.jpg");
      image = ImageIO.read(url);
    }
    catch(Exception e)
    {
      System.out.println("REEEEEE");
    }
  }

  public void setSpeed(int s)
  {
    speed = s;
  }

  public int getSpeed()
  {
    return speed;
  }

  public void move(String x)
  {
    if(x.equals("UP"))
      setY(getY()-speed);
    if(x.equals("LEFT"))
      setX(getX()-speed);
    if(x.equals("RIGHT"))
      setX(getX()+speed);
    if(x.equals("DOWN"))
      setY(getY()+speed);
  }
  public void move()
  {
    setX(getX()+speed);
    if(getX() < -30 || getX() > 810)
    {
      setY(getY()+(getWidth()*2));
      setSpeed(-getSpeed());
    }
  }

  public void draw( Graphics window )
  {
    window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
  }

  public String toString()
  {
    return super.toString() + speed;
  }
}
