package in.yabelo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer categoryCode;
	private Integer value;
	
	
	
	public Integer getCategoryCode() {
		return categoryCode;
	}



	public void setCategoryCode(Integer categoryCode) {
		this.categoryCode = categoryCode;
	}



	public Integer getValue() {
		return value;
	}



	public void setValue(Integer value) {
		this.value = value;
	}



	@Override
	public String toString() {
		return "Category [categoryCode=" + categoryCode + ", value=" + value + "]";
	}
	
	

}
