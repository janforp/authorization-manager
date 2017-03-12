package com.zbmatsu.iam.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * jpa要求
 * 实体类与表名对应
 * 可以通过插件自动生成这些实体类
 */
@Entity
@Table(name = "user", schema = "iam")
public class User {

	//主键
	@Id
	private String id;
	//字段,不能为空,没有写默认可以为空
	@Column(name="name", length=255, nullable=false)
	private String name;
	
	@Column(name="user_name", unique=true, length=255, nullable=false)
	private String userName;
	
	@Column(name="password", length=255)
	private String password;
	
	@Column(name="addresses", length=255)
	private String addresses;
	
	@Column(name="emails", length=255)
	private String emails;
	
	@Column(name="phone_numbers", length=255)
	private String phoneNumbers;
	
	@Column(name="photos", length=255)
	private String photos;

	/**
	 * 用户角色id,应存入json串
	 */
	@Column(name="roles", length=36, nullable=false)
	private String roles;
	
	@Column(name="creation_time")
	private LocalDateTime creationTime;
	
	@Column(name="modification_time")
	private LocalDateTime modificationTime;
	
	@Column(name="create_user_id", length=36)
	private String createUserId;
	
	@Column(name="last_update_user_id", length=36)
	private String lastUpdateUserId;
	
	@Column(name="status", length=1, nullable=false)
	private String status;

	@Column(name="certificates", length=255, nullable=false)
	private String certificates;
	
	@Column(name="description", length=255)
	private String description;
	
	

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddresses() {
		return addresses;
	}

	public void setAddresses(String addresses) {
		this.addresses = addresses;
	}

	public String getEmails() {
		return emails;
	}

	public void setEmails(String emails) {
		this.emails = emails;
	}

	public String getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(String phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public String getPhotos() {
		return photos;
	}

	public void setPhotos(String photos) {
		this.photos = photos;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public LocalDateTime getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(LocalDateTime creationTime) {
		this.creationTime = creationTime;
	}

	public LocalDateTime getModificationTime() {
		return modificationTime;
	}

	public void setModificationTime(LocalDateTime modificationTime) {
		this.modificationTime = modificationTime;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getLastUpdateUserId() {
		return lastUpdateUserId;
	}

	public void setLastUpdateUserId(String lastUpdateUserId) {
		this.lastUpdateUserId = lastUpdateUserId;
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
