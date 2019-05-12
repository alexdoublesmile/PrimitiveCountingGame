public class Counting {

    private static String Mode = "";

    public static String mode() {
        return Mode;
    }

    public static void start() {
        Mode = "";
        Output.outputStart();
        Mode = Input.inputString();
        if(!(Mode.equals("1") || Mode.equals("2"))) {
            Output.outputAnswerAgain();
            start();
        }
        else if (Mode.equals("2")) {
            countingDetail();
        } else  {
            Output.outputFastStart();
            Input.startFast();
        }
    }

    public static void countingFast(int ArrayName[], int n, int firstNum) {
        /// инициализация участников
        Input.FastCountPlayers(ArrayName, n);
        /// счет
        Input.countFast(ArrayName, n, firstNum);
        /// финал
        Output.outputAgain();
        Input.inputStartAgain();
    }

    public static void countingDetail() {
        /// приветствие
        Output.outputGreetings();

        /// регистрация участников
        Input.inputRegister();

        /// ввод считалочки
        Output.outputCounting();
        Input.inputCounting();

        /// вывод всех параметров
        Input.inputConditions();

        /// счет
        Output.outputGameMode();
        Input.inputGameMode();

        /// результат
        Input.inputResult();

        /// финал
        Output.outputAgain();
        Input.inputStartAgain();
    }

    public static void countingDetailSecond() {
        /// ввод считалочки
        Output.outputCounting();
        Input.inputCounting();

        /// вывод всех параметров
        Input.inputConditions();

        /// счет
        Output.outputGameMode();
        Input.inputGameMode();

        /// результат
        Input.inputResult();

        /// финал
        Output.outputAgain();
        Input.inputStartAgain();
    }

    public static void countingDetailThird() {
        /// вывод всех параметров
        Input.inputConditions();

        /// счет
        Output.outputGameMode();
        Input.inputGameMode();

        /// результат
        Input.inputResult();

        /// финал
        Output.outputAgain();
        Input.inputStartAgain();
    }
}

