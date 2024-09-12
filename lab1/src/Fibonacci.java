/**
 * Клас, що моделює числа Фібоначчі і надає методи для їх розрахунку.
 */
public class Fibonacci {
    private int numberOfFibonacci, valueOfFibonacci;

    /**
     * Конструктор для створення об'єкта Fibonacci.
     * Ініціалізує номер числа Фібоначчі та обчислює його значення.
     *
     * @param _numberOfFibonacci номер числа Фібоначчі для ініціалізації
     * @throws IllegalArgumentException якщо номер числа Фібоначчі є від'ємним
     */
    public Fibonacci(int _numberOfFibonacci) {

        setNumberOfFibonacci(_numberOfFibonacci);
    }

    /**
     * Приватний метод, що обчислює значення числа Фібоначчі для заданого порядкового номера.
     *
     * @param _numberInRange номер числа Фібоначчі, значення якого треба обчислити
     * @return значення числа Фібоначчі для даного номера
     */
    private int getValueOfNumberInFibonacciRange(int _numberInRange) {
        int first = 0;
        int second = 1;
        int counter = 0;
        while (counter < _numberInRange - 2) {
            int tempSum = first + second;
            first = second;
            second = tempSum;
            counter += 1;
        }
        return second;
    }

    /**
     * Метод, що повертає номер числа Фібоначчі.
     *
     * @return номер числа Фібоначчі
     */
    public int getNumberOfFibonacci() {
        return numberOfFibonacci;
    }

    /**
     * Метод для встановлення номера числа Фібоначчі.
     * Одночасно обчислюється значення числа Фібоначчі для встановленого номера.
     *
     * @param _numberOfFibonacci номер числа Фібоначчі
     * @throws IllegalArgumentException якщо номер числа Фібоначчі є від'ємним
     */
    public void setNumberOfFibonacci(int _numberOfFibonacci) {
        if (_numberOfFibonacci < 0) {
            throw new IllegalArgumentException("fibonacci number can not be negative");
        }
        this.numberOfFibonacci = _numberOfFibonacci;
        this.valueOfFibonacci = this.getValueOfNumberInFibonacciRange(_numberOfFibonacci);
    }

    /**
     * Метод, що повертає значення числа Фібоначчі для встановленого номера.
     *
     * @return значення числа Фібоначчі
     */
    public int getValueOfFibonacci() {
        return valueOfFibonacci;
    }

    /**
     * Метод, що обчислює суму перших N чисел Фібоначчі.
     * N визначається встановленим номером числа Фібоначчі.
     *
     * @return сума перших N чисел Фібоначчі
     */
    public int calculateSumOfFirstNFibonacciNumbers() {
        int resultSum = 0;
        int first = 0;
        int second = 1;
        int counter = 0;
        while (counter < this.numberOfFibonacci - 1) {
            resultSum += second;
            int temp = first + second;
            first = second;
            second = temp;
            counter += 1;
        }
        return resultSum;
    }

}
