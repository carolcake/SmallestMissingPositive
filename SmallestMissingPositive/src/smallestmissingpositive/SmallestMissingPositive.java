/*
Caroline Hsu - 2/9/2023
This program receives the user input and will be placed in an unsorted array. 
The array will be sorted and the smallest missing positive will be found and
outputed. 
 */
package smallestmissingpositive;

// import scanner from API
import java.util.Scanner;

public class SmallestMissingPositive
{

  public static void main(String[] args)
  {
    // declare scanner for input
    Scanner input = new Scanner(System.in);
    int numbersInArray;
    // ask user for how many numbers the array will hold
    System.out.print("Please enter how many numbers your array will hold: ");
    numbersInArray = input.nextInt();
    // make a new array of values for the unsorted array
    int[] values = new int[numbersInArray];
    for (int i = 0; i < numbersInArray; i++)
    {
      System.out.println("Please enter your number: ");
      values[i] = input.nextInt();
    }
    // sort the array using selection sort
    selectionSort(values);
    // print the sorted input
    for (int i = 0; i < values.length; i++)
    {
      if (i == values.length - 1)
      {
        System.out.print(values[i] + " ");
      }
      else
      {
        System.out.print(values[i] + ", ");
      }
    }
    System.out.println();
    // use smallest integer method to output the smallest integer to the user
    int smallestInteger = smallestInteger(values);
    System.out.println("Your smallest missing positive integer is: " + smallestInteger);
  }

  // selection sort 
  public static void selectionSort(int[] values)
  {
    // best for marker of smallest number
    int best;
    // loop for k
    for (int k = 0; k < values.length - 1; k++)
    {
      // set best at k
      best = k;
      // loop through q at one ahead of q
      for (int q = k + 1; q < values.length; q++)
      {
        // if statement for if the array at q is less than the array at best
        if (values[q] < values[best])
        {
          best = q;
        }
      }
      // swap the values
      swap(values, k, best);
    }
  }

  // swap method to switch
  public static void swap(int[] values, int k, int best)
  {
    // declare temp for placeholder
    int temp;
    // set array at k equal to temp
    temp = values[k];
    // make array at best = array at k
    values[k] = values[best];
    // make temp value the array value at best
    values[best] = temp;
  }

  // smallest integer method
  public static int smallestInteger(int[] values)
  {
    int i = 0;
    // while i is less than the length of the array and the array at i is NOT 
    // less than or equal to 0
    while (i < values.length && values[i] <= 0)
    {
      // add more to i
      i++;
    }
    // while i is less than the length of the array and the array at i is i + 1
    while (i < values.length && values[i] == i + 1)
    {
      // add more to i
      i++;
    }
    // return the smallest integer
    return i + 1;
  }

}
