package com.usablecoder.alc4phase1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initProfilePicture();
    }

    public void initProfilePicture() {
        ImageView alc_bg = (ImageView) findViewById(R.id.image_bg);
        ImageView alc_logo = (ImageView) findViewById(R.id.alc_logo);

        Glide.with(this)
                .load(R.mipmap.alc2019_fullcolor)
                .centerCrop()
                .into(alc_logo);

        Glide.with(this)
                .load(R.mipmap.alc_group_photo)
                .centerCrop()
                .into(alc_bg );
    }

    public void openAlcWebpage(View view) {
        Intent intent = new Intent(this, OpenWebpage.class);
        startActivity(intent);
        Log.d("NIY", "alcWebPage: ");
    }

    public void myProfile(View view) {
        startActivity(new Intent(this, MyProfile.class));
        Log.d("NIY", "myProfile: ");
    }
}
