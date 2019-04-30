import java.util.Arrays;
import java.util.Scanner;

public class Counting {

    static int wordsNumber;

    public static void start() {
        String Mode = "";
        Output.outputStart();
        Scanner scanMode = new Scanner(System.in);
        Mode = scanMode.nextLine();
        if(!(Mode.equals("1") || Mode.equals("2"))) {
            System.out.println("Выберите, пожалуйста, одно из предложенных значений");
            start();
        }
        if(Mode.equals("2")) {
            Counting.countingDetail();
        } else  {
            startFast();
        }
    }

    public static void startFast() {
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
        Counting.countingFast(n, x);
    }

    public static void countingDetail() {
        // приветствие
        Output.outputGreetings();

        // регистрация участников
        Input.inputRegister();

        // ввод считалочки
        Output.outputCounting();
        wordsNumber = Input.inputCounting();

        // вывод всех параметров
        Input.inputConditions();

        // счет
        Input.inputGameMode();

        // результат
        Input.inputResult();

        // финал
        Output.outputAgain();
        Input.inputStartAgain();
        Output.outputFinal();
    }

    public static void countingFast(int n, int wordsNumber) {
        int company[] = new int[n];
        int y = wordsNumber;
        // инициализация участников
        for(int i = 0; i < n; i++) {
            company[i] = i + 1;
        }
        // счет
        while (n > 1) {
            if(y % n > 0) {
                for (int i = y % n; i < n; i++) {
                    company[i - 1] = company[i];
                }
                y = (y % n) + wordsNumber - 1;
            } else {
                y = wordsNumber;
            }
            int companyCopy2[] = new int[company.length - 1];
            System.arraycopy(company, 0, companyCopy2, 0, companyCopy2.length);
            company = companyCopy2;
            n--;
        }
        // финал
        Output.outputFastResult(company, n);
        Output.outputAgain();
        Input.inputStartAgain();
        Output.outputFinal();
    }

    public static int countWords(String counting) {
        wordsNumber = 1;
        char ch[] = counting.toCharArray();
        for(int i = 0; i < ch.length; i++) {
            if(ch[i] == (' ')) {
                wordsNumber++;
            }
        }
        return wordsNumber;
    }

    public static boolean positive(String tryPositive) {
        if (!(Arrays.asList(Input.positive).contains(tryPositive.toLowerCase()))) {
            String Yes = Input.inputTestAnswer();
            if (Yes.equals("1")) {
                String ArrayCopy[] = Arrays.copyOf(Input.positive, Input.positive.length + 1);
                Input.positive = ArrayCopy;
                Input.positive[Input.positive.length - 1] = tryPositive.toLowerCase();
            } else {
                return false;
            }

        }
        return true;
    }
}

