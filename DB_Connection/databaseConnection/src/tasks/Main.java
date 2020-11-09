package tasks;

import java.util.Scanner;

public class Main {

    private static String update;
    private static Scanner input = new Scanner(System.in);
    private static DatabaseConnection connection = new DatabaseConnection();



    public static void main(String[] args) {
        Main obj = new Main();

        System.out.println("Do you want to see: \n ORDERS [1] \n UPDATE ORDER[2]");
        int choice = input.nextInt();


        if (choice == 1){
            connection.getOrders();

        }else if (choice == 2){

            System.out.println("is the order CANCELLED [1] or SHIPPED [2]?");
            int status = input.nextInt();

            switch (status){
                case 1:
                    update = "Cancelled";
                    connection.update(update);
                    break;

                case 2:
                    update = "Shipped";
                    connection.update(update);
                    break;
            }
        }
    }
}
