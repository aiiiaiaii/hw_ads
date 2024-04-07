import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1 = scanner.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = scanner.nextInt();
        }
        int minimum = findMinimum(arr1, n1);
        System.out.println("Problem 1: " + minimum);

        int n2 = scanner.nextInt();
        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            arr2[i] = scanner.nextInt();
        }
        double avg = findAvg(arr2, n2);
        System.out.println("Problem 2: " + avg);

        int n3 = scanner.nextInt();
        boolean prime = isPrime(n3, 2);
        System.out.println("Problem 3: " + prime);

        int n4 = scanner.nextInt();
        int fact = factorial(n4);
        System.out.println("Problem 4: " + fact);

        int n5 = scanner.nextInt();
        int fib = fibonacci(n5);
        System.out.println("Problem 5: " + fib);

        int a = scanner.nextInt();
        int n6 = scanner.nextInt();
        int pow = power(a, n6);
        System.out.println("Problem 6: " + pow);

        System.out.println("Problem 7: ");
        String str1 = scanner.nextLine();
        permutation(str1, "");

        String str2 = scanner.nextLine();
        System.out.println("Problem 8: " + isDigits(str2));

        int n9 = scanner.nextInt();
        int k9 = scanner.nextInt();
        System.out.println("Problem 9:" + binomialCoef(n9, k9));

        int a10 = scanner.nextInt();
        int b10 = scanner.nextInt();
        System.out.println("Problem 10: " + gcd(a10, b10));
    }

    //Problem 1:
    public static int findMinimum(int[] arr, int n) {
        if (n == 1) {
            return arr[0];
        }
        int minimum = findMinimum(arr, n - 1);
        if (arr[n - 1] < minimum) {
            return arr[n - 1];
        } else {
            return minimum;
        }
    }

    //Problem 2:
    public static double findAvg(int[] arr, int n) {
        if (n == 1) {
            return arr[0];
        }
        return (arr[n - 1] + (n - 1) * findAvg(arr, n - 1)) / n;
    }

    //Problem 3:
    public static boolean isPrime(int n, int i) {
        if (n <= 2) {
            return n == 2;
        }
        if (n % i == 0) {
            return false;
        }
        if (i * i > n) {
            return true;
        }
        return isPrime(n, i + 1);
    }

    //Problem 4:
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    //Problem 5:
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    //Problem 6:
    public static int power(int a, int n) {
        if (n == 0) {
            return 1;
        } else {
            return a * power(a, n - 1);
        }
    }

    //Problem 7:
    public static void permutation(String str, String prefix) {
        if (str.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1);
                permutation(rem, prefix + str.charAt(i));
            }
        }
    }

    //Problem 8:
    public static boolean isDigits(String str) {
        if (str.length() == 0) {
            return true;
        }
        char firstChar = str.charAt(0);
        if (!Character.isDigit(firstChar)) {
            return false;
        }
        return isDigits(str.substring(1));
    }

    //Problem 9:
    public static int binomialCoef(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        }
        return binomialCoef(n - 1, k - 1) + binomialCoef(n - 1, k);
    }

    //Problem 10:
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}