//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class AlienHorde
{
  private List<Alien> aliens;
  private int gap = 60;
  private int sides = 50;
  private int speed = 1;

  
  public AlienHorde(int size)
  {
    aliens = new ArrayList<Alien>();
    for(int i = 0; i<= size; i++)
    {
      add(new Alien(((gap*i)),-60,sides,sides,speed));
    }
  }

  public void addMORE()
  {
    for(int i = 0; i<= 10; i++)
    {
      add(new Alien(((gap*i)),-60,sides,sides,speed));
    }
  }
  public void add(Alien al)
  {
    aliens.add(al);
  }

  public void drawEmAll( Graphics window )
  {
    for(Alien x: aliens)
    {
      x.draw(window);
    }
  }

  public void moveEmAll()
  {
    for(Alien x: aliens)
    {
      x.move();      
    }
  }
  public void removeDeadOnes(List<Ammo> shots)
  {
    int countAlien = 0;
    int countAmmo = 0;
    for(Alien x: aliens)
    {
      countAmmo = 0;
      for(Ammo y: shots)
      {
        if( y.getX()>=x.getX() &&
            y.getX()<=(x.getX()+sides) &&
            y.getY()>=x.getY() &&
            y.getY()<=(x.getY()+sides) )
            {
              aliens.get(countAlien).dead();
              shots.remove(countAmmo);
              countAlien--;
              countAmmo--;
            }
        countAmmo++;
      }
      countAlien++;
    }
  }
  public boolean loose()
  {
    if(aliens.get(aliens.size()-1).getY() >=600)
      return true;
    return false;
  }
  public boolean win()
  {
    for(Alien al:aliens)
    {
      if(al.alive())
        return false;
    }
    return true;
  }
  public int returnGap()
  {
    return gap;
  }
  public int returnSides()
  {
    return sides;
  }
  public List<Alien> returnList()
  {
    return aliens;
  }
  public int returnSpeed()
  {
    return speed;
  }
  public String toString()
  {
    return "";
  }
}
