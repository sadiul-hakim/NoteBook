package com.hakim.dao.shareNote;

/**
 *
 * @author Hakim
 */
public class ShareNoteDTO {

    private int nid;
    private String aid;
    private String uniqueid;
    private String aname;
    private String title;
    private String description;

    public ShareNoteDTO() {
    }

    public ShareNoteDTO(int nid, String aid, String uniqueid, String aname,String title, String description) {
        this.nid = nid;
        this.aid = aid;
        this.uniqueid = uniqueid;
        this.aname = aname;
        this.title = title;
        this.description = description;
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

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }
    
    
    
}
