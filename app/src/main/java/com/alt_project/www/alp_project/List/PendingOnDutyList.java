package com.alt_project.www.alp_project.List;

import com.alt_project.www.alp_project.model.PendingOnDutyView;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by pt on 9/25/16.
 */
public class PendingOnDutyList {


    @SerializedName("PendingOnDutyView")
    @Expose
    private ArrayList<PendingOnDutyView> pendingOnDutyView = new ArrayList<PendingOnDutyView>();

    /**
     *
     * @return
     * The pendingOnDutyView
     */
    public ArrayList<PendingOnDutyView> getPendingOnDutyView() {
        return pendingOnDutyView;
    }

    /**
     *
     * @param pendingOnDutyView
     * The PendingOnDutyView
     */
    public void setPendingOnDutyView(ArrayList<PendingOnDutyView> pendingOnDutyView) {
        this.pendingOnDutyView = pendingOnDutyView;
    }
}
