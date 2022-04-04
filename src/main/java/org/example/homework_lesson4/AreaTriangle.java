package org.example.homework_lesson4;
import java.util.Scanner;



public class AreaTriangle {

    public static void main(String args[]) {
        double side;
        double height;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Сторона треугольника: ");
        side = scanner.nextDouble();

        System.out.println("Высота треугольника: ");
        height = scanner.nextDouble();

        double area = calcTriangleTest(side, height);
        System.out.println("Площадь треугольника равна: " + area);
    }

    protected static double calcTriangleTest(double side, double height) {
        return  (side * height) / 2;
    }
}