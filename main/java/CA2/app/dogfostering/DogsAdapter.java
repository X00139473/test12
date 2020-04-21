package CA2.app.dogfostering;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;


import java.util.List;

public class DogsAdapter  extends ArrayAdapter<Dogs> {

    private Activity context;
    private List<Dogs> dogsList;


    public DogsAdapter(Activity context, List<Dogs> dogsList) {
        super(context, R.layout.content_dog, dogsList);
        this.context = context;
        this.dogsList = dogsList;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listview = inflater.inflate(R.layout.content_dog,null,true);

        TextView id = (TextView) listview.findViewById(R.id.id);
        TextView name = (TextView) listview.findViewById(R.id.name);
        TextView breed = (TextView) listview.findViewById(R.id.breed);
        TextView age = (TextView) listview.findViewById(R.id.age);
        TextView info = (TextView) listview.findViewById(R.id.info);
        ImageView image = (ImageView) listview.findViewById(R.id.dogURL);
        TextView adoption = (TextView) listview.findViewById(R.id.adoption);


        Dogs dog = dogsList.get(position);


        id.setText("Dogs ID : "+dog.getId());
        name.setText("Dogs Name : "+dog.getName());
        breed.setText("Dogs Breed : "+dog.getBreed());
        String numberStr = Double.toString(dog.getAge());
        age.setText("Dogs Age : "+numberStr);
        info.setText("Dogs Information : "+dog.getInformation());


        Glide.with(context).load(dog.getImageURL()).into(image);

        if(dog.isAdopted()){
            adoption.setText("Dog Adopted");
        }else{
            adoption.setText("Not Adopted");
        }


        return listview;

    }

}
