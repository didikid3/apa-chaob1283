import java.awt.*;
public class Wall extends Block
{
  public Wall()
  {
    super(0,0,1,1,Color.black);
  }
  public Wall(int x,int y,int w,int h)
  {
    super(x,y,w,h,Color.black);
  }
}
