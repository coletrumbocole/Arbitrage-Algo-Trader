package com.coletrumbo.arbitragealgotrader.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.coletrumbo.arbitragealgotrader.R;

/**
 * This activity displays the exchanges you are connected to and the exchanges available.
 * In this activity you can connect to an exchange or remove an exchange.
 * You have to input your api key and api secret.
 */
public class AddExchangeActivity extends AppCompatActivity {
    Button mClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exchanges);

        this.mClick = (Button) findViewById(R.id.click_it);
        this.mClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doSomething();
                Toast.makeText(getApplicationContext(), "AddExchange Activity", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void doSomething() {
        int i = 0;
        i++;
        if (i < 0)
            i++;
        return;
    }
}
