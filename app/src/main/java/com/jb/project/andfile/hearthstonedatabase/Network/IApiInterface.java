package com.jb.project.andfile.hearthstonedatabase.Network;

import com.jb.project.andfile.hearthstonedatabase.Model.Card;

import java.util.List;

import io.realm.RealmList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by Alexander on 04.08.2017.
 */

public interface IApiInterface {

    @Headers("X-Mashape-Key:4l5odhB56ymshxVyss7uD163D1sjp1zjo1LjsnnhHUBmVV6evH")
    @GET("/cards/types/Minion?collectible=1")
    Call<RealmList<Card>> getCardsMinions();

    @Headers("X-Mashape-Key:4l5odhB56ymshxVyss7uD163D1sjp1zjo1LjsnnhHUBmVV6evH")
    @GET("/cards/types/Spell?collectible=1")
    Call<RealmList<Card>> getCardsSpells();

    @Headers("X-Mashape-Key:4l5odhB56ymshxVyss7uD163D1sjp1zjo1LjsnnhHUBmVV6evH")
    @GET("/cards/types/Weapon?collectible=1")
    Call<RealmList<Card>> getCardsWeapon();
}
