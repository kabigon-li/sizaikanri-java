package co.jp.mamol.myapp.form;

import java.util.List;

import co.jp.mamol.myapp.dto.SizaiDto;
import co.jp.mamol.myapp.dto.SoukoDto;

public class InstoreForm {
	public SizaiDto sizai;
	public List<SoukoDto> soukoList;
	public int sizaiId;
	public SizaiDto getSizai() {
		return sizai;
	}
	public void setSizai(SizaiDto sizai) {
		this.sizai = sizai;
	}
	public List<SoukoDto> getSoukoList() {
		return soukoList;
	}
	public void setSoukoList(List<SoukoDto> soukoList) {
		this.soukoList = soukoList;
	}
	public int getSizaiId() {
		return sizaiId;
	}
	public void setSizaiId(int sizaiId) {
		this.sizaiId = sizaiId;
	}


}
