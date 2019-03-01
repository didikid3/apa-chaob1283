//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;
import static java.lang.System.*; 

public class NumberSorterRunner
{
	public static void main(String args[])
	{
		int[] cases = {567891, 901912468, 864213507, 898777, 234422};
		for( int test : cases )
		{
			NumberSorter.getSortedDigitArray( test );
			System.out.println();
		}
	}
}
