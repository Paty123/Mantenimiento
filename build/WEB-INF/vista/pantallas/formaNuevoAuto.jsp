    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>


    <br>
    <font size='5'><fmt:message key="formaNuevoAuto.titulo" /></font>

    <form id="forma" action="procesarRegistroAuto.do" method="post">
        <div class="table">
            <div class="tr">
                <div class="td" colspan="2">
                   <html:errors />
                </div>
            </div>
            <div class="tr">
                <div class="td" align="right">
                    <fmt:message key="formaNuevoAuto.etiqueta.marca" />
                </div>
                <div class="td" align="left">
                    <input type="text" 
                           name="marca" 
                           size="50" 
                           maxlength="100" 
                           value="${formaNuevoAuto.marca}" />
                </div>
            </div>
            <div class="tr">
                <div class="td" align="right">
                    <fmt:message key="formaNuevoAuto.etiqueta.color" />
                </div>
                <div class="td" align="left">
                    <input type="text" 
                           name="color" 
                           size="50" 
                           maxlength="100" 
                           value="${formaNuevoAuto.color}" />
                </div>
            </div>
            <div class="tr">
                <div class="td" align="right">
                    <fmt:message key="formaNuevoAuto.etiqueta.placas" />
                </div>
                <div class="td" align="left">
                    <input type="text" 
                           name="placas" 
                           size="50" 
                           maxlength="100" 
                           value="${formaNuevoAuto.placas}" />
                </div>
            </div>
            <div class="tr">
                <div class="td" align="right">
                    <fmt:message key="formaNuevoAuto.etiqueta.propietario" />
                </div>
                <div class="td" align="left">
                    <input type="text" 
                           name="propietario" 
                           size="50" 
                           maxlength="100" 
                           value="${formaNuevoAuto.propietario}" />
                </div>
            </div>
            <div class="tr">
                <div class="td" align="right">
                    <fmt:message key="formaNuevoAuto.etiqueta.ciudad" />
                </div>
                <div class="td" align="left" style="position:relative">
                    <input type="text" 
                           id ="ciudadBuscar" autocomplete="off" />
                    <div class="buscar">
                      <ul>
                      </ul>
                    </div>
                    <input type="text" 
                           id="idCiudad"
                           name="idCiudad" 
                           size="50" 
                           style="display:none"
                           maxlength="100" />
                  <!--
                    <select name="idCiudad" >
                      <c:forEach var="ciudad" items="${formaNuevoGente.ciudades}">
                        <option value='<c:out value="${ciudad.id}" />'><c:out value="${ciudad.nombre}" /></option>
                      </c:forEach>
                    </select>
                  -->
                </div>
            </div>
            <div class="tr">
                <div class="td" align="right">
                    <fmt:message key="formaNuevoAuto.etiqueta.estado" />
                </div>
                <div class="td" align="left" style="position:relative">
                    <div id="estadoNombre"></div>
                </div>
            </div>
            <div class="tr">
                <div class="td" style="width:400px;" align="center">
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
                </div>
            </div>
        </div>
    </form>