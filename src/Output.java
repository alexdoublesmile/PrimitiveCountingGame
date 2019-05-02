public class Output {

    public static void outputStart() {
        System.out.println("В какую считалочку предпочитаете сыграть?");
        System.out.println("1 - Быстрый вариант");
        System.out.println("2 - Детальный вариант");
    }

    public static void outputFastStart() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("-------------------------- Правила -----------------------------");
        System.out.println("Участники пронумерованы и стоят кружком");
        System.out.println("При выбывании одного, счет идет со следующего и так до конца");
        System.out.println("Значения вводите только цифрами");
        System.out.println("----------------------------------------------------------------");
    }

    public static void outputGreetings() {
        System.out.println("*** Приветствуем в нашей Автоматизированной Считалочке (АС-1)! ***");
        System.out.println("----------------------------------------------------------------");
    }

    public static void outputCounting() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("Введите Вашу считалочку: ");
    }

    public static void startCounting() {
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
        System.out.println("1 - Все стоят кружком. Считаем от начала до конца навылет");
        System.out.println("2 - Все стоят в ряд. Считаем каждый раз с начала ряда");
        System.out.println("3 - Свои правила");

    }

    public static void outputUserSettings() {
        System.out.println("Чтобы создать свои правила, следует ввести дополнительные данные ");
        System.out.println("------- Информацию следует вводить только цифрами --------");
        System.out.println("Введите номер участника, с которого следует начинать счет: ");
    }


    public static void outputUserGameMode() {
        System.out.println("Выберите порядок счета после вылета одного из участников:");
        System.out.println("- 1 - считать с участника, следующего за вылетающим");
        System.out.println("- 2 - считать каждый раз с начала очереди");
    }

    public static void outputResult(String ArrayName[], int arrayNumber) {
        for (int i = 0; i < arrayNumber; i++) {
            System.out.print("* Поздравляем Вас, " + ArrayName[i] + ". Вы - победитель! *");
        }
        System.out.println("");
    }

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
        System.out.println("1 - Да");
        System.out.println("2 - Нет");
    }
}

