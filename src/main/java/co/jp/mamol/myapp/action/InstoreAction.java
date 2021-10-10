package co.jp.mamol.myapp.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import co.jp.mamol.myapp.dto.DepartmentDto;
import co.jp.mamol.myapp.dto.SizaiDto;
import co.jp.mamol.myapp.dto.SoukoDto;

import co.jp.mamol.myapp.form.InstoreForm;

import co.jp.mamol.myapp.service.StoreService;

@Results({ @Result(name = "intore", location = "/WEB-INF/jsp/inStore.jsp") })
public class InstoreAction extends BaseAction {

	private InstoreForm form = new InstoreForm();

	@Autowired
	StoreService service;

	// 初期表示
	@Action("/inStore/init")
	public String init() {

		return "intore";
	}

	// 資材検索
	@Action("/inStore/search")
	public String search() {
		// 資材取得
		SizaiDto sizai = service.getSizaiById(form.getSizaiId());

		if (sizai==null) {
			setMessage("資材情報を取得できませんでした。", false);
			return "instore";
		} else {
			form.setSizai(sizai);
			List<SoukoDto> soukoList = service.getAllSouko();
			form.setSoukoList(soukoList);

			if (!form.getSizai().getStatus().equals("5")) {
				setMessage("資材の状態は「納品済」ではないため、入庫できません。", false);
			}
			// session取得
			Map<String, Object> session = getSession();

			session.put("sizaiId", form.getSizaiId());
			session.put("soukoList", form.getSoukoList());

		}
		return "intore";
	}

	@Action("/inStore/act")
	public String inStore() {

		Map<String, Object> session = getSession();
		// sessionから検索用部署IDを取得
		int sizaiIdForSearch = (int) session.get("sizaiId");

		List<SoukoDto> soukoList =( List<SoukoDto>) session.get("soukoList");

		form.setSizaiId(sizaiIdForSearch);

		form.setSoukoList(soukoList);

		//入庫処理
		boolean inStore = service.inStore(form.getSizai());

		if (inStore) {
			setMessage("入庫完了しました。", true);
		} else {
			setMessage("入庫できませんでした。", false);
		}


		// 資材取得
		SizaiDto sizai = service.getSizaiById(form.getSizaiId());
		form.setSizai(sizai);

		return "intore";
	}

	public InstoreForm getForm() {
		return form;
	}

	public void setForm(InstoreForm form) {
		this.form = form;
	}

}
