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

public class Pong extends Canvas implements KeyListener, Runnable
{
  private Ball ball;
  private Paddle leftPaddle;
  private Paddle rightPaddle;
  
  private boolean[] keys;
  private BufferedImage back;
  private Score score;

  private int width = 800;
  private int height = 600;
  private int obj_width = 10;
  private int paddle_height = 60;
  private int paddle_locationL;
  private int paddle_locationR;

  private Wall left;
  private Wall right;
  private Wall top;
  private Wall bottom;


  public Pong(int x, int y)
  {
    width = x;
    height = y;

    ball = new Ball(200,200,obj_width,obj_width,Color.red,2,1);

    leftPaddle = new Paddle(0,0,obj_width,paddle_height,Color.blue,2);
    rightPaddle = new Paddle(width-obj_width,0,obj_width,paddle_height,Color.red,2);

    left = new Wall(0,0,1,height);
    right = new Wall(width-1,0,1,height);
    top = new Wall(0,0,width,1);
    bottom = new Wall(0,height-1,width,1);

    keys = new boolean[4];
    score = new Score();
    setBackground(Color.WHITE);
    setVisible(true);
		
    new Thread(this).start();
    addKeyListener(this);		//starts the key thread to log key strokes
  }
	
  public void update(Graphics window){
    paint(window);
  }

  public void paint(Graphics window)
  {
    left.draw(window);
    right.draw(window);
    top.draw(window);
    bottom.draw(window);
    ball.moveAndDraw(window);
    leftPaddle.draw(window);
    rightPaddle.draw(window);
    score.displayScore(window);

    //see if ball hits left wall or right wall
    if(ball.didCollideLeft() || ball.didCollideRight(width))
    {
      ball.setXSpeed(-ball.getXSpeed());
      ball.setYSpeed(-ball.getYSpeed());
      if(ball.didCollideLeft())
        score.setR(score.getR()+1);
      else
        score.setL(score.getL()+1);
      score.displayScore(window);
    }
    
    //see if the ball hits the top or bottom wall 
    if((ball.didCollideTop() || ball.didCollideBottom(height)))
    {
      ball.setYSpeed(-ball.getYSpeed());
    }


    //see if the ball hits the left paddle
   paddle_locationL = (leftPaddle.getY() + leftPaddle.getHeight());
   if ((ball.getX() <= leftPaddle.getX()+10) &&
      (ball.getY()>leftPaddle.getY())&&
      (ball.getY() < paddle_locationL))
    {
    	ball.setXSpeed(-ball.getXSpeed());
    }
		
		
    //see if the ball hits the right paddle
    paddle_locationR = rightPaddle.getY() + rightPaddle.getHeight();
    if ((ball.getX()+10 >= rightPaddle.getX()) &&
        (rightPaddle.getY() <= ball.getY()) && (ball.getY()<=paddle_locationR))
    {
      ball.setXSpeed(-ball.getXSpeed());
    }		
		
    //see if the paddles need to be moved
    if (keys[0])
    {
      //move left paddle up and draw it on the window
      leftPaddle.moveUpAndDraw(window);
    }
    if (keys[1])
    {
      //move left paddle down and draw it on the window
      leftPaddle.moveDownAndDraw(window);

    }
    if (keys[2])
    {
      rightPaddle.moveUpAndDraw(window);
    }
    if (keys[3])
    {
      rightPaddle.moveDownAndDraw(window);
    }

		
    //twoDGraph.drawImage(back, null, 0, 0);
  }

  public void keyPressed(KeyEvent e)
  {
    switch(toUpperCase(e.getKeyChar()))
    {
    case 'W' : keys[0]=true; break;
    case 'Z' : keys[1]=true; break;
    case 'I' : keys[2]=true; break;
    case 'M' : keys[3]=true; break;
    }
  }

  public void keyReleased(KeyEvent e)
  {
    switch(toUpperCase(e.getKeyChar()))
    {
    case 'W' : keys[0]=false; break;
    case 'Z' : keys[1]=false; break;
    case 'I' : keys[2]=false; break;
    case 'M' : keys[3]=false; break;
    }
  }

  public void keyTyped(KeyEvent e){}
	
  public void run()
  {
    try
    {
      while(true)
      {
	Thread.currentThread().sleep(8);
	repaint();
      }
    }catch(Exception e)
    {
    }
  }	
}