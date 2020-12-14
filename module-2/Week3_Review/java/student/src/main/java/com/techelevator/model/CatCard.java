package com.techelevator.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class CatCard {

	private long id;
	@NotBlank
	private String imgUrl;
	@NotBlank
	private String catFact;
	@NotBlank
	private String caption;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getImgUrl() {
		return imgUrl;
	}
	
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	public String getCatFact() {
		return catFact;
	}
	
	public void setCatFact(String fact) {
		this.catFact = fact;
	}
	
	public String getCaption() {
		return caption;
	}
	
	public void setCaption(String caption) {
		this.caption = caption;
	}
	
	
	
}
