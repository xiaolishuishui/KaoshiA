package com.example.administrator.kaoshia;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
/*
* 我叫李强，在H1612B正在考试A场
*
* */
public class MainActivity extends AppCompatActivity {

    private TextView tvtv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


    }

    private void initView() {
        tvtv = (TextView) findViewById(R.id.tvtv);
        ObjectAnimator anim1 = ObjectAnimator.ofFloat(tvtv, "alpha", 0.0f, 1.0f); //透明
        anim1.setDuration(2000);
        anim1.start();
        anim1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

                ObjectAnimator anim1 = ObjectAnimator.ofFloat(tvtv, "alpha", 1.0f, 0f); //透明
                anim1.setDuration(2000);
                anim1.start();
               anim1.addListener(new Animator.AnimatorListener() {
                   @Override
                   public void onAnimationStart(Animator animation) {

                   }

                   @Override
                   public void onAnimationEnd(Animator animation) {
                       startActivity(new Intent(MainActivity.this, Main2Activity.class));
                   }

                   @Override
                   public void onAnimationCancel(Animator animation) {

                   }

                   @Override
                   public void onAnimationRepeat(Animator animation) {

                   }
               });
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });


    }
}
