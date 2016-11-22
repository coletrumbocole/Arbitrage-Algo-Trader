package com.coletrumbo.arbitragealgotrader.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.coletrumbo.arbitragealgotrader.R;
import com.coletrumbo.arbitragealgotrader.tradeRobot.brain.networkservice.PersistantRequestQueue;
import com.coletrumbo.arbitragealgotrader.tradeRobot.TradeRobot;

public class MainActivity extends AppCompatActivity {
    private Button mAddExchangeButton;
    private Button mStartButton;
    private Button mStopButton;

    private TradeRobot mRobot = new TradeRobot();

    private boolean mIsPretendingToWork = false;
    private TextView mPretendMoneyTextView;
    private int mPretendMoney = 0;

    private TextView mPracticeTextView;

    public static final String URL ="http://www.google.com";


    /**
     * Starts the algo trading, which continues as long as the app is open.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PersistantRequestQueue.setInstance(this.getApplicationContext());

        // start algo trader
        this.mRobot.start();

        this.mPracticeTextView = (TextView) findViewById(R.id.output_text_view);
        this.mPretendMoneyTextView = (TextView) findViewById(R.id.cash_total_text_view);

        this.mAddExchangeButton = (Button) findViewById(R.id.add_exchange_button);
        this.mAddExchangeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Start the Add Exchange Activity
                addExchange(view);
            }
        });

        this.mStartButton = (Button) findViewById(R.id.start_button);
        this.mStartButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Start the Add Exchange Activity
                pretendToWork();
            }
        });

        this.mStopButton = (Button) findViewById(R.id.stop_button);
        this.mStopButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Start the Add Exchange Activity
                mIsPretendingToWork = false;
            }
        });

        Toast.makeText(this, "onCreate is over", Toast.LENGTH_SHORT).show();
    }

    public void addExchange(View view) {
        Intent intent = new Intent(this, AddExchangeActivity.class);
        startActivity(intent);
    }

    /**
     * Can't have a while loop in here, even if this is called inside an onclicklistener.
     */
    private void pretendToWork() {
        this.mIsPretendingToWork = true;
        mPretendMoney++;
        // make i show up in a text view.
        this.mPretendMoneyTextView.setText("" + mPretendMoney);
    }


}
