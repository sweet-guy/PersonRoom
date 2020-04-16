package com.wdcloud.personroom;

import android.os.Bundle;
import android.view.View;

import com.next.easynavigation.view.EasyNavigationBar;
import com.wdcloud.personroom.fragment.AFragment;
import com.wdcloud.personroom.fragment.BFragment;
import com.wdcloud.personroom.fragment.CFragment;
import com.wdcloud.personroom.fragment.DFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import static com.next.easynavigation.constant.Anim.DropOut;

public class MainActivity extends AppCompatActivity {
    private EasyNavigationBar navigationBar;

    private String[] tabText = {"首页", "发现", "消息", "我的"};
    //未选中icon
    private int[] normalIcon = {R.mipmap.index, R.mipmap.find, R.mipmap.message, R.mipmap.me};
    //选中时icon
    private int[] selectIcon = {R.mipmap.index1, R.mipmap.find1, R.mipmap.message1, R.mipmap.me1};

    private List<Fragment> fragments = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationBar = findViewById(R.id.navigationBar);

        fragments.add(new AFragment());
        fragments.add(new BFragment());
        fragments.add(new CFragment());
        fragments.add(new DFragment());

        navigationBar.titleItems(tabText)
                .normalIconItems(normalIcon)
                .selectIconItems(selectIcon)
                .fragmentList(fragments)
                .anim(DropOut)
                .fragmentManager(getSupportFragmentManager())
                .canScroll(true)
                .onTabClickListener(new EasyNavigationBar.OnTabClickListener() {
                    @Override
                    public boolean onTabClickEvent(View view, int position) {
                        return false;
                    }
                })
                .build();
    }
}
