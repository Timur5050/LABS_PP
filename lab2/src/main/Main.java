package main;

import customers.Customer;

import java.util.*;

public class Main {
    public static void customersMethod()
    {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Customer> customerList = new ArrayList<>();
        while (true)
        {
            System.out.print("""
                    What do you want to do:
                    0 - fill massive with hard-coded values
                    1 - add new customer to massive
                    2 - list of customers with specific name
                    3 - list of customers whose credit card number is in the specified interval
                    4 - amount and list of customers that have negative balance
                    5 - list of all customers
                    6 - leave
                     :
                    """);

            String ask = scanner.next();
            if(Objects.equals(ask, "6")) break;
            switch(ask)
            {
                case "0":
                    customerList.add(new Customer("ivanov", "ivan", "ivanovich", "lviv", "1234567887654321", 500));
                    customerList.add(new Customer("olexandrov", "olexandr", "olexandrovich", "khmelnitskiy", "1111222233334444", 1000));
                    customerList.add(new Customer("stukan", "timur", "olexandovich", "lviv", "5125875210742695", 9999999));
                    customerList.add(new Customer("evgenovich", "evgen", "evgenovich", "kiev", "8888999911112222", -200));
                    break;
                case "1":
                    System.out.print("enter lastname: ");
                    String lastname = scanner.next();
                    System.out.print("enter firstname: ");
                    String firstname = scanner.next();
                    System.out.print("enter middlename: ");
                    String middlename = scanner.next();
                    System.out.print("enter address: ");
                    String address = scanner.next();
                    System.out.print("enter card number: ");
                    String cardnumber = scanner.next();
                    System.out.print("enter balance: ");
                    int balance = scanner.nextInt();
                    customerList.add(new Customer(lastname, firstname, middlename, address, cardnumber, balance));
                    break;
                case "2":
                    System.out.print("enter name : ");
                    String nameToFind = scanner.next();
                    for (int i = 0; i < customerList.size(); i++)
                    {
                        if (customerList.get(i).getFirstName().equals(nameToFind))
                        {
                            System.out.println(customerList.get(i));
                        }
                    }
                    break;
                case "3":
                    System.out.print("enter lower limit of card numbers: ");
                    long low = scanner.nextLong();
                    System.out.print("enter higher limit of card numbers: ");
                    long high = scanner.nextLong();
                    for (int i = 0; i < customerList.size(); i++)
                    {
                        if (Long.parseLong(customerList.get(i).getCardNumber()) > low && Long.parseLong(customerList.get(i).getCardNumber()) < high)
                        {
                            System.out.println(customerList.get(i));
                        }
                    }
                    break;
                case "4":
                    int counter = 0;
                    for (int i = 0; i < customerList.size(); i++)
                    {
                        if (customerList.get(i).getBalance() < 0)
                        {
                            counter += 1;
                            System.out.println(customerList.get(i));
                        }
                    }
                    System.out.println("total amount of people with negative balance: " + counter);
                    break;
                case "5":
                    for (int i = 0; i < customerList.size(); i++)
                    {
                        System.out.println(customerList.get(i));
                    }
                    break;
                default:
                    System.out.println("you hae only options: (0 - 5)");
            }
        }
    }

    public static void main(String[] args) {
        customersMethod();
    }
}