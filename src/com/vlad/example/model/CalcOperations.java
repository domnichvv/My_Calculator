package com.vlad.example.model;

/**
 * Created by Влад on 09.11.2016.
 */
public class CalcOperations {

    /**
     * Метод складывает два числа
     * @param a 1-е число
     * @param b 2-е число
     * @return возвращает результат от сложения
     */
    public static double add(double a, double b){ //сложение
        return a + b;
    }

    /**
     * Метод вычитает из одного числа другое
     * @param a 1-е число
     * @param b 2-е число
     * @return возвращает результат от вычитания
     */
    public static double substract(double a, double b){ //вычитание
        return a - b;
    }

    /**
     * Метод умножает два числа
     * @param a 1-е число
     * @param b 2-е число
     * @return возврращает результат от вычитания
     */
    public static double multiply(double a , double b){ //умножение
        return a * b;
    }

    /**
     * Метод делит одно число на другое
     * @param a 1-е число
     * @param b 2-е число
     * @return возвращает результат от деления
     */
    public static double divide(double a, double b){ //деление
        return a / b;
    }
}
