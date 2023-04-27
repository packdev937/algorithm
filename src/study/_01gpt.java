package study;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _01gpt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        do {
            System.out.print("Input the number of numbers to process: ");
            n = scanner.nextInt();
        } while (n < 2 || n > 30);

        int[] numbers = new int[n];
        System.out.print("Input the numbers to be processed: ");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        scanner.close();

        Arrays.sort(numbers);

        List<Integer> distinctNumbers = new ArrayList<>();
        distinctNumbers.add(numbers[0]);
        for (int i = 1; i < n; i++) {
            if (numbers[i] != numbers[i - 1]) {
                distinctNumbers.add(numbers[i]);
            }
        }

        int distinctCount = distinctNumbers.size();
        for (int i = 0; i < distinctCount - 1; i++) {
            int primeCount = countPrimesBetween(distinctNumbers.get(i), distinctNumbers.get(i + 1));
            System.out.printf("Number of prime numbers between %d, %d: %d\n",
                    distinctNumbers.get(i), distinctNumbers.get(i + 1), primeCount);
        }

        long startTime = System.nanoTime();

        // code to be timed here

        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1_000_000_000.0;
        System.out.printf("Total execution time using Java is %.9f seconds!", duration);
    }

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static int countPrimesBetween(int a, int b) {
        int count = 0;
        for (int i = a; i <= b; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }
}
