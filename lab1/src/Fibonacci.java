public class Fibonacci {
    private int numberOfFibonacci, valueOfFibonacci;

    public Fibonacci(int _numberOfFibonacci)
    {
        setNumberOfFibonacci(_numberOfFibonacci);
    }

    private int getValueOfNumberInFibonacciRange(int _numberInRange)
    {
        int first = 0;
        int second = 1;
        int counter = 0;
        while(counter < _numberInRange - 2)
        {
            int tempSum = first + second;
            first = second;
            second = tempSum;
            counter += 1;
        }
        return second;
    }

    public int getNumberOfFibonacci()
    {
        return numberOfFibonacci;
    }

    public void setNumberOfFibonacci(int _numberOfFibonacci)
    {
        if(_numberOfFibonacci < 0)
        {
            throw new IllegalArgumentException("fibonacci number can not be negative");
        }
        this.numberOfFibonacci = _numberOfFibonacci;
        this.valueOfFibonacci = this.getValueOfNumberInFibonacciRange(_numberOfFibonacci);
    }

    public int getValueOfFibonacci()
    {
        return valueOfFibonacci;
    }

    public int calculateSumOfFirstNFibonacciNumbers()
    {
        int resultSum = 0;
        int first = 0;
        int second = 1;
        int counter = 0;
        while(counter < this.numberOfFibonacci - 1)
        {
            resultSum += second;
            int temp = first + second;
            first = second;
            second = temp;
            counter += 1;
        }
        return resultSum;
    }

}
