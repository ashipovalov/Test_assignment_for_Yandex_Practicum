package net.shipovalov.assignment;

import java.util.Scanner;

public class DeliveryCostCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод данных от пользователя
        System.out.print("Введите расстояние до пункта назначения (км): ");
        int distance = scanner.nextInt();

        System.out.print("Введите габариты груза (1 - маленькие, 2 - большие): ");
        int size = scanner.nextInt();

        System.out.print("Груз хрупкий? (1 - да, 0 - нет): ");
        int isFragile = scanner.nextInt();

        System.out.print("Введите уровень загруженности службы доставки (1 - обычная, 2 - повышенная, 3 - высокая, 4 - очень высокая): ");
        int workload = scanner.nextInt();

        double cost = calculateDeliveryCost(distance, size, isFragile, workload);

        System.out.println("Стоимость доставки: " + cost + " рублей");
    }

    public static double calculateDeliveryCost(int distance, int size, int isFragile, int workload) {
        double baseCost = 0;

        if (distance > 30) {
            if (isFragile == 1) {
                System.out.println("Ошибка: хрупкие грузы нельзя возить на расстояние более 30 км.");
                return -1;
            }
            baseCost += 300;
        } else if (distance > 10) {
            baseCost += 200;
        } else if (distance > 2) {
            baseCost += 100;
        } else {
            baseCost += 50;
        }

        if (size == 2) {
            baseCost += 200;
        } else {
            baseCost += 100;
        }

        if (isFragile == 1) {
            baseCost += 300;
        }

        double workloadCoefficient = switch (workload) {
            case 2 -> 1.2;
            case 3 -> 1.4;
            case 4 -> 1.6;
            default -> 1.0;
        };

        double totalCost = baseCost * workloadCoefficient;

        if (totalCost < 400) {
            totalCost = 400;
        }

        return totalCost;
    }
}