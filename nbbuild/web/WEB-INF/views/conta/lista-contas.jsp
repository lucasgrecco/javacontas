<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<c:import url="../imports/cabecalho.jsp"></c:import>
<script type="text/javascript" src="resources/js/jquery.js"></script>

<script type="text/javascript">
function pagaAgora(id) {
	  $.post("paga-conta", {'id' : id}, function() {
		  $("#conta-"+id).remove();
		  $("#conta-"+id+"-status").text("Paga");
	    alert("Conta paga com sucesso");
	  });
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contas Adicionadas</title>
</head>
<body>
<br><br>
 <div class="jumbotron">
	<table class="table table-bordered">
		<tr>
			<th>Código</th>
			<th>Descrição</th>
			<th>Valor</th>
			<th>Tipo</th>
			<th>Pago?</th>
			<th>Data de Pagamento</th>
			<th>Ações</th>
		</tr>
	
	
		<c:forEach items="${contas}" var="conta">
			<tr id="resultado">
				<td>${conta.id}</td>	
				<td>${conta.descricao}</td>	
				<td>${conta.valor}</td>	
				<td>${conta.tipo}</td>	
				<td id="conta-${conta.id}-status">
					<c:if test="${conta.paga eq false}">
						Não Pago
					</c:if> 
					<c:if test="${conta.paga eq true}">
						Pago
					</c:if> 
				</td>	
				<td id="conta-${conta.id}-data-pagamento">
					<fmt:formatDate value="${conta.dataPagamento.time}" pattern="dd/mm/yyyy"/> 
				</td>	
				<td>
					<ul>
						<li></div><a href="/contas/remove-conta?id=${conta.id}">Remove Conta</a></li>
						<li><a href="/contas/mostra-conta?id=${conta.id}">Alterar</a></li>
						<c:if test="${conta.paga eq false}">
							<li id="conta-${conta.id}">
							  <a href="#" onClick="pagaAgora(${conta.id})">
							    Pagar agora!
							  </a>
							</li>
						</c:if>
					</ul>
				</td>
			</tr>	
		</c:forEach>
	</table>
</div>
</body>
</html>