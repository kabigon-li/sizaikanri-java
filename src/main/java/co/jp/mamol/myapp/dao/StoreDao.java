package co.jp.mamol.myapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.jp.mamol.myapp.dto.SizaiDto;
import co.jp.mamol.myapp.dto.SoukoDto;

public interface StoreDao {
	//4001資材情報一件取得
	public SizaiDto getSizaiById(@Param("sizaiId") int sizaiId);

	//4002倉庫情報取得
	public List<SoukoDto> getSoukoList();

	//4003入庫実行
	public boolean inStoreAct(SizaiDto sizai);

	//4004出庫実行
	public boolean outStoreAct(SizaiDto sizai);

}
