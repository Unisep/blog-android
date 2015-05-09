package com.brunoocasali.mynotes.vo;

import java.util.Date;

/**
 * Created by bruno on 02/05/15.
 */
public class NoteVO {

    private Integer id;
    private String title;
    private String description;
    private Date onCreate;
    private Date onUpdate;
    private NotebookVO notebook;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public NotebookVO getNotebook() {
        return notebook;
    }

    public void setNotebook(NotebookVO notebook) {
        this.notebook = notebook;
    }

    public Date getOnCreate() {
        return onCreate;
    }

    public void setOnCreate(Date onCreate) {
        this.onCreate = onCreate;
    }

    public Date getOnUpdate() {
        return onUpdate;
    }

    public void setOnUpdate(Date onUpdate) {
        this.onUpdate = onUpdate;
    }
}
