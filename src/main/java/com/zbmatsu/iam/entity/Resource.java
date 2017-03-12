package com.zbmatsu.iam.entity;


import com.zbmatsu.iam.enums.IamStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Janita on 2017/1/1.
 */
@Entity
@Table(name = "resource",schema = "iam")
public class Resource {

    @Id
    private String  id;

    @Column(name = "name",nullable = false,length = 255)
    private String  name;

    @Column(name = "type",length =20,nullable = false)
    private String  type;

    @Column(name = "url",length = 255)
    private String  url;

    @Column(name = "parent_id",length = 36,nullable = false)
    private String  parent_id;

    @Column(name = "icon_image",length = 255)
    private String  icon_image;

    @Column(name = "sort",length = 32)
    private Integer sort;

    @Column(name = "status",length = 1,nullable = false)
    private String  status = IamStatus.NORMAL.toString();

    @Column(name = "certificates",length = 255,nullable = false)
    private String  certificates;

    @Column(name = "description",length = 255)
    private String  description;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public String getIcon_image() {
        return icon_image;
    }

    public void setIcon_image(String icon_image) {
        this.icon_image = icon_image;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCertificates() {
        return certificates;
    }

    public void setCertificates(String certificates) {
        this.certificates = certificates;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
