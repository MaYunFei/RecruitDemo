package com.demo.kaiyun.androiddemo.ui.company;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.demo.kaiyun.androiddemo.R;
import com.demo.kaiyun.androiddemo.ui.student.HomeFragment;
import com.demo.kaiyun.androiddemo.ui.student.MeFragment;
import com.demo.kaiyun.androiddemo.ui.student.ResumeFragment;

public class CompanyMainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private ViewPager viewPager;
    private Toolbar toolbar;
    private HomeFragment homeFragment = new HomeFragment();
    private MeFragment meFragment = new MeFragment();
    private ResumeFragment resumeFragment = new ResumeFragment();
    private BottomNavigationView navigation;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int order = item.getOrder();
            viewPager.setCurrentItem(item.getOrder());
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_main);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        //添加viewPager事件监听（很容易忘）
        viewPager.addOnPageChangeListener(this);
        setTitle(R.string.title_home);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return homeFragment;
                    case 1:
                        return resumeFragment;
                    case 2:
                        return meFragment;
                }
                return null;
            }

            @Override
            public CharSequence getPageTitle(int position) {

                switch (position) {
                    case 0:
                        getString(R.string.title_home);
                    case 1:
                        getString(R.string.title_dashboard);
                    case 2:
                        getString(R.string.title_notifications);
                }
                return "";
            }

            @Override
            public int getCount() {
                return 3;
            }
        });
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        //页面滑动的时候，改变BottomNavigationView的Item高亮
        getSupportActionBar().setTitle(navigation.getMenu().getItem(position).getTitle());
        navigation.getMenu().getItem(position).setChecked(true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
