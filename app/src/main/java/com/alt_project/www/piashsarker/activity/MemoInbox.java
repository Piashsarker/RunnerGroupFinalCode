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

import com.alt_project.www.piashsarker.List.InboxList;
import com.alt_project.www.piashsarker.R;
import com.alt_project.www.piashsarker.Session.SessionManager;
import com.alt_project.www.piashsarker.adapter.InboxAdapter;
import com.alt_project.www.piashsarker.model.Inbox;
import com.alt_project.www.piashsarker.retrofit.ApiService;
import com.alt_project.www.piashsarker.retrofit.RetroClient;

import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MemoInbox extends AppCompatActivity {

    InboxAdapter adapter ;
    ArrayList<Inbox> inboxList = new ArrayList<>();
    SessionManager sessionManager ;
    Dialog alertDialog;
    HashMap<String , String> user;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo_inbox);
        alertDialog = new Dialog(MemoInbox.this);
        toolbarSetup();
        initViews();
        loadInbox();

    }


    public void toolbarSetup() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.memo_inbox_list);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

    }

    private void loadInbox() {

        sessionManager = new SessionManager(getApplicationContext());
        sessionManager.checkLogin();
       user  = sessionManager.getUserDetails();


        if (isNetworkConnected()) {
            final ProgressDialog progressDialog ;

            progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Wait");
            progressDialog.setMessage("Loading Inbox Data");
            progressDialog.show();

            ApiService api = RetroClient.getApiService();

            Call<InboxList> call = api.getInboxList(user.get(SessionManager.KEY_KEY), "INBOX", Integer.parseInt(user.get(SessionManager.KEY_EMPLOYEE_ID)));

            call.enqueue(new Callback<InboxList>() {
                @Override
                public void onResponse(Call<InboxList> call, Response<InboxList> response) {
                    progressDialog.dismiss();

                    if (response.isSuccess()){


                        inboxList= response.body().getInbox();
                        if(inboxList.isEmpty()){
                            alertDialog.showDialog("EMPTY!","Data Not Found");
                        }
                        else {
                            adapter = new InboxAdapter(getApplicationContext() , inboxList);
                            recyclerView.setAdapter(adapter);
                            adapter.setOnItemClickListener(new InboxAdapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(View v, int position) {
                                    Bundle bundle = new Bundle();
                                    Intent intent = new Intent(getApplicationContext(),InboxDetails.class);
                                    bundle.putString("sender_id",inboxList.get(position).getFromEmployeeCode().toString());
                                    bundle.putString("sender_name",inboxList.get(position).getFromEmployeeName().toString());
                                    bundle.putString("message",inboxList.get(position).getMsg());
                                    bundle.putString("subject",inboxList.get(position).getSubject());
                                    bundle.putString("date_and_time",inboxList.get(position).getDateNTime().substring(0,10));
                                    bundle.putString("time",inboxList.get(position).getDateNTime().substring(11,16));
                                    postReadStatus(inboxList.get(position).getEmployeeMailId().toString());
                                    intent.putExtras(bundle);
                                    startActivity(intent);

                                }
                            });
                        }

                    }
                }

                @Override
                public void onFailure(Call<InboxList> call, Throwable t) {
                    alertDialog.showDialog("ERROR!","SERVER ERROR");

                }
            });

        } else {
            alertDialog.showDialog("NO INTERNET!","Please Enable WIFI or Mobile Data");
        }

    }

    private void postReadStatus(String s) {

        if(isNetworkConnected()){


            ApiService api = RetroClient.getApiService();
            Call<ResponseBody> call = api.postReadStatus(user.get(SessionManager.KEY_KEY), "POSTREADSTATUS", s);

            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                    if (response.isSuccess()){
                        if(response.code()==200){

                        }
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    alertDialog.showDialog("ERROR!","SERVER ERROR");
                }
            });
        }
        else{

           alertDialog.showDialog("NO INTERNET!","Please Enable WIFI or Mobile Data");

        }

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
                loadInbox();
                break ;
        }
        return super.onOptionsItemSelected(item);
    }
}
