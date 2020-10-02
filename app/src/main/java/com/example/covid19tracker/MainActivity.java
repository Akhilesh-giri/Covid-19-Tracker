package com.example.covid19tracker;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView totalCase, todayCase, totalRecv, todayRecv, totalDth, todayDth,activeCase, criticalCase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalCase=(TextView)findViewById(R.id.total_case);
        todayCase=(TextView)findViewById(R.id.today_case);
        totalRecv=(TextView)findViewById(R.id.total_recv);
        todayRecv=(TextView)findViewById(R.id.today_recv);
        totalDth=(TextView)findViewById(R.id.total_dth);
        todayDth=(TextView)findViewById(R.id.today_dth);
        activeCase=(TextView)findViewById(R.id.active_case);
        criticalCase=(TextView)findViewById(R.id.critical_case);



        final SwipeRefreshLayout swipeRefreshLayout=(SwipeRefreshLayout)findViewById(R.id.swipe);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        fetchdata();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                },2000);
            }
        });

        Button button=(Button)findViewById(R.id.et);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),CountryActivity.class);
                startActivity(intent);
            }
        });

        fetchdata();

    }

    private void fetchdata() {
        String url="https://disease.sh/v3/covid-19/all";

        StringRequest request=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject=new JSONObject(response.toString());
                    totalCase.setText(jsonObject.getString("cases"));
                    todayCase.setText(jsonObject.getString("todayCases"));
                    totalRecv.setText(jsonObject.getString("recovered"));
                    todayRecv.setText(jsonObject.getString("todayRecovered"));
                    totalDth.setText(jsonObject.getString("deaths"));
                    todayDth.setText(jsonObject.getString("todayDeaths"));
                    activeCase.setText(jsonObject.getString("active"));
                    criticalCase.setText(jsonObject.getString("critical"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        RequestQueue requestQueue=Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

}
