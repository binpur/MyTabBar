package com.app.ada.mytabbar;

import java.util.List;
import java.util.Locale;

import com.app.ada.mytabbar.R;
import com.mirko.tbv.TabBarView;
import com.mirko.tbv.TabBarView.IconTabProvider;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;


import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements ItemFragment.OnFragmentInteractionListener {

    private String TAG = MainActivity.class.getCanonicalName();
    private TabBarView tabBarView;


    SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"onCreate");

        LayoutInflater inflator =
                (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v = inflator.inflate(R.layout.custom_ab, null);
        tabBarView = (TabBarView) v.findViewById(R.id.tab_bar);

        getActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getActionBar().setCustomView(v);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        tabBarView.setViewPager(mViewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter implements IconTabProvider{

        private int[] tab_icons={R.drawable.ic_tab1,
                R.drawable.ic_tab2
        };


        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class
            // below).
            return ItemFragment.newInstance(position);
            //return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return tab_icons.length;
        }

        @Override
        public int getPageIconResId(int position) {
            return tab_icons[position];
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.title_section1).toUpperCase(l);
                case 1:
                    return getString(R.string.title_section2).toUpperCase(l);
            }
            return null;
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
   /* public static class PlaceholderFragment extends Fragment {
        *//**
         * The fragment argument representing the section number for this
         * fragment.
         *//*
        private static final String ARG_SECTION_NUMBER = "section_number";

        *//**
         * Returns a new instance of this fragment for the given section number.
         *//*
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container,
                    false);
            TextView textView = (TextView) rootView
                    .findViewById(R.id.section_label);
            textView.setText(Integer.toString(getArguments().getInt(
                    ARG_SECTION_NUMBER)));
            return rootView;
        }
    }*/


    @Override
    public void onFragmentInteraction(MyListItem item) {
        Toast.makeText(this, item.getName() + " Clicked!"
                , Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onFragmentInteraction(List<MyListItem> list, int position) {

    }

    public void onFragmentInteraction(View view){

    }

    public void onFragmentInteraction(AdapterView<?> parent, View view, int position, long id){

    }

    private void clickEffect(MyListItem item){

    }
}
