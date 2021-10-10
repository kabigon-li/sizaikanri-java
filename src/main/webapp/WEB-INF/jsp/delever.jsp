<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ include file="menu.jsp"%>
<body>
	<h1>納品</h1>
	<form action="/sizaikanri/order/search" method="post">

		<s:select name="form.deptId" list="form.deptList" listKey="id"
			listValue="name" />
		<input type="submit" value="検索" />
	</form>

	<s:if test="form.sizaiList != null && form.sizaiList.size != 0">
		<table class="outputtable">
			<tr>
				<th><font>資材ID</font></th>
				<th><font>資材名</font></th>
				<th><font>数量</font></th>
				<th><font>カテゴリ</font></th>
				<th><font>購入依頼者</font></th>
				<th><font>購入依頼部門</font></th>
				<th><font>状態</font></th>
				<th><font>依頼日</font></th>
				<th><font>納品</font></th>
				<th><font>QRコード</font></th>
			</tr>

			<s:iterator value="form.sizaiList">
				<tr>
					<td><font><s:property value="id" /></font></td>

					<td><a
						href="/sizaikanri/approvalDetail/init?form.sizaiId=<s:property value="id"/>"
						target="under"> <font><s:property value="name" /></font>
					</a></td>

					<td><font><s:property value="num" /></font></td>

					<td><font><s:property value="category_name" /></font></td>

					<td><font><s:property value="request_user_name" /></font></td>

					<td><font><s:property value="request_dept_name" /></font></td>

					<td><font><s:property value="status_name" /></font></td>

					<td><font><s:property value="request_date" /></font></td>
					<td><s:if test="status == 4">
							<a
								href="/sizaikanri/delever/act?form.sizaiId=<s:property value="id"/>">
								<font>納品処理</font>
							</a>
						</s:if> <s:else>
							<font color="red">納品済</font>
						</s:else></td>

					<td><s:if test="status == 5">
							<a
								href="/sizaikanri/delever/qr?form.sizaiId=<s:property value="id"/>"  target="under">
								<font>QRコード</font>
							</a>
						</s:if>


				</tr>
			</s:iterator>
		</table>

		<!--------------------------------------detail sizai--------------------------------------------  -->

		<iframe name="under" width="100%" height="400"> </iframe>

	</s:if>

</body>