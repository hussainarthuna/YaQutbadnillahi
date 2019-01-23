package com.hussain.yaqutbadnillahi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class BundListAdapter extends RecyclerView.Adapter<BundListAdapter.ViewHolder> {


    private List<String> bundItem;
    private Context context;
    String bund;

    public BundListAdapter(List<String> bundItem, Context context) {
        this.bundItem = bundItem;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyler_row,viewGroup,false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {

        bund = bundItem.get(i);

        viewHolder.textView.setText(bund);
        viewHolder.textView.setText(bund);

        //viewHolder.itemView.setTag(viewHolder);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                Intent intent = new Intent(context,MainMediaActivity.class);

                intent.putExtra("bundname",String.valueOf(viewHolder.getAdapterPosition()+1));
                //intent.putExtra("bundname",bundItem.get(viewHolder.getAdapterPosition()));

                context.startActivity(intent);
                ((Activity)context).finish();

            }
        });


    }

    @Override
    public int getItemCount() {
        return bundItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView=(TextView)itemView.findViewById(R.id.bundItem);



        }
    }


}
