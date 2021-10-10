package co.jp.mamol.myapp.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.jp.mamol.myapp.dao.BuyRequestDao;
import co.jp.mamol.myapp.dto.CategoryDto;
import co.jp.mamol.myapp.dto.SizaiDto;
@Service
public class BuyRequsetService {

	@Autowired
	BuyRequestDao requestDao;
	//1001購入依頼登録
	public void requestRegist(SizaiDto sizai) {

		requestDao.requestRegist(sizai);

	}

	//1002カテゴリ取得
	public List<CategoryDto> getCategory() {
		List<CategoryDto> categoryList =requestDao.getCategory();
		return categoryList;
	}

	//1003ユーザー別購入依頼一覧取得
	public List<SizaiDto> getUserRequestList(String startDate,String endDate, String userid){
		startDate = startDate + " " + "00:00:00";
		endDate = endDate + " " + "23:59:59";

		List<SizaiDto> sizaiList = requestDao.getUserRequestList(startDate, endDate, userid);
		return sizaiList;
	}

	//1004購入依頼一件取得
	public SizaiDto getRequest(int sizaiId) {
		SizaiDto sizai = requestDao.getRequestById(sizaiId);
		return sizai;
	}

	//1005購入依頼変更
	public boolean modifyRequest(SizaiDto sizai) {
		boolean isModify = requestDao.modifyRequest(sizai);
		return isModify;
	}

	//1006購入依頼撤回
	public boolean deleteRequest (int sizaiId) {
		boolean isDelete = requestDao.deleteById(sizaiId);
		return isDelete;
	}



















}
