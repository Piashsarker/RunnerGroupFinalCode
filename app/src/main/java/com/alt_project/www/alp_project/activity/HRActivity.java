package com.alt_project.www.alp_project.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.alt_project.www.alp_project.R;

public class HRActivity extends AppCompatActivity {
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hr);
        toolbarSetup();


    }

    public void btnLeaveAndTourOnclick(View view){
        intent = new Intent(getApplicationContext(), LeaveInsert.class);
        startActivity(intent);
    }
    public void btnOnDutyOnclick(View view){
        intent = new Intent(getApplicationContext(), OnDutyInsert.class);
        startActivity(intent);
    }
    public void btnAttendanceReportOnclik(View view){
        intent = new Intent(getApplicationContext(), AttendenceReportActivity.class);
        startActivity(intent);
    }


    public void toolbarSetup(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }


    public void btnLeaveAndTourReportOnClick(View view) {
        intent = new Intent(getApplicationContext(), LeaveReport.class);
        startActivity(intent);
    }

    public void btnOnDutyInsertOnclick(View view) {
        intent = new Intent(getApplicationContext(),OnDutyReport.class);
        startActivity(intent);

    }

    public void btnTourAddOnClick(View view) {
        intent = new Intent(getApplicationContext() , TourInsert.class);
        startActivity(intent);
    }

    public void btnTourReportOnClick(View view) {
    intent = new Intent( getApplicationContext(), TourReport.class);
        startActivity(intent);
    }
}
