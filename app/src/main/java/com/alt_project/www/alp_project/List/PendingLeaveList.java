package com.alt_project.www.alp_project.List;

import com.alt_project.www.alp_project.model.PendingLeaveApplicationView;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by pt on 9/25/16.
 */
public class PendingLeaveList {
    @SerializedName("PendingLeaveApplicationView")
    @Expose
    private ArrayList<PendingLeaveApplicationView> pendingLeaveApplicationView = new ArrayList<PendingLeaveApplicationView>();

    /**
     *
     * @return
     * The pendingLeaveApplicationView
     */
    public ArrayList<PendingLeaveApplicationView> getPendingLeaveApplicationView() {
        return pendingLeaveApplicationView;
    }

    /**
     *
     * @param pendingLeaveApplicationView
     * The PendingLeaveApplicationView
     */
    public void setPendingLeaveApplicationView(ArrayList<PendingLeaveApplicationView> pendingLeaveApplicationView) {
        this.pendingLeaveApplicationView = pendingLeaveApplicationView;
    }
}
