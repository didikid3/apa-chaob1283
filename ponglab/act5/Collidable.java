public interface Collidable
{
  public boolean didCollideLeft();
  public boolean didCollideRight(int x);
  public boolean didCollideTop();
  public boolean didCollideBottom(int x);
}