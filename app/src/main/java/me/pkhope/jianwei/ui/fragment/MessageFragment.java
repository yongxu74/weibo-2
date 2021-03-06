package me.pkhope.jianwei.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import me.pkhope.jianwei.ui.adapter.MyFragmentPagerAdapter;
import me.pkhope.jianwei.R;

/**
 * Created by pkhope on 2016/6/7.
 */
public class MessageFragment extends Fragment {

    private List<String> titleList = new ArrayList<>();
    private List<Fragment> fragmentList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_message, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        titleList.add("收到的");
        titleList.add("@我的");
        titleList.add("发出的");

        ViewPager viewPager = (ViewPager)getView().findViewById(R.id.msg_viewpager);
        fragmentList.add(new CommentToMeFragment());
        fragmentList.add(new MentionsFragment());
        fragmentList.add(new CommentByMeFragment());
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getChildFragmentManager(),fragmentList);
        viewPager.setAdapter(adapter);
        adapter.setTitleList(titleList);

        TabLayout tab = (TabLayout) getView().findViewById(R.id.tab);
        tab.setupWithViewPager(viewPager);
        tab.setTabMode(TabLayout.MODE_FIXED);
    }
}
