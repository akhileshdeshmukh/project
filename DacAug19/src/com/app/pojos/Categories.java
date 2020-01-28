package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "t_categories")
public class Categories {
	private Integer categoryId;
	private String categoryName;
	@JsonIgnore
	private List<News> news = new ArrayList<>();

	public Categories() {
		System.out.println("Inside parameterless constructor");
	}

	public Categories(String categoryName) {
		super();
		this.categoryName = categoryName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "c_id")
	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	@Column(length = 50)
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	
	  @OneToMany(mappedBy = "categories", cascade = CascadeType.ALL, orphanRemoval
	  = true) public List<News> getNews() { return news; }
	  
	  public void setNews(List<News> news) { this.news = news; }
	 
	  
	  public void addNews(News n) {
			news.add(n);
			n.setCategories(this);
		}

		public void removeAccount(News n) {
			news.remove(n);
			n.setCategories(null);
		}
	  

	@Override
	public String toString() {
		return "Categories [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}

}
