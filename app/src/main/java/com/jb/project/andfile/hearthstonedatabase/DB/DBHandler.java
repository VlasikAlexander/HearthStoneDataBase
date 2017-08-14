package com.jb.project.andfile.hearthstonedatabase.DB;

import android.util.Log;

import com.jb.project.andfile.hearthstonedatabase.Model.Card;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;
import retrofit2.Call;

/**
 * Created by Alexander on 05.08.2017.
 */

public class DBHandler  {


    public static void addAllCards(RealmList<Card> cards) {

        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        try {
            realm.copyToRealmOrUpdate(cards);
            Log.d("REALM", "YES");

        } catch (Exception e){
            Log.d("REALM", e.toString());
        }finally {

            realm.commitTransaction();
        }


    }

    public static void getCardById() {

    }

    public static RealmResults<Card> getAllCards() {

        Realm realm = Realm.getDefaultInstance();
       return realm.where(Card.class).findAll();
    }

    public static void deleteAll() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        realm.deleteAll();
        Log.d("REALM", "DB DELETED");
        realm.commitTransaction();
    }

    public static RealmResults<Card> getWeaponsCard() {
        Realm realm = Realm.getDefaultInstance();
        return realm.where(Card.class).contains("type", "Weapon").findAllSorted("name");
    }
    public static RealmResults<Card> getSpellsCard() {
        Realm realm = Realm.getDefaultInstance();
        return realm.where(Card.class).contains("type", "Spell").findAllSorted("name");
    }
    public static RealmResults<Card> getMinionsCard() {

        Realm realm = Realm.getDefaultInstance();
        return realm.where(Card.class).contains("type", "Minion").findAllSorted("name");
    }
}

