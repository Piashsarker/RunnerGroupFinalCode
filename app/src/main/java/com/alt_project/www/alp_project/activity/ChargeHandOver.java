package com.alt_project.www.alp_project.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.alt_project.www.alp_project.List.ChargeHandOverList;
import com.alt_project.www.alp_project.List.LeaveReportList;
import com.alt_project.www.alp_project.R;
import com.alt_project.www.alp_project.Session.SessionManager;
import com.alt_project.www.alp_project.adapter.ChargeHandOverAdapter;
import com.alt_project.www.alp_project.adapter.LeaveAndTourAdapter;
import com.alt_project.www.alp_project.model.PendingCHOApplicationView;
import com.alt_project.www.alp_project.retrofit.ApiService;
import com.alt_project.www.alp_project.retrofit.RetroClient;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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