package com.hakim.dao.note;

/**
 *
 * @author Hakim
 */
public class NoteDTO {

    private int uid;
    private String title;
    private String description;

    public NoteDTO() {
    }

    public NoteDTO(int uid, String title, String description) {
        this.uid = uid;
        this.title = title;
        this.description = description;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
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

    
    
    
    
}
