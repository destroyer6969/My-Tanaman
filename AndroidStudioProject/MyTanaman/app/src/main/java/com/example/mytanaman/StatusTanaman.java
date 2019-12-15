package com.example.mytanaman;

import com.google.gson.annotations.SerializedName;

public class StatusTanaman {
    @SerializedName("nama")
    private String nama;
    @SerializedName("suhu")
    private Double suhu;
    @SerializedName("cahaya")
    private Double cahaya;
    @SerializedName("kelembaban")
    private Double kelembaban;
    @SerializedName("sudah_disinari")
    private Double sudah_disinari;
    @SerializedName("relay1")
    private Integer relay1;
    @SerializedName("relay2")
    private Integer relay2;
    @SerializedName("relay3")
    private Integer relay3;
    @SerializedName("relay4")
    private Integer relay4;
    @SerializedName("relay5")
    private Integer relay5;
    @SerializedName("relay6")
    private Integer relay6;
    @SerializedName("relay7")
    private Integer relay7;
    @SerializedName("relay8")
    private Integer relay8;

    @Override
    public String toString() {
        return "StatusTanaman{" +
                "nama='" + nama + '\'' +
                ", suhu=" + suhu +
                ", cahaya=" + cahaya +
                ", kelembaban=" + kelembaban +
                ", sudah_disinari=" + sudah_disinari +
                ", relay1=" + relay1 +
                ", relay2=" + relay2 +
                ", relay3=" + relay3 +
                ", relay4=" + relay4 +
                ", relay5=" + relay5 +
                ", relay6=" + relay6 +
                ", relay7=" + relay7 +
                ", relay8=" + relay8 +
                '}';
    }

    public Double getSudah_disinari() {
        return sudah_disinari;
    }

    public void setSudah_disinari(Double sudah_disinari) {
        this.sudah_disinari = sudah_disinari;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Double getSuhu() {
        return suhu;
    }

    public void setSuhu(Double suhu) {
        this.suhu = suhu;
    }

    public Double getCahaya() {
        return cahaya;
    }

    public void setCahaya(Double cahaya) {
        this.cahaya = cahaya;
    }

    public Double getKelembaban() {
        return kelembaban;
    }

    public void setKelembaban(Double kelembaban) {
        this.kelembaban = kelembaban;
    }

    public Integer getRelay1() {
        return relay1;
    }

    public void setRelay1(Integer relay1) {
        this.relay1 = relay1;
    }

    public Integer getRelay2() {
        return relay2;
    }

    public void setRelay2(Integer relay2) {
        this.relay2 = relay2;
    }

    public Integer getRelay3() {
        return relay3;
    }

    public void setRelay3(Integer relay3) {
        this.relay3 = relay3;
    }

    public Integer getRelay4() {
        return relay4;
    }

    public void setRelay4(Integer relay4) {
        this.relay4 = relay4;
    }

    public Integer getRelay5() {
        return relay5;
    }

    public void setRelay5(Integer relay5) {
        this.relay5 = relay5;
    }

    public Integer getRelay6() {
        return relay6;
    }

    public void setRelay6(Integer relay6) {
        this.relay6 = relay6;
    }

    public Integer getRelay7() {
        return relay7;
    }

    public void setRelay7(Integer relay7) {
        this.relay7 = relay7;
    }

    public Integer getRelay8() {
        return relay8;
    }

    public void setRelay8(Integer relay8) {
        this.relay8 = relay8;
    }
}
