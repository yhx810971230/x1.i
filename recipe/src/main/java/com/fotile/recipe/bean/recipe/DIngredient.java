package com.fotile.recipe.bean.recipe;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * 文件名称：DIngredient
 * 创建时间：2017-12-22 15:07
 * 文件作者：shihuijuan
 * 功能描述：菜谱D配料
 */

public class DIngredient implements Parcelable{
    /**
     * 配料用量
     */
    @SerializedName("unit")
    @Expose
    private String unit;

    /**
     * 配料名称
     */
    @SerializedName("name")
    @Expose
    private String name;

    public DIngredient() {
    }

    protected DIngredient(Parcel in) {
        unit = in.readString();
        name = in.readString();
    }

    public static final Creator<DIngredient> CREATOR = new Creator<DIngredient>() {
        @Override
        public DIngredient createFromParcel(Parcel in) {
            return new DIngredient(in);
        }

        @Override
        public DIngredient[] newArray(int size) {
            return new DIngredient[size];
        }
    };

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(unit);
        dest.writeString(name);
    }
}
