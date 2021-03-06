package algorithm.dynamic_programing;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * How many different ways can you make change for an amount, given a list of
 * coins? In this problem, your code will need to efficiently compute the
 * answer.
 * 
 * =====Task=====
 * 
 * Write a program that, given
 * 
 * 1. The amount N to make change for and the number of types M of infinitely
 * available coins
 * 2. A list M of coins - C = {C1, C2, C3,...,CM}
 * Prints out how many different ways you can make change from the coins to
 * STDOUT.
 * 
 * =====The problem can be formally stated:=====
 * 
 * Given a value N, if we want to make change for N cents, and we have infinite
 * supply of each of C = {C1, C2, C3,...,CM} valued coins, how many ways can we
 * make the change? The order of coins doesn’t matter.
 * 
 * =====Solving the overlapping subproblems using dynamic programming=====
 * 
 * You can solve this problem recursively, but not all the tests will pass
 * unless you optimise your solution to eliminate the overlapping subproblems
 * using a dynamic programming solution
 * 
 * Or more specifically;
 * 
 * If you can think of a way to store the checked solutions, then this store can
 * be used to avoid checking the same solution again and again.
 * 
 * =====Input Format=====
 * 
 * First line will contain 2 integer N and M respectively.
 * Second line contain M integer that represent list of distinct coins that are
 * available in infinite amount.
 * 
 * =====Constraints=====
 * 1 <= Ci <= 50
 * 1 <= N <= 250
 * 1 <= M <= 50
 * 
 * The list of coins will contain distinct integers.
 * Output Format
 * 
 * One integer which is the number of ways in which we can get a sum of N from
 * the given infinite supply of M types of coins.
 * 
 * =====Sample Input=====
 * 
 * 4 3
 * 1 2 3
 * 
 * =====Sample Output=====
 * 
 * 4
 * 
 * =====Sample Input #02=====
 * 
 * 10 4
 * 2 5 3 6
 * 
 * =====Sample Output #02=====
 * 
 * 5
 * 
 * =====Explanation=====
 * 
 * Example 1: For N=4 and C={1,2,3} there are four
 * solutions:{1,1,1,1},{1,1,2},{2,2},{1,3}
 * 
 * Example 2: For N=10 and C={2,5,3,6} there are five solutions: {2,2,2,2,2},
 * {2,2,3,3}, {2,2,6},{2,3,5},{5,5}.
 * 
 * Hints
 * 
 * Think about the degenerate cases:
 * 
 * How many ways can you give change for 0 cents?
 * How many ways can you give change for >0 cents, if you have no coins?
 * If you are having trouble defining your solutions store, then think about it
 * in terms of the base case (n=0)
 * 
 * For help on reading from STDIN, see the HackerRank environment help page
 * under the "Sample Problem Statement" section.
 * 
 * 
 * @author RichBear
 *
 */
public class TheCoinChangeProblem {

    private static int amount = 0;
    private static int combo = 0;

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        amount = in.nextInt();
        int size = in.nextInt();

        Integer[] arr = new Integer[size];
        for (int i = 0; i < size; i++)
            arr[i] = in.nextInt();

        // Comparator<Integer> comp = Collections.reverseOrder();
        Arrays.sort(arr);

        findCombo2(arr[0], 0, arr);
        System.out.println(combo);
    }

    public static void findCombo2(int v, int current, Integer[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int temp = current;
            if (arr[i] < v)
                continue;
//            System.out.print(temp + "+" + arr[i] + "=");
            temp += arr[i];
//            System.out.print(temp + "\n");
            if (temp < amount)
                findCombo2(arr[i], temp, arr);
            else {
                if (temp == amount) {
//                    System.out.println("count");
                    combo++;
                }
                return;
            }

        }

    }

}
