package com.alt_project.www.alp_project.List;

import com.alt_project.www.alp_project.model.Outbox;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by pt on 9/13/16.
 */
public class OutboxList {

    @SerializedName("Outbox")
    @Expose
    private ArrayList<Outbox> outbox = new ArrayList<Outbox>();

    /**
     *
     * @return
     * The outbox
     */
    public ArrayList<Outbox> getOutbox() {
        return outbox;
    }

    /**
     *
     * @param outbox
     * The Outbox
     */
    public void setOutbox(ArrayList<Outbox> outbox) {
        this.outbox = outbox;
    }
}
