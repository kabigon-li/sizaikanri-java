<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<body>

	<div style="border: thin solid black">
		<h1>詳細情報</h1>

		<table>
			<tr>
				<td>資材ID</td>
				<td><s:property value="form.sizai.id" /></td>
			</tr>
			<tr>
				<td>資材名</td>
				<td><s:property value="form.sizai.name" /></td>
			</tr>
			<tr>
				<td>数量</td>
				<td><s:property value="form.sizai.num" /></td>
			</tr>
			<tr>
				<td>購入依頼者</td>
				<td><s:property value="form.sizai.request_user_name" /></td>
			</tr>
			<tr>
				<td>購入依頼部門</td>
				<td><s:property value="form.sizai.request_dept_name" /></td>
			</tr>
			<tr>
				<td>状態</td>
				<td><s:property value="form.sizai.status_name" /></td>
			</tr>
			<tr>
				<td>依頼日</td>
				<td><s:property value="form.sizai.request_date" /></td>
			</tr>
			<tr>
				<td>備考</td>
				<td><s:property value="form.sizai.note" /></td>
			</tr>
		</table>


	</div>

</body>