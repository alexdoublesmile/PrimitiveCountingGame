import java.util.Arrays;
import java.util.Scanner;

class Input {

    private static int arrayNumber = 1;
    private static int arraySameNumber = 1;
    private static int countPlayers = 1;
    private static int wordsNumber;
    private static int numStep = 1;
    private static String arrayCompany[] = new String[arrayNumber];
    private static String arraySameCompany[] = new String[arraySameNumber];
    private static String outPlayer;

    // "динамические" массивы положительных и отрицательных ответов
    private static String[] positive = new String[]{"да", "давай", "ок", "ага", "угу", "конечно", "можно", "сыграем", "верно", "точно", "правильно", "хорошо", "будут", "y", "yes", "ok", "lf", "1"};
    private static String[] negative = new String[]{"нет", "не", "неа", "хватит", "хорош", "yt", "ytn", "неверно", "0"};

    static boolean positive(String tryPositive) {
        while (tryPositive.equals("") || tryPositive.equals(" ")) {
            Output.outputWhat();
            Scanner scantryPositive = new Scanner(System.in);
            tryPositive = scantryPositive.nextLine();
        }
        String MaybeYes = "";
        if (!(Arrays.asList(negative).contains(tryPositive.toLowerCase())) && !(Arrays.asList(positive).contains(tryPositive.toLowerCase()))) {
            while (!(MaybeYes.equals("1") || (MaybeYes.equals("2")))) {
                Output.outputAnswer();
                Scanner scanYes = new Scanner(System.in);
                MaybeYes = scanYes.nextLine();
                if (!(MaybeYes.equals("1") || (MaybeYes.equals("2")))) {
                    Output.outputAnswerAgain();
                }
            }
            if (MaybeYes.equals("1")) {
                String ArrayCopy[] = Arrays.copyOf(positive, positive.length + 1);
                positive = ArrayCopy;
                positive[positive.length - 1] = tryPositive.toLowerCase();
                return true;
            } else {
                String ArrayCopy[] = Arrays.copyOf(negative, negative.length + 1);
                negative = ArrayCopy;
                negative[negative.length - 1] = tryPositive.toLowerCase();
                return false;
            }

        } else if (Arrays.asList(negative).contains(tryPositive.toLowerCase())) {
            return false;
        }
        return true;
    }

    // регистрация участников
    public static void inputRegister() {
        Output.outputName(countPlayers);
        Scanner scanName = new Scanner(System.in);
        arrayCompany[(arrayNumber - 1)] = scanName.nextLine();
        while (arrayCompany[(arrayNumber - 1)].equals("") || arrayCompany[arrayNumber - 1].equals(" ")) {
            Output.outputWhat();
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
            Output.outputNameAgain();
            Scanner scanMore = new Scanner(System.in);
            String answer = scanMore.nextLine();
            if (!(positive(answer))) {

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

    // ввод считалочки
    public static int inputCounting() {
        Scanner scanLine = new Scanner(System.in);
        String counting = scanLine.nextLine();
        if (counting.matches("[0-9]+")) {
            wordsNumber = Integer.parseInt(counting);
        } else {
            int severalWords = Counting.countWords(counting);
            while (severalWords < 2) {
                Output.outputWhat();
                scanLine = new Scanner(System.in);
                counting = scanLine.nextLine();
                severalWords = Counting.countWords(counting);
            }
            Output.outputCountCheck(severalWords);
            Scanner scanAgain = new Scanner(System.in);
            String scan = scanAgain.nextLine();
            if (!(positive(scan))) {
                Output.outputCountCheckAgain(severalWords);
                Scanner scanMoreAgain = new Scanner(System.in);
                String scanMore = scanMoreAgain.nextLine();
                if (!(positive(scanMore))) {
                    Output.outputCountingAgain();
                } else {
                    wordsNumber = severalWords;
                }
            } else {
                wordsNumber = severalWords;
            }
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
                Output.outputAnswerAgain();
                inputGameMode();
        }
    }

    // настройка пользовательского режима
    public static void inputUserGameMode() {
        Output.outputUserSettings();
        int startNumber = checkNumber();
        Output.outputUserSettingsStep();
        int stepNumber = checkNumber();
        Output.outputUserGameMode();
        Scanner scanOrder = new Scanner(System.in);
        String order = scanOrder.nextLine();
        while (!(order.equals("1")) && !(order.equals("2"))) {
            Output.outputAnswerAgain();
            scanOrder = new Scanner(System.in);
            order = scanOrder.nextLine();
        }
        mainCount(startNumber, stepNumber, order);
    }

    // счет
    public static void mainCount(int startNumber, int stepNumber, String order) {
        String arrayForSameCompany[] = Arrays.copyOf(arrayCompany, arrayCompany.length);
        arraySameCompany = arrayForSameCompany;
        arraySameNumber = arrayNumber;
        Output.outputstartCounting();
        Output.outputAllPlayers(arrayCompany, arrayNumber);
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
                    outPlayer = arrayCompany[arrayNumber - 1];
                    finalNumber = wordsNumber*stepNumber;
                }
            } else {
                if (finalNumber % arrayNumber > 0) {
                    outPlayer = arrayCompany[finalNumber % arrayNumber - 1];
                    for (int i = finalNumber % arrayNumber; i < arrayNumber; i++) {
                        arrayCompany[i - 1] = arrayCompany[i];
                    }
                } else {
                    outPlayer = arrayCompany[arrayNumber - 1];
                }
            }
            /// текущее уменьшение массива во время счета
            Counting.arrayCut(arrayCompany);
            arrayNumber--;
            /// текущий результат во время счета
            Output.outputTempResult(arrayCompany, arrayNumber, numStep, outPlayer);
            numStep++;
        }
    }

    public static void inputResult() {
        Output.outputResult(arrayCompany, arrayNumber);
    }

    // перезапуск
    public static void inputStartAgain() {
        String was = Counting.mode();
        Scanner scanAgain = new Scanner(System.in);
        String again = scanAgain.nextLine();
        if (!(positive(again))) {
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
                Output.outputAnswerAgain();
                inputContinue();
        }
    }

    // проверка и перевод вводимых данных в численный вид
    public static int checkNumber() {
        Scanner scanNumber = new Scanner(System.in);
        String number = scanNumber.nextLine();
        while (!(number.matches("[0-9]+"))) {
            Output.outputCheckedNumber();
            Scanner scanS = new Scanner(System.in);
            number = scanS.nextLine();
        }
        int n = Integer.parseInt(number);
        return n;
    }
}
