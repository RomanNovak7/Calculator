import java.io.IOException;
import java.util.Scanner;

public class Calculator {
    static boolean CheckArabic (String input) {
        if (input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4") || input.equals("5")
                || input.equals("6") || input.equals("7") || input.equals("8") || input.equals("9") || input.equals("10")) {
            return true;
        } else {
            return false;
        }
    }
    static boolean CheckRome (String input) {
        if (input.equals("I") || input.equals("II") || input.equals("III") || input.equals("IV") || input.equals("V")
                || input.equals("VI") || input.equals("VII") || input.equals("VIII") || input.equals("IX") || input.equals("X")) {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String[] array = s1.split(" ");
        if (array.length != 3) {
            try {
                throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("Не точное кол-во элементов");
                return;
            }
        }
        if (CheckArabic(array[0]) && CheckArabic(array[2])) {
            int a = Integer.parseInt(array[0]);
            int b = Integer.parseInt(array[2]);
            String operation = array[1];
            if (operation.equals("+")) {
                System.out.println(a + b);
            } else if (operation.equals("-")) {
                System.out.println(a - b);
            } else if (operation.equals("/")) {
                System.out.println(a / b);
            } else if (operation.equals("*")) {
                System.out.println(a * b);
            } else {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    System.out.println("Неверная операция");
                    return;
                }
            }
        }
        else if (CheckRome(array[0]) && CheckRome(array[2])) {
            String romeA = array[0];
            String romeB = array[2];
            int result = 0;
            RomeNumber romeOne = RomeNumber.valueOf(romeA);
            RomeNumber romeTwo = RomeNumber.valueOf(romeB);
            int a = romeOne.getArabic();
            int b = romeTwo.getArabic();
            String operation = array[1];

            if (operation.equals("+")) {
                result = a+b;
            } else if (operation.equals("-")) {
                result = a-b;
            } else if (operation.equals("/")) {
                result = a/b;
            } else if (operation.equals("*")) {
                result = a*b;
            } else {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    System.out.println("Неверная операция");
                    return;
                }
            }
            if (result >= 1) {
                RomeNumber romeResult = RomeNumber.arabicToRome(result);
                System.out.println(romeResult);
            } else {
                System.out.println("Результат работы с римскими цифрами не может быть отрицательным");
            }
        } else {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("Неверые цифры");
                return;
            }
        }
    }
}