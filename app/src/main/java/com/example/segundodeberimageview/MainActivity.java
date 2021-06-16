package com.example.segundodeberimageview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerViewElemnt;
    private RecicleViewAdaptador adactadorElement;
    Bitmap bitmap;
    Bitmap res;
    ImageView image;
    TextView txtdatosEnviados;
    Button bntBuscar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = findViewById(R.id.imageView);
        txtdatosEnviados=findViewById(R.id.txtvalue);
        bntBuscar=findViewById(R.id.bntenviar);
        bntBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(txtdatosEnviados.getText().length()>0)
                {
                    obtnerElementosImgane(txtdatosEnviados.getText().toString());
                    txtdatosEnviados.setText("");

                }
                else
                {
                    Toast toast = Toast.makeText(getApplicationContext(), "Ingrese el id  a buscar", Toast.LENGTH_SHORT);
                    toast.show();

                }
            }
        });

       // obtnerElementosImgane();
    }


    public void  obtnerElementosImgane(String dato) {
        List<ListadeModelo> mode = new ArrayList<>();
        ImageView imageViewNu = findViewById(R.id.imageView);
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url = "https://revistas.uteq.edu.ec/ws/issues.php?j_id="+dato;
        JSONObject nuevo = new JSONObject();
        JsonArrayRequest request = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {

                     for (int i = 0; i < response.length(); i++) {
                         JSONObject row = response.getJSONObject(i);
                         mode.add(new ListadeModelo(row.getString("issue_id"), row.getString("volume"), row.getString("number"), row.getString("year"), row.getString("date_published"), row.getString("title"), row.getString("cover")));

                     }
                    llamr(mode);
                } catch (Exception e) {
                }

            }

        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);


    }
    public void llamr(List mode)
    {
        RecicleViewAdaptador lis = new RecicleViewAdaptador(this,mode);
        recyclerViewElemnt = (RecyclerView) findViewById(R.id.Recycler_layout);
        recyclerViewElemnt.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewElemnt.setAdapter(lis);
    }
}