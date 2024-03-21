package adet.recyclerview.t137.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {

    ArrayList<PhoneModel> phoneModels = new ArrayList<>();

    int[] phoneImages = {R.drawable.phone1, R.drawable.phone2,
            R.drawable.phone3, R.drawable.phone4,
            R.drawable.phone5, R.drawable.phone6,
            R.drawable.phone7, R.drawable.phone8,
            R.drawable.phone9, R.drawable.phone10,
            R.drawable.ashinobu, R.drawable.achiz,
            R.drawable.baseline_3k_24, R.drawable.baseline_4k_24,
            R.drawable.baseline_5k_24, R.drawable.baseline_6k_24,
            R.drawable.baseline_7k_24, R.drawable.baseline_8k_24,
            R.drawable.baseline_9k_24, R.drawable.baseline_9k_plus_24,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.mRecyclerView);

        setUpPhoneModels();

        Phone_RecyclerViewAdapter adapter = new Phone_RecyclerViewAdapter(this,phoneModels, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void setUpPhoneModels() {
        //grabbing arrays on "res/values/strings.xml"
        String[] phoneNames = getResources().getStringArray(R.array.phones_name);
        String[] phonePrice = getResources().getStringArray(R.array.phones_price);
        String[] phoneDiscount = getResources().getStringArray(R.array.phones_discount);
        String[] phoneDescription = getResources().getStringArray(R.array.phones_description);
        String[] phoneRating = getResources().getStringArray(R.array.phones_rating);

        for (int i = 0; i<phoneNames.length; i++) {
            phoneModels.add(new PhoneModel(phoneNames[i],
                    phonePrice[i],
                    phoneDiscount[i],
                    phoneImages[i],
                    phoneDescription[i],
                    phoneRating[i]));
        }

    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);

        intent.putExtra("NAME", phoneModels.get(position).getPhoneName());
        intent.putExtra("PRICE", phoneModels.get(position).getPhonePrice());
        intent.putExtra("DISCOUNT", phoneModels.get(position).getPhoneDiscount());
        intent.putExtra("DESCRIPTION", phoneModels.get(position).getDescription());
        intent.putExtra("IMAGE", phoneModels.get(position).getImage());
        intent.putExtra("RATING", phoneModels.get(position).getRating());

        startActivity(intent);
    }
}