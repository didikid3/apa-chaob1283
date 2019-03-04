//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import java.util.ArrayList;
import java.util.List;

public class ListOddToEven
{
  public static int go( List<Integer> ray )
  {
    int firstOdd = 0;
    int even = 0;
    boolean find = false;
    while(!find&&firstOdd<ray.size()){
      if(ray.get(firstOdd)%2 !=0)
        find = true;
      else{
        firstOdd++;
      }
    }
    if(firstOdd == ray.size()-1){
      return -1;
    }
    find = false;
    even = firstOdd;
    while(!find&&even<ray.size()){
        if(ray.get(even)%2 == 0)
          find = true;
        else{
          even ++;
        }
    }
    return even-firstOdd;
  }
}
