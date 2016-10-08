package com.alt_project.www.alp_project.List;

import com.alt_project.www.alp_project.model.OnDutyView;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by pt on 9/21/16.
 */
public class OnDutyList {
    @SerializedName("OnDutyView")
    @Expose
    private ArrayList<OnDutyView> onDutyView = new ArrayList<OnDutyView>();

    /**
     *
     * @return
     * The onDutyView
     */
    public ArrayList<OnDutyView> getOnDutyView() {
        return onDutyView;
    }

    /**
     *
     * @param onDutyView
     * The OnDutyView
     */
    public void setOnDutyView(ArrayList<OnDutyView> onDutyView) {
        this.onDutyView = onDutyView;
    }
}
