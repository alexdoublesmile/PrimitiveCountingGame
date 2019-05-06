import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.*;

public class Counting {

    static int wordsNumber;
    static String Mode = "";

    public static String mode() {
        return Mode;
    }

    public static void start() {
        Mode = "";
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
            Output.outputFastStart();
            startFast();
        }
    }


    public static void startFast() {
        System.out.println("Введите количество участников: ");
        int n = checkNumber();
        System.out.println("Введите количество слов в считалочке: ");
        int x = checkNumber();
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
        Output.outputGameMode();
        Input.inputGameMode();

        // результат
        Input.inputResult();

        // финал
        Output.outputAgain();
        Input.inputStartAgain();
    }

    public static void countingDetailSecond() {
        // ввод считалочки
        Output.outputCounting();
        wordsNumber = Input.inputCounting();

        // вывод всех параметров
        Input.inputConditions();

        // счет
        Output.outputGameMode();
        Input.inputGameMode();

        // результат
        Input.inputResult();

        // финал
        Output.outputAgain();
        Input.inputStartAgain();
    }

    public static void countingDetailThird() {
        // вывод всех параметров
        Input.inputConditions();

        // счет
        Output.outputGameMode();
        Input.inputGameMode();

        // результат
        Input.inputResult();

        // финал
        Output.outputAgain();
        Input.inputStartAgain();
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
    }

    public static int countWords(String counting) {
        int count = 0;
        Pattern pattern = Pattern.compile("[A-Za-z0-9А-Яа-я]+");
        Matcher matcher = pattern.matcher(counting);
        while (matcher.find())
            count++;
        return count;
    }

    public static int checkNumber() {
        Scanner scanNumber = new Scanner(System.in);
        String number = scanNumber.nextLine();
        while (!(number.matches("[0-9]+"))) {
            System.out.println("Введите, пожлуйста, значение в виде числа");
            scanNumber = new Scanner(System.in);
            number = scanNumber.nextLine();
        }
        int n = Integer.parseInt(number);
        return n;
    }

    public static boolean positive(String tryPositive) {
        String MaybeYes = "";
        if (!(Arrays.asList(Input.negative).contains(tryPositive.toLowerCase())) && !(Arrays.asList(Input.positive).contains(tryPositive.toLowerCase()))) {
            while (!(MaybeYes.equals("1") || (MaybeYes.equals("2")))) {
                Output.outputAnswer();
                Scanner scanYes = new Scanner(System.in);
                MaybeYes = scanYes.nextLine();
                if (!(MaybeYes.equals("1") || (MaybeYes.equals("2")))) {
                    System.out.println("Выберите, пожалуйста, один из предложенных вариантов");
                }
            }
            if (MaybeYes.equals("1")) {
                String ArrayCopy[] = Arrays.copyOf(Input.positive, Input.positive.length + 1);
                Input.positive = ArrayCopy;
                Input.positive[Input.positive.length - 1] = tryPositive.toLowerCase();
                return true;
            } else {
                String ArrayCopy[] = Arrays.copyOf(Input.negative, Input.negative.length + 1);
                Input.negative = ArrayCopy;
                Input.negative[Input.negative.length - 1] = tryPositive.toLowerCase();
                return false;
            }

        } else if (Arrays.asList(Input.negative).contains(tryPositive.toLowerCase())) {
            return false;
        }
        return true;
    }
}

