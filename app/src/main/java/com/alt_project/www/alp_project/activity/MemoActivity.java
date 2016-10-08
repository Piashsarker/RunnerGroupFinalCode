package com.alt_project.www.alp_project.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alt_project.www.alp_project.R;
import com.alt_project.www.alp_project.Session.SessionManager;

import java.util.HashMap;

public class MemoActivity extends AppCompatActivity {
    Intent intent;
    SessionManager sessionManager ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);
        toolbarSetup();



        sessionManager = new SessionManager(getApplicationContext());
        sessionManager.checkLogin();




    }

    public void btnComposeMemoOnClick(View view){
        intent = new Intent(getApplicationContext(),MemoCompose.class);
        startActivity(intent);

    }
    public void btnInboxOnclick(View view){
        intent = new Intent(getApplicationContext(),MemoInbox.class);
        startActivity(intent);
    }
    public void btnOutBoxOnClick(View view){
        intent = new Intent(getApplicationContext(), MemoOutbox.class);
        startActivity(intent);
    }
    public void btnContactOnclick(View view){
        intent = new Intent(getApplicationContext(), ContactActivity.class);
        startActivity(intent);

    }

    public void toolbarSetup(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

}
