package com.jb.project.andfile.hearthstonedatabase.View;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jb.project.andfile.hearthstonedatabase.DB.DBHandler;
import com.jb.project.andfile.hearthstonedatabase.IConstant;
import com.jb.project.andfile.hearthstonedatabase.Model.Card;
import com.jb.project.andfile.hearthstonedatabase.R;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

/**
 * Created by Alexander on 04.08.2017.
 */

public class RecyclerListFragment extends Fragment implements IConstant {

    RecyclerView mRecyclerView;
    RecyclerViewAdapter mRecyclerViewAdapter;
    private  static RealmResults<Card> mCardsList;
    LinearLayoutManager mLayoutManager;
    public  static ArrayList<Card> mCardListArray = null;
    private GridLayoutManager mGridLayoutManager;
    private Boolean isGrid = false;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.recycler_view_fragment, container, false);



        mRecyclerView = v.findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(getContext());
        mGridLayoutManager = new GridLayoutManager(getContext(), 3);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerViewAdapter = new RecyclerViewAdapter(getmCardListArray(), getContext());
        
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
        Log.d(RECYCLERLISTFRAGMENT, "onCreate");

    return v;
    }

    public ArrayList<Card> getmCardListArray() {
        Realm realm = Realm.getDefaultInstance();
        mCardListArray = (ArrayList<Card>) realm.copyFromRealm(getCardList(getArguments().getString("type")));
        return mCardListArray;
    }

    public static RecyclerListFragment newInstance(String type)
    {
        RecyclerListFragment myFragment = new RecyclerListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("type", type);
        myFragment.setArguments(bundle);
        return myFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public static RealmResults<Card> getCardList(String type) {
        switch (type) {
            case "weapon": mCardsList = DBHandler.getWeaponsCard();
                return mCardsList;
            case "spell": mCardsList = DBHandler.getSpellsCard();
                return mCardsList;
            case "minion": mCardsList = DBHandler.getMinionsCard();
                return mCardsList;
        }
        return mCardsList;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    public void changeRecyclerView() {
        if (!isGrid)
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        else mRecyclerView.setLayoutManager(mLayoutManager);
        isGrid = !isGrid;
    }


}
