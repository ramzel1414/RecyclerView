package adet.recyclerview.t137.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.ErrorListener;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RequestQueue requestQueue;

    private List<Item> mList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        requestQueue = VollySingleton.getmInstance(this).getRequestQueue();

        mList = new ArrayList<>();
        fetchData();

    }

    private void fetchData() {

        String url = "https://dummyjson.com/products/";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("products");

                    for(int i = 0; i<jsonArray.length(); i++){
                        JSONObject jsonObject =jsonArray.getJSONObject(i);
                        String thumbnailurl = jsonObject.getString("thumbnail");
                        String title = jsonObject.getString("title");
                        String description = jsonObject.getString("description");
                        String price = jsonObject.getString("price");
                        String discountPercentage = jsonObject.getString("discountPercentage");
                        String brand = jsonObject.getString("brand");
                        String stock = jsonObject.getString("stock");
                        String category = jsonObject.getString("category");

                        Item post = new Item(thumbnailurl, title, description, price, discountPercentage, brand, stock, category);
                        mList.add(post);

                    }

                    PostAdapter adapter = new PostAdapter(MainActivity.this, mList);
                    recyclerView.setAdapter(adapter);

                    adapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(jsonObjectRequest);
    }
}