package co.jp.mamol.myapp.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import co.jp.mamol.myapp.dto.DepartmentDto;
import co.jp.mamol.myapp.dto.SizaiDto;
import co.jp.mamol.myapp.form.OrderForm;

import co.jp.mamol.myapp.service.OrderDeleverService;

@Results({ @Result(name = "orderList", location = "/WEB-INF/jsp/order.jsp"),

})
public class OrderAction extends BaseAction {
	private OrderForm form = new OrderForm();

	@Autowired
	OrderDeleverService service;

	// 初期表示
	@Action("/order/init")
	public String init() {
		// 部署リスト取得
		List<DepartmentDto> deptList = service.deptList();

		form.setDeptList(deptList);

		// 一個目の部署ID取得、検索用の部署IDとしてformにセット
		String searchDeptId = deptList.get(0).getId();

		form.setDeptId(searchDeptId);
		// 部署別資材リスト取得
		List<SizaiDto> sizaiListByDept = service.approvaledList(form.getDeptId());

		form.setSizaiList(sizaiListByDept);
		// session取得
		Map<String, Object> session = getSession();

		// setSessionに登録
		session.put("deptId", form.getDeptId());

		return "orderList";
	}

	@Action("/order/search")
	public String search() {
		// 部署リスト取得
		List<DepartmentDto> deptList = service.deptList();

		form.setDeptList(deptList);

		// 部署別承認済み資材リスト
		List<SizaiDto> sizaiList = service.approvaledList(form.getDeptId());

		form.setSizaiList(sizaiList);

		// session取得
		Map<String, Object> session = getSession();

		// setSessionに登録
		session.put("deptId", form.getDeptId());

		return "orderList";
	}

	@Action("/order/act")
	public String orderAct() {
		Map<String, Object> session = getSession();
		// sessionから検索用部署IDを取得
		String deptIdForSearch = (String) session.get("deptId");

		form.setDeptId(deptIdForSearch);
		// 発注
		boolean orderAct = service.orderAct(form.sizaiId);

		if (orderAct) {
			setMessage("発注しました", true);
		} else {
			setMessage("発注失敗しました", false);
			return "orderList";
		}
		// 部署リスト取得
		List<DepartmentDto> deptList = service.deptList();

		form.setDeptList(deptList);
		// 部署別承認済み資材リスト
		List<SizaiDto> sizaiList = service.approvaledList(form.getDeptId());

		form.setSizaiList(sizaiList);

		return "orderList";
	}

	public OrderForm getForm() {
		return form;
	}

	public void setForm(OrderForm form) {
		this.form = form;
	}

}
