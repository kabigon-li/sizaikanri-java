package co.jp.mamol.myapp.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import co.jp.mamol.myapp.dto.DepartmentDto;
import co.jp.mamol.myapp.dto.SizaiDto;
import co.jp.mamol.myapp.form.DeleverForm;
import co.jp.mamol.myapp.form.OrderForm;

import co.jp.mamol.myapp.service.OrderDeleverService;

@Results({ @Result(name = "delever", location = "/WEB-INF/jsp/delever.jsp"),
	@Result(name = "qrcode", location = "/WEB-INF/jsp/qr.jsp")

})
public class DeleverAction extends BaseAction {
	private DeleverForm form = new DeleverForm();

	@Autowired
	OrderDeleverService service;

	// 初期表示
	@Action("/delever/init")
	public String init() {
		// 部署リスト取得
		List<DepartmentDto> deptList = service.deptList();

		form.setDeptList(deptList);

		// 一個目の部署ID取得、検索用の部署IDとしてformにセット
		String searchDeptId = deptList.get(0).getId();

		form.setDeptId(searchDeptId);
		// 部署別資材リスト取得
		List<SizaiDto> sizaiListByDept = service.orderedList(form.getDeptId());

		form.setSizaiList(sizaiListByDept);
		// session取得
		Map<String, Object> session = getSession();

		// setSessionに登録
		session.put("deptId", form.getDeptId());

		return "delever";
	}

	@Action("/delever/search")
	public String search() {
		// 部署リスト取得
		List<DepartmentDto> deptList = service.deptList();

		form.setDeptList(deptList);

		// 部署別承認済み資材リスト
		List<SizaiDto> sizaiList = service.orderedList(form.getDeptId());

		form.setSizaiList(sizaiList);

		// session取得
		Map<String, Object> session = getSession();

		// setSessionに登録
		session.put("deptId", form.getDeptId());

		return "delever";
	}

	@Action("/delever/act")
	public String deleverAct() {
		Map<String, Object> session = getSession();
		// sessionから検索用部署IDを取得
		String deptIdForSearch = (String) session.get("deptId");

		form.setDeptId(deptIdForSearch);
		// 納品
		boolean deleverAct = service.deleverAct(form.sizaiId);

		if (deleverAct) {
			setMessage("納品しました", true);
		} else {
			setMessage("納品失敗しました", false);
			return "delever";
		}
		// 部署リスト取得
		List<DepartmentDto> deptList = service.deptList();

		form.setDeptList(deptList);
		// 部署別承認済み資材リスト
		List<SizaiDto> sizaiList = service.orderedList(form.getDeptId());

		form.setSizaiList(sizaiList);

		return "delever";
	}

	@Action("/delever/qr")
	public String qrcode() {
		return "qrcode";
	}

	public DeleverForm getForm() {
		return form;
	}

	public void setForm(DeleverForm form) {
		this.form = form;
	}



}
