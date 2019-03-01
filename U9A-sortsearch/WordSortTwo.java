//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;

public class WordSortTwo
{
	public static void WordSortTwo(String sentence)
	{
    		int count = 0;
    		char word;
    		for(int i=0;i<sentence.length();i++){
      			word = sentence.charAt(i);
      			if(word == ' ')
        			count++;
    		}
    		String[] lets = new String[count+1];
    		String add="";
    		int index = 0;
    		for(int m=0;m<sentence.length();m++){
      			word = sentence.charAt(m);
        		if(word == ' '){
          			lets[index] = add;
          			add = "";
          			index ++;
        		}
        		else{
			  	add = add + sentence.charAt(m);
          			if(m == sentence.length()-1){
            				lets[index] = add;
          			}
        		}
    		}
    		Arrays.sort(lets);
    		for(String item:lets){
      			System.out.println(item);
    		}
  	}
}
