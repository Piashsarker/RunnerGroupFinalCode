package com.alt_project.www.alp_project.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.alt_project.www.alp_project.R;

public class InboxDetails extends AppCompatActivity {

    TextView id , message , dateTime,subject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox_details);
        toolbarSetup();
        initializeViews();
        getAndSetData();
    }

    private void getAndSetData() {

        Bundle bundle = getIntent().getExtras();

        id.setText("Sender: "+bundle.getString("sender_name")+" ("+bundle.getString("sender_id")+")");

        message.setText(bundle.getString("message"));
        subject.setText(bundle.getString("subject"));
        dateTime.setText("Date: " +bundle.getString("date_and_time")+" , "+bundle.getString("time"));

    }

    private void initializeViews() {
        id = (TextView) findViewById(R.id.txt_from_name);
        subject = (TextView) findViewById(R.id.txt_subject);
        message = (TextView) findViewById(R.id.txt_message);
        dateTime = (TextView) findViewById(R.id.txt_date_time);

    }

    private void toolbarSetup() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.inbox_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sent:
                Bundle bundle = new Bundle();
                Intent intent = new Intent(InboxDetails.this, MemoCompose.class);
                bundle.putString("message",message.getText().toString());
                bundle.putString("id",id.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.forward:
                Bundle bundle1 = new Bundle();
                Intent intent1 = new Intent(InboxDetails.this,MemoCompose.class);
                bundle1.putString("id",id.getText().toString());
                bundle1.putString("message",message.getText().toString());
                intent1.putExtras(bundle1);
                startActivity(intent1);
                break;



        }
        return super.onOptionsItemSelected(item);
    }


}
