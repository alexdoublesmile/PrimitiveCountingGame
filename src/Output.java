import java.util.Scanner;

public class Output {

    public static void outputStart() {
        System.out.println("В какую считалочку предпочитаете сыграть?");
        System.out.println("- 1 - Быстрый вариант");
        System.out.println("- 2 - Детальный вариант");
    }

    public static void outputFastStart() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("-------------------------- Правила -----------------------------");
        System.out.println("Участники пронумерованы и стоят кружком");
        System.out.println("При выбывании одного, счет идет со следующего и так до конца");
        System.out.println("----------------------------------------------------------------");
    }

    public static void outputGreetings() {
        System.out.println("*** Приветствуем в нашей Автоматизированной Считалочке (АС-1)! ***");
        System.out.println("----------------------------------------------------------------");
    }

    public static void outputName(int n) {
        System.out.println("Введите имя " + n + " игрока: ");
    }

    public static void outputNameAgain() {
        System.out.println("Будут ли еще игроки?");
    }

    public static void outputCounting() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("Введите считалочку или количество слов в ней: ");
    }

    public static void outputCountCheck(int n) {
        System.out.println("Кол-во слов в считалочке: " + n + ". Верно?");
    }

    public static void outputCountCheckAgain(int n) {
        System.out.println("..может тогда " + (n - 1) + "?");
    }

    public static void outputCountingAgain() {
        System.out.println("Введите еще разок Вашу считалочку (не забывайте раделять слова пробелами): ");
        Input.inputCounting();
    }

    public static void outputstartCounting() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("--------------------   Поехали!!!  -----------------------------");
        System.out.println("----------------------------------------------------------------");
        System.out.println("");
    }

    public static void outputConditions(String ArrayName[], int arrayNumber, int wordsNumber) {
        System.out.println("----------------------------------------------------------------");
        System.out.print("Принимают участие " + arrayNumber + " игроков:  ");
        for (int i = 0; i < arrayNumber; i++) {
            System.out.print(ArrayName[i] + "  ");
        }
        System.out.println("");
        System.out.println("А кол-во слов в считалочке = " + wordsNumber + ".");
        System.out.println("");
        System.out.println("");
    }

    public static void outputGameMode() {
        System.out.println("Как будем считать?");
        System.out.println("- 1 - Все стоят кружком. Считаем от начала до конца навылет");
        System.out.println("- 2 - Все стоят в ряд. Считаем каждый раз с начала ряда");
        System.out.println("- 3 - Свои правила");

    }

    public static void outputUserSettings() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("Чтобы создать свои правила, следует ввести дополнительные данные ");
        System.out.println("");
        System.out.println("Введите номер участника, с которого начинать счет: ");
    }

    public static void outputUserSettingsStep() {
        System.out.println("Введите шаг, с которым следует вести счет: ");
    }

    public static void outputUserGameMode() {
        System.out.println("Выберите порядок счета после вылета одного из участников:");
        System.out.println("- 1 - считать с участника, следующего за вылетающим");
        System.out.println("- 2 - считать каждый раз с начала очереди");
    }

    // временный результат, выводимый при счете
    public static void outputTempResult(String ArrayName[], int arrayNumber, int num, String out) {
        if(!(arrayNumber == 1)) {
            System.out.println("Шаг " + num + ". Вылетает: " + out);
            System.out.println("Остаются: ");
            for (int i = 0; i < arrayNumber; i++) {
                if(i == arrayNumber - 1) {
                    System.out.print(ArrayName[i] + ".");
                } else {
                    System.out.print(ArrayName[i] + ", ");
                }
            }
            System.out.println("");
            System.out.println("");
        } else {
            System.out.println("Шаг последний. Остаётся " + ArrayName[0] + ".");
            System.out.println("");
        }
    }

    // конечный результат детального счета
    public static void outputResult(String ArrayName[], int arrayNumber) {
        for (int i = 0; i < arrayNumber; i++) {
            System.out.print("* Поздравляем Вас, " + ArrayName[i] + ". Вы - победитель! *");
        }
        System.out.println("");
    }

    // конечный результат быстрого счета
    public static void outputFastResult(int ArrayName[], int arrayNumber) {
        for (int i = 0; i < arrayNumber; i++) {
            System.out.print("Остается: " + ArrayName[i]);
            System.out.println("");
        }
    }

    public static void outputAgain() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("Сыграем еще?");
    }

    public static void outputContinue() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("С какого места Вы хотели бы повторить?");
        System.out.println("- 1 - Хочу сыграть с самого начала");
        System.out.println("- 2 - Играть с теми же участниками");
        System.out.println("- 3 - Играть с теми же участниками и той же считалочкой");
    }

    public static void outputFinal() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("*** Спасибо за игру. Приходите еще! :) ***");
    }

    public static void outputAnswer() {
        System.out.println("Не совсем понятен Ваш ответ.. Это означает \"Да\" ?");
        System.out.println("- 1 - Да");
        System.out.println("- 2 - Нет");
    }


    public static void outputAnswerAgain() {
        System.out.println("Выберите, пожалуйста, одно из предложенных значений");
    }

    public static void outputWhat() {
        System.out.println("Введите, пожалуйста, что-то более внятное :)");
    }

    public static boolean outputCheckedNumber(String s) {
        while (!(s.matches("[0-9]+"))) {
            System.out.println("Введите, пожлуйста, значение в виде числа");
            Scanner scanS = new Scanner(System.in);
            s = scanS.nextLine();
        }
        return true;
    }
}

