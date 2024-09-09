import java.util.Scanner;

public class Main {

    public static void dealWithFibonacci()
    {
        Scanner scanner = new Scanner(System.in);
        Fibonacci fibonacciObject = null;
        while (true)
        {
            System.out.println("0 - Initialize fibonacci object");
            System.out.println("1 - get fibonacci number");
            System.out.println("2 - get fibonacci value of the number");
            System.out.println("3 - set fibonacci number");
            System.out.println("4 - get sum of first N fibonacci number");
            System.out.print("5 - exit\n : ");

            int result = scanner.nextInt();

            if(result == 5) break;

            if (fibonacciObject == null && result != 0) {
                System.out.println("you firstly need to initialize fibonacci object!!!");
                continue;
            }

            switch (result)
            {
                case 0:
                    System.out.print("enter number to create fibonacci object : ");
                    int number = scanner.nextInt();
                    fibonacciObject = new Fibonacci(number);
                    break;
                case 1:
                    System.out.println("Fibonacci number: " + fibonacciObject.getNumberOfFibonacci());
                    break;
                case 2:
                    System.out.println("Fibonacci value: " + fibonacciObject.getValueOfFibonacci());
                    break;
                case 3:
                    System.out.print("enter number to set as fibonacci number : ");
                    int numberToSet = scanner.nextInt();
                    fibonacciObject.setNumberOfFibonacci(numberToSet);
                    break;
                case 4:
                    System.out.println("Sum of first N Fibonacci numbers: " + fibonacciObject.calculateSumOfFirstNFibonacciNumbers());
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        dealWithFibonacci();
    }
}