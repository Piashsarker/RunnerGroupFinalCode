package com.alt_project.www.piashsarker.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alt_project.www.piashsarker.R;
import com.alt_project.www.piashsarker.model.PendingTourView;

import java.util.ArrayList;

/**
 * Created by pt on 9/25/16.
 */
public class PendingTourAdapter extends RecyclerView.Adapter<PendingTourAdapter.ViewHolder> {
    private Context context;
    private ArrayList<PendingTourView> arrayList = new ArrayList<>();
    private OnItemClickListener onItemClickListener;

    public PendingTourAdapter(Context context, ArrayList<PendingTourView> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_boss_approve, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.id.setText("ID: " + arrayList.get(position).getEmployeeCode().toString());
        holder.name.setText("Name: " + arrayList.get(position).getEmployeeName());
        holder.toDate.setText("To: " + arrayList.get(position).getToDate().toString().substring(0,10));
        holder.fromDate.setText("From: " + arrayList.get(position).getFromDate().toString().substring(0,10));


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public void setOnItemClickListener(final OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView id, name, fromDate, toDate;
        Button reject, approve;
        RelativeLayout holder;

        public ViewHolder(View itemView) {
            super(itemView);

            holder = (RelativeLayout) itemView.findViewById(R.id.holder);
            id = (TextView) itemView.findViewById(R.id.txt_id_no);
            name = (TextView) itemView.findViewById(R.id.txt_name);
            fromDate = (TextView) itemView.findViewById(R.id.txt_from_date);
            toDate = (TextView) itemView.findViewById(R.id.txt_to_date);
            reject = (Button) itemView.findViewById(R.id.btnReject);
            approve = (Button) itemView.findViewById(R.id.btnApprove);
            reject.setOnClickListener(this);
            approve.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            if(onItemClickListener != null){
                onItemClickListener.onItemClick(v, getAdapterPosition());
            }
        }
    }
}
