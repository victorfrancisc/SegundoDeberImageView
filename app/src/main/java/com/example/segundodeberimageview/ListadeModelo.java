package com.example.segundodeberimageview;

import android.graphics.Bitmap;

public class ListadeModelo {

    private String issue_id;
    private String volumen;
    private  String number;

    public String getIssue_id() {
        return issue_id;
    }

    public void setIssue_id(String issue_id) {
        this.issue_id = issue_id;
    }

    public String getVolumen() {
        return volumen;
    }

    public void setVolumen(String volumen) {
        this.volumen = volumen;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getDate_published() {
        return date_published;
    }

    public void setDate_published(String date_published) {
        this.date_published = date_published;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    private String ano;
    private String date_published;
    private String title;
    private String cover;

    public ListadeModelo(String issue_id, String volumen, String number, String ano, String date_published, String title, String cover) {
        this.issue_id = issue_id;
        this.volumen = volumen;
        this.number = number;
        this.ano = ano;
        this.date_published = date_published;
        this.title = title;
        this.cover = cover;
    }


}
