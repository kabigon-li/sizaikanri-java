package co.jp.mamol.myapp.form;

import co.jp.mamol.myapp.dto.SizaiDto;

public class ApprovalDetailForm {
public int sizaiId;
public SizaiDto sizai;
public int getSizaiId() {
	return sizaiId;
}
public void setSizaiId(int sizaiId) {
	this.sizaiId = sizaiId;
}
public SizaiDto getSizai() {
	return sizai;
}
public void setSizai(SizaiDto sizai) {
	this.sizai = sizai;
}

}
