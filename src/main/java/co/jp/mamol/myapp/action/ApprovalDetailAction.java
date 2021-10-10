package co.jp.mamol.myapp.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;


import co.jp.mamol.myapp.dto.SizaiDto;
import co.jp.mamol.myapp.form.ApprovalDetailForm;
import co.jp.mamol.myapp.form.RequestDetailForm;
import co.jp.mamol.myapp.service.BuyRequsetService;

@Results({ @Result(name = "approvaldetail", location = "/WEB-INF/jsp/approvalDetail.jsp") })
public class ApprovalDetailAction {

	private ApprovalDetailForm form = new ApprovalDetailForm();

	@Autowired
	BuyRequsetService service;

   //初期表示
	@Action("/approvalDetail/init")
	public String init() {
		SizaiDto sizai = service.getRequest(form.getSizaiId());

		form.setSizai(sizai);

		return "approvaldetail";
	}


	public ApprovalDetailForm getForm() {
		return form;
	}

	public void setForm(ApprovalDetailForm form) {
		this.form = form;
	}



}
