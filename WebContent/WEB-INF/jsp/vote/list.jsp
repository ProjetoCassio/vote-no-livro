
<body>
<center>
	<form method="post" id="formAction" action="vote/save">
		<p>Selecione o livro preferido entre as duas opções</p>
		<p>O mesmo livro pode aparecer comparando com outras opções</p>
		<br>
		<div id="opcoes">
			<table width="60%">
				<c:forEach items="${livros}" var="livro">
					<tr>
						<td width="15%"><img src="/vote-no-livro/img/${livro.id}.jpg"
							style="width: 160px; height: 220px"></td>
						<td>
							<div
								style="width: 100%; height: 100px; background-color: #CFCFCF"><br>
								${livro.title } - ${livro.author }</div>
							<div
								style="width: 100%; height: 100px; background-color: #CFCFCF">
								${livro.description }</div>
							<div
								style="width: 100%; height: 40px; background-color: #CFCFCF; text-align: center;">
								<a href="/vote-no-livro/vote/save?id=${livro.id }"><div
										style="width: 100px; height: 40px; background-color: #7B68EE; text-align: center;"><br>Votar</div></a>
							</div>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</form>
	</center>
</body>