<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ include file="menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>入庫画面</title>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/webrtc-adapter/3.3.3/adapter.min.js"></script>
<script type="text/javascript"
	src="https://rawgit.com/schmich/instascan-builds/master/instascan.min.js"></script>
<script type="text/javascript">
	function scan() {
		document.getElementById("disdiv").style.display = "block";
		let scanner = new this.Instascan.Scanner({
			video : document.getElementById('preview')
		});
		scanner.addListener('scan', function(content) {
			console.log(content);
			document.getElementById('target').value = content;
			document.getElementById("disdiv").style.display = "none";
			document.searchform.submit();
			scanner.stop();
		});
		Instascan.Camera.getCameras().then(function(cameras) {
			if (cameras.length > 0) {
				scanner.start(cameras[0]);
			} else {
				console.error('No cameras found.');
			}
		});
	};
</script>
</head>

<body>
	<h1>入庫</h1>
	<!-- --------------read QR code------------------- -->
	<div id="disdiv" style="display: none">
		<video id="preview" width="300" height="300"></video>
	</div>

	<button id="scanbutton" onclick="scan()">QRコード読取</button>


	<!-- ---------------search sizai by id ------------- -->
	<form action="/sizaikanri/inStore/search" method="post">
		<input type="number" name ="form.sizaiId" id="target" placeholder="資材IDを入力してください"/> <input type="submit" value="検索" />
	</form>

	<!----------------- search result sizaiDto ----------------------->

	<s:if test="form.sizai !=null">
		<form name="instoreform" action="/sizaikanri/inStore/act"
			method="post">
			<table class="inputtable">
				<tr>
					<td><label>資材ID</label></td>
					<td><s:property value="form.sizai.id" /> <input type="hidden"
						name="form.sizai.id" value="<s:property value="form.sizai.id" />" />
					</td>
				</tr>
				<tr>
					<td><label>資材名</label></td>
					<td><s:property value="form.sizai.name" /><input
						type="hidden" name="form.sizai.name"
						value="<s:property value="form.sizai.name"/>" /></td>
				</tr>
				<tr>
					<td><label>数量</label></td>
					<td><s:property value="form.sizai.num" /><input type="hidden"
						name="form.sizai.num" value="<s:property value="form.sizai.num"/>" /></td>
				</tr>

				<tr>
					<td><label>カテゴリ</label></td>
					<td><s:property value="form.sizai.category_name" /><input
						type="hidden" name="form.sizai.category_name"
						value="<s:property value="form.sizai.category_name"/>" /></td>

				</tr>

				<tr>
					<td><label>状態</label></td>
					<td><s:property value="form.sizai.status_name" /><input
						type="hidden" name="form.sizai.status_name"
						value="<s:property value="form.sizai.status_name"/>" /></td>
				</tr>


				<tr>
					<s:select name="form.sizai.souko_id" label="倉庫"
						list="form.soukoList" class="seigyo" listKey="id" listValue="name" />
				</tr>


				<tr>
					<td><label>購入依頼者</label></td>
					<td><s:property value="form.sizai.request_user_name" /><input
						type="hidden" name="form.sizai.request_user_name"
						value="<s:property value="form.sizai.request_user_name"/>" /></td>
				</tr>

				<tr>
					<td><label>購入依頼部門</label></td>
					<td><s:property value="form.sizai.request_dept_name" /><input
						type="hidden" name="form.sizai.request_dept_name"
						value="<s:property value="form.sizai.request_dept_name"/>" /></td>
				</tr>



				<tr>
					<td><label>依頼日</label></td>
					<td><s:property value="form.sizai.request_date" /><input
						type="hidden" name="form.sizai.request_date"
						value="<s:property value="form.sizai.request_date"/>" /></td>
				</tr>

				<tr>
					<td><label>発注日</label></td>
					<td><s:property value="form.sizai.order_date" /><input
						type="hidden" name="form.sizai.order_date"
						value="<s:property value="form.sizai.order_date"/>" /></td>
				</tr>

				<tr>
					<td><label>納品日</label></td>
					<td><s:property value="form.sizai.delivery_date" /><input
						type="hidden" name="form.sizai.delivery_date"
						value="<s:property value="form.sizai.delivery_date"/>" /></td>
				</tr>

				<tr>
					<td><label>入庫日</label></td>
					<td><s:property value="form.sizai.instore_date" /><input
						type="hidden" name="form.sizai.instore_date"
						value="<s:property value="form.sizai.instore_date"/>" /></td>
				</tr>

				<tr>
					<td><label>出庫日</label></td>
					<td><s:property value="form.sizai.outstore_date" /><input
						type="hidden" name="form.sizai.outstore_date"
						value="<s:property value="form.sizai.outstore_date"/>" /></td>
				</tr>


				<tr>
					<td><label>備考</label></td>
					<td><s:property value="form.sizai.note" /><input
						type="hidden" name="form.sizai.note"
						value="<s:property value="form.sizai.note"/>" /></td>
				</tr>

			</table>

			<s:if test="form.sizai.status == 5">
				<input type="submit" value="入庫" />
			</s:if>
		</form>
	</s:if>

</body>