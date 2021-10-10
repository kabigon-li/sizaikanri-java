<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ include file="menu.jsp"%>

<html>
<head>
<title>購入依頼詳細</title>
<script type="text/javascript">
	$(function() {
		if ('<s:property value="form.flag" />' == 'false') {
			$(".seigyo").prop('disabled', true);
		}
	});
</script>
</head>

<body>
	<h1>購入依頼詳細</h1>

	<font color="blue">購入理由、補足事項を備考欄に記載してください。</font>
	<form name="requestdetailform"
		action="/sizaikanri/requestDetail/modify" method="post">
		<table class="inputtable">
			<tr>
				<td><label>資材ID</label></td>
				<td><s:property value="form.sizai.id" /> <input type="hidden"
					name="form.sizai.id" value="<s:property value="form.sizai.id" />" />
				</td>
			</tr>
			<tr>
				<td><label>資材名</label></td>
				<td><input type="text" name="form.sizai.name" class="seigyo"
					size="60" value="<s:property value="form.sizai.name"/>" /></td>
			</tr>
			<tr>
				<td><label>数量</label></td>
				<td><input type="number" name="form.sizai.num" class="seigyo"
					size="60" value="<s:property value="form.sizai.num"/>" /></td>
			</tr>

			<tr>
				<s:select name="form.sizai.category_id" label="カテゴリ"
					list="form.categoryList" listKey="id" listValue="name" />

			</tr>

			<tr>
				<td><label>購入依頼者</label></td>
				<td><s:property value="form.sizai.request_user_name" /></td>
			</tr>

			<tr>
				<td><label>購入依頼部門</label></td>
				<td><s:property value="form.sizai.request_dept_name" /></td>
			</tr>

			<tr>
				<td><label>状態</label></td>
				<td><s:property value="form.sizai.status_name" /></td>
			</tr>

			<tr>
				<td><label>依頼日</label></td>
				<td><s:property value="form.sizai.request_date" /></td>
			</tr>


			<tr>
				<td><label>備考</label></td>
				<td><textarea rows="10" cols="30" name="form.sizai.note"
						class="seigyo" ></textarea></td>
			</tr>

			<tr>
				<td><label>購入理由</label></td>
				<td><textarea rows="10" cols="30" name="form.sizai.buy_reason"
						class="seigyo" ></textarea></td>
			</tr>

		</table>

		<input type="submit" value="更新" /> <a
			href="/sizaikanri/requestList/init">一覧へ戻る</a>
	</form>


</body>