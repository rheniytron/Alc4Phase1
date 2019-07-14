package com.usablecoder.alc4phase1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MyProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        initProfilePicture();
    }

    public void initProfilePicture() {
        ImageView profile_pic = (ImageView) findViewById(R.id.imageView);

        Glide.with(this)
                .load(R.mipmap.mi)
                .centerCrop()
                .into(profile_pic);
    }

    public void go_home(View view) {
        finish();
    }


    public void sendWhatsappFeedback(View view) {
        Toast.makeText(MyProfile.this,"FEEDBACKS PLEASE",Toast.LENGTH_SHORT).show();

        Uri uri = Uri.parse("smsto:" + "2348090526685");
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);

        intent.putExtra(Intent.EXTRA_TEXT, "Well done from Alc4App");

        intent.setPackage("com.whatsapp");
        startActivity(Intent.createChooser(intent," Share with"));

    }
}
