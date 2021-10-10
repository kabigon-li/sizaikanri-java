package co.jp.mamol.myapp.form;

import java.util.List;

import co.jp.mamol.myapp.dto.CategoryDto;
import co.jp.mamol.myapp.dto.SizaiDto;

public class BuyRequestForm {
	public List<CategoryDto> categoryList;
	public SizaiDto sizai;
	public List<CategoryDto> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<CategoryDto> categoryList) {
		this.categoryList = categoryList;
	}
	public SizaiDto getSizai() {
		return sizai;
	}
	public void setSizai(SizaiDto sizai) {
		this.sizai = sizai;
	}


}
