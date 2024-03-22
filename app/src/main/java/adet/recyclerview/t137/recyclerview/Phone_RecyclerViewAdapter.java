package adet.recyclerview.t137.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Phone_RecyclerViewAdapter extends RecyclerView.Adapter<Phone_RecyclerViewAdapter.MyViewHolder> {
    private final RecyclerViewInterface recyclerViewInterface;

    Context context;
    ArrayList<PhoneModel> phoneModels;

    public Phone_RecyclerViewAdapter(Context context, ArrayList<PhoneModel> phoneModels, RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.phoneModels = phoneModels;
        this.recyclerViewInterface = recyclerViewInterface;
    }


    @NonNull
    @Override
    public Phone_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // This is where you inflate the layout (Giving a look to our rows)
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent,false);

        return new Phone_RecyclerViewAdapter.MyViewHolder(view, recyclerViewInterface);

    }

    @Override
    public void onBindViewHolder(@NonNull Phone_RecyclerViewAdapter.MyViewHolder holder, int position) {
        // Assigning values to the views we created i the recycler_view_row layout file
        // based on the position of the recycler view

        holder.tvName.setText(phoneModels.get(position).getPhoneName());
        holder.tvPrice.setText(phoneModels.get(position).getPhonePrice());
        holder.tvDiscount.setText(phoneModels.get(position).getPhoneDiscount());
        holder.imageView.setImageResource(phoneModels.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        // the recycler view just wants to know the number of items you wanted to display
        return phoneModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // grabbing the views from our recycler_view_row layout file
        // kinda like in the onCreate method

        ImageView imageView;
        TextView tvName, tvPrice, tvDiscount;
        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            tvName = itemView.findViewById(R.id.textView);
            tvPrice = itemView.findViewById(R.id.textView2);
            tvDiscount = itemView.findViewById(R.id.textView3);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerViewInterface != null) {
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION) {
                            recyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {

                    if (recyclerViewInterface != null) {
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION) {
                            recyclerViewInterface.onItemLongClick(pos);
                        }
                    }
                    return false;
                }
            });


        }
    }
}
