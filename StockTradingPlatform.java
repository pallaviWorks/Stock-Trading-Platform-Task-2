import java.util.ArrayList;
import java.util.Scanner;

class Stock {
    String name;
    double price;

    Stock(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class Portfolio {
    double balance;
    ArrayList<String> ownedStocks = new ArrayList<>();

    Portfolio(double balance) {
        this.balance = balance;
    }

    void buyStock(Stock stock) {
        if (balance >= stock.price) {
            balance -= stock.price;
            ownedStocks.add(stock.name);
            System.out.println("Bought: " + stock.name);
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    void sellStock(Stock stock) {
        if (ownedStocks.contains(stock.name)) {
            balance += stock.price;
            ownedStocks.remove(stock.name);
            System.out.println("Sold: " + stock.name);
        } else {
            System.out.println("You don't own this stock.");
        }
    }

    void showPortfolio() {
        System.out.println("\n----- Portfolio -----");
        System.out.println("Balance: ₹" + balance);
        System.out.println("Owned Stocks: " + ownedStocks);
    }
}

public class StockTradingPlatform {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Stock stock1 = new Stock("TCS", 3500);
        Stock stock2 = new Stock("Infosys", 1800);
        Stock stock3 = new Stock("Reliance", 2500);

        Portfolio user = new Portfolio(10000);

        while (true) {
            System.out.println("\n===== STOCK TRADING PLATFORM =====");
            System.out.println("1. View Market");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\nAvailable Stocks:");
                    System.out.println("1. TCS - ₹3500");
                    System.out.println("2. Infosys - ₹1800");
                    System.out.println("3. Reliance - ₹2500");
                    break;

                case 2:
                    System.out.println("Choose Stock:");
                    System.out.println("1. TCS");
                    System.out.println("2. Infosys");
                    System.out.println("3. Reliance");

                    int buyChoice = sc.nextInt();

                    if (buyChoice == 1)
                        user.buyStock(stock1);
                    else if (buyChoice == 2)
                        user.buyStock(stock2);
                    else if (buyChoice == 3)
                        user.buyStock(stock3);
                    else
                        System.out.println("Invalid Choice!");
                    break;

                case 3:
                    System.out.println("Choose Stock:");
                    System.out.println("1. TCS");
                    System.out.println("2. Infosys");
                    System.out.println("3. Reliance");

                    int sellChoice = sc.nextInt();

                    if (sellChoice == 1)
                        user.sellStock(stock1);
                    else if (sellChoice == 2)
                        user.sellStock(stock2);
                    else if (sellChoice == 3)
                        user.sellStock(stock3);
                    else
                        System.out.println("Invalid Choice!");
                    break;

                case 4:
                    user.showPortfolio();
                    break;

                case 5:
                    System.out.println("Thank You!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}