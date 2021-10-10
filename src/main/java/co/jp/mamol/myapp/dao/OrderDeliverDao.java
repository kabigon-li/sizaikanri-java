package co.jp.mamol.myapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.jp.mamol.myapp.dto.DepartmentDto;
import co.jp.mamol.myapp.dto.SizaiDto;

public interface OrderDeliverDao {
   //3001部署リスト取得
	public List<DepartmentDto> deptList();

	//3002承認済資材取得（部署別）
	public List<SizaiDto> approvaledList(@Param("dempId") String dempId);

	//3003発注済資材取得（部署別）
	public List<SizaiDto> orderedList(@Param("dempId") String dempId);

	//3004発注実行
	public boolean orderAct(@Param("sizaiId") int sizaiId);

	//3005納品実行
	public boolean deleverAct(@Param("sizaiId") int sizaiId);

}
