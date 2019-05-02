import java.util.Arrays;
import java.util.Scanner;

public class Input {

    static int arrayNumber = 1;
    static int arraySameNumber = 1;
    static int countPlayers = 1;
    static int wordsNumber;
    static int numStep = 1;
    static String arrayCompany[] = new String[arrayNumber];
    static String arraySameCompany[] = new String[arraySameNumber];
    static String outPlayer;

    // "динамические" массивы положительных и отрицательных ответов
    static String[] positive = new String[]{"да", "давай", "ок", "ага", "угу", "конечно", "можно", "сыграем", "верно", "точно", "правильно", "хорошо", "будут", "y", "yes", "ok", "lf", "1"};
    static String[] negative = new String[]{"нет", "не", "неа", "хватит", "хорош", "yt", "ytn", "неверно", "0"};

    // регистрация участников
    public static void inputRegister() {
        System.out.println("Введите имя " + countPlayers + " игрока: ");
        Scanner scanName = new Scanner(System.in);
        arrayCompany[(arrayNumber - 1)] = scanName.nextLine();
        while (arrayCompany[(arrayNumber - 1)].equals("") || arrayCompany[arrayNumber - 1].equals(" ")) {
            System.out.println("Стоит ввести хоть какое-то имя или псевдоним :)");
            Scanner scanNameAgain = new Scanner(System.in);
            arrayCompany[(arrayNumber - 1)] = scanNameAgain.nextLine();
        }
            countPlayers++;
        if (countPlayers == 2) {
            String ArrayCopy[] = Arrays.copyOf(arrayCompany, arrayCompany.length + 1);
            arrayCompany = ArrayCopy;
            arrayNumber++;
            inputRegister();
        } else if (countPlayers > 2) {
            System.out.println("Будут ли еще игроки?");
            Scanner scanMore = new Scanner(System.in);
            String answer = scanMore.nextLine();
            if (Counting.positive(answer) == false) {

            } else {

                String ArrayCopy[] = Arrays.copyOf(arrayCompany, arrayCompany.length + 1);
                arrayCompany = ArrayCopy;
                arrayNumber++;
                inputRegister();
            }
            countPlayers = 1;
        }
        String arrayForSameCompany[] = Arrays.copyOf(arrayCompany, arrayCompany.length);
        arraySameCompany = arrayForSameCompany;
        arraySameNumber = arrayNumber;
    }

    public static String[] sameCompany() {
        return arraySameCompany;
    }

    // ввод считалочки
    public static int inputCounting() {
        Scanner scanLine = new Scanner(System.in);
        String counting = scanLine.nextLine();
        int severalWords = Counting.countWords(counting);
        while (severalWords < 2) {
            System.out.println("Следует ввести что-то чуть более похожее на считалочку:)");
            scanLine = new Scanner(System.in);
            counting = scanLine.nextLine();
            severalWords = Counting.countWords(counting);
        }
        System.out.println("Кол-во слов в считалочке: " + severalWords + ". Верно?");
        Scanner scanAgain = new Scanner(System.in);
        String scan = scanAgain.nextLine();
        if (Counting.positive(scan) == false) {
            System.out.println("Введите еще разок Вашу считалочку (не забывайте раделять слова пробелом): ");
            inputCounting();
        } else {
            wordsNumber = severalWords;
        }
        return wordsNumber;
    }

    // вывод параметров и результатов
    public static void inputConditions() {
        Output.outputConditions(arrayCompany, arrayNumber, wordsNumber);
    }

    // выбор режима
    public static void inputGameMode() {
        Scanner scanGameMode = new Scanner(System.in);
        String gameMode = scanGameMode.nextLine();
        switch (gameMode) {
            case ("1"):
                mainCount(1, 1, "1");
                break;
            case ("2"):
                mainCount(1, 1, "2");
                break;
            case ("3"):
                inputUserGameMode();
                break;
            default:
                System.out.println("Выберите, пожалуйста, одно из предложенных значений");
                inputGameMode();
        }
    }

