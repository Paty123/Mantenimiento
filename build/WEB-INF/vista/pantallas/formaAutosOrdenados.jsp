    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>
         

              <div class="contenedor">
  <h3>Reporte de Marcas agregados</h3>
  <table>
        <a href="solicitarRegistroAuto.do" class="HipervinculoAdmon">Agregar nuevo Auto...</a>

        
        <html:errors />
        
        <tr>
         <td class="ordena"><b><fmt:message key="formaListadoAutos.etiqueta.marca" /></b></td>
         <td class="ordena"><b><fmt:message key="formaListadoAutos.etiqueta.color" /></b></td>
         <td class="ordena"><b><fmt:message key="formaListadoAutos.etiqueta.placas" /></b></td>
         <td class="ordena"><b><fmt:message key="formaListadoAutos.etiqueta.propietario" /></b></td>
         <td class="ordena"><b><fmt:message key="formaListadoAutos.etiqueta.ciudad" /></b></td>
         <td ><b><fmt:message key="formaListadoAutos.etiqueta.modificar" /></b></td>
         <td ><b><fmt:message key="formaListadoAutos.etiqueta.eliminar" /></b></td>
        </tr>
        <c:forEach var="Autos" items="${formaListadoAutos.Autos}">
            <tr>
                <td align="left"><c:out value="${Autos.marca}"/></td>
                <td align="left"><c:out value="${Autos.color}"/></td>
                <td align="left"><c:out value="${Autos.placas}"/></td>
                <td align="left"><c:out value="${Autos.propietario}"/></td>
                <td align="left"><c:out value="${Autos.ciudad}"/></td>
                <td align="left">
                    <a href='solicitarModificarAutos.do?id=<c:out value="${Autos.id}"/>'
                       class="HipervinculoAdmon">
                        <fmt:message key="formaListadoAutos.etiqueta.modificar" />
                    </a>
                </td>
                <td>
                    <a href='procesarEliminarAuto.do?id=<c:out value="${Auto.id}"/>'
                       onClick="javascript: return EliminarAuto('<c:out value="${Pacientes.nombre}"/>')"
                       class="HipervinculoAdmon">
                        <fmt:message key="formaListadoAutos.etiqueta.eliminar" />
                    </a>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="4" align="right" style="padding-top:25px;"><b>Total:</b> ${formaListadoAutos.contador}</td>
        </tr>
    </table>
</div>