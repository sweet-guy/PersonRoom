package com.wdcloud.personroom.activity.view;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wdcloud.personroom.R;

public class SplashActivity extends AppCompatActivity implements Animation.AnimationListener{
//    private static final int ANIM_TIME = 1000;
//    @BindView(R.id.img_spl)
//    ImageView imgSpl;
//    @BindView(R.id.text_spl)
//    TextView textSpl;
//    @BindView(R.id.rv_spl)
//    RelativeLayout rvSpl;
//    private Unbinder bind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏状态栏
//        setContentView(R.layout.activity_splash);
//        bind = ButterKnife.bind(this);
//        ScaleAnimation sa = new ScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
//        sa.setDuration(ANIM_TIME);
//        imgSpl.startAnimation(sa);
//        textSpl.startAnimation(sa);
//        AlphaAnimation mShowAnimation = new AlphaAnimation(0.0f, 1.0f);
//        mShowAnimation.setDuration(ANIM_TIME*2);
//        mShowAnimation.setFillAfter(true);
//        mShowAnimation.setAnimationListener(this);
//        rvSpl.startAnimation(mShowAnimation);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        bind.unbind();
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
//        startActivity(new Intent(SplashActivity.this, MainActivity.class));
//        finish();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
