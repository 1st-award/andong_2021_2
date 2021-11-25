package com.example.actionbar1_project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.FragmentTransaction;

@SuppressWarnings("deprecation")
public class MainActivity extends AppCompatActivity implements ActionBar.TabListener{
    ActionBar.Tab tabDog, tabCat, tabRabbit, tabHorse;
    MyTabFragment myFrags[] = new MyTabFragment[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar bar = getSupportActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        tabDog = bar.newTab();
        tabDog.setIcon(R.drawable.pictodog);
        tabDog.setTabListener(this);
        bar.addTab(tabDog);

        tabCat = bar.newTab();
        tabCat.setIcon(R.drawable.pictocat);
        tabCat.setTabListener(this);
        bar.addTab(tabCat);

        tabRabbit = bar.newTab();
        tabRabbit.setIcon(R.drawable.pictorabbit);
        tabRabbit.setTabListener(this);
        bar.addTab(tabRabbit);
        
        tabHorse = bar.newTab();
        tabHorse.setIcon(R.drawable.pictohorse);
        tabHorse.setTabListener(this);
        bar.addTab(tabHorse);

        bar.setDisplayShowCustomEnabled(false);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        MyTabFragment myTabFrag = null;

        if (myFrags[tab.getPosition()] == null) {

            myTabFrag = new MyTabFragment();
            Bundle data = new Bundle();
            data.putString("tabPosition", Integer.toString(tab.getPosition()));

            myTabFrag.setArguments(data);
            myFrags[tab.getPosition()] = myTabFrag;
        } else
            myTabFrag = myFrags[tab.getPosition()];


        ft.replace(android.R.id.content, myTabFrag);

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
    }

    public static class MyTabFragment extends androidx.fragment.app.Fragment {
        String tabPosition;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Bundle data = getArguments();
            tabPosition = data.getString("tabPosition");
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // activity_main.xml에 구성된 요소들을 view에 저장한다.
            View view = inflater.inflate(R.layout.activity_main, null);
            ImageView imageView = view.findViewById(R.id.imageView);
            System.out.println(tabPosition);
            if (tabPosition.equals("0"))
                imageView.setImageResource(R.drawable.dog);
            if (tabPosition.equals("1"))
                imageView.setImageResource(R.drawable.cat);
            if (tabPosition.equals("2"))
                imageView.setImageResource(R.drawable.rabbit);
            if (tabPosition.equals("3"))
                imageView.setImageResource(R.drawable.horse);

            return view;
        }
    }
}

