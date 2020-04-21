package CA2.app.dogfostering;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.ImageView;
//import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.textfield.TextInputLayout;

import org.w3c.dom.Text;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DogsAddActivity  extends AppCompatActivity {
    private EditText[] editText = new EditText[4];


    private Activity context;
    private List<Dogs> dogsList;

    private jsonPlaceHolderAPI jsonPlaceHolderApi;
    //private TextView textViewResult;

    String id,name,breed,information,image_url;
    double age;
    EditText eid, ename, ebreed, eage, einfo, eimage;

    TextInputLayout textInputAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Button postDogButton = (Button) findViewById(R.id.postDogButton1);

        eid =  findViewById(R.id.newId);
        ename = findViewById(R.id.newName);
        ebreed =  findViewById(R.id.newBreed);
        eage =findViewById(R.id.newAge);
        einfo =  findViewById(R.id.newInfo);
        eimage =  findViewById(R.id.newImage);

        // textViewResult = findViewById(R.id.name);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://ca2api20200421041940.azurewebsites.net/api/Dogs/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(jsonPlaceHolderAPI.class);

        postDogButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {



                id = eid.getText().toString();
                name = ename.getText().toString();
                breed = ebreed.getText().toString();
                age = Double.parseDouble(eage.getText().toString());
                information = einfo.getText().toString();
                image_url = eimage.getText().toString();


                createPost();
            }
        });
    }

    private boolean validateAge(){
        String ageInput = eage.getText().toString();

        if(ageInput.isEmpty()){
            ename.setError("Field cannot be empty");
            return false;
        } else {
            ename.setError(null);
            return true;
        }
    }

    private void createPost(){
        Dogs dog = new Dogs(id, name, breed,age, information, image_url);
        Call<Dogs> call = jsonPlaceHolderApi.createPost(dog);

        call.enqueue(new Callback<Dogs>() {
            @Override
            public void onResponse(Call<Dogs> call, Response<Dogs> response) {
                if(!response.isSuccessful()){
                    // textViewResult.setText("Code: " + response.code());
                    return;
                }

                Dogs dogResponse = response.body();

            }

            @Override
            public void onFailure(Call<Dogs> call, Throwable t) {

            }
        });
    }


}
