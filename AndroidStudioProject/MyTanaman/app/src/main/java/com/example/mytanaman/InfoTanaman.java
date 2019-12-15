package com.example.mytanaman;

import com.google.gson.annotations.SerializedName;

public class InfoTanaman {
    @SerializedName("nama")
    private String nama;
    @SerializedName("suhu_atas")
    private String suhu_atas;
    @SerializedName("suhu_bawah")
    private String suhu_bawah;
    @SerializedName("cahaya_atas")
    private String cahaya_atas;
    @SerializedName("cahaya_bawah")
    private String cahaya_bawah;
    @SerializedName("kelembaban_atas")
    private String kelembaban_atas;
    @SerializedName("kelembaban_bawah")
    private String kelembaban_bawah;

    @Override
    public String toString() {
        return "InfoTanaman{" +
                "nama='" + nama + '\'' +
                ", suhu_atas='" + suhu_atas + '\'' +
                ", suhu_bawah='" + suhu_bawah + '\'' +
                ", cahaya_atas='" + cahaya_atas + '\'' +
                ", cahaya_bawah='" + cahaya_bawah + '\'' +
                ", kelembaban_atas='" + kelembaban_atas + '\'' +
                ", kelembaban_bawah='" + kelembaban_bawah + '\'' +
                '}';
    }


    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getSuhu_atas() {
        return suhu_atas;
    }

    public void setSuhu_atas(String suhu_atas) {
        this.suhu_atas = suhu_atas;
    }

    public String getSuhu_bawah() {
        return suhu_bawah;
    }

    public void setSuhu_bawah(String suhu_bawah) {
        this.suhu_bawah = suhu_bawah;
    }

    public String getCahaya_atas() {
        return cahaya_atas;
    }

    public void setCahaya_atas(String cahaya_atas) {
        this.cahaya_atas = cahaya_atas;
    }

    public String getCahaya_bawah() {
        return cahaya_bawah;
    }

    public void setCahaya_bawah(String cahaya_bawah) {
        this.cahaya_bawah = cahaya_bawah;
    }

    public String getKelembaban_atas() {
        return kelembaban_atas;
    }

    public void setKelembaban_atas(String kelembaban_atas) {
        this.kelembaban_atas = kelembaban_atas;
    }

    public String getKelembaban_bawah() {
        return kelembaban_bawah;
    }

    public void setKelembaban_bawah(String kelembaban_bawah) {
        this.kelembaban_bawah = kelembaban_bawah;
    }
}