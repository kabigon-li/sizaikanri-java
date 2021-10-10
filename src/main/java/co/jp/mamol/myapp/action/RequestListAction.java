package co.jp.mamol.myapp.action;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import co.jp.mamol.myapp.dto.SizaiDto;
import co.jp.mamol.myapp.dto.UserDto;
import co.jp.mamol.myapp.form.RequestListForm;
import co.jp.mamol.myapp.service.BuyRequsetService;

@Results({ @Result(name = "requestList", location = "/WEB-INF/jsp/requestList.jsp"),
@Result(name = "init", location = "/requestList/init",type="redirect")
})
public class RequestListAction extends BaseAction{
	private RequestListForm form = new RequestListForm();

	@Autowired
	BuyRequsetService service;


	 //初期表示
		@Action("/requestList/init")
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
			List<SizaiDto> sizaiList = service.getUserRequestList(oneMonthAgoDate, nowDate, loginUser.getId());

			if (sizaiList == null || sizaiList.size() == 0) {
				setMessage("指定期間の購入依頼が登録されていません。",false);
				return "requestList";
			}else {
				form.setSizaiList(sizaiList);
			}
			return "requestList";
		}

		@Action("/requestList/search")
		public String search() {
			UserDto loginUser = getLoginUser();

			List<SizaiDto> sizaiDtoList = service.getUserRequestList(form.getStartDate(), form.getEndDate(), loginUser.getId());

			if (sizaiDtoList == null || sizaiDtoList.size()==0) {
				setMessage("指定期間の購入依頼が登録されていません。",false);
				return "requestList";
			}

			form.setSizaiList(sizaiDtoList);
			return "requestList";
		}

		@Action("/requestList/delete")
		public String delete() {
			service.deleteRequest(form.getWithdrawalId());
			return "init";
		}


	public RequestListForm getForm() {
		return form;
	}

	public void setForm(RequestListForm form) {
		this.form = form;
	}




}
