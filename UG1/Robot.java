//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;

class Robot extends Canvas
{
  public Robot()    //constructor method - sets up the class
  {
    setSize(800,600);
    setBackground(Color.WHITE);   	
    setVisible(true);
  }
  
  public void paint( Graphics window )
  {
    window.setColor(Color.BLUE);
    
    window.drawString("Robot LAB ", 35, 35 );
    
    //call head method
    head(window);
    //call other methods
    Body(window);
  }
  
  public void head( Graphics window )
  {
    window.setColor(Color.YELLOW);
    
    window.fillOval(300, 100, 200, 100);
    window.setColor(Color.RED);
    window.fillRect(350,125,20,25);
    window.fillRect(425,125,20,25);
    window.drawArc(350,325,100,25,180,180);

    //add more code here
    
  }

  public void Body( Graphics window )
  {
    window.setColor(Color.GREEN);
    window.fillRect(300,200,200,200);
    window.drawLine(350,400,10,20);
    window.drawLine(440,400,10,20);
    
  }

}
