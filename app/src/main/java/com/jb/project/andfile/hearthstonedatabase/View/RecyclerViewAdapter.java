package com.jb.project.andfile.hearthstonedatabase.View;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jb.project.andfile.hearthstonedatabase.Model.Card;
import com.jb.project.andfile.hearthstonedatabase.Network.ImageDownloader;
import com.jb.project.andfile.hearthstonedatabase.R;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmResults;

/**
 * Created by Alexander on 04.08.2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

     ArrayList<Card> cardList;
    private Context mContext;
    public static final String IMAGE_URL = "image_url";
    public static final String IMAGE_GOLD_URL = "image_gold_url";


    public RecyclerViewAdapter(ArrayList<Card> cardList, Context context) {

        this.cardList = cardList;
        mContext = context;

    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false );
        return new MyViewHolder(v);
    }



    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
       final Card card = cardList.get(position);
        holder.name.setText(card.getName());
        holder.text.setText(card.getFlavor());
        ImageDownloader.downLoadImage(mContext, cardList, position, holder.mImageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mContext, PhotoActivity.class);
                intent.putExtra(IMAGE_URL, card.getImg().toString());
                intent.putExtra(IMAGE_GOLD_URL, card.getImgGold().toString());
                mContext.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name, rarity, cardset, text;
        private ImageView mImageView;

        public MyViewHolder(View itemView) {
            super(itemView);

            name = (TextView)itemView.findViewById(R.id.name);
            text = (TextView)itemView.findViewById(R.id.text);
           mImageView = (ImageView)itemView.findViewById(R.id.imageView);


        }
    }

    public  void setFilter(ArrayList<Card> cards) {
        Log.d("RecyclerViewAdapter", "setFilter");
        for (Card card: cards) {
            Log.d("cards: ", card.getName());
        }

        cardList = cards;
        notifyDataSetChanged();
    }
    public  void updateList() {

        notifyDataSetChanged();
    }


}
