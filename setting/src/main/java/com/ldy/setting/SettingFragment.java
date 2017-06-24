package com.ldy.setting;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.ldy.common.base.BaseFragment;
import com.ldy.common.base.ComparableWrapper;
import com.ldy.common.modulecommunication.event.plug.EventControl;
import com.ldy.setting.common.event.GetSettingItemEvent;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends BaseFragment {


    public SettingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LinearLayout view = (LinearLayout) inflater.inflate(R.layout.setting_fragment_setting, container, false);
        GetSettingItemEvent event = new GetSettingItemEvent(getActivity());
        EventControl.instance().post(event);
        for (ComparableWrapper<View> wrapper : event) {
            View content = wrapper.getContent();
            view.addView(content);
        }
        return view;
    }

}
