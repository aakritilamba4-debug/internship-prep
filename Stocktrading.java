import java.util.*;
import java.io.*;

class stock 
{
    String name;
    double price;

    stock(String name, double price) 
    {
        this.name = name;
        this.price = price;
    }
}

class user
{

    double balance = 10000;

    HashMap<String, Integer> portfolio = new HashMap<>();

    ArrayList<String> history = new ArrayList<>();

    void buyStock(stock stock, int quantity) 
    {

        double total = stock.price * quantity;

        if (balance >= total)
        {

            balance = balance - total;

            if (portfolio.containsKey(stock.name)) 
            {

                int oldQty = portfolio.get(stock.name);

                portfolio.put(stock.name, oldQty + quantity);

            }
            else 
            {

                portfolio.put(stock.name, quantity);
            }

            history.add("Bought " + quantity + " shares of " + stock.name);

            System.out.println("stock bought sccessfully");

        } 
        else 
        {

            System.out.println("not enough balance");
        }
    }

    void sellstock(stock stock, int quantity) 
    {

        if (portfolio.containsKey(stock.name)) 
        {

            int oldQty = portfolio.get(stock.name);

            if (oldQty >= quantity) 
            {

                portfolio.put(stock.name, oldQty - quantity);

                balance = balance + (stock.price * quantity);

                history.add("Sold " + quantity + " shares of " + stock.name);

                System.out.println("ssock sold successfully");

            } 
            else 
            {

                System.out.println("not enough shares");
            }

        } 
        else 
        {

            System.out.println("stock not found in portfolio");
        }
    }

    void showportfolio() 
    {

        System.out.println("\n----- PORTFOLIO -----");

        if (portfolio.isEmpty()) 
        {

            System.out.println("no stocks purchased");

        } 
        else 
        {

            for (String stock : portfolio.keySet()) 
            {

                System.out.println(stock + " : " + portfolio.get(stock) + " shares");
            }
        }
    }

    void showhistory() 
    {

        System.out.println("transtition history");

        if (history.isEmpty()) 
        {

            System.out.println("no transactions");

        } 
        else 
        {

            for (String s : history) 
            {

                System.out.println(s);
            }
        }
    }

    void showbalance() 
    {

        System.out.println("current balance : $" + balance);
    }

    void savedata() 
    {

        try 
        {

            FileWriter fw = new FileWriter("portfolio.txt");

            for (String stock : portfolio.keySet()) 
            {

                fw.write(stock + " : " + portfolio.get(stock) + " shares\n");
            }

            fw.close();

            System.out.println("portfolio saved");

        } 
        catch (Exception e) 
        {

            System.out.println("error saving file");
        }
    }
}

public class Stocktrading 
{

    public static void main(String[] args) 
    {

        Scanner sc = new Scanner(System.in);

        
        user user = new user();

        int choice;

        do 
        {

            System.out.println("====== STOCK TRADING PLATFORM =====");

            System.out.println("1. View Market");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. View Transactions");
            System.out.println("6. View Balance");
            System.out.println("7. Save Portfolio");
            System.out.println("0. Exit");

            System.out.print("Enter Choice : ");

            choice = sc.nextInt();

            switch (choice) 
            {

                
case 1:

    System.out.print("Enter number of stocks : ");
    int n = sc.nextInt();

    stock[] stocks = new stock[n];

    for(int i = 0; i < n; i++)
    {
        System.out.print("Enter Stock Name : ");
        String stockName = sc.next();

        System.out.print("Enter Stock Price : ");
        double stockPrice = sc.nextDouble();

        stocks[i] = new stock(stockName, stockPrice);
    }

    System.out.println("\nAvailable Stocks");

    for(int i = 0; i < n; i++)
    {
        System.out.println((i + 1) + ". " +
                stocks[i].name + " : $" +
                stocks[i].price);
    }

    break;

                
case 2:

    System.out.print("How many stocks do you want to add : ");
    int total = sc.nextInt();

    stock[] stocks2 = new stock[total];

    for(int i = 0; i < total; i++)
    {
        System.out.print("Enter Stock Name : ");
        String name = sc.next();

        System.out.print("Enter Stock Price : ");
        double price = sc.nextDouble();

        stocks2[i] = new stock(name, price);
    }

    System.out.println("\nSelect Stock");

    for(int i = 0; i < total; i++)
    {
        System.out.println((i + 1) + ". " +
                stocks2[i].name);
    }

    int buyChoice = sc.nextInt();

    System.out.print("Enter Quantity : ");
    int buyQty = sc.nextInt();

    if(buyChoice >= 1 && buyChoice <= total)
    {
        user.buyStock(stocks2[buyChoice - 1], buyQty);
    }
    else
    {
        System.out.println("Invalid Choice");
    }

    break;

                // ===== CASE 3 =====

case 3:

    System.out.print("How many stocks do you want to add : ");
    int totalSell = sc.nextInt();

    stock[] stocks3 = new stock[totalSell];

    for(int i = 0; i < totalSell; i++)
    {
        System.out.print("Enter Stock Name : ");
        String name = sc.next();

        System.out.print("Enter Stock Price : ");
        double price = sc.nextDouble();

        stocks3[i] = new stock(name, price);
    }

    System.out.println("\nSelect Stock");

    for(int i = 0; i < totalSell; i++)
    {
        System.out.println((i + 1) + ". " +
                stocks3[i].name);
    }

    int sellChoice = sc.nextInt();

    System.out.print("Enter Quantity : ");
    int sellQty = sc.nextInt();

    if(sellChoice >= 1 && sellChoice <= totalSell)
    {
        user.sellstock(stocks3[sellChoice - 1], sellQty);
    }
    else
    {
        System.out.println("Invalid Choice");
    }

    break;

                case 0:

                    System.out.println("Program Ended");

                    break;

                default:

                    System.out.println("Wrong Choice");
            }

        } 
        while (choice != 0);

        sc.close();
    }
}
