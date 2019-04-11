package com.kazishihan.tourmate.Adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kazishihan.tourmate.Classes.IndividualTrip;
import com.kazishihan.tourmate.Classes.MemoryClass;
import com.kazishihan.tourmate.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MomentAdapter extends RecyclerView.Adapter<MomentAdapter.ViewHolder> {

    private List<MemoryClass> memoryClasses;
    Context context;

    private Picasso picasso;

    public MomentAdapter(List<MemoryClass> memoryClasses, Context context) {
        this.memoryClasses = memoryClasses;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.memory_item_list,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        MemoryClass memoryList = memoryClasses.get(i);

        Uri myUri = Uri.parse(memoryList.getPostimages());
        Picasso.get().load(myUri).into(viewHolder.memoryImage);
        viewHolder.imageCaption.setText(memoryList.getCaption());

    }

    @Override
    public int getItemCount() {
        return memoryClasses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView imageCaption;
        private ImageView memoryImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            memoryImage = itemView.findViewById(R.id.memoryImageListIvId);
            imageCaption = itemView.findViewById(R.id.memoryCaptionListIvId);

        }
    }
}
