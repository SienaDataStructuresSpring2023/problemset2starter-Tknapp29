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
    private ArrayList<StockHolding> stocks;
    private int lifeTime;
    private int lifeTimePayout;

    public Portfolio()
    {
        stocks = new ArrayList<StockHolding>();
        this.lifeTime = 0;
        this.lifeTimePayout = 0;
    }

    public int getLifeTime()
    {
        return lifeTime;
    }

    public int lifeTimePayout()
    {
        return lifeTimePayout;
    }

    public int buyStock(String symbol, String name, int numShares,int pricePerShare)
    {
        int finalPrice = 0;
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

    public int sellStock(String symbol, int sharesToSell)
    {
        return -1;
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
