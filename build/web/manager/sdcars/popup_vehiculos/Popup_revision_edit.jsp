<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
	<SCRIPT>

   function enviar(){
      if(document.forms[0].rveh_actividad.value==''){
         alert('<bean:message key="5020" />');
         document.forms[0].rveh_actividad.focus();
         return false;
      }
      if((document.forms[0].rveh_cada_cdk.value=='0' || document.forms[0].rveh_cada_cdk.value=='') && (document.forms[0].rveh_alt_cod.value==1 ||document.forms[0].rveh_alt_cod.value==3)){
         alert('<bean:message key="5022" />');
         document.forms[0].rveh_cada_cdk.focus();
         return false;
      }
      if((document.forms[0].rveh_cada_cdm.value=='0' || document.forms[0].rveh_cada_cdm.value=='') && (document.forms[0].rveh_alt_cod.value==2 ||document.forms[0].rveh_alt_cod.value==3)){
         alert('<bean:message key="5021" />');
         document.forms[0].rveh_cada_cdm.focus();
         return false;
      }
               
	  //lo paso a Km porq en la BD estamos almacenando todo en Km
<%--      if (document.forms[0].tipoMedidaP.value=="Millas") {--%>
<%--      	var millaD = document.forms[0].rveh_cada_cdk.value / 0.6;--%>
<%--		var milla = Math.floor(millaD);--%>
<%--		document.forms[0].rveh_cada_cdk.value = milla;--%>
<%--      }--%>
      
		document.forms[0].action="<%=request.getContextPath()%>/DatosVehiculo/Popup/transferir_revision.do"
	    document.forms[0].target='a3'
		top.close();
		actualiza_popup_abierto();
		document.forms[0].submit();
}

	function habilitar()
	{
		if(document.forms[0].rveh_alt_cod.value==1) {
			document.forms[0].rveh_cada_cdk.disabled=false;
			document.forms[0].rveh_cada_cdm.disabled=true;
		}
		else if(document.forms[0].rveh_alt_cod.value==2) {
			document.forms[0].rveh_cada_cdk.disabled=true;
			document.forms[0].rveh_cada_cdm.disabled=false;
		}
		else if(document.forms[0].rveh_alt_cod.value==3) {
			document.forms[0].rveh_cada_cdk.disabled=false;
			document.forms[0].rveh_cada_cdm.disabled=false;
		}	
	}
	
	function carga() {
		 //lo paso a Km porq en la BD estamos almacenando todo en Km
<%--      	if (document.forms[0].tipoMedidaP.value=="Millas") {--%>
<%--      		var millaD = document.forms[0].rveh_cada_cdk.value * 0.6;--%>
<%--			var milla = Math.floor(millaD);--%>
<%--			document.forms[0].rveh_cada_cdk.value = milla;--%>
<%--     	}--%>
	}
