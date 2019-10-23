package vn.com.mob1032_ps10814_lab8_bai2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;



public class MainActivity extends AppCompatActivity {
TextView tvResponse;
Button btnRequest;
RequestQueue mQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapComp();
        mQueue = Volley.newRequestQueue(this);

        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                request();
            }
        });

    }
    private void mapComp(){
        if(btnRequest==null)
            btnRequest = findViewById(R.id.btnRequest);
        if(tvResponse==null)
            tvResponse = findViewById(R.id.tvResponse);
    }
    private void request(){
        String url="http://www.google.com";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        tvResponse.setText("Response is: "+ response.substring(0,500));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                tvResponse.setText("That didn't work!");
            }
        });
        mQueue.add(stringRequest);
    }
}
