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
import co.jp.mamol.myapp.form.OutstoreForm;
import co.jp.mamol.myapp.service.StoreService;

@Results({ @Result(name = "outstore", location = "/WEB-INF/jsp/outStore.jsp") })
public class OutstoreAction extends BaseAction {

	private OutstoreForm form = new OutstoreForm();

	@Autowired
	StoreService service;

	// 初期表示
	@Action("/outStore/init")
	public String init() {

		return "outstore";
	}

	// 資材検索
	@Action("/outStore/search")
	public String search() {
		// 資材取得
		SizaiDto sizai = service.getSizaiById(form.getSizaiId());

		if (sizai == null) {
			setMessage("資材情報を取得できませんでした。", false);
			return "outstore";
		} else {
			form.setSizai(sizai);
			List<SoukoDto> soukoList = service.getAllSouko();
			form.setSoukoList(soukoList);

			if (!form.getSizai().getStatus().equals("6")) {
				setMessage("資材の状態は「入庫済」ではないため、出庫できません。", false);
			}
			// session取得
			Map<String, Object> session = getSession();

			session.put("sizaiId", form.getSizaiId());
			session.put("soukoList", form.getSoukoList());

		}
		return "outstore";
	}

	@Action("/outStore/act")
	public String outStore() {

		Map<String, Object> session = getSession();
		// sessionから検索用部署IDを取得
		int sizaiIdForSearch = (int) session.get("sizaiId");

		List<SoukoDto> soukoList =( List<SoukoDto>) session.get("soukoList");

		form.setSizaiId(sizaiIdForSearch);

		form.setSoukoList(soukoList);

		//出庫処理
		boolean outStore = service.outStore(form.getSizai());

		if (outStore) {
			setMessage("出庫完了しました。", true);
		} else {
			setMessage("出庫できませんでした。", false);
		}


		// 資材取得
		SizaiDto sizai = service.getSizaiById(form.getSizaiId());
		form.setSizai(sizai);

		return "outstore";
	}

	public OutstoreForm getForm() {
		return form;
	}

	public void setForm(OutstoreForm form) {
		this.form = form;
	}

}
