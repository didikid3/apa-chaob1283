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

	public static void  getSortedDigitArray(int number)
	{
		int[] sorted = null;
		int count = 0;
		while(number >= 10){
			number = number/10;
			count++;
		}			
		return sorted;
	}
}
