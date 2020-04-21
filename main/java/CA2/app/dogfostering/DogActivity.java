package CA2.app.dogfostering;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.toolbox.StringRequest;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DogActivity extends AppCompatActivity {

    String id,name,breed,information,image_url;
    double age;
    Button updateButton;
    private jsonPlaceHolderAPI jsonPlaceHolderApi;
    TextView tid, tname, tbreed, tage, tinfo, tadoption;
    ImageView timage;

    boolean isAdopted;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog);
        updateButton = (Button) findViewById(R.id.updateButton);


        id = getIntent().getExtras().getString("Dog ID");
        name = getIntent().getExtras().getString("Dog Name");
        breed = getIntent().getExtras().getString("Dog breed");
        age = getIntent().getExtras().getDouble("Dog age");
        information = getIntent().getExtras().getString("Dog information");
        image_url = getIntent().getExtras().getString("Dog Url");
        isAdopted = getIntent().getExtras().getBoolean("Dog isAdopted");


        tid = (TextView) findViewById(R.id.aId);
        tname = (TextView) findViewById(R.id.aname);
        tbreed = (TextView) findViewById(R.id.abreed);
        tage = (TextView) findViewById(R.id.aage);
        tinfo = (TextView) findViewById(R.id.ainfo);
        timage = (ImageView) findViewById(R.id.adogURL);
        tadoption = (TextView) findViewById(R.id.aadoption);

        // setting values to each view

        //tid.setText(id);
        tname.setText(name);
        tbreed.setText(breed);
        String numberStr = Double.toString(age);
        tage.setText("Dogs Age : " + numberStr);
        tinfo.setText(information);
        if (isAdopted) {
            tadoption.setText("Dog Adopted");
        } else {
            tadoption.setText("Not Adopted");
        }

        Glide.with(DogActivity.this).load(image_url).into(timage);


        Gson gson = new GsonBuilder().serializeNulls().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://ca2api20200421041940.azurewebsites.net/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        jsonPlaceHolderApi = retrofit.create(jsonPlaceHolderAPI.class);


        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(DogActivity.this, "Message not sent", Toast.LENGTH_SHORT).show();
                adoptDog();
            }
        });

    }


    public void adoptDog() {

        Dogs dog = new Dogs(id,name,breed,age,information,image_url,true);

        retrofit2.Call<Dogs> call = jsonPlaceHolderApi.putPost(id, dog);

        call.enqueue(new Callback<Dogs>() {


            @Override
            public void onResponse(Call<Dogs> call, Response<Dogs> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(DogActivity.this, "Message not sent", Toast.LENGTH_SHORT).show();
                    return;
                }

                Dogs postResponse = response.body();
                Toast.makeText(DogActivity.this, "Dog Adopted !", Toast.LENGTH_SHORT).show();
                // setting values to each view

               /* tid.setText(postResponse.getId());
                tname.setText(postResponse.getName());
                tbreed.setText(postResponse.getBreed());
                String numberStr = Double.toString(postResponse.getAge());
                tage.setText("Dogs Age : " + numberStr);
                tinfo.setText(postResponse.getInformation());
                if (postResponse.isAdopted()) {
                    tadoption.setText("Dog Adopted");
                } else {
                    tadoption.setText("Not Adopted");
                }*/

                //Glide.with(DogActivity.this).load(postResponse.getImageURL()).into(timage);


            }

            @Override
            public void onFailure(Call<Dogs> call, Throwable t) {

            }
        });


    }
}






