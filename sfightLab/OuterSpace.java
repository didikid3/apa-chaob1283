import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OuterSpace extends Canvas implements KeyListener, Runnable
{
  private Ship ship;
  private Bullets shots = new Bullets();
  private AlienHorde horde;

  private boolean control = true;

  private boolean[] keys;
  private BufferedImage back;

  public OuterSpace()
  {
    setBackground(Color.black);
    keys = new boolean[5];

    ship = new Ship(400,400,50,50,5);
    shots = new Bullets();
    horde = new AlienHorde(10);

    this.addKeyListener(this);
    new Thread(this).start();
    setVisible(true);
  }

  public void update(Graphics window)
  {
    paint(window);
  }

  public void paint( Graphics window )
  {
    
    Graphics2D twoDGraph = (Graphics2D)window;

    if(back==null)
      back = (BufferedImage)(createImage(getWidth(),getHeight()));

    Graphics graphToBack = back.createGraphics();

    graphToBack.setColor(Color.BLUE);
    graphToBack.drawString("StarFighter ", 25, 50 );
    graphToBack.setColor(Color.BLACK);
    graphToBack.fillRect(0,0,800,600);
    ship.draw(graphToBack);

    if(control){
    if(keys[0] == true)
    {
      ship.move("LEFT");
    }
    if(keys[1] == true)
    {
      ship.move("RIGHT");
    }
    if(keys[2] == true)
    {
      ship.move("UP");
    }
    if(keys[3] == true)
    {
      ship.move("DOWN");
    }
    if(keys[4] == true)
    {
      shots.add(new Ammo((ship.getXPos()+((ship.getWidth()-5)/2)),(ship.getYPos()-10),5));
    }
    }
    shots.moveEmAll();
    shots.drawEmAll(graphToBack);
    horde.moveEmAll();
    horde.drawEmAll(graphToBack);

    horde.removeDeadOnes(shots.getList());

    if(horde.win())
    {
      graphToBack.setColor(Color.BLACK);
      graphToBack.fillRect(0,0,800,600);
      graphToBack.setColor(Color.GREEN);
      graphToBack.drawString("GAME WON! ", 400, 300);
      control = false;
    }

    if(horde.loose())
    {
      graphToBack.setColor(Color.BLACK);
      graphToBack.fillRect(0,0,800,600);
      graphToBack.setColor(Color.RED);
      graphToBack.drawString("YOU LOOSE ", 400, 300);
      control = false;
    }

    twoDGraph.drawImage(back, null, 0, 0);
  }


  public void keyPressed(KeyEvent e)
  {
    if (e.getKeyCode() == KeyEvent.VK_LEFT)
    {
      keys[0] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_RIGHT)
    {
      keys[1] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_UP)
    {
      keys[2] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_DOWN)
    {
      keys[3] = true;
    }
    if (e.getKeyCode() == KeyEvent.VK_SPACE)
    {
      keys[4] = true;
    }
    repaint();
  }

  public void keyReleased(KeyEvent e)
  {
    if (e.getKeyCode() == KeyEvent.VK_LEFT)
    {
      keys[0] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_RIGHT)
    {
      keys[1] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_UP)
    {
      keys[2] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_DOWN)
    {
      keys[3] = false;
    }
    if (e.getKeyCode() == KeyEvent.VK_SPACE)
    {
      keys[4] = false;
    }
    repaint();
  }

  public void keyTyped(KeyEvent e)
  {
    //no code needed here
  }

  public void run()
  {
    try
    {
      while(true)
      {
        Thread.currentThread().sleep(5);
        repaint();
      }
    }catch(Exception e)
    {
    }
  }
}

