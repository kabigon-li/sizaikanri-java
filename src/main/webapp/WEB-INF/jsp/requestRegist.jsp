<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ include file="menu.jsp"%>


<body>
<h1>購入依頼登録</h1>

	<font color="blue">購入理由、補足事項を備考欄に記載してください。</font>
	<form name="buyrequestform" action="/sizaikanri/requestRegist/regist" method="post">
		<table class="inputtable">
			<tr>
				<td><label>資材名</label></td>
				<td><input type="text" name="form.sizai.name" /></td>
			</tr>
			<tr>
				<td><label>数量</label></td>
				<td><input type="number" name="form.sizai.num" /></td>
			</tr>
			<tr>
				<s:select name="form.sizai.category_id" label="カテゴリ" list="form.categoryList" listKey="id" listValue="name" />
			</tr>

			<tr>
				<td><label>備考</label></td>
				<td><textarea rows="10" cols="30" name="form.sizai.note"></textarea></td>
			</tr>

			<tr>
				<td><label>購入理由</label></td>
				<td><textarea rows="10" cols="30" name="form.sizai.buy_reason"></textarea></td>
			</tr>
			<tr>
				<td><input type="submit" value="登録"/></td>
				<td><input type="reset" value="リセット"/></td>
			</tr>

		</table>
	</form>
	<a href="/sizaikanri/requestList/init">一覧へ戻る</a>
</body>
