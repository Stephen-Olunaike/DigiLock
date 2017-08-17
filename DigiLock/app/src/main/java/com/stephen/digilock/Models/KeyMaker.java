package com.stephen.digilock.Models;

/**
 * Created by stephen on 17/08/2017.
 */

public class KeyMaker {


    private static final KeyMaker ourInstance = new KeyMaker();


    public static KeyMaker getInstance() {
        return ourInstance;
    }

    private KeyMaker() {
    }

    private Maker maker = null;

    public void setMaker(Maker maker) {
        this.maker = maker;
    }

}
