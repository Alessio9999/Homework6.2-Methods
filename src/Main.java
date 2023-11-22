package pro.sky;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Task1();
        Task2();
        Task3();
    }


    public static boolean isLeapYear(int year) {
        int firstLeapYear = 1584;
        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) && year >= firstLeapYear;
        return isLeapYear;
    }

    public static String getRequiredVersionOS(byte OS, int Year) {
        String answerStr;
        int currentYear = LocalDate.now().getYear();
        if (OS == 0)
            if (Year >= currentYear) answerStr = "Установите версию приложения для iOS по ссылке";
            else answerStr = "Установите облегченную версию приложения для iOS по ссылке";
        else
            if (OS == 1)
                if(Year >= currentYear) answerStr = "Установите версию приложения для Android по ссылке";
                else answerStr = "Установите облегченную версию приложения для Android по ссылке";
            else answerStr = "Такая ОС не поддерживается...";
        return answerStr;
    }

    public static byte getDeliveryDays(short distance) {
        byte days;
        if (distance <= 20) days = 1;
        else
            if (distance <= 60) days = 2;
            else
                if (distance <= 100) days = 3;
                else days = 0;
        return days;
    }

    public static void Task1() {
        System.out.println("\nЗадача 1:");

        int year = 2021;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите год: ");
        if (scanner.hasNextShort()) year = scanner.nextShort();
        else System.out.println("Вы ввели некорректное число, поэтому по умолчанию год выбран " + year);

        if (isLeapYear(year)) System.out.println(year + " год является високосным");
        else System.out.println(year + " год НЕ является високосным");
    }

    public static void Task2() {
        System.out.println("\nЗадача 2:");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите Вашу OS (0 или 1), где 0 - iOS, 1 - Android: ");
        byte clientOS = -1;
        if (scanner.hasNextByte()) clientOS = scanner.nextByte();
        else System.out.println("Вы ввели некорректное число!");

        System.out.println("Укажите год производства Вашего телефона: ");
        int deviceYear=2010;
        scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) deviceYear = scanner.nextInt();
        else System.out.println("Вы ввели некорректное число, поэтому устройство будет считаться "
                + deviceYear + " года производства");

        System.out.println(getRequiredVersionOS(clientOS, deviceYear));
    }


    public static void Task3() {
        System.out.println("\nЗадача 3:");

        short deliveryDistance = 95;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите расстояние от офиса до адреса доставки: ");
        if (scanner.hasNextShort()) deliveryDistance = scanner.nextShort();
        else System.out.println("Вы ввели некорректное число, поэтому по умолчанию расстояние доставки равно "
                + deliveryDistance + " км");

        String answerStr = "";
        byte deliveryDays = getDeliveryDays(deliveryDistance);
        if (deliveryDays>0) answerStr = "Потребуется дней на доставку: " + deliveryDays;
        else answerStr = "На такое расстояние доставки нет...";
        System.out.println(answerStr);
    }

}