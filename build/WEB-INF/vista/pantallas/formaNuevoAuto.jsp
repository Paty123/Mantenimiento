<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>




<script type="text/javascript"  src="js/jquery.js"></script>
<script type="text/javascript">

$(document).ready(function(){

  $('#muestra').on('keyup',function(){

    var valor=$('#muestra').val();

    $.ajax({

      type:"post",url:'solicitarListarCiudadesXML.do?letra'+valor,dataType:"html",success:function(data){

        $('ListaOrdenada').html(data);
        $('ListaOrdenada').css('display','block');
      },
      error:function(){

        alert("Un error al procesar el archivo ");
      }
    });

    $('body').on('mouseover','ciudad',function(){
      $(this).css('background-color','lightblue');

    )};
    $('body').on('click','.ciudad',function()
    {
      $('#muestra').val($(this).html());
      $('#ListaOrdenada').css('display','none');
      });

  });
</script>



<div class="sixteen column">
  
  <html:errors />
  <h3>Agregar un nuevo Auto</h3>
  <form id="formaRegistro" action="procesarRegistroAuto.do" method="post">
    <label>Marca: </label><input 
    type="text" 
    name="marca"
    value="${formaNuevoAuto.marca}">
    <label>Color : </label><input 
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
    id="muestra"
    name="ciudad"
    value="${formaNuevoAuto.ciudad}">
    <div id="ListaOrdenada"style="display:none;

margin-top: 1px;
width: 220px;
height: 200px;
  "></div>
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
</div>
