package adet.recyclerview.t137.recyclerview;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String name = getIntent().getStringExtra("NAME");
        String price = getIntent().getStringExtra("PRICE");
        String discount = getIntent().getStringExtra("DISCOUNT");
        String description = getIntent().getStringExtra("DESCRIPTION");
        int image = getIntent().getIntExtra("IMAGE", 0);
        String rating = getIntent().getStringExtra("RATING");

        TextView nameTextView = findViewById(R.id.Phone_Title);
        TextView priceTextView = findViewById(R.id.Phone_Price);
        TextView discountTextView = findViewById(R.id.Phone_Discount);
        TextView descriptionTextView = findViewById(R.id.Phone_Description);
        ImageView Phone_Image = findViewById(R.id.Phone_Image);
        TextView ratingTextView = findViewById(R.id.Phone_Rating);


        nameTextView.setText(name);
        priceTextView.setText(price);
        discountTextView.setText(discount);
        descriptionTextView.setText(description);
        Phone_Image.setImageResource(image);
        ratingTextView.setText(rating);


        Button backButton = findViewById(R.id.button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Finish the current activity (MainActivity2) and go back to the previous one
            }
        });
    }
}
