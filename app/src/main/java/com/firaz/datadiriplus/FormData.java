package com.firaz.datadiriplus;

import android.os.Parcel;
import android.os.Parcelable;

public class FormData implements Parcelable {
    String nama, NPM;

    public String getNPM() {
        return NPM;
    }

    public void setNPM(String NPM) {
        this.NPM = NPM;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeString(this.NPM);
    }

    public FormData() {
    }

    protected FormData(Parcel in) {
        this.nama = in.readString();
        this.NPM = in.readString();
    }

    public static final Parcelable.Creator<FormData> CREATOR = new Parcelable.Creator<FormData>() {
        @Override
        public FormData createFromParcel(Parcel source) {
            return new FormData(source);
        }

        @Override
        public FormData[] newArray(int size) {
            return new FormData[size];
        }
    };
}
