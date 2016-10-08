package com.alt_project.www.alp_project.List;

import com.alt_project.www.alp_project.model.District;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by pt on 10/8/16.
 */
public class DistrictList {
    @SerializedName("District")
    @Expose
    private ArrayList<District> district = new ArrayList<District>();

    /**
     *
     * @return
     * The district
     */
    public ArrayList<District> getDistrict() {
        return district;
    }

    /**
     *
     * @param district
     * The District
     */
    public void setDistrict(ArrayList<District> district) {
        this.district = district;
    }
}
