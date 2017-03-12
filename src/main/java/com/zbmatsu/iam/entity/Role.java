package com.zbmatsu.iam.entity;

import com.zbmatsu.iam.enums.IamStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * Created by Janita on 2017/1/1.
 */
@Entity
@Table(name = "role",schema = "iam")
public class Role {

    @Id
    private String  id;

    @Column(name = "name",length = 255,nullable = false)
    private String  name;

    @Column(name = "status",length = 1,nullable = false)
    private String  status = IamStatus.NORMAL.toString();

    @Column(name = "certificates",length = 255,nullable = false)
    private String  certificates;

    @Column(name = "description",length = 255)
    private String  description;

    @Column(name = "create_user_id",length = 36,nullable = false)
    private String  createUserId;

    @Column(name = "creation_time",length = 6,nullable = false)
    private LocalDateTime creationTime;





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

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }
}
