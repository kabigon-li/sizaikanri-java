package co.jp.mamol.myapp.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import co.jp.mamol.myapp.dto.CategoryDto;
import co.jp.mamol.myapp.dto.SizaiDto;
import co.jp.mamol.myapp.form.RequestDetailForm;
import co.jp.mamol.myapp.service.BuyRequsetService;

@Results({ @Result(name = "requestdetail", location = "/WEB-INF/jsp/requestDetail.jsp") })
public class RequestDetailAction extends BaseAction {

	private RequestDetailForm form = new RequestDetailForm();

	@Autowired
	BuyRequsetService service;

   //初期表示
	@Action("/requestDetail/init")
	public String init() {
		SizaiDto sizai = service.getRequest(form.getSizaiId());

		List<CategoryDto> categoryList = service.getCategory();

		form.setSizai(sizai);

		form.setCategoryList(categoryList);

		if (sizai.getStatus().equals("1") || sizai.getStatus().equals("3")) {
			form.setFlag(true);
		}else {
			form.setFlag(false);
			setMessage("承認済の依頼を変更できません",false);
			return "requestdetail";
		}

		return "requestdetail";
	}

	//変更
	@Action("/requestDetail/modify")
	public String modify() {

		boolean isModified = service.modifyRequest(form.getSizai());

		if (isModified) {
			setMessage("変更完了しました。",true);
		}else {
			setMessage("変更できませんでした",false);
		}

		SizaiDto modifiedSizai = service.getRequest(form.getSizai().getId());

		form.setSizai(modifiedSizai);

		List<CategoryDto> categoryList = service.getCategory();

		form.setCategoryList(categoryList);

		form.setFlag(true);

		return "requestdetail";
	}




	public RequestDetailForm getForm() {
		return form;
	}

	public void setForm(RequestDetailForm form) {
		this.form = form;
	}














}
