package christmas.frame.photoedittor.collage.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import christmas.frame.photoedittor.collage.R;
import christmas.frame.photoedittor.collage.addsticker.OnStickerSelect;


public class AddStickerAdapter extends RecyclerView.Adapter<AddStickerAdapter.ViewHolder> {
    List<String> listFrameAsset;
    Context context;
    OnStickerSelect onStickerSelect;

    public AddStickerAdapter(ArrayList<String> listFrameAsset, Context context) {
        this.context = context;
        this.listFrameAsset = listFrameAsset;
        onStickerSelect = (OnStickerSelect) context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_photo2, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Glide.with(context).load(listFrameAsset.get(position)).into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listFrameAsset.get(position).contains("nonee")) {
                    onStickerSelect.sendSticker("none");
                } else if (listFrameAsset.get(position).contains("addd")) {
                    onStickerSelect.sendSticker("add");
                } else {
                    onStickerSelect.sendSticker(listFrameAsset.get(position));
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return listFrameAsset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_photo);
        }
    }

}