package com.coletrumbo.arbitragealgotrader.tradeRobot;

import android.content.Context;
import android.widget.Toast;

import com.coletrumbo.arbitragealgotrader.tradeRobot.brain.RoboBrain;

/**
 * Created by Cole on 11/12/2016.
 * The trade robot takes my place as the trader.
 * All buying, selling, and transfering are done by the trade robot.
 * The user input can help control the robot: the user tells it to start, stop, add an exchange, remove an exchange, set buy/sell limits,
 * The robot's brain will control (the user has no control over) the trading timing, the network calls, the trade execution or prices, the transfers,
 */

public class TradeRobot {
    private RoboBrain mBrain = new RoboBrain();

    public void start() {
        // starts its brain. Brain runs as a service that continually checks prices and organizes trades
        this.mBrain.start();

        // executes stream of tasks. This runs as a service that listens for any trades the brain lines up, and executes them when they come up.
            // Do I have to encapsulate it in another class?
            //this.mTraderService.start(); vs. runTradeService(); private method.

        // checks for stop command. How can this be always listening?
            // where should it be listening for stop? How can I stop the brain and the trading?


    }

    public static void stop(){}


}
