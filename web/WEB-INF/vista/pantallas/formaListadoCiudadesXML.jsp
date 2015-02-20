    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

        <c:forEach var="ciudad" items="${formaListadoCiudades.ciudades}">
         

         <p class='ciudad'> <c:out value="${ciudad.nombre}"/><p>

        </c:forEach>

       