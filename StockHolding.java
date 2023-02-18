import java.util.Scanner;
/**
 * This class will hold information about a stock.
 *
 * @author Tyler
 * @version 2/23/23
 */
public class StockHolding
{
    Scanner input = new Scanner(System.in);
    private String symbol;
    private String name;
    private int numShares;
    private int price;
    public StockHolding(String symbol, String name, int numShares, int price) {
        this.symbol = symbol;
        this.name = name;
        this.numShares = numShares;
        this.price = price;
    }

    /**
     * Returns the stock symbol
     * 
     * @return symbol
     * 
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Returns the stock name
     * 
     * @return name
     * 
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the number of stock shares
     * 
     * @return number of stock shares
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
    public int getPrice() {
        return price;
    }

    /**
     * Determines the price to buy a share
     * 
     * @param shares, price per share
     * @return price to buy shares
     * 
     */
    public int buyShares(int shares, int pricePerShare)
    {
        return shares*pricePerShare;
    }

    /**
     * Determines price for selling shares
     * 
     * @param shares
     * @return symbol
     * 
     */
    public int sharesToSell(int shares)
    {
        return shares*price;
    }

    /**
     * Returns the method to string
     * 
     * @return toString
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
