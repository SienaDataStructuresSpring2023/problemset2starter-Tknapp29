import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This program creates a portfolio by reading the transactions in
 * the file transactions.txt and buying and selling stock shares
 * accordingly. Then, this program prints the portfolio report
 * as described in the problem set 2 instructions.
 *
 * @author Tyler Knapp
 * @version Spring 2023
 */
public class PortfolioReport
{
    /**
     * This program creates a portfolio by reading the transactions in
     * the file transactions.txt and buying and selling stock shares
     * accordingly.  Then, this program prints the portfolio report
     * as described in the problem set 2 instructions.
     * 
     * @param args No command line arguments required.
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner file = new Scanner(new File("transactions.txt"));        
        Portfolio p = new Portfolio();

        while(file.hasNext()){
            String line = file.nextLine();
            String[] data = line.split(",");
            if(data[0].equals("B")){
                String symbol = data[1];
                String name = data[2];
                String theNumShares = data[3].trim();
                String thePrice = data[4].trim();
                int numShares = Integer.valueOf(theNumShares);
                double price =  Double.valueOf(thePrice);
                p.buyStock(symbol,name,numShares,price);
            } else {
                String symbol = data[1];
                String theNumShares = data[2].trim();
                int numShares = Integer.valueOf(theNumShares);
                p.sellStock(symbol,numShares);
            }
        }

        System.out.print(p);
        System.out.println();
        
        // Uncomment the lines of code below and complete the print statements to work as intended.
         System.out.println(String.format("      Current Value:  $%,15.2f", p.getCurrentValue()));
         System.out.println(String.format("Lifetime Investment:  $%,15.2f", p.getLifeTime()));
         System.out.println(String.format("    Lifetime Payout:  $%,15.2f", p.getLifeTimePayout()));
    }
}
