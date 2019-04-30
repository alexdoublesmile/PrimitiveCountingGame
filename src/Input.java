import java.util.Arrays;
import java.util.Scanner;

public class Input {

    static int arrayNumber = 1;
    static int countPlayers = 1;
    static int wordsNumber;
    static String answer = "";
    static String gameMode = "3";
    static int num = 1;
    static String arrayCompany[] = new String[arrayNumber];

    // "динамические" массивы положительных и отрицательных ответов
    static String[] positive = new String[]{"да", "давай", "ок", "ага", "угу", "конечно", "можно", "сыграем", "верно", "точно", "правильно", "хорошо", "будут", "y", "yes", "ok", "lf", "1"};
    static String[] negative = new String[]{"нет", "не", "неа", "хватит", "хорош", "yt", "ytn", "неверно", "0"};

    // общий уточняющий вопрос
    public static String inputTestAnswer() {
        while (!(answer.equals("1") || (answer.equals("2")))) {
            Output.outputAnswer();
            Scanner scanYes = new Scanner(System.in);
            answer = scanYes.nextLine();
            if (!(answer.equals("1") || (answer.equals("2")))) {
                System.out.println("Выберите, пожалуйста, один из предложенных вариантов");
            }
        }
        return answer;
    }

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
        System.out.println("Будут ли еще игроки?");
        Scanner scanMore = new Scanner(System.in);
        answer = scanMore.nextLine();
        if (Arrays.asList(negative).contains(answer.toLowerCase()) || !(Counting.positive(answer))) {

        } else if (!(Arrays.asList(negative).contains(answer.toLowerCase()) && Counting.positive(answer))) {
            String ArrayCopy[] = Arrays.copyOf(arrayCompany, arrayCompany.length + 1);
            arrayCompany = ArrayCopy;
            countPlayers++;
            arrayNumber++;
            inputRegister();
        }
        countPlayers = 1;
    }

    // ввод считалочки
    public static String inputNewCounting() {
        Scanner scanLine = new Scanner(System.in);
        String counting = scanLine.nextLine();
        wordsNumber = Counting.countWords(counting);
        System.out.println("Кол-во слов в считалочке: " + wordsNumber + ". Верно?");
        Scanner scanAgain = new Scanner(System.in);
        String scan = scanAgain.nextLine();
        return scan;
    }

    // проверка считалочки
    public static int inputCounting() {
        String again = inputNewCounting();
        if (!(Arrays.asList(negative).contains(again.toLowerCase())) && Counting.positive(again)) {
        } else if (Arrays.asList(negative).contains(again.toLowerCase()) || !(Counting.positive(again))) {
            System.out.println("Введите еще разок Вашу считалочку (не забывайте раделять слова пробелом): ");
            inputNewCounting();
        }
        return wordsNumber;
    }

    // вывод параметров и результатов
    public static void inputConditions() {
        Output.outputConditions(arrayCompany, arrayNumber, wordsNumber);
    }

    // выбор режима
    public static void inputGameMode() {
        Output.outputGameMode();
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
        System.out.println("2) Введите шаг, с которым следует вести счет: ");
        Scanner scanstepNumber = new Scanner(System.in);
        int stepNumber = scanstepNumber.nextInt();
        Output.outputUserGameMode();
        Scanner scanOrder = new Scanner(System.in);
        String order = scanOrder.nextLine();
        mainCount(startNumber, stepNumber, order);
    }

    // счет
    public static void mainCount(int startNumber, int stepNumber, String order) {
        if (order.equals("2")) {
            // удаление участников по считалочке из массива(счет все время с первого)
            num = 1;
            while (arrayNumber > 1) {
                if ((wordsNumber*stepNumber + startNumber) % arrayNumber > 0) {
                    for (int i = ((wordsNumber*stepNumber + startNumber) % arrayNumber); i < arrayNumber; i++) {
                        arrayCompany[i - 1] = arrayCompany[i];
                    }
                }
                /// уменьшение массива
                arrayCut(arrayCompany);
                arrayNumber--;
                /// вывод текущего результата
                System.out.println("Шаг " + num + ". Остаются: ");
                for (int i = 0; i < arrayNumber; i++) {
                    System.out.print(arrayCompany[i] + "  ");
                }
                System.out.println("");
                System.out.println("");
                num++;
            }
        } else {
            // удаление участников по считалочке из массива(счет подряд)
            System.out.println("----------------------------------------------------------------");
            int finalNumber = wordsNumber*stepNumber + startNumber;
            num = 1;
            while (arrayNumber > 1) {
                if(finalNumber % arrayNumber > 0) {
                    for (int i = (finalNumber) % arrayNumber; i < arrayNumber; i++) {
                        arrayCompany[i - 1] = arrayCompany[i];
                    }
                    finalNumber = (finalNumber % arrayNumber) + wordsNumber - 1;
                } else {
                    finalNumber = wordsNumber;
                }
                /// уменьшение массива
                arrayCut(arrayCompany);
                arrayNumber--;
                /// вывод текущего результата
                System.out.println("Шаг " + num + ". Остаются: ");
                for (int i = 0; i < arrayNumber; i++) {
                    System.out.print(arrayCompany[i] + "  ");
                }
                System.out.println("");
                System.out.println("");
                num++;
            }
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
        Scanner scanAgain = new Scanner(System.in);
        String again = scanAgain.nextLine();
        if (!(Arrays.asList(negative).contains(answer.toLowerCase()) && Counting.positive(again))) {
            Counting.start();
        } else if (Arrays.asList(negative).contains(again.toLowerCase())) {

        }
    }
}
