package com.jb.project.andfile.hearthstonedatabase;

import android.content.Context;
import android.support.v7.widget.SearchView;
import android.util.Log;

import com.jb.project.andfile.hearthstonedatabase.Model.Card;
import com.jb.project.andfile.hearthstonedatabase.View.RecyclerListFragment;
import com.jb.project.andfile.hearthstonedatabase.View.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander on 10.08.2017.
 */

public class SearchViewListener implements SearchView.OnQueryTextListener {

    Context context;
    ArrayList<Card> mCards;
    RecyclerListFragment mFragment;
    RecyclerViewAdapter mRecyclerViewAdapter;
    List<RecyclerListFragment> mListFragments;

    public SearchViewListener(Context context) {
        this.context = context;

    }

    @Override
    public boolean onQueryTextSubmit(String newText) {

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.d("MAIN", "onQUeryTextChange");
        Log.d("MAIN_ACTIVITY", "onQuerySubmit");
        newText = newText.toLowerCase();
        ArrayList<Card> cards = new ArrayList<>();
        for (Card card: RecyclerListFragment.mCardListArray) {
            String name = card.getName().toLowerCase();
            if (name.contains(newText))
                cards.add(card);

        }

        return false;
    }
}
