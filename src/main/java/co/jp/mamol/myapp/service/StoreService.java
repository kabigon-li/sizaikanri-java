package co.jp.mamol.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.jp.mamol.myapp.dao.StoreDao;
import co.jp.mamol.myapp.dto.SizaiDto;
import co.jp.mamol.myapp.dto.SoukoDto;

@Service
public class StoreService {
	@Autowired
	StoreDao storeDao;
//4001資材情報一件取得
	public SizaiDto getSizaiById(int sizaiId) {
		SizaiDto sizai = storeDao.getSizaiById(sizaiId);
		return sizai;
	}

	//4002倉庫情報取得
	public List<SoukoDto> getAllSouko(){
		List<SoukoDto> soukoList = storeDao.getSoukoList();
		return soukoList;

	}

	//4003入庫実行
	public boolean inStore(SizaiDto sizai) {
		boolean isInStore = storeDao.inStoreAct(sizai);
		return isInStore;
	}

	//4004出庫実行
	public boolean outStore(SizaiDto sizai) {
		boolean isOutStore = storeDao.outStoreAct(sizai);
		return isOutStore;
	}















}
