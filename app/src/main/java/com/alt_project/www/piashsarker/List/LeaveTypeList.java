package com.alt_project.www.piashsarker.List;

import com.alt_project.www.piashsarker.model.LeaveType;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by pt on 9/13/16.
 */
public class LeaveTypeList {
    @SerializedName("LeaveType")
    @Expose
    private ArrayList<LeaveType> leaveType = new ArrayList<LeaveType>();

    /**
     *
     * @return
     * The leaveType
     */
    public ArrayList<LeaveType> getLeaveType() {
        return leaveType;
    }

    /**
     *
     * @param leaveType
     * The LeaveType
     */
    public void setLeaveType(ArrayList<LeaveType> leaveType) {
        this.leaveType = leaveType;
    }

}
