package com.harunkor.androidimageloadingurl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.harunkor.androidimageloadingurllib.MagicImageView;


public class MainActivity extends AppCompatActivity {
    private MagicImageView magicImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        magicImageView= (MagicImageView) findViewById(R.id.imageView);


        // url set progress animation-list
        magicImageView.setProgress(R.drawable.magic_progress);

        //url image  load set.
       magicImageView.load("https://i.imgur.com/XGbwZnb.jpg",true);

        // url image clear cache.
       magicImageView.clearCache("https://i.imgur.com/XGbwZnb.jpg");

        // url all images clear cache.
       magicImageView.allClearCache();







    }
}
