
<body>
	<center>
		<b>Ranking de livros

<br><br><br><br>
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
</b>
	</center>
</body>
