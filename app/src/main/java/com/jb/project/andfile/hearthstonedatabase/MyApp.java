package com.jb.project.andfile.hearthstonedatabase;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import com.jb.project.andfile.hearthstonedatabase.DB.DBHandler;
import com.jb.project.andfile.hearthstonedatabase.Model.Card;
import com.jb.project.andfile.hearthstonedatabase.Network.ApiClient;
import com.jb.project.andfile.hearthstonedatabase.Network.IApiInterface;

import io.realm.Realm;
import io.realm.RealmList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Alexander on 07.08.2017.
 */

public class MyApp extends Application {

    private static Context sContext;
    private static IApiInterface mApiInterface;
    private static RealmList<Card> mCards;
    private static SharedPreferences sSharedPreferences;

    @Override
    public void onTerminate() {
        super.onTerminate();

    }

    @Override
    public void onCreate() {

        super.onCreate();
        Realm.init(this);
        sSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        sSharedPreferences.edit().putBoolean("update",true);
        mApiInterface = ApiClient.getApiClient().create(IApiInterface.class);
        Realm realm = Realm.getDefaultInstance();
        if (realm.isEmpty()) {

            Call<RealmList<Card>> call = mApiInterface.getCardsMinions();
            call.enqueue(new Callback<RealmList<Card>>() {
                @Override
                public void onResponse(Call<RealmList<Card>> call, Response<RealmList<Card>> response) {
                    mCards = response.body();
                    DBHandler.addAllCards(mCards);
                    Log.d("APPLICATION MINION", mCards.toString());
                }

                @Override
                public void onFailure(Call<RealmList<Card>> call, Throwable t) {

                }
            });

            Call<RealmList<Card>> call1 = mApiInterface.getCardsSpells();

            call1.enqueue(new Callback<RealmList<Card>>() {
                @Override
                public void onResponse(Call<RealmList<Card>> call, Response<RealmList<Card>> response) {
                    mCards = response.body();
                    DBHandler.addAllCards(mCards);
                    Log.d("APPLICATION SPELL", mCards.toString());
                }

                @Override
                public void onFailure(Call<RealmList<Card>> call, Throwable t) {

                }
            });
            Call<RealmList<Card>> call2 = mApiInterface.getCardsWeapon();

            call2.enqueue(new Callback<RealmList<Card>>() {
                @Override
                public void onResponse(Call<RealmList<Card>> call, Response<RealmList<Card>> response) {
                    mCards = response.body();
                    DBHandler.addAllCards(mCards);
                    Log.d("APPLICATION WEAPON", mCards.toString());
                }

                @Override
                public void onFailure(Call<RealmList<Card>> call, Throwable t) {

                }
            });

        } else {
            Log.d("APPLICATION", "noNeedToUpdate");
        }
}
}
