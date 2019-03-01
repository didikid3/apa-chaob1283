//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays; 
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class NumberSorter
{
	public static void  getSortedDigitArray(int orig)
	{
		int number = orig;
    		int[] sorted = null;
		int count = 0;
		while(number > 0){
			number = number/10;
			count++;
		}			
		sorted = new int[count];
    		number = orig;
    		for(int i=0;i<sorted.length;i++){
        		sorted[i]=(number%10);
        		number = number/10;
   		}

    		Arrays.sort(sorted);
    		for(int item:sorted){
      			System.out.print(item + " ");
    		}
	}
}
