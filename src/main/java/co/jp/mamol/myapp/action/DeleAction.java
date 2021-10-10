package co.jp.mamol.myapp.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import co.jp.mamol.myapp.dto.CategoryDto;
import co.jp.mamol.myapp.dto.UserDto;
import co.jp.mamol.myapp.form.BuyRequestForm;
import co.jp.mamol.myapp.form.DeleForm;
import co.jp.mamol.myapp.service.BuyRequsetService;


@Results({ @Result(name = "delete", location = "/WEB-INF/jsp/deleteConfirm.jsp") })
public class DeleAction extends BaseAction {
DeleForm form = new DeleForm();


	@Autowired
	BuyRequsetService service;

   //初期表示
	@Action("/deleconfirm/init")
	public String init() {
		List<CategoryDto> categoryList = service.getCategory();
		form.setCategoryList(categoryList);
		return "delete";
	}

	public DeleForm getForm() {
		return form;
	}

	public void setForm(DeleForm form) {
		this.form = form;
	}

	public BuyRequsetService getService() {
		return service;
	}

	public void setService(BuyRequsetService service) {
		this.service = service;
	}






}
