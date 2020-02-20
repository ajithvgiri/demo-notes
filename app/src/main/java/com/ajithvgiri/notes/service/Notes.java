package com.ajithvgiri.notes.service;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;


@Entity(tableName = "notes")
public class Notes implements Serializable {

    @PrimaryKey
    int id;
    @ColumnInfo(name = "userId")
    int userId;

    @ColumnInfo(name = "title")
    String title;

    @ColumnInfo(name = "body")
    String body;

    @ColumnInfo(name = "favorite")
    Boolean favorite;

    @ColumnInfo(name = "completed")
    Boolean completed;

    @Ignore
    public Notes(int userId, int id, String title, Boolean completed) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public Notes(int userId, int id, String title, String body, Boolean favorite, Boolean completed) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
        this.favorite = favorite;
        this.completed = completed;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
