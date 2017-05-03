package com.shebao.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Table(name = "info")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Info {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String infoclass;

    private String img;

    private String description;

    private String keywords;

    private Integer count;

    private String fcount;

    private String rcount;

    @Column(name = "Timestamp")
    private Date timestamp;

    private byte[] message;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return infoclass
     */
    public String getInfoclass() {
        return infoclass;
    }

    /**
     * @param infoclass
     */
    public void setInfoclass(String infoclass) {
        this.infoclass = infoclass;
    }

    /**
     * @return img
     */
    public String getImg() {
        return img;
    }

    /**
     * @param img
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return keywords
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * @param keywords
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    /**
     * @return count
     */
    public Integer getCount() {
        return count;
    }

    /**
     * @param count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * @return fcount
     */
    public String getFcount() {
        return fcount;
    }

    /**
     * @param fcount
     */
    public void setFcount(String fcount) {
        this.fcount = fcount;
    }

    /**
     * @return rcount
     */
    public String getRcount() {
        return rcount;
    }

    /**
     * @param rcount
     */
    public void setRcount(String rcount) {
        this.rcount = rcount;
    }

    /**
     * @return Timestamp
     */
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp
     */
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * @return message
     */
    public byte[] getMessage() {
        return message;
    }

    /**
     * @param message
     */
    public void setMessage(byte[] message) {
        this.message = message;
    }
}