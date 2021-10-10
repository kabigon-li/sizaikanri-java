package co.jp.mamol.myapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.jp.mamol.myapp.dto.SizaiDto;

public interface BuyApprovalDao {
	//2001部門別購入依頼一覧
	public List<SizaiDto> getDeptRequestList(@Param("startDate") String startDate,@Param("endDate")String endDate, @Param("deptId")String deptId);

	//2002購入依頼一件取得
	public SizaiDto getRequestById (@Param("sizaiId") int sizaiId);

	//2003承認実行
	public boolean approval(@Param("sizaiId") int sizaiId);

	//2004却下実行
	public boolean regect(@Param("sizaiId") int sizaiId);







}
