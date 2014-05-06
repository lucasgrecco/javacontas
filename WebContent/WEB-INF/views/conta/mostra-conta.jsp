<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<body>
<c:import url="../imports/cabecalho.jsp"></c:import>
<div class="jumbotron">
	<div class="container"> 
	    <h3>Alterar Conta</h3>
	    <form action="altera-conta" method="post">
	        Descrição: <br/>
	        <textarea name="descricao" rows="5" cols="100">${conta.descricao}</textarea>
	        <br/>
	        Valor: <br/>
	        <input type="text" name="valor" value="${conta.valor}"/>
	        Tipo: 
	        <select name="tipo">
	            <option value="ENTRADA" ${conta.tipo=='ENTRADA' ? 'selected':''}>Entrada</option>
	            <option value="SAIDA" ${conta.tipo=='SAIDA' ? 'selected':''}>Saída</option>
	        </select>
	        <br/>
	        Pago? <input type="checkbox" name="paga"     ${conta.paga?'checked':''} />
	        <br/>
	        Data de Pagamento: <input type="text" name="dataPagamento" value="<fmt:formatDate value="${conta.dataPagamento.time}" pattern="dd/MM/yyyy" />" />
	        <br/>
	        <input type="hidden" name="id" value="${conta.id}"/>
	        <input type="submit" value="Alterar"/>
	    </form>
	</div>
</div>    
</body>
</html>