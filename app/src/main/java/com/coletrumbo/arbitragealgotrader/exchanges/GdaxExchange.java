package com.coletrumbo.arbitragealgotrader.exchanges;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by Cole on 11/12/2016.
 */

public class GdaxExchange implements IExchange {
    private float mAskPriceBTC_USD;
    private float mAskPriceETH_USD;
    private float mAskPriceETH_BTC;
    private float mBidPriceBTC_USD;
    private float mBidPriceETH_USD;
    private float mBidPriceETH_BTC;

    private String makeRequest(String path, String requestMethod) {
        try {
            URL apiUrl = new URL("https://api.gdax.com/" + path);

            HttpsURLConnection connection = (HttpsURLConnection)apiUrl.openConnection();
            connection.setRequestMethod(requestMethod);
            connection.addRequestProperty("Accept", "text/html");

            connection.connect();
            int rc = connection.getResponseCode();

            if (rc == HttpsURLConnection.HTTP_OK) {
                InputStream responseBody = connection.getInputStream();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();

                byte[] buffer = new byte[1024];
                int length = 0;
                while ((length = responseBody.read(buffer)) != -1) {
                    baos.write(buffer, 0, length);
                }

                String responseBodyData = baos.toString();
                return responseBodyData;
            }
            else { // SERVER RETURNED AN HTTP ERROR
//                400	Bad Request – Invalid request format
//                401	Unauthorized – Invalid API Key
//                403	Forbidden – You do not have access to the requested resource
//                404	Not Found
//                500	Internal Server Error – We had a problem with our server
                switch (rc) {

                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public GdaxExchange() {
    }
    @Override
    public void updateData() {
        // make api calls to get ask, bid of each currency. Save to private fields
        this.mAskPriceBTC_USD = getAskPrice("BTC-USD");
        // get balances of each currency. Save to private fields

    }

    @Override
    public String buy(String currencyName) {
        return null;
    }

    @Override
    public String sell(String currencyName) {
        return null;
    }

    @Override
    public float getAskPrice(String currencyName) {
//        makeRequest();
        return 0;
    }

    @Override
    public float getBidPrice(String currencyName) {
        return 0;
    }

    @Override
    public float getBalance(String currencyName) {
        return 0;
    }

    @Override
    public float getLastUsedAskPrice(String currencyName) {
        return 0;
    }

    @Override
    public float getLastUsedBidPrice(String currencyName) {
        return 0;
    }

    @Override
    public float getLastUsedBalance(String currencyName) {
        return 0;
    }

    @Override
    public String transfer(ICurrency c, String wallet) {
        return null;
    }

    @Override
    public String cancelOrders() {
        return null;
    }

    @Override
    public String retry() {
        return null;
    }

    @Override
    public String receive(String currencyName) {
        return null;
    }


    private class Bitcoin implements ICurrency {

        @Override
        public String getName() {
            return null;
        }

        @Override
        public float getAskPrice() {
            return 0;
        }

        @Override
        public float getBidPrice() {
            return 0;
        }
    }

}
