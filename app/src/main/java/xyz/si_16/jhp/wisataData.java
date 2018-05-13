package xyz.si_16.jhp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;

public class wisataData {
    private String wisataName;
    private int wisataImage;
    static final String NAME_KEY = "Wisata Name";
    static final String IMAGE_KEY = "Wisata Image";

    public wisataData(String wisataName; int wisataImage){
        this.wisataName=wisataName;
        this.wisataImage=wisataImage;
    }

    public String getWisataName(){
        return wisataName;
    }

    public int getWisataImage(){
        return wisataImage;
    }

    static Intent startr(Context context, String wisataName, @DrawableRes int wisataImage){
        Intent detailIntent = new Intent(context, detail_activity.class);
        detailIntent.putExtra(NAME_KEY, wisataName);
        detailIntent.putExtra(IMAGE_KEY, wisataImage);
        return detailIntent;
    }
}
