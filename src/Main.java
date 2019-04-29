import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String Mode = "";
        Scanner scanMode = new Scanner(System.in);
        System.out.println("В какую считалочку предпочитаете сыграть?");
        while(!(Mode.equals("1") || Mode.equals("2"))) {
            System.out.println("1 - Быстрый вариант");
            System.out.println("2 - Детальный вариант");
            Mode = scanMode.nextLine();
            if(!(Mode.equals("1") || Mode.equals("2"))) {
                System.out.println("Выберите, пожалуйста, одно из предложенных значений");
            }
        }
        if(Mode.equals("2")) {
            Counting.DetailCounting();
        } else  {
            Scanner scanNumber = new Scanner(System.in);
            System.out.println("Введите количество участников: ");
            String number = scanNumber.nextLine();
            try {
                Integer.parseInt(number);
            } catch (Exception e) {
                System.out.println("Количество участников стоит вводить числом");
            }
            int n = Integer.parseInt(number);
            Scanner scanWords = new Scanner(System.in);
            System.out.println("Введите количество слов в считалочке: ");
            String words = scanWords.nextLine();
            try {
                Integer.parseInt(words);
            } catch (Exception e) {
                System.out.println("Количество слов стоит вводить числом");
            }
            int x = Integer.parseInt(words);
            Counting.SimpleCounting(n, x);
        }
    }
}