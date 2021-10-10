package co.jp.mamol.myapp.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import co.jp.mamol.myapp.dto.CategoryDto;
import co.jp.mamol.myapp.dto.UserDto;
import co.jp.mamol.myapp.form.BuyRequestForm;
import co.jp.mamol.myapp.service.BuyRequsetService;


@Results({ @Result(name = "buyrequest", location = "/WEB-INF/jsp/requestRegist.jsp") })
public class BuyRequestAction extends BaseAction {

	private BuyRequestForm form = new BuyRequestForm();

	@Autowired
	BuyRequsetService service;

   //初期表示
	@Action("/requestRegist/init")
	public String init() {
		List<CategoryDto> categoryList = service.getCategory();
		form.setCategoryList(categoryList);
		return "buyrequest";
	}

	// 登録実行
	@Action("/requestRegist/regist")
	public String regist() {
		//入力チェック
		if (form.getSizai().getName() == null || form.getSizai().getName().length() == 0) {
			setMessage("資材名を入力してください",false);
			return "buyrequest";
		}else if (form.getSizai().getNum() == 0) {
			setMessage("数量を入力してください",false);
			return "buyrequest";
		}else {
			UserDto loginUser = getLoginUser();
			form.getSizai().setRequest_user_id(loginUser.getId());
			form.getSizai().setRequest_dept_id(loginUser.getDepid());
			service.requestRegist(form.getSizai());
			setMessage("登録完了しました",true);
		}
		//カテゴリ情報のリスト取得
		List<CategoryDto>categoryList = service.getCategory();

		//カテゴリリストを画面formにset
		form.setCategoryList(categoryList);


		return "buyrequest";
	}

	public BuyRequestForm getForm() {
		return form;
	}

	public void setForm(BuyRequestForm form) {
		this.form = form;
	}

}
