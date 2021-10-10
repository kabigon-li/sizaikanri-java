package co.jp.mamol.myapp.form;

import java.util.List;

import co.jp.mamol.myapp.dto.SizaiDto;

public class RequestListForm {
	private String startDate;
	private String endDate;
	private List<SizaiDto> sizaiList;
	private int withdrawalId;
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public List<SizaiDto> getSizaiList() {
		return sizaiList;
	}
	public void setSizaiList(List<SizaiDto> sizaiList) {
		this.sizaiList = sizaiList;
	}
	public int getWithdrawalId() {
		return withdrawalId;
	}
	public void setWithdrawalId(int withdrawalId) {
		this.withdrawalId = withdrawalId;
	}


}
