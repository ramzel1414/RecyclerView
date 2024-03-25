package adet.recyclerview.t137.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder> {

    Context context;
    List<Item> postList;

    public PostAdapter(Context context, List<Item> postList){
        this.context = context;
        this.postList = postList;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(context).inflate(R.layout.recycler_view_row , parent, false);
        return  new PostHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, final int position) {
        final Item item = postList.get(position);
        holder.setImageView(item.getThumbnailurl());
        holder.setmTitle(item.getTitle());
        holder.setmPrice(item.getPrice());
        holder.setmDiscountPercentage(item.getDiscountPercentage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity2.class);
                intent.putExtra("thumbnailurl", item.getThumbnailurl());
                intent.putExtra("title", item.getTitle());
                intent.putExtra("price", item.getPrice());
                intent.putExtra("discountPercentage", item.getDiscountPercentage());
                intent.putExtra("description", "Description for " + item.getTitle()); // This could be fetched from API if available
                intent.putExtra("brand", item.getBrand()); // Add brand
                intent.putExtra("category", item.getCategory()); // Add category
                intent.putExtra("stock", item.getStock()); // Add stock
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class PostHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView mTitle, mPrice, mDiscountPercentage;
        View view;
        public PostHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;

        }

        public void setImageView(String url){
            imageView = view.findViewById(R.id.imageView);
            Glide.with(context).load(url).into(imageView);
        }

        public void setmTitle(String title){
            mTitle = view.findViewById(R.id.title);
            mTitle.setText(title);
        }

        public void setmPrice(String price){
            mPrice = view.findViewById(R.id.price);
            mPrice.setText("Price: " + price);
        }

        public void setmDiscountPercentage(String discountPercentage){
            mDiscountPercentage = view.findViewById(R.id.discountPercentage);
            mDiscountPercentage.setText("Discount: " + discountPercentage);
        }



    }
}
