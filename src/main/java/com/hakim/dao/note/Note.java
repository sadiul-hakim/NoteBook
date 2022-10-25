package com.hakim.dao.note;

import java.sql.Timestamp;

/**
 *
 * @author Hakim
 */
public class Note {
    private int id;
    private int uid;
    private String title;
    private String description;
    private Timestamp date;

    public Note() {
    }

    public Note(int id, int uid,String title, String description, Timestamp date) {
        this.id = id;
        this.uid = uid;
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

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Note{" + "id=" + id + ", uid=" + uid + ", title=" + title + ", description=" + description + ", date=" + date + '}';
    }

   
    
    
}
