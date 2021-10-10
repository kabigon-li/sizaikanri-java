package co.jp.mamol.myapp.form;

import java.util.List;

import co.jp.mamol.myapp.dto.CategoryDto;
import co.jp.mamol.myapp.dto.SizaiDto;

public class RequestDetailForm {
	public int sizaiId;
	public List<CategoryDto> categoryList;
	public SizaiDto sizai;
	public boolean flag;
	
	
	public int getSizaiId() {
		return sizaiId;
	}
	public void setSizaiId(int sizaiId) {
		this.sizaiId = sizaiId;
	}
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
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}



}
