package com.ldy.main;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ldy.account.common.service.AccountService;
import com.ldy.account.common.service.AccountServiceRepository;
import com.ldy.main.common.entity.MainPageEntity;
import com.ldy.main.common.event.InitMainPageEvent;
import com.ldy.main.serviceimpl.MainServiceImpl;
import com.ldy.main.widget.tabview.TabFragmentAdapter;
import com.ldy.main.widget.tabview.TabView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabView tabView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = ((ViewPager) findViewById(R.id.vp_main));
        tabView = ((TabView) findViewById(R.id.tabview_main));

        EventBus.getDefault().post(new InitMainPageEvent());
        List<MainPageEntity> pageEntityList = MainServiceImpl.instance().getPageEntityList();

        int length = pageEntityList.size();
        ArrayList<Fragment> fragments = new ArrayList<>(length);
        int[] titles = new int[length];
        int[] iconNormals = new int[length];
        int[] iconSelects = new int[length];
        int i = 0;
        for (MainPageEntity mainPageEntity : pageEntityList) {
            titles[i] = mainPageEntity.getTitleRes().build();
            iconNormals[i] = mainPageEntity.getIconNormalRes().build();
            iconSelects[i] = mainPageEntity.getIconSelectRes().build();
            fragments.add(mainPageEntity.getFragmentFactory().build());
            i++;
        }
        viewPager.setAdapter(new TabFragmentAdapter(getSupportFragmentManager(), fragments));
        tabView.initData(titles, iconNormals, iconSelects);
        tabView.setViewPager(viewPager);
    }
}
