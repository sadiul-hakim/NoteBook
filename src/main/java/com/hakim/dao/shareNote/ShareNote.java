package com.hakim.dao.shareNote;

import java.sql.Timestamp;

/**
 *
 * @author Hakim
 */
public class ShareNote {
    private int id;
    private int nid;
    private String aid;
    private String uniqueid;
    private String aname;
    private String title;
    private String description;
    private Timestamp date;

    public ShareNote() {
    }

    public ShareNote(int id, int nid, String aid, String uniqueid,String aname, String title, String description, Timestamp date) {
        this.id = id;
        this.nid = nid;
        this.aid = aid;
        this.uniqueid = uniqueid;
        this.aname = aname;
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getUniqueid() {
        return uniqueid;
    }

    public void setUniqueid(String uniqueid) {
        this.uniqueid = uniqueid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    @Override
    public String toString() {
        return "ShareNote{" + "id=" + id + ", nid=" + nid + ", aid=" + aid + ", uniqueid=" + uniqueid + ", aname=" + aname + ", title=" + title + ", description=" + description + ", date=" + date + '}';
    }

   
    
    
    
}
