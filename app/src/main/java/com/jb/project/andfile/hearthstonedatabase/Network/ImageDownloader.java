package com.jb.project.andfile.hearthstonedatabase.Network;

import android.content.Context;
import android.provider.ContactsContract;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jb.project.andfile.hearthstonedatabase.Model.Card;

import java.util.ArrayList;

import io.realm.RealmList;
import io.realm.RealmResults;

/**
 * Created by Alexander on 08.08.2017.
 */

public class ImageDownloader {

    public static void downLoadImage(Context context, ArrayList<Card> cards, int position, ImageView imageView) {

        Glide.with(context)
                .load(cards.get(position).getImg())
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(imageView);


    }

    public static void downLoadImageByURL(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(imageView);
    }
}
