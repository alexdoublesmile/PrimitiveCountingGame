public class Output {

    public static void outputStart() {
        System.out.println("В какую считалочку предпочитаете сыграть?");
        System.out.println("1 - Быстрый вариант");
        System.out.println("2 - Детальный вариант");
    }

    public static void outputGreetings() {
        System.out.println("*** Приветствуем в нашей Автоматизированной Считалочке (АС-1)! ***");
        System.out.println("----------------------------------------------------------------");
    }

    public static void outputCounting() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("Введите Вашу считалочку: ");
    }

    public static void outputConditions(String ArrayName[], int arrayNumber, int wordsNumber) {
        System.out.println("----------------------------------------------------------------");
        System.out.print("Принимают участие " + arrayNumber + " игроков:  ");
        for (int i = 0; i < arrayNumber; i++) {
            System.out.print(ArrayName[i] + "  ");
        }
        System.out.println("");
        System.out.println("А кол-во слов в считалочке: " + wordsNumber + ".");
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
        System.out.println("---------- Информацию следует вводить только цифрами -----------");
        System.out.println("1) Введите номер участника, с которого следует начинать счет: ");
    }


    public static void outputUserGameMode() {
        System.out.println("3) Выберите порядок счета после вылета одного из участников:");
        System.out.println("- 1 - считать с участника, следующего за вылетающим");
        System.out.println("- 2 - считать каждый раз с начала очереди");
    }

    public static void outputResult(String ArrayName[], int arrayNumber) {
        for (int i = 0; i < arrayNumber; i++) {
            System.out.print("Остается: " + ArrayName[i] + "!");
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

    public static void outputAnswer() {
        System.out.println("Не совсем понятен Ваш ответ.. Это означает \"Да\" ?");
        System.out.println("1 - Да");
        System.out.println("2 - Нет");
    }

    public static void outputFinal() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("*** Спасибо за игру. Приходите еще! :) ***");
    }
}

