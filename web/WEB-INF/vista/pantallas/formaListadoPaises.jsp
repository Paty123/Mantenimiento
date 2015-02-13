  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>
<style>
  .HipervinculoAdmon{
    color:#000000;
    text-decoration:none;
  }
  
  .HipervinculoAdmon:hover{
    color:#006666;
    text-decoration:underline;
  }
</style>
<script language="javascript" type="text/javascript">
<!--
  function EliminarEstado(strEstadoName){
    return confirm("¿Desea eliminar el estado '" + strEstadoName + "'?")
  }
-->
</script>
    <br>
    <font size='5'><fmt:message key="formaListadoPaises.titulo" /></font>
    <div class="table" style="width:100%" >
        <div class="tr">
            <div class="td" colspan="4" style="padding-top:25px; padding-bottom:25px;">
                <a href="solicitarRegistroPaises.do" class="HipervinculoAdmon boton">Agregar nuevo pais...</a>
            </div>
        </div>
        <div class="tr">
            <div class="td" colspan="4">
               <html:errors />
            </div>
        </div>
        <div class="tr" style="background:#CCCCCC;">
         
         <div class="td" style="width:58%; border-right-style:solid; border-left-style:solid; border-width:1px; border-color:#000000;"><b><fmt:message key="formaListadoPaises.etiqueta.descripcion" /></b></div>
         <div class="td" style="width:20%"><b><fmt:message key="formaListadoPaises.etiqueta.administracion" /></b></div>
        </div>
        <c:forEach var="pais" items="${formaListadoPaises.paises}">
            <div class="tr">
               
                <div class="td" align="left" style="width:58%"><c:out value="${pais.descripcion}"/></div>
                <div class="td" align="left" style="width:20%">
                    <a href='solicitarModificarPais.do?id=<c:out value="${pais.id}"/>'
                       class="HipervinculoAdmon">
                        <fmt:message key="formaListadoPaises.etiqueta.modificar" />
                    </a>
                    <a href='procesarEliminarPais.do?id=<c:out value="${pais.id}"/>'
                       onClick="javascript: return EliminarPais('<c:out value="${pais.descripcion}"/>')"
                       class="HipervinculoAdmon">
                        <fmt:message key="formaListadoPaises.etiqueta.eliminar" />
                    </a>
                </div>
            </div>
        </c:forEach>
        <div class="tr">
            <div class="td" colspan="4" align="right" style="padding-top:25px;"><b>Total:</b> ${formaListadoPaises.contador}</div>
        </div>
    </div>