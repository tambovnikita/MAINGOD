package com.company;

import java.util.Scanner;  // ввод

// Графика
import java.awt.*;
import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {

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

        // ГРАФИКА

        new MyFrame();

    }
}
