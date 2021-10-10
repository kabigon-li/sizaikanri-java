package co.jp.mamol.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.jp.mamol.myapp.dao.BuyRequestDao;
import co.jp.mamol.myapp.dao.OrderDeliverDao;
import co.jp.mamol.myapp.dto.DepartmentDto;
import co.jp.mamol.myapp.dto.SizaiDto;

@Service
public class OrderDeleverService {
	@Autowired
	OrderDeliverDao orderDao;
	//3001部署リスト取得
	public List<DepartmentDto> deptList(){
		List<DepartmentDto> deptList = orderDao.deptList();
		return deptList;
	}

	//3002承認済資材取得(部署別）
	public List<SizaiDto> approvaledList(String demptId){
		List<SizaiDto> sizaiList = orderDao.approvaledList(demptId);
		return sizaiList;
	}

	//3003発注済資材取得(部署別）
	public List<SizaiDto> orderedList(String demptId){
		List<SizaiDto> orderedList = orderDao.orderedList(demptId);
		return orderedList;
	}

	//3004発注実行
	public boolean orderAct(int sizaiId) {
		boolean isOrder = orderDao.orderAct(sizaiId);
		return isOrder;
	}

	//3005納品実行
	public boolean deleverAct(int sizaiId) {
		boolean isDelever = orderDao.deleverAct(sizaiId);
		return isDelever;
	}



















}
