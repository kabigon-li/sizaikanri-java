package co.jp.mamol.myapp.form;

import java.util.List;

import co.jp.mamol.myapp.dto.DepartmentDto;
import co.jp.mamol.myapp.dto.SizaiDto;

public class DeleverForm {

	public List<DepartmentDto> deptList;
	public String deptId;
	public List<SizaiDto> sizaiList;
	public int sizaiId;
	public List<DepartmentDto> getDeptList() {
		return deptList;
	}
	public void setDeptList(List<DepartmentDto> deptList) {
		this.deptList = deptList;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public List<SizaiDto> getSizaiList() {
		return sizaiList;
	}
	public void setSizaiList(List<SizaiDto> sizaiList) {
		this.sizaiList = sizaiList;
	}
	public int getSizaiId() {
		return sizaiId;
	}
	public void setSizaiId(int sizaiId) {
		this.sizaiId = sizaiId;
	}



}
