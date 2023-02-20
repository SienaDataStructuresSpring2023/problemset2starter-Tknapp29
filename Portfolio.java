import java.util.ArrayList;
import java.util.Scanner; 
/**
 * This class takes the stock class and makes a portfolio with them with what the user does with the stock.
 *
 * @author Tyler
 * @version Spring 2023
 */
public class Portfolio
{
    public ArrayList<StockHolding> stocks;
    private double lifeTime;
    private double lifeTimePayout;

    public Portfolio()
    {
        stocks = new ArrayList<StockHolding>();
        this.lifeTime = 0.0;
        this.lifeTimePayout = 0.0;
    }

    /**
     * Returns the users lifetime stock purchases
     * @return the users lifetime stock purchases
     */
    public double getLifeTime()
    {
        return lifeTime;
    }

    /**
     * returns the users lifetime stock sells
     * @returns the users lifetime stock sells
     */
    public double getLifeTimePayout()
    {
        return lifeTimePayout;
    }

    /**
     * This method will buy stock shares with however many shares and price the user inputs. It will search the array list to see if can find the stock and if it cannot, the stock will be added
     * The method will also update users the lifetime values
     * @param symbol, name, numShares, pricePerShare
     * @return finalPrice
     */
    public double buyStock(String symbol, String name, int numShares,double pricePerShare)
    {
        double finalPrice = 0.0;
        int index = getIndex(symbol);
        if(index != -1)
        {
            finalPrice = stocks.get(index).buyShares(numShares,pricePerShare);
        }
        else
        {
            StockHolding newStock = new StockHolding(symbol, name, numShares, pricePerShare);
            stocks.add(newStock);
            finalPrice = numShares*pricePerShare;
        }
        lifeTime = lifeTime + finalPrice;
        return finalPrice;

    }

    /**
     * This method will sell stock shares with however many shares the user inputs. if the shares are less than or equal to 0, the stock will be removed from the array list
     * The method will also update the users lifetime values
     * @param symbol,shares
     * @return finalPrice
     */
    public double sellStock(String symbol, int shares)
    {
        double finalPrice = 0.0;
        int index = getIndex(symbol);
        if(index != -1)
        {
            if(stocks.get(index).getNumShares() <= 0)
            {
                stocks.remove(index);
            }
            else
            {
                finalPrice = stocks.get(index).sellShares(shares);
            }
            lifeTimePayout = lifeTimePayout + finalPrice;
        }
        return finalPrice;
    }

    /**
     * Gets users current value
     * @returns currentValue
     */
    public double getCurrentValue()
    {
        double currentValue = 0.0;
        for(StockHolding s : stocks)
        {
            currentValue = currentValue + s.getNumShares()*s.getPrice();
        }
        return currentValue;
    }

    /**
     * Gets the index of the stock on the array list where the symbol is located
     * @param symbol
     * @returns -1 or index of stock
     */
    private int getIndex(String symbol)
    {
        int i =0;
        for(StockHolding s : stocks)
        {
            if(s.getSymbol().equals(symbol))
            {
                return i;
            }
            i++;
        }    
        return -1;
    }

    /**
     * returns the method toString
     * @returns the method toString
     */
    @Override
    public String toString()
    {
        //DO NOT EDIT THIS METHOD.
        StringBuffer sb = new StringBuffer();
        sb.append(String.format("%6s%25s%10s%15s%15s%n", 
                "Symbol", "Name", "Shares", "@Price", "Total"));
        sb.append("-----------------------------------------------------------------------\n");

        for(StockHolding s : stocks){
            sb.append(s.toString());
        }
        return sb.toString();
    }
}
