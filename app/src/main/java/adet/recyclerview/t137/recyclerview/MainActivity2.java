package adet.recyclerview.t137.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        if (intent != null) {
            String thumbnailurl = intent.getStringExtra("thumbnailurl");
            String title = intent.getStringExtra("title");
            String price = intent.getStringExtra("price");
            String discountPercentage = intent.getStringExtra("discountPercentage");
            String description = intent.getStringExtra("description");
            String brand = intent.getStringExtra("brand");
            String category = intent.getStringExtra("category");
            String stock = intent.getStringExtra("stock");

            ImageView imageView = findViewById(R.id.imageView);
            TextView titleTextView = findViewById(R.id.title);
            TextView priceTextView = findViewById(R.id.price);
            TextView discountPercentageTextView = findViewById(R.id.discountPercentage);
            TextView descriptionTextView = findViewById(R.id.description);
            TextView brandTextView = findViewById(R.id.brand);
            TextView categoryTextView = findViewById(R.id.category);
            TextView stockTextView = findViewById(R.id.stock);

            Glide.with(this).load(thumbnailurl).into(imageView);
            titleTextView.setText(title);
            priceTextView.setText("Price: " + price);
            discountPercentageTextView.setText("Discount(%): " + discountPercentage);
            descriptionTextView.setText("Description: " + description);
            brandTextView.setText("Brand: " + brand);
            categoryTextView.setText("Category: " + category);
            stockTextView.setText("Stock: " + stock);

            // Back button functionality
            Button backButton = findViewById(R.id.button);
            backButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Navigate back to MainActivity
                    finish();
                }
            });
        }
    }
}
