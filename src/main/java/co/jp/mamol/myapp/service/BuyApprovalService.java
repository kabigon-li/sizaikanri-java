package co.jp.mamol.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.jp.mamol.myapp.dao.BuyApprovalDao;
import co.jp.mamol.myapp.dao.BuyRequestDao;
import co.jp.mamol.myapp.dto.SizaiDto;

@Service
public class BuyApprovalService {
	@Autowired
	BuyApprovalDao approvalDao;

	//2001部門別購入依頼一覧取得
	public List<SizaiDto> getDeptRequestList(String startDate,String endDate,String deptId) {
		startDate = startDate + " " + "00:00:00";
		endDate = endDate + " " + "23:59:59";
		List<SizaiDto> sizaiList = approvalDao.getDeptRequestList(startDate, endDate, deptId);
		return sizaiList;
	}

	//2002購入依頼一件取得
	public SizaiDto getRequest(int sizaiId) {
		SizaiDto sizai = approvalDao.getRequestById(sizaiId);
		return sizai;
	}

	//2003承認実行
	public boolean approval(int sizaiId) {

		boolean isApproval = approvalDao.approval(sizaiId);
		return isApproval;
	}

	//2004却下実行
	public boolean regect(int sizaiId) {
		boolean isRegect = approvalDao.regect(sizaiId);
		return isRegect;
	}

















}
