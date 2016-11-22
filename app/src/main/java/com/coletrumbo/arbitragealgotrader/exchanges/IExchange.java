package com.coletrumbo.arbitragealgotrader.exchanges;

/**
 * Created by Cole on 11/12/2016.
 */

public interface IExchange {
    public static final float MINIMUM_USABLE_USD_BALANCE = 5f;
    public String buy(String currencyName);
    public String sell(String currencyName);
    public float getAskPrice(String currencyName);
    public float getBidPrice(String currencyName);
    public float getBalance(String currencyName);
    public float getLastUsedAskPrice(String currencyName);
    public float getLastUsedBidPrice(String currencyName);
    public float getLastUsedBalance(String currencyName);
    public String transfer(ICurrency c, String wallet);
    public String cancelOrders();
    public String retry();
    public String receive(String currencyName);
    public void updateData();

    void getRequestData();

    public interface ICurrency {
        public String getName();
        public float getAskPrice();
        public float getBidPrice();
    }
}
