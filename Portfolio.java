import java.util.ArrayList;
import java.util.Scanner; 
/**
 * Write a description of class Portfolio here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Portfolio
{
    public ArrayList<StockHolding> stocks;
    private double lifeTime;
    private double lifeTimePayout;

    public Portfolio()
    {
        stocks = new ArrayList<StockHolding>();
        this.lifeTime = 0;
        this.lifeTimePayout = 0;
    }

    public double getLifeTime()
    {
        return lifeTime;
    }

    public double getLifeTimePayout()
    {
        return lifeTimePayout;
    }

    public double buyStock(String symbol, String name, int numShares,double pricePerShare)
    {
        double finalPrice = 0.0;
        if(stocks.contains(getIndex(symbol)))
        {
            finalPrice = numShares*pricePerShare;
            lifeTime = lifeTime + finalPrice;
        }
        else
        {
            StockHolding newStock = new StockHolding(symbol, name, numShares, pricePerShare);
            stocks.add(newStock);
        }
        return finalPrice;

    }

    public double sellStock(String symbol, int shares)
    {
        double finalPrice = 0.0;
        for(StockHolding s : stocks)
        {
            if(stocks.contains(getIndex(symbol)))
            {
                finalPrice = s.sharesToSell(shares);
            }
            if(s.getNumShares() <= 0)
            {
                stocks.remove(s);
            }
        }
        return finalPrice;
    }

    public double getCurrentValue()
    {
        double currentValue = 0.0;
        for(StockHolding s : stocks)
        {
            currentValue = currentValue + s.getNumShares()*s.getPrice();
        }
        return currentValue;
    }

    private int getIndex(String symbol)
    {
        for(StockHolding s : stocks)
        {
            if(s.equals(symbol))
            {
                return stocks.indexOf(symbol);
            }
        }    
        return -1;
    }

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
