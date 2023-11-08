Find the Smallest number (Not leading Zeros) which can be obtained by rearranging the digits of a given number. 

Examples: 

Input: n = 846903
Output: 304689

Input: n = 55010
Output: 10055

Input: n = -40505
Output: -55400



  import java.lang.Math;

// Java program for finding smallest number
// from digits of given number
public class GFG {

	// function to find the smallest number
	static int smallest(int num)
	{
		// initialize frequency of each digit to Zero
		int[] freq = new int[10];
	
		// Checking Number is positive or Negative
		boolean is_pos = (num>0);
	
		// Getting the absolute value of num
		num = Math.abs(num);
	
		// count frequency of each digit in the number
		while (num > 0)
		{
			int d = num % 10; // extract last digit
			freq[d]++; // increment counting
			num = num / 10; //remove last digit
		}
	
	int result = 0;

		// If it is positive Number then it should be smallest
		if(is_pos) 
		{
			// Set the LEFTMOST digit to minimum expect 0
			for (int i = 1 ; i <= 9 ; i++)
			{
					if (freq[i] != 0)
				{
						result = i;
						freq[i]--;
					break;
				}
			}
	
			// arrange all remaining digits
			// in ascending order
			for (int i = 0 ; i <= 9 ; i++)
				while (freq[i]-- != 0)
					result = result * 10 + i;
		}
		else // If negative then number should be Largest
		{
		// Set the Rightmost digit to maximum 
		for (int i = 9 ; i >= 1 ; i--)
		{
			if (freq[i] !=0)
			{
				result = i;
				freq[i]--;
				break;
			}
		}

		// arrange all remaining digits
		// in descending order
		for (int i = 9 ; i >=0 ; i--)
			while (freq[i]-- != 0)
				result = result * 10 + i;

		// Negative number should be returned here
		result = -result; 
		}
		return result;
	}
	
	// Driver Program
	public static void main(String args[])
	{
		int num = 570107;
		System.out.println(smallest(num));
		
		int num2 = -691005;
		System.out.println(smallest(num2));
	}
}
// This code is contributed by Sumit Ghosh
