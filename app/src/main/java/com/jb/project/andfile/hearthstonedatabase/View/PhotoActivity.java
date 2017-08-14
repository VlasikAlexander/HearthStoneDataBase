package com.jb.project.andfile.hearthstonedatabase.View;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.jb.project.andfile.hearthstonedatabase.Network.ImageDownloader;
import com.jb.project.andfile.hearthstonedatabase.R;

/**
 * Created by Alexander on 09.08.2017.
 */

    public class PhotoActivity extends AppCompatActivity{

    private String URL;
    private String URL_GOLD;
    private ImageView imageHolder;
    private Button mButton;
    private Boolean isGold;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_photo);

        imageHolder = (ImageView)findViewById(R.id.imageHolder);

        URL = getIntent().getStringExtra(RecyclerViewAdapter.IMAGE_URL);
        URL_GOLD = getIntent().getStringExtra(RecyclerViewAdapter.IMAGE_GOLD_URL);
        ImageDownloader.downLoadImageByURL(this, URL, imageHolder );
        isGold = false;


        imageHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isGold)
                    ImageDownloader.downLoadImageByURL(getApplication(), URL, imageHolder);
                else
                ImageDownloader.downLoadImageByURL(getApplication(), URL_GOLD, imageHolder);
                isGold = !isGold;
            }
        });
    }
}
