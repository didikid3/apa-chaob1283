//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable
{
  private int xPos;
  private int yPos;
  private int width;
  private int height;

  private Color color;

  public Block()
  {
      setX(10);
      setY(10);
      setWidth(10);
      setHeight(10);
      setColor(Color.blue);
  }
  public Block(int x, int y)
  {
    setX(x);
    setY(y);
    setWidth(10);
    setHeight(10);
    setColor(Color.red);
  }
  public Block(int x, int y, int w, int h, Color col)
  {
      setX(x);
      setY(y);
      setWidth(w);
      setHeight(h);
      setColor(col);
  }
  public Block(int x, int y, int w, int h)
  {
      setX(x);
      setY(y);
      setWidth(w);
      setHeight(h);
      setColor(Color.blue);
  }
  public void setPos(int x, int y)
  {
    setX(x);
    setY(y);
  }
  public void setX(int x)
  {
    xPos = x;
  } 
  public void setY(int y)
  {
    yPos = y;
  }
  public void setWidth(int x)
  {
    width = x;
  }
  public void setHeight(int x)
  {
    height = x;
  }
  public void setColor(Color col)
  {
    color = col;
  }

  public void draw(Graphics window)
  {
    window.setColor(color);
    window.fillRect(getX(), getY(), getWidth(), getHeight());
  }

  public void draw(Graphics window, Color col)
  {
    window.setColor(col);
    window.fillRect(getX(), getY(), getWidth(), getHeight());
  }
   
  public boolean equals(Object obj)
  {
    Block test = (Block)obj;
    if(xPos == test.xPos)
    {
      if(yPos == test.yPos)
      {
        if(width == test.width)
        {
          if(height == test.height)
          {
            if(color == test.color)
              return true;
          }
        }
      }
    }
    return false;
  }   

  public int getX()
  {
    return xPos;
  }
  public int getY()
  {
    return yPos;
  }
  public int getWidth()
  {
    return width;
  }
  public int getHeight()
  {
    return height;
  }
  public String toString()
  {
    return xPos + " "+ yPos + " "+ width + " "+height + " "+ color;
  }
}