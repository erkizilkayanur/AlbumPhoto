package com.example.nurerkizilkaya.albumphoto;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.nurerkizilkaya.albumphoto.adapter.PhotoAdapter;
import com.example.nurerkizilkaya.albumphoto.model.Photos;
import com.example.nurerkizilkaya.albumphoto.webservices.PhotoMethods;
import com.example.nurerkizilkaya.albumphoto.webservices.PhotoRetroClient;

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoActivity extends AppCompatActivity {
    @Bind(R.id.listRcyViewId)
    RecyclerView listRcyViewId;

    public Photos[] photoArray;
    public PhotoAdapter adapter;

    public ProgressDialog dialog ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        ButterKnife.bind(this);

        LinearLayoutManager ll=new LinearLayoutManager(this);
        ll.setOrientation(LinearLayoutManager.VERTICAL);
        listRcyViewId.setLayoutManager(ll);

        final PhotoMethods photoApi= PhotoRetroClient.getClient().create(PhotoMethods.class);
        final Call<Photos[]> call=photoApi.getItemPhotos();
        dialog = new ProgressDialog(PhotoActivity.this);
        dialog.setMessage("Yükleniyor...");
        dialog.show();

        call.enqueue(new Callback<Photos[]>() {
            @Override
            public void onResponse(Call<Photos[]> call, Response<Photos[]> response) {
                photoArray=response.body();
                adapter=new PhotoAdapter(getApplicationContext(),Arrays.asList(photoArray));
                listRcyViewId.setAdapter(adapter);

                dialog.dismiss();

            }

            @Override
            public void onFailure(Call<Photos[]> call, Throwable t) {

            }
        });


    }
}
