<body>
	<center>
		<form name="userext" action="/vote-no-livro/user/save">
			<table>
				<tr>
					<td>Por favor, insira o seu nome e email para salvar.<c:if
							test="${message!=null}">
							<font color="red">${message }</font>
						</c:if>
						<div id="msgemail"></div>
					</td>
				</tr>
				<tr>
					<td>Nome: <input type="text" id="name" name="userExt.name"></td>
				</tr>
				<tr>
					<td>E-mail: <input type="text" id="email" name="userExt.email"
						onblur="validacaoEmail(userext.userExt.email)"></td>
				</tr>
				<tr>
					<td><input type="button" value="Enviar" onClick="sendUser()"></td>
				</tr>
			</table>
		</form>
		<br> <br>
		Lista do livros mais votados por você:<br><br>
		<div id="opcoes">
			<table width="60%">
				<c:forEach items="${books}" var="rk">
					<tr>
						<td width="15%"><img
							src="/vote-no-livro/img/${rk.book.id}.jpg"
							style="width: 80px; height: 110px"></td>
						<td>
							<div style="width: 100%; height: 60px; background-color: #CFCFCF">
								${rk.book.title } - ${rk.book.author }</div>
							<div
								style="width: 100%; height: 20px; background-color: #CFCFCF; text-align: center;">
								<div
									style="width: 100px; height: 40px; background-color: #7B68EE; text-align: center;">${rk.count }</div>
							</div>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</center>
</body>
<script language="javascript">
	function sendUser() {
		v1 = document.userext.email.value.substring(0,
				document.userext.email.value.indexOf("@"));
		v2 = document.userext.email.value.substring(
				document.userext.email.value.indexOf("@") + 1,
				document.userext.email.value.length);
		if ((v1.length >= 1) && (v2.length >= 3) && (v1.search("@") == -1)
				&& (v2.search("@") == -1) && (v1.search(" ") == -1)
				&& (v2.search(" ") == -1) && (v2.search(".") != -1)
				&& (v2.indexOf(".") >= 1)
				&& (v2.lastIndexOf(".") < v2.length - 1)) {

			location.href = "/vote-no-livro/user/save?userExt.name="
					+ document.userext.name.value + "&userExt.email="
					+ document.userext.email.value;
		} else {
			document.getElementById("msgemail").innerHTML = "<font color='red'>E-mail inválido </font>";
		}

	}
</script>