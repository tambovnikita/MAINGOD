// https://books.trinket.io/thinkjava/appendix-b.html

package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class MyFrame extends JFrame {
    MyFrame () {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 700);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void paint(Graphics g) {

        Graphics2D g2D = (Graphics2D) g;

        int [] x0H0 = new int [] {100, 600};  // начало координат при данных условиях


        int count_tochek_N = 8;

        int x_Man = 0;
        int H_Man = 12;
        x_Man = x_Man * 40 + x0H0[0];  // преобразование
        H_Man = x0H0[1] - H_Man * 40;  // преобразование
        g2D.setColor(Color.BLUE);
        g2D.drawLine(x0H0[0], x0H0[1], x_Man, H_Man);  // рисуем зрителя


        int[] x_N = new int[] {3, 4, 5, 6, 8, 9, 10, 11};
        int[] H_N = new int[] {0, 2, 1, 4, 4, 3, 5, 0};

        int[] x_M = new int[] {13, 13, 14, 15, 16, 17, 18, 18, 17, 16, 15, 14};
        int[] H_M = new int[] {0, 1, 2, 2, 3, 3, 2, 1, 0, 1, 0, 1};


        int R = 1;  // расстояние от фигуры N и до оболочки

        R *= 40;  // преобразование

        for (int i=0; i<x_N.length; i++) {  // преобразование N
            x_N[i] = (x_N[i] * 40) + x0H0[0];
            H_N[i] = x0H0[1] - (H_N[i] * 40);  // перевёрнуто
        }

        for (int i=0; i<x_N.length-1; i++) {  // рисуем N
            g2D.setColor(Color.BLACK);
            g2D.drawLine(x_N[i], H_N[i], x_N[i+1], H_N[i+1]);
            g2D.drawOval(x_N[i]-R, H_N[i]-R, R*2, R*2);
        }

        for (int i=0; i<x_M.length; i++) {  // преобразование M
            x_M[i] = (x_M[i] * 40) + x0H0[0];
            H_M[i] = x0H0[1] - (H_M[i] * 40);  // перевёрнуто
        }

        for (int i=0; i<x_M.length-1; i++) {  // рисуем M
            g2D.setColor(Color.BLACK);
            g2D.drawLine(x_M[i], H_M[i], x_M[i+1], H_M[i+1]);
        }

        // Дорисовка последних линий
        g2D.setColor(Color.BLACK);
        g2D.drawLine(x_N[x_N.length-1], H_N[x_N.length-1], x_N[0], H_N[0]); // фигуры N
        g2D.drawOval(x_N[x_N.length-1]-R, H_N[x_N.length-1]-R, R*2, R*2);
        g2D.drawLine(x_M[x_M.length-1], H_M[x_M.length-1], x_M[0], H_M[0]);  // фигуры M



        // 1 ЧАСТЬ ЗАДАНИЯ.


        // Координаты точек оболочки
        //double [] x_obolochka = new double [] {(double)(x_N[0]-R)};
        //double [] H_obolochka = new double [] {0.0};
        List<Integer> x_obolochka = new ArrayList<Integer>();  // координата x оболочки
        List<Integer> H_obolochka = new ArrayList<Integer>();  // координа H оболочки
        List<Integer> need_tochki = new ArrayList<Integer>();  // записываем нужные точки фигуры N (это нужно для нахождения длины дуги)

        // Начало оболочки
        x_obolochka.add(x_N[0]-R);
        H_obolochka.add(x0H0[1]);
        need_tochki.add(0);

        double P = 0; // оптимальный периметр



        int [] main_begin = new int [] {x_N[0], H_N[0]};  // Точка, в которой мы сейчас находимся (в данном случае - первая точка фигуры N)

        count_tochek_N -= 1;

        while (count_tochek_N>0)

        {

            double hot_tochka_znach = Math.toDegrees(Math.atan2(H_N[H_N.length-count_tochek_N] - main_begin[1], x_N[x_N.length-count_tochek_N] - main_begin[0]));
            //System.out.println("hot_tochka_znach =    " + hot_tochka_znach);

            //System.out.println("Предпологаемая точка 1 - " + hot_tochka_znach);
            int hot_tochka_index = x_N.length-count_tochek_N;

            //System.out.println("hot_tochka_index =    " + hot_tochka_index);

            System.out.println("i < count_tochek_N = " + (count_tochek_N));

            for (int i = x_N.length-count_tochek_N + 1; i < x_N.length; i++) {
                //double maybe_tochki_in_gradus = Math.toDegrees(Math.atan2(H_N[i + 1] - main_begin[1], x_N[i + 1] - main_begin[0]));
                double maybe_tochki_in_gradus = Math.toDegrees(Math.atan2(H_N[i] - main_begin[1], x_N[i] - main_begin[0]));
                if (hot_tochka_znach > maybe_tochki_in_gradus) {
                    hot_tochka_znach = maybe_tochki_in_gradus;
                    hot_tochka_index = i;
                }
                //System.out.println("Предпологаемая точка " + i + " - " + maybe_tochki_in_gradus);
            }

            System.out.println("В итоге znach = " + hot_tochka_znach);
            System.out.println("В итоге index = " + hot_tochka_index + "\n");
            need_tochki.add(hot_tochka_index);


            // Перпендикулярная линия
            x_obolochka.add((int) (x_N[x_N.length-count_tochek_N-1] - (Math.cos(Math.toRadians(90 + hot_tochka_znach))) * R));
            H_obolochka.add((int) (H_N[H_N.length-count_tochek_N-1] - (Math.sin(Math.toRadians(90 + hot_tochka_znach))) * R));

            g2D.drawLine(x_N[x_N.length-count_tochek_N-1], H_N[H_N.length-count_tochek_N-1], x_obolochka.get(x_obolochka.size() - 1), H_obolochka.get(H_obolochka.size() - 1));


            x_obolochka.add(x_N[hot_tochka_index] - (x_N[x_N.length-count_tochek_N-1] - x_obolochka.get(x_obolochka.size() - 1)));
            H_obolochka.add(H_N[hot_tochka_index] - (H_N[H_N.length-count_tochek_N-1] - H_obolochka.get(H_obolochka.size() - 1)));

            g2D.drawLine(x_N[hot_tochka_index], H_N[hot_tochka_index], x_obolochka.get(x_obolochka.size() - 1), H_obolochka.get(H_obolochka.size() - 1));


            //System.out.println("count_tochek_N - hot_tochka_index =   " + (count_tochek_N - hot_tochka_index));

            count_tochek_N = (x_N.length - 1) - hot_tochka_index;

            main_begin[0] = x_N[hot_tochka_index];
            main_begin[1] = H_N[hot_tochka_index];

        }


        // Конец оболочки
        x_obolochka.add(x_N[7]+R);
        H_obolochka.add(x0H0[1]);
        need_tochki.add(7);


        //System.out.println("Выведем содержимое need_tochki\n");
        for (int i=0; i<need_tochki.size()-1; i++) {
            //System.out.println(need_tochki.get(i));
        }


        int j = 0;
        int main_ugol = 0;
        for (int i=0; i<x_obolochka.size()-1; i++) {

            if (i%2 == 0) {

                if (i==0) {
                    int ugol1 = (int)(Math.toDegrees(Math.atan2(H_N[need_tochki.get(j)] - H_obolochka.get(i), x_N[need_tochki.get(j)] - x_obolochka.get(i))));
                    main_ugol = 90 - ugol1;
                }
                else if (i==x_obolochka.size()-2){
                    int ugol1 = (int)(Math.toDegrees(Math.atan2(H_N[need_tochki.get(j)] - H_obolochka.get(i), x_N[need_tochki.get(j)] - x_obolochka.get(i))));
                    main_ugol = 180 - ugol1;
                }
                else {
                    int ugol1 = (int)(Math.toDegrees(Math.atan2(H_N[need_tochki.get(j)] - H_obolochka.get(i), x_N[need_tochki.get(j)] - x_obolochka.get(i))));
                    int ugol2 = (int)(Math.toDegrees(Math.atan2(H_N[need_tochki.get(j)] - H_obolochka.get(i+1), x_N[need_tochki.get(j)] - x_obolochka.get(i+1))));
                    main_ugol = ugol2-ugol1;
                    g2D.setColor(Color.cyan);
                    //System.out.println("Угол 1 при " + j + " = " + ugol1);
                    //System.out.println("Угол 2 при " + j + " = " + ugol2);
                }

                //System.out.println("Угол main при " + j + " = " + main_ugol);

                P += (Math.PI * R * main_ugol)/180;  // подсчёт периметра для дуг

                j++;
                //g2D.drawArc(x_obolochka.get(i), H_obolochka.get(i), R*2, R*2, ugol1, ugol2);

            }
            else {
                g2D.setColor(Color.cyan);
                g2D.drawLine(x_obolochka.get(i), H_obolochka.get(i), x_obolochka.get(i + 1), H_obolochka.get(i + 1));
                P += Math.pow((Math.pow((x_obolochka.get(i + 1)-x_obolochka.get(i)), 2)+Math.pow((H_obolochka.get(i + 1)-H_obolochka.get(i)), 2)), 0.5);
            }
        }



        //System.out.println("Оптимальный периметр P (при увеличенных размерах) = " + P);  // Оптимальный периметр
        System.out.println("Оптимальный периметр P (при реальных размерах) = " + (P/40));  // Оптимальный периметр




        // 2 ЧАСТЬ ЗАДАНИЯ.


        // Находим максимальную высоту оболочки
        int max_H_obolochki = H_obolochka.get(0);
        int then_x_obolochki = 0;
        for (int i=1; i<H_obolochka.size(); i++) {
            if (H_obolochka.get(i) < max_H_obolochki) {
                max_H_obolochki = H_obolochka.get(i);
                then_x_obolochki = x_obolochka.get(i);
            }
        }

        // Находим максимальную H фигуры M
        int max_H_M = H_M[0];
        int then_x_M = 0;
        for (int i=1; i<H_M.length; i++) {
            if (H_M[i] < max_H_M) {
                max_H_M = H_M[i];
                then_x_M = x_M[i];
            }
        }

        //System.out.println("\nH_Man = " + H_Man);
        //System.out.println("max_H_obolochki = " + max_H_obolochki);
        //System.out.println("max_H_M = " + max_H_M);

        //System.out.println("\nx_Man = " + x_Man);
        //System.out.println("then_x_obolochki = " + then_x_obolochki);
        //System.out.println("then_x_M = " + then_x_M);



        double kof = 0.0;

        if (H_Man < max_H_obolochki) {

            kof = (((double)then_x_M+(double)x_Man)/(double)then_x_obolochki);
            //System.out.println(kof);

            if ((max_H_M+H_Man)/kof < max_H_obolochki) {
                System.out.println("Зритель увидит фигуру M");
                g2D.setColor(Color.green);
                g2D.drawLine(x_Man, H_Man, then_x_M, max_H_M);
            }
            else{
                System.out.println("Зритель не увидит фигуру M");
                g2D.setColor(Color.red);
                g2D.drawLine(x_Man, H_Man, then_x_M, max_H_M);
            }
        }


        else {

            if ((H_Man-max_H_obolochki) < (max_H_obolochki-max_H_M)) {
                System.out.println("Зритель увидит фигуру M");
                g2D.setColor(Color.green);
                g2D.drawLine(x_Man, H_Man, then_x_M, max_H_M);
            }
            else {
                System.out.println("Зритель не увидит фигуру M");
                g2D.setColor(Color.red);
                g2D.drawLine(x_Man, H_Man, then_x_M, max_H_M);
            }
        }

    }

}
