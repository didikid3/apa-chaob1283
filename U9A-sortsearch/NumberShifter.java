//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class NumberShifter
{
	public static void  makeLucky7Array( int[] array)
	{
		int[] nArray = new int[array.length];
		int count = 0;
		for(int x:array){
			if(x==7){
				count++;
			}
		}
		for(int i=0; i<count;i++){
			nArray[i]=7;
		}
		int index = count;
		for(int m=0;m<array.length;m++){
			if(array[m]!=7){
				nArray[index] = array[m];
				index++;
			}
		}
		for(int q:nArray){
			System.out.print(q+" ");
		}
	}

}
