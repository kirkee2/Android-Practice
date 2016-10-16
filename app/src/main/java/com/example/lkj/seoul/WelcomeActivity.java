package com.example.lkj.seoul;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.media.MediaBrowserServiceCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lkj.seoul.Connection.Connect;
import com.example.lkj.seoul.Connection.WebHook;
import com.example.lkj.seoul.Kakao_Login.LoginActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class WelcomeActivity extends AppCompatActivity {

    private ImageView img;
    private Animation animation;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        new WebHook().execute("good async",null,null);

        textView = (TextView) findViewById(R.id.textView);
        img = (ImageView) findViewById(R.id.imageView);
        animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animation2);
        img.setAnimation(animation);
        textView.setAnimation(animation);


        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                finish();
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
