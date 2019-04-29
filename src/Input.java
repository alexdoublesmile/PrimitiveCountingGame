import java.util.Scanner;

public class Input {

    static String[] positive = new String[]{"да", "давай", "ок", "ага", "угу", "конечно", "можно", "сыграем", "верно", "точно", "правильно", "y", "yes", "ok", "lf"};

    public static String inputTestAnswer() {
        String answer = "";
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

    public static boolean inputAnswer() {
        Scanner scanAgain = new Scanner(System.in);
        String again = scanAgain.nextLine();
        if(!(Counting.positive(again))) {
            return false;
        }
        return true;
    }

    public static int inputCounting() {
        Scanner scanLine = new Scanner(System.in);
        String counting = scanLine.nextLine();
        int x = Counting.countWords(counting);
        System.out.println("Кол-во слов в считалочке: " + x + ". Верно?");
        if(!(inputAnswer())) {
            System.out.println("Введите еще разок Вашу считалочку(не забывайте ставить пробел между словами): ");
            inputCounting();
        }
        return x;
    }

    public static void inputStartAgain() {
        if(inputAnswer()) {
            Counting.Start();
        }
    }
}
