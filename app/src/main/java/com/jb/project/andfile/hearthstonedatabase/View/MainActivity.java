package com.jb.project.andfile.hearthstonedatabase.View;

import android.support.design.widget.TabLayout;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.jb.project.andfile.hearthstonedatabase.Model.Card;
import com.jb.project.andfile.hearthstonedatabase.R;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

import static android.support.design.widget.TabLayout.*;


public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    ViewPagerAdapter adapter;
    RecyclerListFragment mFragment;
    FragmentManager fm;
    RecyclerViewAdapter mRecyclerViewAdapter;
    SearchView search;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("HearthStone");




        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(3);
        setupViewPager(viewPager);


        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);


    }

    private void setupViewPager(final ViewPager viewPager) {

        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(RecyclerListFragment.newInstance("minion"), "Minions");
        adapter.addFragment(RecyclerListFragment.newInstance("weapon"), "Weapons");
        adapter.addFragment(RecyclerListFragment.newInstance("spell"), "Spells");
        viewPager.setAdapter(adapter);
    }
    public RecyclerListFragment getFragment() {
        return ViewPagerAdapter.mFragmentList.get(viewPager.getCurrentItem());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d("onCreateMenu", "Created");
        getMenuInflater().inflate(R.menu.menu_items, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        MenuItem menuItem1 = menu.findItem(R.id.action_view);
        menuItem1.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                getFragment().changeRecyclerView();
                return false;
            }
        });
        SearchView search = (SearchView) menuItem.getActionView();

        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                newText = newText.toLowerCase();
                mFragment = getFragment();
                ArrayList<Card> cards = new ArrayList<Card>();


                for (Card card: mFragment.getmCardListArray() ) {
                    String name = card.getName().toLowerCase();
                    if (name.contains(newText))
                        cards.add(card);

                }
                mFragment.mRecyclerViewAdapter.setFilter(cards);

                return false;
            }
        });

            return true;
    }


}

