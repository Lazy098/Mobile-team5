package vn.edu.usth.nutrition_recipe;

import java.io.Serializable;

public class Food implements Serializable{

    private String mName;
    private Integer mCalo;
    private Integer mFat;
    private Integer mCarbohydrate;
    private Integer mVitamin;
    private Integer mProtein;

    public Food(String mName, Integer mCalo, Integer mFat, Integer mCarbohydrate, Integer mProtein, Integer mVitamin) {
        this.mName = mName;
        this.mCalo = mCalo;
        this.mFat = mFat;
        this.mCarbohydrate = mCarbohydrate;
        this.mVitamin = mVitamin;
        this.mProtein = mProtein;
    }

    public String getmName() {
        return mName;
    }

    public Integer getmCalo() { return mCalo;}

    public Integer getmFat() {
        return mFat;
    }

    public Integer getmCarbohydrate() { return mCarbohydrate;}

    public Integer getmVitamin() {
        return mVitamin;
    }

    public Integer getmProtein() { return mProtein;}

}
