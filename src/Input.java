import java.util.Arrays;
import java.util.Scanner;

public class Input {

    static int n = 1;
    static int p = 1;
    static String answer = "";
    static String company[] = new String[n];

    static String[] positive = new String[]{"да", "давай", "ок", "ага", "угу", "конечно", "можно", "сыграем", "верно", "точно", "правильно", "хорошо", "y", "yes", "ok", "lf", "1"};
    static String[] negative = new String[]{"нет", "не", "неа", "хватит", "хорош", "yt", "ytn", "неверно", "0"};

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

    public static void inputRegister() {
        if (p <= n) {
            inputName();
            while (company[(n - 1)].equals("") || company[(n - 1)].equals(" ")) {
                System.out.println("Стоит ввести хоть какое-то имя или псевдоним :)");
                inputName();
            }
            System.out.println("Будут ли еще игроки?");
            Scanner scanAnswer = new Scanner(System.in);
            answer = scanAnswer.nextLine();
            p++;
        } else {
            String ArrayCopy[] = Arrays.copyOf(company, company.length + 1);
            company = ArrayCopy;
            n++;

        }
        if (Arrays.asList(Input.negative).contains(answer.toLowerCase()) && !(Counting.positive(answer))) {
            System.out.println("Не совсем понятен ответ, ну да ладно..");
        }
    }

    public static void inputName() {
            System.out.println("Введите имя " + p + " игрока: ");
            Scanner scanName = new Scanner(System.in);
            company[(n - 1)] = scanName.nextLine();
    }

    public static void inputNewCounting() {
        Scanner scanLine = new Scanner(System.in);
        String counting = scanLine.nextLine();
        int x = Counting.countWords(counting);
        System.out.println("Кол-во слов в считалочке: " + x + ". Верно?");
        Scanner scanAgain = new Scanner(System.in);
        String again = scanAgain.nextLine();
    }

    public static int inputCounting() {
        int x = 1;
        String again = "";
        inputNewCounting();
        do {
            if (Arrays.asList(negative).contains(again.toLowerCase()) && !Counting.positive(again)) {
                System.out.println("Введите еще разок Вашу считалочку(не забывайте ставить пробел между словами): ");
                inputNewCounting();
            }
        } while (!Counting.positive(again));
        return x;
    }

    public static void inputStartAgain() {
        Scanner scanAgain = new Scanner(System.in);
        String again = scanAgain.nextLine();
        if (!(Arrays.asList(negative).contains(again.toLowerCase())) && Counting.positive(again)) {
            Counting.Start();
        }
    }
}
