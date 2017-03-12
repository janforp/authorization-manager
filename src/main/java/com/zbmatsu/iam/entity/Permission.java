package com.zbmatsu.iam.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Janita on 2017/1/1.
 */
@Entity
@Table(name = "permission",schema = "iam")
public class Permission {

    @Id
    private String  id;

    @Column(name = "role_id",length = 36,nullable = false)
    private String  roleId;

    @Column(name = "resource_id",length = 36,nullable = false)
    private String  resourceId;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }
}
