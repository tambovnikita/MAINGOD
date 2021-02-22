// https://books.trinket.io/thinkjava/appendix-b.html

package com.company;

// Необходимые библиотеки
import java.util.Scanner;  // ввод
import java.util.List;  // массив нужного вида
import java.util.ArrayList;  // массив нужного вида

// Графика
import javax.swing.*;
import java.awt.*;


public class MyFrame extends JFrame {   // Класс окно
    MyFrame () {   // Конструктор класса (метод запускается при создании объекта)
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // При закрытии окна - завершение программы
        this.setSize(1000, 700);   // размеры окна
        this.setLocationRelativeTo(null);   // расположение окна (по-центру)
        this.setVisible(true);   // визуализация
    }

    public void paint(Graphics g) {   // Способность "График"

        Graphics2D g2D = (Graphics2D) g;  // Преобразование типа Graphics к Graphics2D (для большего удобства)

        int [] x0H0 = new int [] {100, 600};  // начало координат на рисунке



        /*
        Scanner num = new Scanner(System.in);

        // ВВОД ДАННЫХ

        // Данные для зрителя
        System.out.println("Введите x, H для зрителя: ");
        System.out.print("x = ");
        int x_Man = num.nextInt();
        System.out.print("H = ");
        int H_Man = num.nextInt();


        // R ( расстояние между фигурой N и оболочкой)
        System.out.print("Введите R (расстояние между фигурой N и оболочкой) = ");
        int R = num.nextInt();


        // Данные для фигуры N
        System.out.print("Введите кол-во точек фигуры N: ");
        int count_tochek_N = num.nextInt();

        int[] x_N = new int[count_tochek_N];
        int[] H_N = new int[count_tochek_N];

        System.out.println("Начните вводить координаты x, H точек:");
        for (int i = 0; i < count_tochek_N; i++) {
            System.out.print("x" + (i + 1) + " = ");
            x_N[i] = num.nextInt();
            System.out.print("H" + (i + 1) + " = ");
            H_N[i] = num.nextInt();
        }

        System.out.println("Координаты точек для фигуры N");

        for (int i = 0; i < count_tochek_N; i++) {
            System.out.print(x_N[i] + ", ");
            System.out.println(H_N[i]);
        }


        // Данные для фигуры M
        System.out.print("Введите кол-во точек фигуры M: ");
        int count_tochek_M = num.nextInt();

        int[] x_M = new int[count_tochek_M];
        int[] H_M = new int[count_tochek_M];

        System.out.println("Начните вводить координаты x, H точек:");
        for (int i = 0; i < count_tochek_M; i++) {
            System.out.print("x" + (i + 1) + " = ");
            x_M[i] = num.nextInt();
            System.out.print("H" + (i + 1) + " = ");
            H_M[i] = num.nextInt();
        }

        System.out.println("Координаты точек для фигуры M");

        for (int i = 0; i < count_tochek_M; i++) {
            System.out.print(x_M[i] + ", ");
            System.out.println(H_M[i]);
        }

        */



        int x_Man = 0;  // Координата x для зрителя
        int H_Man = 12;  // Координата H для зрителя
        x_Man = x_Man * 40 + x0H0[0];  // преобразование
        H_Man = x0H0[1] - H_Man * 40;  // преобразование
        g2D.setColor(Color.BLUE);  // цвет линии
        g2D.drawLine(x0H0[0], x0H0[1], x_Man, H_Man);  // рисуем зрителя


        // Шаблонные данные
        int[] x_N = new int[] {3, 4, 5, 6, 8, 9, 10, 11};
        int[] H_N = new int[] {0, 2, 1, 4, 4, 3, 5, 0};

        int[] x_M = new int[] {13, 13, 14, 15, 16, 17, 18, 18, 17, 16, 15, 14};
        int[] H_M = new int[] {0, 1, 2, 2, 3, 3, 2, 1, 0, 1, 0, 1};

        int count_tochek_N = x_N.length;  // кол-во точек фигуры N


        int R = 1;  // расстояние от фигуры N и до оболочки

        R = R*40;  // преобразование

        for (int i=0; i<x_N.length; i++) {  // преобразование N (для рисования)
            x_N[i] = (x_N[i] * 40) + x0H0[0];  // увеличиваем и смещаем
            H_N[i] = x0H0[1] - (H_N[i] * 40);  // перевёрнуто
        }

        for (int i=0; i<x_N.length-1; i++) {  // рисуем N
            g2D.setColor(Color.BLACK);
            g2D.drawLine(x_N[i], H_N[i], x_N[i+1], H_N[i+1]);  // линии
            g2D.drawOval(x_N[i]-R, H_N[i]-R, R*2, R*2);  // круги
        }

        for (int i=0; i<x_M.length; i++) {  // преобразование M (для рисования)
            x_M[i] = (x_M[i] * 40) + x0H0[0];  // увеличиваем и смещаем
            H_M[i] = x0H0[1] - (H_M[i] * 40);  // перевёрнуто
        }

        for (int i=0; i<x_M.length-1; i++) {  // рисуем M
            g2D.setColor(Color.BLACK);
            g2D.drawLine(x_M[i], H_M[i], x_M[i+1], H_M[i+1]);  // линии
        }

        // Дорисовка последних линий
        g2D.setColor(Color.BLACK);
        g2D.drawLine(x_N[x_N.length-1], H_N[x_N.length-1], x_N[0], H_N[0]); // фигуры N (соединяем последнюю точку с первой)
        g2D.drawOval(x_N[x_N.length-1]-R, H_N[x_N.length-1]-R, R*2, R*2);  // окружность последней точки
        g2D.drawLine(x_M[x_M.length-1], H_M[x_M.length-1], x_M[0], H_M[0]);  // фигуры M (соединяем последнюю точку с первой)



        // 1 ЧАСТЬ ЗАДАНИЯ.


        // Координаты точек оболочки
        List<Integer> x_obolochka = new ArrayList<Integer>();  // координаты x оболочки
        List<Integer> H_obolochka = new ArrayList<Integer>();  // координаты H оболочки
        List<Integer> need_tochki = new ArrayList<Integer>();  // записываем нужные точки фигуры N (это нужно для нахождения длины дуги)

        // Начало оболочки
        x_obolochka.add(x_N[0]-R);  // первое значения x
        H_obolochka.add(x0H0[1]);  // первое значение H
        need_tochki.add(0);  // добавляем первую точку (так как с неё всё начинается)

        double P = 0; // оптимальный периметр

        int [] main_begin = new int [] {x_N[0], H_N[0]};  // Точка, в которой мы сейчас находимся (в данном случае - первая точка фигуры N)

        count_tochek_N -= 1;  // сколько осталось точек для рассмотрения



        while (count_tochek_N>0)  // пока есть точки для рассмотрения, то

        {

            double hot_tochka_znach = Math.toDegrees(Math.atan2(H_N[H_N.length-count_tochek_N] - main_begin[1], x_N[x_N.length-count_tochek_N] - main_begin[0]));  // угол для ближайшей точки
            int hot_tochka_index = x_N.length-count_tochek_N;  // индекс нужной точки

            //System.out.println("Предпологаемая точка 1 - " + hot_tochka_znach);
            //System.out.println("hot_tochka_index =    " + hot_tochka_index);
            //System.out.println("count_tochek_N = " + (count_tochek_N));

            for (int i = x_N.length-count_tochek_N + 1; i < x_N.length; i++) { // рассматривает все оставшиеся точки
                double maybe_tochki_in_gradus = Math.toDegrees(Math.atan2(H_N[i] - main_begin[1], x_N[i] - main_begin[0]));  // получаем угол
                if (hot_tochka_znach > maybe_tochki_in_gradus) {  // если новый угол лучше предыдущего
                    hot_tochka_znach = maybe_tochki_in_gradus;  // старый угол = новый угол
                    hot_tochka_index = i;  // заменяем индекс на новый
                }
                //System.out.println("Предпологаемая точка " + i + " - " + maybe_tochki_in_gradus);
            }

            //System.out.println("В итоге hot_tochka_znach = " + hot_tochka_znach);
            //System.out.println("В итоге hot_tochka_index = " + hot_tochka_index + "\n");
            need_tochki.add(hot_tochka_index);  // добавляем индекс в массив с индексами (для дуги)


            // Перпендикулярные линии
            x_obolochka.add((int) (x_N[x_N.length-count_tochek_N-1] - (Math.cos(Math.toRadians(90 + hot_tochka_znach))) * R));  // находим координату x новой точки оболочки
            H_obolochka.add((int) (H_N[H_N.length-count_tochek_N-1] - (Math.sin(Math.toRadians(90 + hot_tochka_znach))) * R));  // находим координату H новой точки оболочки

            g2D.drawLine(x_N[x_N.length-count_tochek_N-1], H_N[H_N.length-count_tochek_N-1], x_obolochka.get(x_obolochka.size() - 1), H_obolochka.get(H_obolochka.size() - 1));  // рисуем перпендикуляр


            x_obolochka.add(x_N[hot_tochka_index] - (x_N[x_N.length-count_tochek_N-1] - x_obolochka.get(x_obolochka.size() - 1)));  // находим координату x новой точки оболочки
            H_obolochka.add(H_N[hot_tochka_index] - (H_N[H_N.length-count_tochek_N-1] - H_obolochka.get(H_obolochka.size() - 1)));  // находим координату H новой точки оболочки

            g2D.drawLine(x_N[hot_tochka_index], H_N[hot_tochka_index], x_obolochka.get(x_obolochka.size() - 1), H_obolochka.get(H_obolochka.size() - 1));  // рисуем перпендикуляр


            count_tochek_N = (x_N.length - 1) - hot_tochka_index;  // оставшееся кол-во точек

            main_begin[0] = x_N[hot_tochka_index];  // меняем координату x рассмотрения
            main_begin[1] = H_N[hot_tochka_index];  // меняем координату H рассмотрения

        }


        // Конец оболочки
        x_obolochka.add(x_N[x_N.length-1]+R);  // добавляем координату x последней точки оболочки
        H_obolochka.add(x0H0[1]);  // добавляем координату H последней точки оболочки
        need_tochki.add(x_N.length-1);  // последняя подходящая точка


        // Считаем перимерт оболочки

        int j = 0;
        int main_ugol = 0;  // угол дуги
        for (int i=0; i<x_obolochka.size()-1; i++) {  // соединяем точки оболочки

            if (i%2 == 0) {  // дуги

                if (i==0) {  // первая дуга
                    int ugol1 = (int)(Math.toDegrees(Math.atan2(H_N[need_tochki.get(j)] - H_obolochka.get(i), x_N[need_tochki.get(j)] - x_obolochka.get(i))));  // находим промежуточный угол
                    main_ugol = 90 - ugol1;  // дополнительный расчёт (угол дуги)
                }
                else if (i==x_obolochka.size()-2){  // последняя дуга
                    int ugol1 = (int)(Math.toDegrees(Math.atan2(H_N[need_tochki.get(j)] - H_obolochka.get(i), x_N[need_tochki.get(j)] - x_obolochka.get(i))));  // находим промежуточный угол
                    main_ugol = 180 - ugol1; // дополнительный расчёт (угол дуги)
                }
                else {  // все остальные дуги
                    int ugol1 = (int)(Math.toDegrees(Math.atan2(H_N[need_tochki.get(j)] - H_obolochka.get(i), x_N[need_tochki.get(j)] - x_obolochka.get(i))));  // находим промежуточный угол
                    int ugol2 = (int)(Math.toDegrees(Math.atan2(H_N[need_tochki.get(j)] - H_obolochka.get(i+1), x_N[need_tochki.get(j)] - x_obolochka.get(i+1))));  // находим промежуточный угол
                    main_ugol = ugol2-ugol1;  // дополнительный расчёт (угол дуги)
                    g2D.setColor(Color.cyan);
                }

                //System.out.println("Угол main при " + j + " = " + main_ugol);
                P += (Math.PI * R * main_ugol)/180;  // подсчёт периметра для дуг
                j++;

            }
            else {  // прямые
                g2D.setColor(Color.cyan);  // цвет линии
                g2D.drawLine(x_obolochka.get(i), H_obolochka.get(i), x_obolochka.get(i + 1), H_obolochka.get(i + 1));  // рисуем линию
                P += Math.pow((Math.pow((x_obolochka.get(i + 1)-x_obolochka.get(i)), 2)+Math.pow((H_obolochka.get(i + 1)-H_obolochka.get(i)), 2)), 0.5);  // периметр для прямых
            }
        }


        //System.out.println("1) Оптимальный периметр P (при увеличенных размерах) = " + P);  // Оптимальный периметр
        System.out.println("1) Оптимальный периметр P (при реальных размерах) = " + (P/40));  // Оптимальный периметр



        // 2 ЧАСТЬ ЗАДАНИЯ.


        // Находим максимальную высоту оболочки
        int max_H_obolochki = H_obolochka.get(0);  // по координате H
        int then_x_obolochki = 0;  // при этом координата x
        // Пробегаем, заменяем
        for (int i=1; i<H_obolochka.size(); i++) {
            if (H_obolochka.get(i) < max_H_obolochki) {
                max_H_obolochki = H_obolochka.get(i);
                then_x_obolochki = x_obolochka.get(i);
            }
        }

        // Находим максимальную H фигуры M
        int max_H_M = H_M[0];  // по координате H
        int then_x_M = 0;  // при этом координата x
        // Пробегаем, заменяем
        for (int i=1; i<H_M.length; i++) {
            if (H_M[i] < max_H_M) {
                max_H_M = H_M[i];
                then_x_M = x_M[i];
            }
        }

        // Смотрим, что получилось

        //System.out.println("\nH_Man = " + H_Man);
        //System.out.println("max_H_obolochki = " + max_H_obolochki);
        //System.out.println("max_H_M = " + max_H_M);

        //System.out.println("\nx_Man = " + x_Man);
        //System.out.println("then_x_obolochki = " + then_x_obolochki);
        //System.out.println("then_x_M = " + then_x_M);


        double kof = 0.0;  // спец. коэффициент

        if (H_Man < max_H_obolochki) {  // если зритель выше оболочки

            kof = (((double)then_x_M+(double)x_Man)/(double)then_x_obolochki);  // считаем коэффициент
            //System.out.println(kof);

            if ((max_H_M+H_Man)/kof < max_H_obolochki) {  // если линия от зрителя до фигуры M проходит выше максимальной точки оболочки
                System.out.println("2) Зритель увидит фигуру M");
                g2D.setColor(Color.green);  // цвет линии
                g2D.drawLine(x_Man, H_Man, then_x_M, max_H_M);  // рисуем линию
            }
            else{  // если нет (проходит ниже или наравне), то
                System.out.println("2) Зритель не увидит фигуру M");
                g2D.setColor(Color.red);  // цвет линии
                g2D.drawLine(x_Man, H_Man, then_x_M, max_H_M);  // рисуем линию
            }
        }


        else {  // если нет (зритель ниже или наравне с оболочкой), то

            if ((H_Man-max_H_obolochki) < (max_H_obolochki-max_H_M)) {  // Если расстояние (по H) между зрителем и оболочкой меньше расстояния (по H) между оболочкой и фигурой M
                System.out.println("2) Зритель увидит фигуру M");
                g2D.setColor(Color.green);  // цвет линии
                g2D.drawLine(x_Man, H_Man, then_x_M, max_H_M);  // рисуем линию
            }
            else {  // если нет (расстояние (по H) больше или равно), то
                System.out.println("2) Зритель не увидит фигуру M");
                g2D.setColor(Color.red);  // цвет линии
                g2D.drawLine(x_Man, H_Man, then_x_M, max_H_M);  // рисуем линию
            }
        }
    }
}
