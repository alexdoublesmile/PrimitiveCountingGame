public class Output {

    public static void outputGreetings() {
        System.out.println("*** Приветствуем в нашей Автоматизированной Считалочке (АС-1)! ***");
        System.out.println("----------------------------------------------------------------");
    }

    public static void outputCounting() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("Введите Вашу считалочку: ");
    }

    public static void outputConditions(String ArrayName[], int n, int x) {
        System.out.println("----------------------------------------------------------------");
        System.out.print("Принимают участие " + n + " игроков:  ");
        for (int i = 0; i < n; i++) {
            System.out.print(ArrayName[i] + "  ");
        }
        System.out.println("");
        System.out.println("А кол-во слов в считалочке: " + x + ".");
        System.out.println("");
        System.out.println("");
    }

    public static void outputTempResult(String ArrayName[], int n) {
        int num = 1;
        System.out.println("Шаг " + num + ". В кругу остаются: ");
        for (int i = 0; i < n; i++) {
            System.out.print(ArrayName[i] + "  ");
        }
        System.out.println("");
        System.out.println("");
        num++;
    }

    public static void outputResult(String ArrayName[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("Остается: " + ArrayName[i] + "!");
        }
        System.out.println("");
    }

    public static void outputAgain() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("Сыграем еще?");
    }

    public static void outputAnswer() {
        System.out.println("Ваш ответ означает \"Да\" ?");
        System.out.println("1 - Да");
        System.out.println("2 - Нет");
    }

    public static void outputFinal() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("*** Спасибо за игру. Приходите еще! :) ***");
    }
}

