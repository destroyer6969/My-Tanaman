package com.example.mytanaman;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface API {
    @FormUrlEncoded
    @POST("info_handler.php")
    Call<InfoTanamanStr> setInfoTanaman(
            @Field("nama") String nama,
            @Field("suhu_atas") String suhu_atas,
            @Field("suhu_bawah") String suhu_bawah,
            @Field("cahaya_atas") String cahaya_atas,
            @Field("cahaya_bawah") String cahaya_bawah,
            @Field("kelembaban_atas") String kelembaban_atas,
            @Field("kelembaban_bawah") String kelembaban_bawah,
            @Field("lama_cahaya") String lama_cahaya,
            @Field("tgl_tanam") String tgl_tanam
    );
    @FormUrlEncoded
    @POST("info_handler.php")
    Call<ResponseBody> delInfoTanaman(
            @Field("nama") String nama,
            @Field("del") String del
    );
    @FormUrlEncoded
    @POST("status_handler.php")
    Call<StatusTanaman> getStatusTanaman(
            @Field("nama") String nama
    );
    @FormUrlEncoded
    @POST("status_handler.php")
    Call<InfoTanamanStr> setRelayState(
            @Field("id") String id,
            @Field("relay_name") String relay_name,
            @Field("state") int state
    );
    @POST("info_handler.php")
    Call<InfoTanamanStr> getInfoTanamanStr();
    @POST("notif_handler.php")
    Call<InfoTanamanStr> getNotif();
}
