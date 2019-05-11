import java.util.Scanner;
import java.util.regex.*;

public class Counting {

    private static int wordsNumber;
    private static String Mode = "";

    public static String mode() {
        return Mode;
    }

    public static void start() {
        Mode = "";
        Output.outputStart();
        Scanner scanMode = new Scanner(System.in);
        Mode = scanMode.nextLine();
        if(!(Mode.equals("1") || Mode.equals("2"))) {
            Output.outputAnswerAgain();
            start();
        }
        else if (Mode.equals("2")) {
            Counting.countingDetail();
        } else  {
            Output.outputFastStart();
            startFast();
        }
    }


    public static void startFast() {
        Output.outputPlayersFast();
        int n = Input.checkNumber();
        Output.outputCountingFast();
        int x = Input.checkNumber();
        Counting.countingFast(n, x);
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

    // подсчет слов считалочки
    public static int countWords(String counting) {
        int count = 0;
        Pattern pattern = Pattern.compile("[A-Za-z0-9А-Яа-я]+");
        Matcher matcher = pattern.matcher(counting);
        while (matcher.find())
            count++;
        return count;
    }

    // уменьшение массива
    public static void arrayCut(String ArrayName[]) {
        String ArrayCopy[] = new String[ArrayName.length - 1];
        System.arraycopy(ArrayName, 0, ArrayCopy, 0, ArrayCopy.length);
        ArrayName = ArrayCopy;
    }
}

