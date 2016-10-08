package com.alt_project.www.alp_project.List;

import com.alt_project.www.alp_project.model.Thana;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by pt on 10/8/16.
 */
public class ThanaList {

    @SerializedName("Thana")
    @Expose
    private ArrayList<Thana> thana = new ArrayList<Thana>();

    /**
     *
     * @return
     * The thana
     */
    public ArrayList<Thana> getThana() {
        return thana;
    }

    /**
     *
     * @param thana
     * The Thana
     */
    public void setThana(ArrayList<Thana> thana) {
        this.thana = thana;
    }

}
