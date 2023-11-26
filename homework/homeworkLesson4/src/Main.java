import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

// Запросить значение n у пользователя.
        // Вызвать метод и передать туда значение, полученное от пользователя.
        // Посмотреть, какие ошибки возможны в данном коде и для каждой
        // ошибки создать пользовательское исключение.
        // Выбросить эти исключения в нужное время и обработать их в main.

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please input any number");
        try {
            testingExceptions(Integer.parseInt(scanner.nextLine()));
        }catch (ArrayLengthCantBeBiggerThanActualException | CantBeZeroException | ArrayLengthCantBeNegative e){
            System.out.println(e.getMessage());
        }

    }

    public static void testingExceptions(int n) throws ArrayLengthCantBeBiggerThanActualException, CantBeZeroException, ArrayLengthCantBeNegative {

        if(n == 0){
            throw new CantBeZeroException("You cant input 0 ");
        }
        int x = 10 / n;
        System.out.println(x);
        if(n < 0){
            throw new ArrayLengthCantBeNegative("you cant input negative number because its out of function logic");
        }
        int[] array = new int[n];
        System.out.println(array.length);
        if(n == array.length) {
            throw new ArrayLengthCantBeBiggerThanActualException(n + " - is longer than length of array");
        }
        System.out.println(array[n]);
    }
}