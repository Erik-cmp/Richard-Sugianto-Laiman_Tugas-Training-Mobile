package com.example.tugaspert2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class HomeActivity extends AppCompatActivity {

    Button logout;
    TextView username, email;
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    PageAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        logout = findViewById(R.id.btn_logout);
        username = findViewById(R.id.tv_username);
        email = findViewById(R.id.tv_email);
        tabLayout = findViewById(R.id.tab_layout);
        viewPager2 = findViewById(R.id.view_pager);

        Intent intent = getIntent();
        String tempUsername = intent.getStringExtra("account_username");
        String tempEmail = intent.getStringExtra("account_email");

        username.setText(tempUsername);
        email.setText(tempEmail);

        logout.setOnClickListener(v -> {
            Intent logoutIntent = new Intent(HomeActivity.this, MainActivity.class);
            startActivity(logoutIntent);
        });

        setViewPager2(viewPager2);

        new TabLayoutMediator(tabLayout, viewPager2, ((tab, position) -> {
            tab.setText(pageAdapter.getFragmentTitle(position));
        })).attach();
    }

    private void setViewPager2(ViewPager2 viewPager2){
        if(pageAdapter == null){
            pageAdapter = new PageAdapter(this);
            pageAdapter.addFragment(new HomeFragment(), "home");
            pageAdapter.addFragment(new SecondFragment(), "second");
            viewPager2.setAdapter(pageAdapter);
        }
    }
}