import java.util.Arrays;
import java.util.Scanner;

public class Counting {
    public static void SimpleCounting(int n, int x) {
        int company[] = new int[n];
        for(int i = 0; i < n; i++) {
            company[i] = i + 1;
        }
        int y = x;
        while (n > 1) {
            if (y <= n) {
                for (int i = y; i < n; i++) {
                    company[i - 1] = company[i];
                }
                y += x - 1;

            } else
                if (y % n > 0) {
                    for (int i = y % n; i < n; i++) {
                        company[i - 1] = company[i];
                    }
                    y = (y % n) + x - 1;
                } else {
                    y = x;
                }
            int companyCopy2[] = new int[company.length - 1];
            System.arraycopy(company, 0, companyCopy2, 0, companyCopy2.length);
            company = companyCopy2;
            n--;
        }
        for (int i = 0; i < n; i++) {
            System.out.print("Остается: " + company[i]);
        }
    }


    public static void DetailCounting() {
        // приветствие
        System.out.println("***Приветствуем в нашей Автоматизированной Считалочке (АС-1)!***");
        System.out.println("----------------------------------------------------------------");
        String again = "да";
        // начало игры, регистрация игроков
        while (again.equals("да") || again.equals("Да") || again.equals("угу") || again.equals("ага") || again.equals("конечно") || again.equals("ДА") || again.equals("lf") || again.equals("давай") || again.equals("сыграем") || again.equals("1") || again.equals("y") || again.equals("Y") || again.equals("yes") || again.equals("ок")) {
            String answer = "да";
            int n = 1;
            int p = 1;
            String company[] = new String[n];
            while(answer.equals("да") || answer.equals("Да") || answer.equals("ага") || answer.equals("Ага") || answer.equals("будут") || answer.equals("Будут") || answer.equals("конечно") || answer.equals("Конечно") || answer.equals("возможно") || answer.equals("") || answer.equals("1") || answer.equals("y") || answer.equals("Y") || answer.equals("yes") || answer.equals("Yes") || answer.equals("lf")) {
                if(p <= n) {
                    Scanner scanName = new Scanner(System.in);
                    System.out.println("Введите имя " + p + " игрока: ");
                    company[(n-1)] = scanName.nextLine();
                    while(company[(n-1)].equals("") || company[(n-1)].equals(" ")) {
                        System.out.println("Стоит ввести хоть какое-то имя или псевдоним :)");
                        System.out.println("Введите имя " + p + " игрока: ");
                        company[(n-1)] = scanName.nextLine();
                    }
                    Scanner scanAnswer = new Scanner(System.in);
                    System.out.println("Будут ли еще игроки?");
                    answer = scanAnswer.nextLine();
                    p++;
                } else {
                    String companyTemp[] = Arrays.copyOf(company, company.length + 1);
                    company = companyTemp;
                    n++;
                }
            }
            if(!(answer.equals("нет") || answer.equals("Нет") || answer.equals("не") || answer.equals("Не") || answer.equals("не будет") || answer.equals("Не будет") || answer.equals("не будут") || answer.equals("Не будут") || answer.equals("больше нет") || answer.equals("Больше нет") || answer.equals("0") || answer.equals("n") || answer.equals("N") || answer.equals("no") || answer.equals("No") || answer.equals("больше не будет") || answer.equals("Больше не будет") || answer.equals("ytn") || answer.equals("все"))) {
                System.out.println("Не совсем понятен ответ, ну да ладно..");
            }


            // ввод считалочки
            System.out.println("----------------------------------------------------------------");
            System.out.println("Введите Вашу считалочку: ");
            int x = 1;
            String countNumber = "нет";
            while (!(countNumber.equals("да") || countNumber.equals("Да") || countNumber.equals("верно") || countNumber.equals("Верно") || countNumber.equals("ДА") || countNumber.equals("lf") || countNumber.equals("Lf") || countNumber.equals("точно") || countNumber.equals("Точно") || countNumber.equals("ага") || countNumber.equals("Ага"))) {
                Scanner scanLine = new Scanner(System.in);
                String counting = scanLine.nextLine();
                x = 1;
                char ch[] = counting.toCharArray();
                for(int i = 0; i < ch.length; i++) {
                    if(ch[i] == (' ') || ch[i] == ('-')) {
                        x++;
                    }
                }
                System.out.println("Кол-во слов в считалочке: " + x + ". Верно?");
                Scanner scanCountAnswer = new Scanner(System.in);
                countNumber = scanCountAnswer.nextLine();
                if(!(countNumber.equals("да") || countNumber.equals("Да") || countNumber.equals("верно") || countNumber.equals("Верно") || countNumber.equals("ДА") || countNumber.equals("lf") || countNumber.equals("Lf") || countNumber.equals("точно") || countNumber.equals("Точно") || countNumber.equals("ага") || countNumber.equals("Ага"))) {
                    System.out.println("Введите еще разок Вашу считалочку(не забывайте ставить пробел между словами): ");
                }
            }

            // вывод всех участников
            System.out.println("----------------------------------------------------------------");
            System.out.println("Принимают участие " + n + " игроков:");
            for (int i = 0; i < n; i++) {
                System.out.print(company[i] + "  ");
            }
            System.out.println("");
            System.out.println("");

            // выбор режима игры
            String gameMode = "3";
            Scanner scanGameMode = new Scanner(System.in);
            while(!(gameMode.equals("1") || gameMode.equals("2"))) {
                System.out.println("Как будем считать?");
                System.out.println("1 - Все стоят кружком. Считаем от начала до конца навылет");
                System.out.println("2 - Все стоят в ряд. Считаем каждый раз с начала ряда");
                gameMode = scanGameMode.nextLine();
                if(!(gameMode.equals("1") || gameMode.equals("2"))) {
                    System.out.println("Выберите, пожалуйста, одно из предложенных значений");
                }
            }
            // счет
            int num = 1;
            if (gameMode.equals("2")) {
                // удаление участников по считалочке из массива(счет все время с первого)
                System.out.println("----------------------------------------------------------------");
                while (n > 1) {
                    if (x <= n) {
                        for (int i = x; i < n; i++) {
                            company[i - 1] = company[i];
                        }
                    } else {
                        if (x % n > 0)
                            for (int i = x % n; i < n; i++)
                                company[i - 1] = company[i];
                    }
                    String companyCopy1[] = new String[company.length - 1];
                    System.arraycopy(company, 0, companyCopy1, 0, companyCopy1.length);
                    company = companyCopy1;
                    n--;
                    System.out.println("Шаг " + num + ". В ряду остаются: ");
                    for (int i = 0; i < n; i++) {
                        System.out.print(company[i] + "  ");
                    }
                    System.out.println("");
                    System.out.println("");
                    num++;
                }
            } else {
                // удаление участника по считалочке из массива(счет подряд)
                System.out.println("----------------------------------------------------------------");
                int y = x;
                while (n > 1) {
                    if (y <= n) {
                        for (int i = y; i < n; i++) {
                            company[i - 1] = company[i];
                        }
                        y += x - 1;

                    } else {
                        if (y % n > 0) {
                            for (int i = y % n; i < n; i++) {
                                company[i - 1] = company[i];
                            }
                            y = (y % n) + x - 1;
                        } else {
                            y = x;
                        }

                    }
                    String companyCopy2[] = new String[company.length - 1];
                    System.arraycopy(company, 0, companyCopy2, 0, companyCopy2.length);
                    company = companyCopy2;
                    n--;
                    System.out.println("Шаг " + num + ". В кругу остаются: ");
                    for (int i = 0; i < n; i++) {
                        System.out.print(company[i] + "  ");
                    }
                    System.out.println("");
                    System.out.println("");
                    num++;
                }
            }


            // вывод оставшегося участника
            for (int i = 0; i < n; i++) {
                System.out.print("Остается: " + company[i] + "!");
            }
            System.out.println("");

            // финишное предложение
            Scanner scanAgain = new Scanner(System.in);
            System.out.println("----------------------------------------------------------------");
            System.out.println("Сыграем еще?");
            again = scanAgain.nextLine();
        }
    }
}

