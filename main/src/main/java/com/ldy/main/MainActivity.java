package com.ldy.main;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ldy.common.base.ComparableWrapper;
import com.ldy.main.common.entity.MainPageEntity;
import com.ldy.main.common.event.GetMainPageEvent;
import com.ldy.main.widget.tabview.TabFragmentAdapter;
import com.ldy.main.widget.tabview.TabView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabView tabView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_main);
        viewPager = ((ViewPager) findViewById(R.id.vp_main));
        tabView = ((TabView) findViewById(R.id.tabview_main));

        GetMainPageEvent event = new GetMainPageEvent();
        EventBus.getDefault().post(event);

        int length = event.size();
        ArrayList<Fragment> fragments = new ArrayList<>(length);
        int[] titles = new int[length];
        int[] iconNormals = new int[length];
        int[] iconSelects = new int[length];
        int i = 0;
        for (ComparableWrapper<MainPageEntity> comparableWrapper : event) {
            MainPageEntity mainPageEntity = comparableWrapper.getContent();
            titles[i] = mainPageEntity.getTitleRes();
            iconNormals[i] = mainPageEntity.getIconNormalRes();
            iconSelects[i] = mainPageEntity.getIconSelectRes();
            fragments.add(mainPageEntity.getFragmentFactory().build());
            i++;
        }
        viewPager.setAdapter(new TabFragmentAdapter(getSupportFragmentManager(), fragments));
        tabView.initData(titles, iconNormals, iconSelects);
        tabView.setViewPager(viewPager);
    }
}