    // настройка пользовательского режима
    public static void inputUserGameMode() {
        Output.outputUserSettings();
        Scanner scanstartNumber = new Scanner(System.in);
        int startNumber = scanstartNumber.nextInt();
        System.out.println("Введите шаг, с которым следует вести счет: ");
        Scanner scanstepNumber = new Scanner(System.in);
        int stepNumber = scanstepNumber.nextInt();
        Output.outputUserGameMode();
        Scanner scanOrder = new Scanner(System.in);
        String order = scanOrder.nextLine();
        mainCount(startNumber, stepNumber, order);
    }

    // счет
    public static void mainCount(int startNumber, int stepNumber, String order) {
        System.out.println("");
        Output.startCounting();
        for (int i = 0; i < arrayNumber; i++) {
            System.out.print(arrayCompany[i] + "  ");
        }
        System.out.println("");
        System.out.println("");
        int finalNumber = wordsNumber*stepNumber + (startNumber - 1);
        numStep = 1;
        while (arrayNumber > 1) {
            if (order.equals("1")) {
                if(finalNumber % arrayNumber > 0) {
                    outPlayer = arrayCompany[finalNumber % arrayNumber - 1];
                    for (int i = finalNumber % arrayNumber; i < arrayNumber; i++) {
                        arrayCompany[i - 1] = arrayCompany[i];
                    }
                    finalNumber = (finalNumber % arrayNumber) + wordsNumber*stepNumber - 1;
                } else {
                    outPlayer = arrayCompany[arrayCompany.length - 1];
                    finalNumber = wordsNumber*stepNumber;
                }
            } else {
                if (finalNumber % arrayNumber > 0) {
                    outPlayer = arrayCompany[finalNumber % arrayNumber - 1];
                    for (int i = finalNumber % arrayNumber; i < arrayNumber; i++) {
                        arrayCompany[i - 1] = arrayCompany[i];
                    }
                } else {
                    outPlayer = arrayCompany[arrayCompany.length - 1];
                }
            }
            /// уменьшение массива
            arrayCut(arrayCompany);
            arrayNumber--;
            /// вывод текущего результата
            outputTempResult(arrayNumber, numStep, outPlayer);
            numStep++;
        }
    }

    public static void outputTempResult(int arrayNumber, int num, String out) {
        if(!(arrayNumber == 1)) {
            System.out.println("Шаг " + num + ". Вылетает: " + out);
            System.out.println("Остаются: ");
            for (int i = 0; i < arrayNumber; i++) {
                if(i == arrayNumber - 1) {
                    System.out.print(arrayCompany[i] + ".");
                } else {
                    System.out.print(arrayCompany[i] + ", ");
                }
            }
            System.out.println("");
            System.out.println("");
        } else {
            System.out.println("Шаг последний. Остаётся " + arrayCompany[0] + ".");
            System.out.println("");
        }
    }

    // обрезка массива
    public static void arrayCut(String ArrayName[]) {
        String ArrayCopy[] = new String[ArrayName.length - 1];
        System.arraycopy(ArrayName, 0, ArrayCopy, 0, ArrayCopy.length);
        ArrayName = ArrayCopy;
    }

    public static void inputResult() {
        Output.outputResult(arrayCompany, arrayNumber);
    }

    // перезапуск
    public static void inputStartAgain() {
        String was = Counting.mode();
        Scanner scanAgain = new Scanner(System.in);
        String again = scanAgain.nextLine();
        if (Counting.positive(again) == false) {
            Output.outputFinal();
        } else {
            if(was.equals("2")) {
                Output.outputContinue();
                inputContinue();
            } else  {
                Counting.start();
            }

        }
    }

    // условия перезапуска
    public static void inputContinue() {
        Scanner scanContinue = new Scanner(System.in);
        String countinue = scanContinue.nextLine();
        switch (countinue) {
            case ("1"):
                Counting.start();
                break;
            case ("2"):
                arrayCompany = arraySameCompany;
                arrayNumber = arraySameNumber;
                Counting.countingDetailSecond();
                break;
            case ("3"):
                arrayCompany = arraySameCompany;
                arrayNumber = arraySameNumber;
                Counting.countingDetailThird();
                break;
            default:
                System.out.println("Выберите, пожалуйста, одно из предложенных значений");
                inputContinue();
        }
    }
}
