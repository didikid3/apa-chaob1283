//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import java.util.List;
import java.util.ArrayList;

public class ListSumFirst
{
  public static int go(List<Integer> ray)
  {
    int first = ray.get(0);
    int sum = 0;
    if(ray.size()<=1)
      return -1;
    for(int i = 1; i<ray.size();i++){
      if(ray.get(i)>first){
        sum+=ray.get(i);
      }
    }
    return sum;
  }
}
