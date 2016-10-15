package com.alt_project.www.piashsarker.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.alt_project.www.piashsarker.List.OnDutyList;
import com.alt_project.www.piashsarker.R;
import com.alt_project.www.piashsarker.Session.SessionManager;
import com.alt_project.www.piashsarker.adapter.OnDutyReportAdapter;
import com.alt_project.www.piashsarker.model.OnDutyView;
import com.alt_project.www.piashsarker.retrofit.ApiService;
import com.alt_project.www.piashsarker.retrofit.RetroClient;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OnDutyReport extends AppCompatActivity {

    RecyclerView recyclerView ;
    ArrayList<OnDutyView> onDutyViewArrayList = new ArrayList<>();
    SessionManager sessionManager ;
    Dialog alertDialog ;
    private OnDutyReportAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_duty_report);
        alertDialog = new Dialog(OnDutyReport.this);
        toolbarSetup();
        initViews();
        loadOnDutyReportData();
    }

    private void loadOnDutyReportData() {
        sessionManager = new SessionManager(getApplicationContext());
        sessionManager.checkLogin();
        HashMap<String , String> user = sessionManager.getUserDetails();

        if(isNetworkConnected()){
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Wait");
            progressDialog.setMessage("On  Duty Data Loading");
            progressDialog.show();

            ApiService api = RetroClient.getApiService();

            /**
             * Calling JSON
             */
            String key = user.get(SessionManager.KEY_KEY);
            String employeeId = user.get(SessionManager.KEY_EMPLOYEE_ID);
            Call<OnDutyList> call = api.getOnDutyList( key, "GETONDUTY",employeeId);

            /**
             * Enqueue Callback will be call when get response...
             */
            call.enqueue(new Callback<OnDutyList>() {
                @Override
                public void onResponse(Call<OnDutyList> call, Response<OnDutyList> response) {
                    //Dismiss Dialog
                    progressDialog.dismiss();

                    if (response.isSuccess()) {
                        /**
                         * Got Successfully
                         */


                        onDutyViewArrayList = response.body().getOnDutyView();

                        /**
                         * Binding that List to Adapter
                         */
                        if (!onDutyViewArrayList.isEmpty()){
                              adapter = new OnDutyReportAdapter(getApplicationContext(),onDutyViewArrayList);
                            recyclerView.setAdapter(adapter);
                        }
                        else {
                            alertDialog.showDialog("EMPTY!","Data Not Found");
                        }


                    } else {
                        Toast.makeText(getApplicationContext(), "Something Wrong", Toast.LENGTH_LONG)
                                .show();
                    }
                }

                @Override
                public void onFailure(Call<OnDutyList> call, Throwable t) {
                    progressDialog.dismiss();

                    alertDialog.showDialog("ERROR!","SERVER ERROR");

                }
            });

        }
        else{
            alertDialog.showDialog("NO INTERNET!","Please Enable WIFI or Mobile Data");
        }

    }

    private void initViews(){
        recyclerView = (RecyclerView)findViewById(R.id.on_duty_list);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);


    }

    public void toolbarSetup(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.inbox,menu);
        return true ;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.refresh:
                loadOnDutyReportData();
                break ;
        }
        return super.onOptionsItemSelected(item);
    }

}
