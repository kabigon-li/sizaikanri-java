<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ include file="menu.jsp"%>
<body>
	<h1>購入依頼一覧</h1>
	<form action="/sizaikanri/requestList/search" method="post">
		<label>From:</label><input type="date" name="form.startDate"
			value="<s:property value="form.startDate"/>" /> <label>To:</label><input
			type="date" name="form.endDate"
			value="<s:property value="form.endDate"/>" /> <input type="submit"
			value="検索" />
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
				<th><font>撤回</font></th>
				<th><font>却下理由</font></th>
			</tr>

			<s:iterator value="form.sizaiList">
				<tr>
					<td><font><s:property value="id" /></font></td>

					<td><a
						href="/sizaikanri/requestDetail/init?form.sizaiId=<s:property value="id"/>">
							<font><s:property value="name" /></font>
					</a></td>

					<td><font><s:property value="num" /></font></td>

					<td><font><s:property value="category_name" /></font></td>

					<td><font><s:property value="request_user_name" /></font></td>

					<td><font><s:property value="request_dept_name" /></font></td>

					<td><font><s:property value="status_name" /></font></td>

					<td><font><s:property value="request_date" /></font></td>
					<td><s:if test="status == 1 || status == 3">
							<a
								href="/sizaikanri/requestList/delete?form.withdrawalId=<s:property value="id"/>">
								<font>撤回</font>
							</a>
						</s:if> <s:else>
							<font color="red">撤回不可</font>
						</s:else></td>

					<td><s:if test="status == 3">
							<s:property value="dele_reason"/>
						</s:if>
				</tr>
			</s:iterator>
		</table>

		<!--------------------------------------add sizai--------------------------------------------  -->
		<s:if test="form.sizaiList != null || form.sizaiList.size != 0">
			<a href="/sizaikanri/requestRegist/init">購入依頼登録</a>
		</s:if>


	</s:if>

</body>













