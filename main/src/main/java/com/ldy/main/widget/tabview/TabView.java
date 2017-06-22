package com.ldy.main.widget.tabview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.StringRes;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ldy.common.util.DensityUtil;
import com.ldy.main.R;

import java.util.ArrayList;
import java.util.List;

public class TabView extends LinearLayout implements View.OnClickListener {


    private ViewPager mViewPager;
    private TabFragmentAdapter mPagerAdapter;
    private int mChildSize;
    private List<TabItem> mTabItems;
    private List<TextView> mMsgItems;

    private int mTextSize = 12;
    private int mTextColorSelect = 0xff45c01a;
    private int mTextColorNormal = 0xff777777;
    private int mPadding = 10;
    private int position = 2;
    /**
     * 中间大按钮的添加位置
     */
    private static final int positionCenter = 1;
    private String[] titles;
    private int[] iconNormals;
    private int[] iconSelects;

    public TabView(Context context) {
        this(context, null);
    }

    public TabView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public void setSelectedTab(int index) {
        mTabItems.get(index).setTabAlpha(1);
        for (int i = 0; i < mTabItems.size(); i++) {
            if (i == index) {
                mTabItems.get(i).setTabAlpha(1);
            } else {
                mTabItems.get(i).setTabAlpha(0);
            }
        }
    }

    /**
     * 显示选项卡上的消息提醒
     *
     * @param position 显示位置
     * @param text     显示内容
     */
    public void showMsgItem(int position, CharSequence text) {
        if (mMsgItems != null && !mMsgItems.isEmpty()) {
            if (mMsgItems.size() > position) {
                mMsgItems.get(position).setVisibility(View.VISIBLE);
                mMsgItems.get(position).setText(text);
            }
        }
    }

    /**
     * 隐藏消息提醒
     *
     * @param position
     */
    public void clearMsgItem(int position) {
        if (mMsgItems != null && !mMsgItems.isEmpty()) {
            if (mMsgItems.size() > position) {
                mMsgItems.get(position).setVisibility(View.INVISIBLE);
            }
        }
    }

    public TabView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = getResources().obtainAttributes(attrs, R.styleable.TabView);
        int N = typedArray.getIndexCount();
        for (int i = 0; i < N; i++) {
            int i1 = typedArray.getIndex(i);
            if (i1 == R.styleable.TabView_tab_text_size) {
                mTextSize = (int) typedArray.getDimension(i, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                        mTextSize, getResources().getDisplayMetrics()));

            } else if (i1 == R.styleable.TabView_tab_text_normal_color) {
                mTextColorNormal = typedArray.getColor(i, mTextColorNormal);

            } else if (i1 == R.styleable.TabView_tab_text_select_color) {
                mTextColorSelect = typedArray.getColor(i, mTextColorSelect);

            } else if (i1 == R.styleable.TabView_tab_item_padding) {
                mPadding = (int) typedArray.getDimension(i, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                        mPadding, getResources().getDisplayMetrics()));

            } else if (i1 == R.styleable.TabView_tab_main_position) {
                position = typedArray.getInt(i, position);

            } else {
            }
        }
        typedArray.recycle();
        mTabItems = new ArrayList<>();
        mMsgItems = new ArrayList<>();
    }

    public void setViewPager(final ViewPager mViewPager) {
        if (mViewPager == null) {
            return;
        }
        this.mViewPager = mViewPager;
        this.mPagerAdapter = (TabFragmentAdapter) mViewPager.getAdapter();
        if (this.mPagerAdapter == null) {
            throw new RuntimeException("在您设置TabView的ViewPager时，请先设置ViewPager的PagerAdapter");
        }
        this.mChildSize = this.mPagerAdapter.getCount();
        this.mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            private int position;

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (positionOffset > 0) {
                    mTabItems.get(position).setTabAlpha(1 - positionOffset);
                    mTabItems.get(position + 1).setTabAlpha(positionOffset);
                } else {
                    mTabItems.get(position).setTabAlpha(1 - positionOffset);
                }
            }

            @Override
            public void onPageSelected(int position) {
                this.position = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state == ViewPager.SCROLL_STATE_IDLE) {
                    for (int i = 0, length = mTabItems.size(); i < length; i++) {
                        TabItem tabItem = mTabItems.get(i);
                        if (i == position) {
                            tabItem.setTabAlpha(1);
                        } else {
                            tabItem.setTabAlpha(0);
                        }
                    }
                }
            }
        });
        initItem();
    }

    private void initItem() {
        int pointSize = DensityUtil.dip2px(18);
        int pointTopMargin = DensityUtil.dip2px(3);
        DisplayMetrics metrics = getContext().getResources().getDisplayMetrics();
        int i1 = DensityUtil.dip2px(23);
        int count = mChildSize;
        int pointRightMargin = metrics.widthPixels / count / 2 - i1;
//        int pointRightMargin = DeviceUtil.dp2px(getContext(), 10);
        for (int i = 0; i < mChildSize; i++) {
            RelativeLayout itemContainer = new RelativeLayout(getContext());
            LayoutParams containerLp = new LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1);
            itemContainer.setLayoutParams(containerLp);

            TabItem tabItem = new TabItem(getContext());
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            params.addRule(RelativeLayout.CENTER_IN_PARENT);

            tabItem.setPadding(mPadding, mPadding, mPadding, mPadding);
            tabItem.setIconText(getIconSelect(i), titles[i]);
            tabItem.setTextSize(mTextSize);
            tabItem.setTextColorNormal(mTextColorNormal);
            tabItem.setTextColorSelect(mTextColorSelect);
            tabItem.setLayoutParams(params);
            tabItem.setTag(i);
            tabItem.setOnClickListener(this);
            mTabItems.add(tabItem);

            itemContainer.addView(tabItem);

            TextView countText = new TextView(getContext());
            countText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 11);
            countText.setTextColor(Color.WHITE);
            countText.setGravity(Gravity.CENTER);
            countText.setBackgroundResource(R.drawable.bg_message_new);
            RelativeLayout.LayoutParams textLp = new RelativeLayout.LayoutParams(pointSize, pointSize);
            textLp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            textLp.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            textLp.rightMargin = pointRightMargin;
            textLp.topMargin = pointTopMargin;
            countText.setLayoutParams(textLp);
            countText.setVisibility(View.INVISIBLE);
            mMsgItems.add(countText);
            itemContainer.addView(countText);

            addView(itemContainer);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public void onClick(View v) {
        int position = (Integer) v.getTag();
        if (mViewPager.getCurrentItem() == position) {
            return;
        }
        for (TabItem tabItem : mTabItems) {
            tabItem.setTabAlpha(0);
        }
        mTabItems.get(position).setTabAlpha(1);
        mViewPager.setCurrentItem(position, false);
    }

    public void initData(@StringRes int[] titles, int[] iconNormals, int[] iconSelects) {
        this.titles = new String[titles.length];
        for (int i = 0; i < titles.length; i++) {
            this.titles[i] = getContext().getString(titles[i]);
        }
        this.iconNormals = iconNormals;
        this.iconSelects = iconSelects;
    }

    public int[] getIconSelect(int position) {
        int icon[] = new int[2];
        icon[0] = iconSelects[position];
        icon[1] = iconNormals[position];
        return icon;
    }
}
