package com.alt_project.www.piashsarker.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.alt_project.www.piashsarker.List.OutboxList;
import com.alt_project.www.piashsarker.R;
import com.alt_project.www.piashsarker.Session.SessionManager;
import com.alt_project.www.piashsarker.adapter.OutboxAdapter;
import com.alt_project.www.piashsarker.model.Outbox;
import com.alt_project.www.piashsarker.retrofit.ApiService;
import com.alt_project.www.piashsarker.retrofit.RetroClient;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MemoOutbox extends AppCompatActivity {
    OutboxAdapter adapter;
     Dialog alertDialog ;
    SessionManager sessionManager ;
    private RecyclerView recyclerView;
    private ArrayList<Outbox> outboxArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo_outbox);
        alertDialog = new Dialog(MemoOutbox.this);
        setupToolbar();
        initViews();
        loadOutboxList();

    }

    private void loadOutboxList() {
        sessionManager = new SessionManager(getApplicationContext());
        sessionManager.checkLogin();
        HashMap<String , String> user = sessionManager.getUserDetails();
     if(isNetworkConnected()){
         final ProgressDialog progressDialog = new ProgressDialog(this);
         progressDialog.setTitle("Wait");
         progressDialog.setMessage("Outbox Data Loading");
         progressDialog.show();

         ApiService api = RetroClient.getApiService();
         Call<OutboxList> call = api.getOutboxList(user.get(SessionManager.KEY_KEY), "OUTBOX", Integer.parseInt(user.get(SessionManager.KEY_EMPLOYEE_ID)));
         call.enqueue(new Callback<OutboxList>() {
             @Override
             public void onResponse(Call<OutboxList> call, Response<OutboxList> response) {
                 progressDialog.dismiss();
                 if(response.isSuccess()){
                     outboxArrayList = response.body().getOutbox();
                     if(!outboxArrayList.isEmpty()){
                         adapter = new OutboxAdapter(getApplicationContext(),outboxArrayList);
                         recyclerView.setAdapter(adapter);
                         adapter.setOnItemClickListener(new OutboxAdapter.OnItemClickListener() {
                             @Override
                             public void onItemClick(View v, int position) {
                                 Bundle bundle = new Bundle();
                                 Intent intent = new Intent(getApplicationContext(),MemoOutboxDetails.class);
                                 bundle.putString("sender_name",outboxArrayList.get(position).getFromEmployeeName().toString());
                                 bundle.putString("sender_id",outboxArrayList.get(position).getFromEmployeeCode().toString());
                                 bundle.putString("subject",outboxArrayList.get(position).getSubject().toString());
                                 bundle.putString("message",outboxArrayList.get(position).getMsg());
                                 bundle.putString("date_and_time",outboxArrayList.get(position).getDateNTime().substring(0,10));
                                 bundle.putString("time",outboxArrayList.get(position).getDateNTime().substring(10,16));
                                 intent.putExtras(bundle);
                                 startActivity(intent);
                             }
                         });
                     }
                     else {
                         alertDialog.showDialog("EMPTY!","Data Not Found");
                     }

                 }
             }

             @Override
             public void onFailure(Call<OutboxList> call, Throwable t) {
                 alertDialog.showDialog("ERROR!","SERVER ERROR");

             }
         });
     }
        else{
         alertDialog.showDialog("NO INTERNET!","Please Enable WIFI or Mobile Data");
     }




    }


    public void setupToolbar (){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }
    private void initViews(){
        recyclerView = (RecyclerView)findViewById(R.id.memo_outbox_list);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);


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
               loadOutboxList();
                break ;
        }
        return super.onOptionsItemSelected(item);
    }

}
