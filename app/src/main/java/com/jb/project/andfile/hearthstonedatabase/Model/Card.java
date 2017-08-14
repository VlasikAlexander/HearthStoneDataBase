package com.jb.project.andfile.hearthstonedatabase.Model;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Card extends RealmObject {



    @SerializedName("cardId")

    @Expose
    private String cardId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("cardSet")
    @Expose
    private String cardSet;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("faction")
    @Expose
    private String faction;
    @SerializedName("rarity")
    @Expose
    private String rarity;
    @SerializedName("cost")
    @Expose
    private Integer cost;
    @SerializedName("attack")
    @Expose
    private Integer attack;
    @SerializedName("health")
    @Expose
    private Integer health;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("flavor")
    @Expose
    private String flavor;
    @SerializedName("artist")
    @Expose
    private String artist;
    @SerializedName("collectible")
    @Expose
    private Boolean collectible;
    @SerializedName("elite")
    @Expose
    private Boolean elite;
    @SerializedName("race")
    @Expose
    private String race;
    @SerializedName("img")
    @Expose
    private String img;
    @SerializedName("imgGold")
    @Expose
    private String imgGold;
    @SerializedName("locale")
    @Expose
    private String locale;
    @SerializedName("mechanics")
    @Expose
    private RealmList<Mechanic> mechanics = null;

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardSet() {
        return cardSet;
    }

    public void setCardSet(String cardSet) {
        this.cardSet = cardSet;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFaction() {
        return faction;
    }

    public void setFaction(String faction) {
        this.faction = faction;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Boolean getCollectible() {
        return collectible;
    }

    public void setCollectible(Boolean collectible) {
        this.collectible = collectible;
    }

    public Boolean getElite() {
        return elite;
    }

    public void setElite(Boolean elite) {
        this.elite = elite;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getImgGold() {
        return imgGold;
    }

    public void setImgGold(String imgGold) {
        this.imgGold = imgGold;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public RealmList<Mechanic> getMechanics() {
        return mechanics;
    }

    public void setMechanics(RealmList<Mechanic> mechanics) {
        this.mechanics = mechanics;
    }
}