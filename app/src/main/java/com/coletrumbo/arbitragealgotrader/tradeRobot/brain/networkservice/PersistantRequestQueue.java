package com.coletrumbo.arbitragealgotrader.tradeRobot.brain.networkservice;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Cole on 11/19/2016.
 */
public class PersistantRequestQueue {
    private static RequestQueue ourInstance;

    public static RequestQueue getInstance() {
        return ourInstance;
    }

    public static synchronized void setInstance(Context appCnxt) {
        if (ourInstance == null) {
            ourInstance = Volley.newRequestQueue(appCnxt);
        }
    }

    private PersistantRequestQueue() {
    }
}
