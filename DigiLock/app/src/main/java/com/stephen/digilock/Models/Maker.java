package com.stephen.digilock.Models;

import android.content.ContentValues;

import com.stephen.digilock.Database.DGDatabaseSchema;

import java.util.ArrayList;

/**
 * Created by stephen on 17/08/2017.
 */

public class Maker {

    private static final String ONE = "1";
    private static final String TWO = "2";
    private static final String THREE = "3";
    private static final String FOUR = "4";
    private static final String FIVE = "5";
    private static final String SIX = "6";
    private static final String SEVEN = "7";
    private static final String EIGHT = "8";
    private static final String NINE = "9";
    private static final String A = "a";
    private static final String B = "b";
    private static final String C = "c";
    private static final String D = "d";
    private static final String E = "e";
    private static final String F = "f";
    private static final String G = "g";
    private static final String H = "h";
    private static final String I = "i";
    private static final String J = "j";
    private static final String K = "k";
    private static final String L = "l";
    private static final String M = "m";
    private static final String N = "n";
    private static final String O = "o";
    private static final String P = "p";
    private static final String Q = "q";
    private static final String R = "r";
    private static final String S = "s";
    private static final String T = "t";
    private static final String U = "u";
    private static final String V = "v";
    private static final String W = "w";
    private static final String X = "x";
    private static final String Y = "y";
    private static final String Z = "z";
    private static final String AT = "@";
    private static final String HASHTAG = "#";
    private static final String UNDER_SCORE = "_";
    private static final String AMPERSAND = "&";
    private static final String DASH = "-";
    private static final String PLUS = "+";
    private static final String OPEN_BRACKET = "(";
    private static final String CLOSE_BRACKET = ")";
    private static final String FORWARD_SLASH = "/";
    private static final String ASTERIX = "*";
    private static final String APOSTROPHE = "'";
    private static final String COLON = ":";
    private static final String SEMI_COLON = ";";
    private static final String EXCLAMAITION_MARK = "!";
    private static final String QUESTION_MARK = "?";
    private static final String OPEN_SQUARE_BRACKET = "[";
    private static final String CLOSE_SQUARE_BRACKET = "]";
    private static final String COMMA = ",";
    private static final String FULL_STOP = ".";


    private long id;
    private String secret;

    public Maker(long id, String secret) {
        this.id = id;
        this.secret = secret;
    }

    public Maker(String secret) {
        this.secret = secret;
    }

    private ArrayList<String> features = new ArrayList<>();

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getSecret() {
        return secret;
    }

    public ArrayList<String> getFeatures() {
        return features;
    }

    public void setFeatures(ArrayList<String> features) {
        this.features = features;
    }


    public static ContentValues getContentValues(Maker m) {
        ContentValues values = new ContentValues();
        values.put(DGDatabaseSchema.MakerTable.MakerCols.ID, m.getId());
        values.put(DGDatabaseSchema.MakerTable.MakerCols.SECRET, m.getSecret());

        return values;
    }
}
