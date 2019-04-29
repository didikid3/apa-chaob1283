import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  public void grayscaleAverage()
  {
	  Pixel[][] pixels = this.getPixels2D();
	    for (Pixel[] rowArray : pixels)
	    {
	      for (Pixel pixelObj : rowArray)
	      {
	        pixelObj.setGrayAverage();
	      }
	    }
  }

  public void grayscaleLightness()
  {
	  Pixel[][] pixels = this.getPixels2D();
	    for (Pixel[] rowArray : pixels)
	    {
	      for (Pixel pixelObj : rowArray)
	      {
	        pixelObj.setGrayLightness();
	      }
	    }
  }
  public void grayscaleLuminosity()
  {
	  Pixel[][] pixels = this.getPixels2D();
	    for (Pixel[] rowArray : pixels)
	    {
	      for (Pixel pixelObj : rowArray)
	      {
	        pixelObj.setGrayLuminosity();
	      }
	    }
  }
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  public void onlyBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setRed(0);
        pixelObj.setGreen(0);
      }
    }
  }
  public void negate()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setRed(255-pixelObj.getRed());
        pixelObj.setBlue(255-pixelObj.getBlue());
        pixelObj.setGreen(255-pixelObj.getGreen());
      }
    }
  }

  public void grayscale()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setGrayLuminosity();
      }
    }
  }
  public void fixUnderwater()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setRed(30+pixelObj.getRed());
        pixelObj.setBlue(10+pixelObj.getBlue());
        pixelObj.setGreen((int)(.7*pixelObj.getGreen()));
      }
    }
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }

  public void mirrorVerticalRightToLeft()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        leftPixel.setColor(rightPixel.getColor());
      }
    } 
  }

 public void mirrorHorizontal()
 {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    int height = pixels.length;
    for (int row = 0; row < height/2; row++)
    {
      for (int col = 0; col < pixels[row].length; col++)
      {
        topPixel = pixels[row][col];
        bottomPixel = pixels[height-1-row][col];
        bottomPixel.setColor(topPixel.getColor());
      }
    }
 }
  public void mirrorHorizontalBotToTop()
 {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    int height = pixels.length;
    for (int row = 0; row < height/2; row++)
    {
      for (int col = 0; col < pixels[row].length; col++)
      {
        topPixel = pixels[row][col];
        bottomPixel = pixels[height-1-row][col];
        topPixel.setColor(bottomPixel.getColor());
      }
    }
 }
 public void mirrorDiagonal()
 {
   Pixel[][] pixels = this.getPixels2D();
   Pixel up = null;
   Pixel down = null;
   int ht = pixels.length;
   int wd = pixels[0].length;
   int side = Math.min(ht,wd);
   for(int row =side-1; row>=0;row--)
   {
     for(int col =side-1;col>=0;col--)
     {
       up = pixels[row][col];
       down = pixels[col][row];
       down.setColor(up.getColor());
     }
   }
 }
  public void mirrorArms()
  {
    int mirrorPoint = 196;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 160; row < mirrorPoint; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 104; col < 295; col++)
      {
        leftPixel = pixels[row][col];      
        rightPixel = pixels[mirrorPoint - row + mirrorPoint][col];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  public void mirrorGull()
  {
    int mirrorPoint = 344;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 232; row < 322; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 238; col < mirrorPoint; col++)
      {
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  public void mirrorRectangle(int x1, int y1, int x2, int y2, boolean vertical)
  {

		int mirrorPoint = 0;
		Pixel fromPixel = null;
		Pixel toPixel = null;
		Pixel[][] pixels = this.getPixels2D();

		if(vertical)
		{
			mirrorPoint = x2;
		    for (int row = y1; row < y2; row++)
		    {
		    	if(mirrorPoint > x1)
          {
            for (int col = x1; col < mirrorPoint; col++)
            {
              fromPixel = pixels[row][col];      
              toPixel = pixels[row][mirrorPoint - col + mirrorPoint];
              toPixel.setColor(fromPixel.getColor());
            }
          }
				  else
          {
            for (int col = x1; col > mirrorPoint; col--)
            {
              fromPixel = pixels[row][col];      
              toPixel = pixels[row][mirrorPoint - col + mirrorPoint];
              toPixel.setColor(fromPixel.getColor());
            }
          }
		    }
		}
    else
		{
			mirrorPoint = y2;
			if(mirrorPoint > y1)
      {
        for (int row = y1; row < mirrorPoint; row++)
        {
          for (int col = x1; col < x2; col++)
          {
            fromPixel = pixels[row][col];      
            toPixel = pixels[mirrorPoint - row + mirrorPoint][col];
            toPixel.setColor(fromPixel.getColor());
          }
        }
      }
			else
      {
        for (int row = y1; row > mirrorPoint; row--)
        {
          for (int col = x1; col < x2; col++)
          {
            fromPixel = pixels[row][col];      
            toPixel = pixels[mirrorPoint - row + mirrorPoint][col];
            toPixel.setColor(fromPixel.getColor());
          }
        }
      }
		}
	}
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
        count++;
      }
    }
    System.out.println(count);
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }
	public void copy(Picture fromPic, int x1, int y1,int x2, int y2, int startRow, int startCol)
	 {
      Pixel fromPixel = null;
			Pixel toPixel = null;
			Pixel[][] toPixels = this.getPixels2D();
			Pixel[][] fromPixels = fromPic.getPixels2D();

				for (int fromRow = x1, toRow = startRow;fromRow < x2 && toRow < toPixels.length;fromRow++, toRow++)
				{
          for (int fromCol = y1, toCol = startCol;     fromCol < y2 && toCol < toPixels[0].length;  fromCol++, toCol++)
          {
            fromPixel = fromPixels[fromRow][fromCol];
            toPixel = toPixels[toRow][toCol];
            toPixel.setColor(fromPixel.getColor());
			    }
			}   
	 }
  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  public void collageCreate()
  {
    Picture beach1 = new Picture("beach.jpg");
    Picture beach2 = new Picture("beach.jpg");
    Picture beach3 = new Picture("beach.jpg");
    Picture beachOrig = new Picture("beach.jpg");
    beach1.fixUnderwater();
    beach2.mirrorDiagonal();
    beach3.mirrorHorizontal();
    beach3.negate();
    beach2.mirrorVertical();
    beach1.mirrorHorizontalBotToTop();
    this.copy(beach1,20, 20, 110, 110, 0,0);
    this.copy(beach2,20, 20, 110, 110, 100,0);
    this.copy(beach3,20, 20, 110, 110, 200,0);
    this.copy(beachOrig,20,20,110,110,300,0); 
  }
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel topPixel = null;
    Pixel botPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    Color bottomColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
      for (int col =0;col < pixels[0].length - 1; col++)
      {  
    	  botPixel = pixels[row+1][col];
        topPixel = pixels[row][col];
        bottomColor = botPixel.getColor();
	        if (topPixel.colorDistance(bottomColor) > 
	            edgeDist)
	          topPixel.setColor(Color.BLACK);
	        else
	          topPixel.setColor(Color.WHITE);
      }
    }
  }
  public void edgeDetection2(int amount)
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel current = null;
    int height = pixels.length;
    for (int r = 0; r < height; r++)
    {
      for (int c = 0; c < pixels[r].length; c++)
      {
        current = pixels[r][c];
        int triggers = 0;

        if (c!=(pixels[0].length-1)&&(Math.abs(current.colorDistance((pixels[r][c+1]).getColor()) ) < amount))
          triggers++;
        if (r!=(0)&&(Math.abs(current.colorDistance((pixels[r-1][c]).getColor()) ) < amount))
          triggers++;
        if (c!=(0)&&(Math.abs(current.colorDistance((pixels[r][c-1]).getColor()) ) < amount))
          triggers++;
        if (r!=(pixels.length-1)&&(Math.abs(current.colorDistance((pixels[r+1][c]).getColor()) ) < amount))
          triggers++;
        if (r!=(pixels.length-1)&&c!=(pixels[0].length-1)&&(Math.abs(current.colorDistance((pixels[r+1][c+1]).getColor()) ) < amount))
          triggers++;
        if (r!=(0)&&c!=(pixels[0].length-1)&&(Math.abs(current.colorDistance((pixels[r-1][c+1]).getColor()) ) < amount))
          triggers++;
        if (r!=(0)&&c!=(0)&&(Math.abs(current.colorDistance((pixels[r-1][c-1]).getColor()) ) < amount))
          triggers++;
        if ((r!=(pixels.length-1))&&c!=(0)&&(Math.abs(current.colorDistance((pixels[r+1][c-1]).getColor()) ) < amount))
          triggers++;

        // else set the color to black
        if(triggers>3)
          current.setColor(Color.WHITE);
        else
          current.setColor(Color.BLACK);
      }
    }

  }
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture p = new Picture("lenslarge.jpg");
    Picture smallP = p.scale(0.2,0.2);
    smallP.write("smalllens.jpg");

  }
  
} // this } is the end of class Picture, put all new methods before this
