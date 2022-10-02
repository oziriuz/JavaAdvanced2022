package StacksAndQueues.exercise;

import java.math.BigInteger;
import java.util.*;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        Map<Integer, BigInteger> memoFibonacci = new HashMap<>();

        System.out.println(Fibonacci(number, memoFibonacci));
    }

    private static BigInteger Fibonacci(int number, Map<Integer, BigInteger> memo) {
        if (number < 2) {
            return BigInteger.ONE;
        }

        if (memo.containsKey(number)) {
            return memo.get(number);
        } else {
            BigInteger result =Fibonacci(number - 1, memo).add(Fibonacci(number - 2, memo));
            memo.putIfAbsent(number, result);
            return result;
        }
    }
}
