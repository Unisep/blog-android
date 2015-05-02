package com.brunoocasali.mynotes.vo;

/**
 * Created by bruno on 02/05/15.
 */
public class NoteVO {
    private Integer id;
    private String title;
    private String text;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public NotebookVO getNotebook() {
        return notebook;
    }

    public void setNotebook(NotebookVO notebook) {
        this.notebook = notebook;
    }
}
