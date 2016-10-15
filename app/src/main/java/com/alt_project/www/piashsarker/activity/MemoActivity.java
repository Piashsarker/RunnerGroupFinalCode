package com.alt_project.www.piashsarker.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.alt_project.www.piashsarker.R;
import com.alt_project.www.piashsarker.Session.SessionManager;

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
