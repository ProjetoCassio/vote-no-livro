
<body>
Escolha o melhor livro:
<table>
  <thead>
    <tr>
    	<th></th>
      <th>Titulo</th>
      <th>Autor</th>
      <th>Descrição</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${livros}" var="livro">
      <tr>
      	<td>${livro.title }</td>
        <td>${livro.title }</td>
        <td>${livro.author}</td>
        <td>${livro.description}</td>
      </tr>          
    </c:forEach>
  </tbody>
</table>
</body>