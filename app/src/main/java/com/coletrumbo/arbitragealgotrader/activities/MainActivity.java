package com.coletrumbo.arbitragealgotrader.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.coletrumbo.arbitragealgotrader.R;
import com.coletrumbo.arbitragealgotrader.tradeRobot.TradeRobot;

public class MainActivity extends AppCompatActivity {
    Button mAddExchangeButton;

    /**
     * Starts the algo trading, which continues as long as the app is open.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // start algo trader
        TradeRobot.start(this);

        this.mAddExchangeButton = (Button) findViewById(R.id.add_exchange_button);
        this.mAddExchangeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Start the Add Exchange Activity
                addExchange(view);
            }
        });

        Toast.makeText(this, "onCreate is over", Toast.LENGTH_SHORT).show();
    }

    public void addExchange(View view) {
        Intent intent = new Intent(this, AddExchangeActivity.class);
        startActivity(intent);
    }
}
