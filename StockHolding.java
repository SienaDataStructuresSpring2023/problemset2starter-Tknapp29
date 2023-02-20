import java.util.Scanner;
/**
 * This class will hold information about a stock.
 *
 * @author Tyler
 * @version Spring 2023
 */
public class StockHolding
{
    Scanner input = new Scanner(System.in);
    private String symbol;
    private String name;
    private int numShares;
    private double price;

    public StockHolding(String symbol, String name, int numShares, double price) {
        this.symbol = symbol;
        this.name = name;
        this.numShares = numShares;
        this.price = price;
    }

    /**
     * Returns the stock symbol
     * 
     * @return the stock symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Returns the stock name
     * 
     * @return the stock name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the number of stock shares
     * 
     * @return the number of stock shares
     * 
     */
    public int getNumShares() {
        return numShares;
    }

    /**
     * Returns the stock price
     * 
     * @return the stock price
     * 
     */
    public double getPrice() {
        return price;
    }

    /**
     * Determines the price to buy a share
     * 
     * @param shares, price per share
     * @return price to buy shares
     * 
     */
    public double buyShares(int shares, double pricePerShare)
    {
        if(price >= pricePerShare)
        {
            price = pricePerShare;
        }
        numShares += shares;
        return shares*pricePerShare;
    }

    /**
     * Determines price for selling shares
     * 
     * @param shares
     * @return symbol
     * 
     */
    public double sellShares(int shares)
    {
        if(shares <= numShares)
        {
            numShares -= shares;
            return shares*price;
        }
        return 0.0;
    }

    /**
     * Returns the method toString
     * 
     * @return the method toString
     * 
     */
    @Override
    public String toString()
    {
        //DO NOT EDIT THIS METHOD.
        return String.format("%6s%25s%,10d  $%,12.2f  $%,12.2f%n", 
            symbol, name, numShares, price, numShares * price); 
    }
}
