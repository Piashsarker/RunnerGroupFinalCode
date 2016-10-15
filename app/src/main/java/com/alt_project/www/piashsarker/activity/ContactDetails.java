package com.alt_project.www.piashsarker.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.alt_project.www.piashsarker.R;


public class ContactDetails extends AppCompatActivity {
    TextView name, officeId, department, designation, mobileNo, email, location;
    Intent intent;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);
        toolbarSetup();
        initializeView();
        setDataToView();

    }

    private void toolbarSetup() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void setDataToView() {
        intent = getIntent();
        bundle = intent.getExtras();

        name.setText(bundle.getString("name"));
        officeId.setText(bundle.getString("office_id"));
        department.setText(bundle.getString("department"));
        designation.setText(bundle.getString("designation"));
        mobileNo.setText(bundle.getString("mobile_no"));
        email.setText(bundle.getString("email"));
        location.setText(bundle.getString("location"));


    }

    private void initializeView() {

        name = (TextView) findViewById(R.id.txt_contact_name);
        officeId = (TextView) findViewById(R.id.txt_office_id_number);
        department = (TextView) findViewById(R.id.txt_department);
        designation = (TextView) findViewById(R.id.txt_designation);
        mobileNo = (TextView) findViewById(R.id.txt_contact_number);
        email = (TextView) findViewById(R.id.txt_email);
        location = (TextView) findViewById(R.id.txt_job_location);
    }

    public void btnSentMessageOnclick(View view) {

        Bundle bundle1 = new Bundle() ;
        intent = new Intent(getApplicationContext(), MemoCompose.class);
        bundle1.putString("employee_code",officeId.getText().toString());
        intent.putExtras(bundle1);
        startActivity(intent);
    }

    public void  btnCallOnClick(View view){
            intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:"+mobileNo.getText().toString()));
            startActivity(intent);
    }
}
