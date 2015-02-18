<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>
<section id = "contenidoGeneral">
	<h3>Agregar un nuevo Auto</h3>
	<form id="formaRegistro" action="procesarRegistroAuto.do" method="post">
		<label>Marca: </label><input 
		type="text" 
		name="marca"
		value="${formaNuevoAuto.marca}">
		<label>Color: </label><input 
		type="text" 
		name="color"
		value="${formaNuevoAuto.color}">
		<label>Placas: </label><input 
		type="text" 
		name="placas"
		value="${formaNuevoAuto.placas}">
		<label>Propietario : </label><input 
		type="text" 
		name="propietario"
		value="${formaNuevoAuto.propietario}">
		<label>Ciudad : </label><input 
		type="text" 
		name="ciudad"
		value="${formaNuevoAuto.ciudad}">
      	<input type="submit" 
      	       name="submit"
      	       value="Agregar y terminar"/>
      	<input type="submit" 
      	       name="submit"
      	       value="Agregar y volver"
      	       onclick="forma.action='procesarRegistroAuto.do?volver=si'"/>
      	<input type="button"
      	       value="Reset"
      	       onclick="location.href='solicitarRegistroAuto.do'" />
      	<input type="submit" 
      	       name="org.apache.struts.taglib.html.CANCEL" 
      	       value="cancelar" 
      	       onclick="bCancel=true;">    
	</form>
</section>
