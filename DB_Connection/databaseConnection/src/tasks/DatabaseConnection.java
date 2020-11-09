package tasks;

import java.sql.*;
import java.util.Scanner;

public class DatabaseConnection {

        String url = "jdbc:mysql://127.0.0.1:3306/classicmodels?user=root&password=swiftA123&useSSL=false";
        Statement statement;
        ResultSet resultSet;
        Scanner input = new Scanner(System.in);
    int x;



        public DatabaseConnection() {
            try {
                Connection connection = DriverManager.getConnection(url);
                statement = connection.createStatement();

            } catch (SQLException ex) {
                System.out.println("Connection failed!");
            }
        }



        public void getOrders() {

            try {
                resultSet = statement.executeQuery(
                        "select * from orders");
            }catch (SQLException ex){
                System.out.println("QUERY failed!");
            }
            try {
                while (resultSet.next()) {
                    System.out.println("ORDERS:  "
                            + resultSet.getInt(1)+ ",  "
                            + resultSet.getString(2)+ ",  "
                            + resultSet.getString(3)+ ",  "
                            + resultSet.getString(4)+ ",  "
                            + resultSet.getString(5)+ ",  "
                            + resultSet.getString(6)+ ",  "
                            + resultSet.getInt(7)
                    );
                }
            }catch (SQLException ex){
                System.out.println("resultset failed!");
            }
        }



        public void update(String update){

            System.out.println("input the order number:");
            int orderN = input.nextInt();

String s = "UPDATE orders SET status = '" + update + "' WHERE orderNumber = '" +orderN + "' ";

            try{
                x=statement.executeUpdate(s);
                System.out.println(x);
            }catch(SQLException ex) {
                System.out.println("problem");
            }
        }
}
