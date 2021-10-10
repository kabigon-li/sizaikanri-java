package co.jp.mamol.myapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.jp.mamol.myapp.dto.CategoryDto;
import co.jp.mamol.myapp.dto.SizaiDto;

public interface BuyRequestDao {
	//1001購入依頼登録
	public void requestRegist(SizaiDto sizai);

	//1002カテゴリ取得
	public List<CategoryDto> getCategory();

	//1003ユーザ別購入依頼リスト
	public List<SizaiDto> getUserRequestList(@Param("startDate") String startDate,@Param("endDate")String endDate, @Param("userid")String userid);

	//1004購入依頼一件取得
	public SizaiDto getRequestById (@Param("sizaiId") int sizaiId);

	//1005購入依頼変更
	public boolean modifyRequest(SizaiDto sizai);

	//1006購入依頼削除
	public boolean deleteById(@Param("sizaiId") int sizaiId);













}
