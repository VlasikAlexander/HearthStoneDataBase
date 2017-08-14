package com.jb.project.andfile.hearthstonedatabase.Model;

import io.realm.RealmObject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

        public class Mechanic extends RealmObject {

        @SerializedName("name")
        @Expose
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

