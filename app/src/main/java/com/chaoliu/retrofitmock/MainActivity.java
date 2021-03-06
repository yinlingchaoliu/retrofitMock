package com.chaoliu.retrofitmock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.chaoliu.mock.annotation.SingleClick;
import com.chaoliu.mock.core.RetrofitMock;
import com.chaoliu.retrofitmock.mock.Api;
import com.chaoliu.retrofitmock.mock.BaseResponse;
import com.chaoliu.retrofitmock.mock.IsUpdate;
import com.chaoliu.retrofitmock.mock.NetworkUtil;

import java.util.UUID;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        button = findViewById( R.id.button );

        button.setOnClickListener( v -> {
            network();
        } );
    }

    @SingleClick
    void network() {

        toast( "network"+UUID.randomUUID() );

        RetrofitMock.setEnabled( true );

        NetworkUtil.getRetrofit(this).create( Api.class )
                .updateApk().subscribe( new Observer<BaseResponse<IsUpdate>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(BaseResponse<IsUpdate> dataBean) {

                if (dataBean.isSuccessful()) {
//                    toast( dataBean.msg );
                    IsUpdate updateBean = dataBean.data;
                    toast( updateBean.toString() );
                }

            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText( MainActivity.this,e.getMessage()+UUID.randomUUID(),Toast.LENGTH_SHORT ).show();
            }

            @Override
            public void onComplete() {

            }
        } );

    }

    void toast(String msg){
        Toast.makeText( MainActivity.this,msg,Toast.LENGTH_SHORT ).show();
    }

}