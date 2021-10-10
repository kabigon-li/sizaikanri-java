package co.jp.mamol.myapp.action;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import co.jp.mamol.myapp.dto.CategoryDto;
import co.jp.mamol.myapp.dto.SizaiDto;
import co.jp.mamol.myapp.dto.UserDto;
import co.jp.mamol.myapp.form.ApprovalListForm;

import co.jp.mamol.myapp.service.BuyApprovalService;


@Results({ @Result(name = "approvalList", location = "/WEB-INF/jsp/approvalList.jsp"),

@Result(name = "init", location = "/approvalList/init",type="redirect")
})

public class ApprovalListAction extends BaseAction{
	private ApprovalListForm form = new ApprovalListForm();

	@Autowired
	BuyApprovalService service;

   //初期表示
	@Action("/approvalList/init")
	public String init() {
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		//現在日付
		String nowDate = now.format(formatter);

		LocalDate oneMonthAgo= now.minusMonths(1);
		//先月日付
		String oneMonthAgoDate = oneMonthAgo.format(formatter);

		form.setEndDate(nowDate);
		form.setStartDate(oneMonthAgoDate);

		UserDto loginUser = getLoginUser();
		List<SizaiDto> sizaiList = service.getDeptRequestList(oneMonthAgoDate, nowDate, loginUser.getDepid());

		if (sizaiList == null || sizaiList.size() == 0) {
			setMessage("指定期間の購入依頼が登録されていません。",false);
			return "requestList";
		}else {
			form.setSizaiList(sizaiList);
		}

		return "approvalList";
	}

	@Action("/approvalList/search")
	public String search() {
		UserDto loginUser = getLoginUser();

		List<SizaiDto> sizaiDtoList = service.getDeptRequestList(form.getStartDate(), form.getEndDate(), loginUser.getDepid());

		if (sizaiDtoList == null || sizaiDtoList.size()==0) {
			setMessage("指定期間の購入依頼が登録されていません。",false);
			return "requestList";
		}

		form.setSizaiList(sizaiDtoList);
		return "requestList";
	}

	@Action("/approvalList/approval")
	public String approval() {

		service.approval(form.getApprovalSizaiId());

		return "init";
	}

	@Action("/approvalList/regect")
	public String regest() {

		service.regect(form.getApprovalSizaiId());

		return "init";
	}



	public ApprovalListForm getForm() {
		return form;
	}

	public void setForm(ApprovalListForm form) {
		this.form = form;
	}




}
