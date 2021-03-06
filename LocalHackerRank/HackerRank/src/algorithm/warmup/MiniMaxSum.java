package algorithm.warmup;

import java.util.Scanner;

/**
 * Given five positive longegers, find the minimum and maximum values that can
 * be
 * calculated by summing exactly four of the five longegers. Then prlong the
 * respective minimum and maximum values as a single line of two space-separated
 * long longegers.
 * 
 * =====Input Format=====
 * 
 * A single line of five space-separated longegers.
 * 
 * =====Constralongs=====
 * 
 * Each longeger is in the inclusive range [1, 10^9].
 * 
 * =====Output Format=====
 * 
 * Prlong two space-separated long longegers denoting the respective minimum and
 * maximum values that can be calculated by summing exactly four of the five
 * longegers. (The output can be greater than 32 bit longeger.)
 * 
 * =====Sample Input=====
 * 
 * 1 2 3 4 5
 * 
 * =====Sample Output=====
 * 
 * 10 14
 * 
 * =====Explanation=====
 * 
 * Our initial numbers are 1, 2, 3, 4, and 5. We can calculate the following
 * sums
 * using four of the five longegers:
 * 
 * If we sum everything except 1, our sum is 2+3+4+5=14.
 * If we sum everything except 2, our sum is 1+3+4+5=13.
 * If we sum everything except 3, our sum is 1+2+4+5=12.
 * If we sum everything except 4, our sum is 1+2+3+5=11.
 * If we sum everything except 5, our sum is 1+2+3+4=10.
 * As you can see, the minimal sum is 1+2+3+4=10 and the maximal sum is 2+3+4+5.
 * Thus, we prlong these minimal and maximal sums as two space-separated
 * longegers
 * on a new line.
 * 
 * =====Hlongs:=====
 * Beware of longeger overflow! Use 64-bit longeger.
 * 
 * @author RichBear
 *
 */
public class MiniMaxSum {
    /**
     * with the initial code, I solve the problem with this way
     * 
     * @param args
     */
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        long sum = 0;
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;

        for (int i = 0; i < 5; i++) {
            long input = in.nextLong();
            sum += input;
            if (max <= input)
                max = input;
            if (min >= input)
                min = input;
        }

        System.out.println((sum - max) + " " + (sum - min));

    }

}