</SCRIPT>
	<html:form target="_self" action="/DatosVehiculo/Popup/add_revision.do">
		<input type="hidden" name="num_revision" value="<%=request.getParameter("num_revision")%>" />
		<html:hidden property="rveh_cod" />
		<html:hidden property="rveh_veh_cod"/>
		<html:hidden property="rveh_control_fec"/>
		<html:hidden property="rveh_control_kms"/>
		<table border="0" cellpadding="0" cellspacing="0" align="center" width="620">
			<tr>
				<TD>
					<table border="0" id="tab2" cellspacing="0" cellpadding="0" width="100%">
						<tr>
							<td colspan="2">
								<img src="<%=request.getContextPath()%>/images/int_tit_car.gif">
							</td>
						</tr>
						<tr>
							<TD colspan="2" class="tdtitle">
								<hr />
							</td>
						</tr>
						<tr>
							<TD class="tdOverNameOption">
								Revision&nbsp;
								<%=Integer.parseInt(request.getParameter("num_revision")) + 1%>
							</TD>
							<TD class="tdOverNameOption">
								<bean:message key="global.button.editar" />
								&nbsp;
								<bean:message key="3527" />
							</TD>
						</tr>
						<tr>
							<TD colspan="2" >&nbsp;
								
							</TD>
						</tr>
						<TR>
							<TD colspan="4" class="view_item">
								<bean:message key="7411" />
							</TD>
						</TR>
						<tr>
							<td>&nbsp;</td>
						</tr>	
						<TR>
							<TD colspan="4" class="view_item">
								<bean:message key="7412" />
							</TD>
						</TR>
						<tr>						
							<td class="view_item" align="left">
								<br>
								<bean:message key="1056" />
							</td>
							<td>
								<html:text property="rveh_actividad" maxlength="150" size="100" styleClass="sel" />
							</td>
						</tr>
						<tr>
							<td class="view_item" align="left">
								<bean:message key="1057" />
							</td>
							<td>
								<html:select property="rveh_alt_cod" styleClass="sel" onchange="habilitar()">
									<html:options collection="alternativas" labelProperty="ralt_des" property="ralt_cod" />
								</html:select>
							</td>
						</tr>
						<tr>
							<td class="view_item" align="left">
								<bean:message key="1058" />
							</td>
							<td>
								<bean:message key="3500" />
								<html:text property="rveh_cada_cdk" onkeyup="isNatural(this);" onblur="isNatural(this);" maxlength="6" size="10" styleClass="sel" onfocus="this.select()" />
								&nbsp;&nbsp;
								<bean:message key="5119" />
								<html:text property="rveh_cada_cdm" onkeyup="isNatural(this);" onblur="isNatural(this);" maxlength="3" size="10" styleClass="sel" onfocus="this.select()" disabled="true"/>
							</td>
						</tr>
						<tr>
							<td class="view_item" align="left">
								<bean:message key="1059" />
							</td>
							<td>
								<html:select property="rveh_acc_cod" styleClass="sel">
									<html:options collection="acciones" labelProperty="racc_des" property="racc_cod" />
								</html:select>
							</td>
						</tr>
						<TR>
							<TD colspan="2">&nbsp;
								
							</TD>
						</TR>
						<TR>
							<TD colspan="2">
								<bean:message key="7443" />
							</TD>
						</TR>
						<tr>
						</tr>
						<tr>
							<TD colspan="2">
								<hr />
							</TD>
						</tr>
						<input type="hidden" name="tipoMedidaP" value="<%=request.getSession().getAttribute("tipoMedida")%>">
						<tr>
							<TD colspan="2" align="center">
								<INPUT type="button" onClick="enviar()" class="sbttn" value="<bean:message key="global.button.aceptar"/>">
							</TD>
						</tr>
					</table>
				</TD>
			</tr>
		</table>
	</html:form>
<script type="text/javascript" src="switchcontent.js" >
	<script type="text/javascript">
	habilitar();
// MAIN FUNCTION: new switchcontent("class name", "[optional_element_type_to_scan_for]") REQUIRED
// Call Instance.init() at the very end. REQUIRED

var bobexample=new switchcontent("switchgroup1", "div") //Limit scanning of switch contents to just "div" elements
bobexample.setStatus('<img src="<%=request.getContextPath()%>/images/opencq8.png" /> ', '<img src="<%=request.getContextPath()%>/images/closedy2.png" /> ')
bobexample.setColor('darkred', 'black')
bobexample.setPersist(true)
bobexample.collapsePrevious(true) //Only one content open at any given time
bobexample.init()
</script>
	<script type="text/javascript" src="switchcontent.js" >

/***********************************************
* Switch Content script- (c) Dynamic Drive (www.dynamicdrive.com)
* This notice must stay intact for legal use.
* Visit http://www.dynamicdrive.com/ for full source code
***********************************************/

</script>

<style type="text/css">

/*Style sheet used for demo. Remove if desired*/
.handcursor{
cursor:hand;
cursor:pointer;
}
</style>
