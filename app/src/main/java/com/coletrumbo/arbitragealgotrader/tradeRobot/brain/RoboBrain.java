package com.coletrumbo.arbitragealgotrader.tradeRobot.brain;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.coletrumbo.arbitragealgotrader.activities.MainActivity;
import com.coletrumbo.arbitragealgotrader.exchanges.IExchange;
import com.coletrumbo.arbitragealgotrader.tradeRobot.brain.networkservice.PersistantRequestQueue;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Cole on 11/19/2016.
 * The brain has no interaction with the UI thread.
 * This is where all the other threads come into play.
 * The brain is in charge of making all the API reuests so that it can make immediate use of the responses.
 * It also keeps a thread alive to continually schedule the next round of API calls, independently of the UI thread.
 */

public class RoboBrain {
    Map<String, JSONObject> mResponses;

    public void start() {
        makePriceRequest(MainActivity.URL);
    }

    private void makePriceRequest(final String url) { // Map<String, String> headers
//        // set up request data (api key, sectret, nonce, any otherstuff)
//        exchange.getRequestData();

        JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.GET, url, new JSONObject(),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
//                        if (mResponses.containsKey(url)) {
//                            mResponses.get(url) = response;
//                        }
                        int i = 0;
                        i++;
                        response.toString();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
//                params.put("User-Agent", "Nintendo Gameboy");
//                params.put("Accept-Language", "fr");
                    // in here, it will set up the headers by asking the exchange for the appropriate header.
                // will that work? how will I know what header to get? If I set an exchange to a certain state, and use a getStateData to get the daa according to its state, will other calls made here mees that up?

                return params;
            }
        };
        // Add the request to the RequestQueue.
        PersistantRequestQueue.getInstance().add(jsonRequest);
    }


}
