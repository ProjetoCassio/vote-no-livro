<body>
	<center>
		<form name="userext" action="/vote-no-livro/user/save">


			<table>
				
				<tr>
					<td>Por favor, insira o seu nome e email para salvar.
					<c:if test="${message!=null}">
					<font color="red">${message }</font>
					</c:if>
					</td>
				</tr>
				<tr>
					<td>Nome: <input type="text" id="name" name="userExt.name"></td>
				</tr>
				<tr>
					<td>E-mail: <input type="text" id="email" name="userExt.email"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Enviar"></td>
				</tr>


			</table>


		</form>
		<br>
		<br>

		<div id="opcoes">
			<table width="60%">
				<c:forEach items="${books}" var="rk">
					<tr>
						<td width="15%"><img src="/vote-no-livro/img/${rk.book.id}.jpg"
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
