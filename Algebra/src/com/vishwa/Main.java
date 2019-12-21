package com.vishwa;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of co-ordinates : ");
        int number = scanner.nextInt();
        input(scanner, number);
        Data.xMean = mean(Data.xCoordinate);
        Data.yMean = mean(Data.yCoordinate);
        calculateSigmadxdy();
        calculateSigmadx2();
        Data.b = Data.sigmadxdy / Data.sigmadx2;
        Data.a = Data.yMean - (Data.b)*(Data.xMean);
        System.out.println("The required linear model is  y = " + Data.a + " + (" + Data.b + ")x");
    }

    private static void input(Scanner scanner, int number) {
        int count = 0;
        Data.xCoordinate = new double[number];
        Data.yCoordinate = new double[number];
        for(int i=0;i<number;i++){
            System.out.print("Enter the x & y co-ordinates : ");
            String[] temp = scanner.next().split(",");
            Data.xCoordinate[count] = Double.parseDouble(temp[0]);
            Data.yCoordinate[count++] = Double.parseDouble(temp[1]);
        }
    }

    private static double mean(double[] data){
        for(int i=1;i<data.length;i++){
            data[0] += data[i];
        }
        return data[0];
    }

    private static void calculateSigmadxdy(){
        Data.sigmadxdy = 0;
        for(int i=0;i<Data.xCoordinate.length;i++){
            Data.sigmadxdy += (Data.xCoordinate[i] - Data.xMean)*(Data.yCoordinate[i] - Data.yMean);
        }
    }

    private static void calculateSigmadx2(){
        Data.sigmadx2 = 0;
        for(int i=0;i<Data.yCoordinate.length;i++){
            Data.sigmadx2 += (Data.xCoordinate[i] - Data.xMean)*(Data.xCoordinate[i] - Data.xMean);
        }
    }
}
