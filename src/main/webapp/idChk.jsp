<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ID�ߺ�üũ</title>
</head>
<script>
function load(){
	document.getElementById("userId").value = opener.document.userInfo.id.value;
	var result = ${result};
	if(result == 0){
		document.getElementById("cancelBtn").style.visibility='visible';
		document.getElementById("useBtn").style.visibility='hidden';
	}else{
		document.getElementById("cancelBtn").style.visibility='hidden';
		document.getElementById("useBtn").style.visibility='visible';
	}
}

function sendCheckValue(){
	// �ߺ�üũ ����� idCheck ���� �����Ѵ�.
	opener.document.userInfo.idDuplication.value ="idCheck";
	// ȸ������ ȭ���� ID�Է¶��� ���� ����
	opener.document.userInfo.id.value = document.getElementById("userId").value;
	
	if (opener != null) {
    	self.close();
	}	
}	
</script>
<body onload="load()">

<input type="text" name="id" id="userId" readonly>
<br>
<h3>${msg}</h3>
<input id="cancelBtn" type="button" value="����ϱ�" onclick="sendCheckValue()">
<input id="useBtn" type="button" value="���" onclick="window.close()">
</body>
</html>