package homeworks.homework1to3;

public class ArrayUtil {
    public static void main(String[] args) {
        int[] numbers = {1, 6, 3, 9, 15, 52, -3, 5, 8};

        // 1
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();

        // 2
        System.out.println("Array first element is " + numbers[0]);

        // 3
        System.out.println("Array last element is " + numbers[numbers.length - 1]);

        // 4
        System.out.println("Array length is " + numbers.length);

        // 5
        int min = numbers[0];
        for (int number : numbers) {
            if (number < min) {
                min = number;
            }
        }
        System.out.println("Array smallest number is " + min);

        // 6
        if (numbers.length > 2) {
            if (numbers.length % 2 == 0) {
                System.out.print("Array middle values is " + numbers[numbers.length / 2] + " " + numbers[numbers.length / 2 - 1]);
            } else {
                System.out.println("Array middle values is " + numbers[numbers.length / 2]);
            }
        } else {
            System.out.println("Can't print middle values!");
        }

        // 7 and 8
        int evenCount = 0;
        int oddCount = 0;

        for (int number : numbers) {
            if (number % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        System.out.println("Even numbers count is " + evenCount);
        System.out.println("Odd numbers count is " + oddCount);

        // 9
        int sum = 0;

        for (int number : numbers) {
            sum += number;
        }
        System.out.println("Sum of array elements is " + sum);

        // 10
        System.out.println("Average of array elements is " + (double) sum / numbers.length);
    }
}
