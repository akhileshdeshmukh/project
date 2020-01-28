package com.app.pojos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="t_news")
public class News 
{
    private Integer newsId;
    private String newsTitle;
    private String newsDescription;
    private String newsLink;
    private String language;
    private String image;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date uploadDate;
    @DateTimeFormat(pattern = "HH-mm-ss")
    private Date uploadTime;
    private String flag;
    private Categories categories; 
    
    public News()
    {
      System.out.println("Inside parameterless constructor");
	}

	public News(String newsTitle, String newsDescription, String newsLink, String language,
		String image, Date uploadDate, Date uploadTime, String flag) {
		super();
		this.newsTitle = newsTitle;
		this.newsDescription = newsDescription;
		this.newsLink = newsLink;
		this.language = language;
		this.image = image;
		this.uploadDate = uploadDate;
		this.uploadTime = uploadTime;
		this.flag = flag;
	}
	
	
	
     public News(String newsTitle, String newsDescription, String newsLink, String language, String image) {
		super();
		this.newsTitle = newsTitle;
		this.newsDescription = newsDescription;
		this.newsLink = newsLink;
		this.language = language;
		this.image = image;
	}

	@Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
     @Column(name="n_id")
     public Integer getNewsId() {
		return newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}
     @Column(length=500)
	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
   @Column(length=1500)
	public String getNewsDescription() {
		return newsDescription;
	}

	public void setNewsDescription(String newsDescription) {
		this.newsDescription = newsDescription;
	}
       @Column(length=500)
	public String getNewsLink() {
		return newsLink;
	}

	public void setNewsLink(String newsLink) {
		this.newsLink = newsLink;
	}

    @Column(length=20)
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	@Column(length=700)
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
    @Temporal(TemporalType.DATE)
	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
   @Temporal(TemporalType.TIME)
	public Date getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}
    @Column(length=20)
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	@ManyToOne
	  
	  @JoinColumn(name = "categories_id") public Categories getCategories() { return
	  categories; }
	  
	  public void setCategories(Categories categories) { this.categories =
	  categories; }
	
	@Override
	public String toString() {
		return "News [newsId=" + newsId + ", newsTitle=" + newsTitle + ", newsDescription=" + newsDescription
				+ ", newsLink=" + newsLink + ", language=" + language + ", image=" + image + ", uploadDate="
				+ uploadDate + ", uploadTime=" + uploadTime + ", flag=" + flag + "]";
	}
}
