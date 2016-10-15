package com.alt_project.www.piashsarker.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.alt_project.www.piashsarker.R;

public class ChargeHandOver extends AppCompatActivity {

    Intent intent ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charge_hand_over);
        toolbarSetup();

    }

    public void toolbarSetup(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    public void btnChargeHanOverOnClick(View view) {
        intent = new Intent(getApplicationContext(), ChargeHandOverActivity.class);
        startActivity(intent);
    }

    public void btnLeaveOnClick(View view) {
        intent = new Intent(getApplicationContext(), PendingLeave.class);
        startActivity(intent);
    }

    public void btnTourOnClick(View view) {
        intent = new Intent(getApplicationContext(), PendingTour.class);
        startActivity(intent);
    }

    public void btnOnDutyOnClick(View view) {
        intent = new Intent(getApplicationContext(), PendingOnDuty.class);
        startActivity(intent);
    }
}