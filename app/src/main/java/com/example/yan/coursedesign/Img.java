package com.example.yan.coursedesign;

import android.graphics.Bitmap;

/**
 * Created by ACM-Yan on 2018/3/15.
 */

public class Img {
    private String name;

    private int headPic;
    private int imgContent;

    public Img(String name, int headPic, int imgContent) {
        this.name = name;
        this.headPic = headPic;
        this.imgContent = imgContent;
    }

    public Img() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeadPic() {
        return headPic;
    }

    public void setHeadPic(int headPic) {
        this.headPic = headPic;
    }

    public int getImgContent() {
        return imgContent;
    }

    public void setImgContent(int imgContent) {
        this.imgContent = imgContent;
    }
}
