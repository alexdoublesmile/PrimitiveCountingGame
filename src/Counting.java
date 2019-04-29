import java.util.Arrays;
import java.util.Scanner;

public class Counting {
    public static void FastCounting(int n, int x) {
        int company[] = new int[n];
        for(int i = 0; i < n; i++) {
            company[i] = i + 1;
        }
        int y = x;
        while (n > 1) {
            if (y <= n) {
                for (int i = y; i < n; i++) {
                    company[i - 1] = company[i];
                }
                y += x - 1;

            } else
                if (y % n > 0) {
                    for (int i = y % n; i < n; i++) {
                        company[i - 1] = company[i];
                    }
                    y = (y % n) + x - 1;
                } else {
                    y = x;
                }
            int companyCopy2[] = new int[company.length - 1];
            System.arraycopy(company, 0, companyCopy2, 0, companyCopy2.length);
            company = companyCopy2;
            n--;
        }
        for (int i = 0; i < n; i++) {
            System.out.print("Остается: " + company[i]);
        }
    }


    public static void DetailCounting() {
        // приветствие
        Output.outputGreetings();
        // начало игры, регистрация игроков
            String answer = "да";
            int n = 1;
            int p = 1;
            String company[] = new String[n];
            while(answer.equals("да") || answer.equals("Да") || answer.equals("ага") || answer.equals("Ага") || answer.equals("будут") || answer.equals("Будут") || answer.equals("конечно") || answer.equals("Конечно") || answer.equals("возможно") || answer.equals("") || answer.equals("1") || answer.equals("y") || answer.equals("Y") || answer.equals("yes") || answer.equals("Yes") || answer.equals("lf")) {
                if(p <= n) {
                    Scanner scanName = new Scanner(System.in);
                    System.out.println("Введите имя " + p + " игрока: ");

//                    System.out.println("размер n: " + n);
//                    System.out.println("");
//                    System.out.println("размер массива: " + company.length);

                    company[(n-1)] = scanName.nextLine();
                    while(company[(n-1)].equals("") || company[(n-1)].equals(" ")) {
                        System.out.println("Стоит ввести хоть какое-то имя или псевдоним :)");
                        System.out.println("Введите имя " + p + " игрока: ");
                        company[(n-1)] = scanName.nextLine();
                    }
                    Scanner scanAnswer = new Scanner(System.in);
                    System.out.println("Будут ли еще игроки?");
                    answer = scanAnswer.nextLine();
                    p++;
                } else {
                    String ArrayCopy[] = Arrays.copyOf(company, company.length + 1);
                    company = ArrayCopy;
                    n++;

                }
            }
            if(!(answer.equals("нет") || answer.equals("Нет") || answer.equals("не") || answer.equals("Не") || answer.equals("не будет") || answer.equals("Не будет") || answer.equals("не будут") || answer.equals("Не будут") || answer.equals("больше нет") || answer.equals("Больше нет") || answer.equals("0") || answer.equals("n") || answer.equals("N") || answer.equals("no") || answer.equals("No") || answer.equals("больше не будет") || answer.equals("Больше не будет") || answer.equals("ytn") || answer.equals("все"))) {
                System.out.println("Не совсем понятен ответ, ну да ладно..");
            }


            // ввод считалочки
            Output.outputCounting();
            int x = Input.inputCounting();

            // вывод всех участников
            Output.outputConditions(company, n, x);

            // выбор режима игры
            String gameMode = "3";
            Scanner scanGameMode = new Scanner(System.in);
            while(!(gameMode.equals("1") || gameMode.equals("2"))) {
                System.out.println("Как будем считать?");
                System.out.println("1 - Все стоят кружком. Считаем от начала до конца навылет");
                System.out.println("2 - Все стоят в ряд. Считаем каждый раз с начала ряда");
                System.out.println("3 - Свои правила");
                gameMode = scanGameMode.nextLine();
                if(!(gameMode.equals("1") || gameMode.equals("2") || gameMode.equals("3"))) {
                    System.out.println("Выберите, пожалуйста, одно из предложенных значений");
                }
            }
            // счет
            if (gameMode.equals("2")) {
                // удаление участников по считалочке из массива(счет все время с первого)
                while (n > 1) {
                    if (x % n > 0) {
                        for (int i = x % n; i < n; i++) {
                            company[i - 1] = company[i];
                        }
                    }
                    /// уменьшение массива
                    arrayCut(company);
                    n--;
                    /// вывод текущего результата
                    Output.outputTempResult(company, n);
                }
            } else {
                // удаление участников по считалочке из массива(счет подряд)
                System.out.println("----------------------------------------------------------------");
                int y = x;
                while (n > 1) {
                    if(y % n > 0) {
                        for (int i = y % n; i < n; i++) {
                            company[i - 1] = company[i];
                        }
                        y = (y % n) + x - 1;
                    } else {
                        y = x;
                    }
                    /// уменьшение массива
                    arrayCut(company);
                    n--;
                    /// вывод текущего результата
                    Output.outputTempResult(company, n);
                }
            }
            // вывод оставшегося участника
            Output.outputResult(company, n);

            // финишное предложение
            Output.outputAgain();
            Input.inputStartAgain();
            Output.outputFinal();
        }


    public static void Start() {
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
            Counting.FastCounting(n, x);
        }
    }

    public static void arrayCut(String ArrayName[]) {
        String ArrayCopy[] = new String[ArrayName.length - 1];
        System.arraycopy(ArrayName, 0, ArrayCopy, 0, ArrayCopy.length);
        ArrayName = ArrayCopy;
    }

    public static void arrayAdd(String ArrayName[]) {
        String ArrayCopy[] = Arrays.copyOf(ArrayName, ArrayName.length + 1);
        ArrayName = ArrayCopy;
    }

    public static int countWords(String counting) {
        int x = 1;
        char ch[] = counting.toCharArray();
        for(int i = 0; i < ch.length; i++) {
            if(ch[i] == (' ')) {
                x++;
            }
        }
        return x;
    }

    public static boolean positive(String tryPositive) {
        if (!(Arrays.asList(Input.positive).contains(tryPositive.toLowerCase()))) {
            String Yes = Input.inputTestAnswer();
            if (Yes.equals("1")) {
                String ArrayCopy[] = Arrays.copyOf(Input.positive, Input.positive.length + 1);
                Input.positive = ArrayCopy;
                Input.positive[Input.positive.length - 1] = tryPositive.toLowerCase();
                return true;
            } else {
                return false;
            }
        }
        return true;
    }
}

