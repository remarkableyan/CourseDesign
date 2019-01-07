package com.example.yan.coursedesign.VO;

import android.graphics.Bitmap;

/**
 * Created by ACM-Yan on 2018/3/15.
 */

public class People {
    private String name;

    private String slabel;
    private int image;

    public People(String name, String slabel, int image) {
        this.name = name;
        this.slabel = slabel;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlabel() {
        return slabel;
    }

    public void setSlabel(String slabel) {
        this.slabel = slabel;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
