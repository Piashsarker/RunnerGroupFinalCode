package com.alt_project.www.piashsarker.List;

import com.alt_project.www.piashsarker.model.Inbox;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by pt on 9/13/16.
 */
public class InboxList {

    @SerializedName("Inbox")
    @Expose
    private ArrayList<Inbox> inbox = new ArrayList<Inbox>();

    /**
     *
     * @return
     * The inbox
     */
    public ArrayList<Inbox> getInbox() {
        return inbox;
    }

    /**
     *
     * @param inbox
     * The Inbox
     */
    public void setInbox(ArrayList<Inbox> inbox) {
        this.inbox = inbox;
    }
}
