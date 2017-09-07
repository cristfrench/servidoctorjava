<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@page import="java.util.List"%>
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

</SCRIPT>
	<html:form target="_self" action="/DatosVehiculo/Popup/add_revision.do">
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
								<%=request.getSession().getAttribute("REVISIONES") != null && ((List)request.getSession().getAttribute("REVISIONES")).size() > 0 ? ((List)request.getSession().getAttribute("REVISIONES")).size() + 1 : 1%>
							</TD>
							<TD class="tdOverNameOption">
								<bean:message key="global.button.adicionar" />
								&nbsp;
								<bean:message key="3527" />
							</TD>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<TD colspan="2" class="view_item">
								<bean:message key="7409" />
							</TD>
						</TR>
						<tr>
							<td>&nbsp;</td>							
						</tr>
						<TR>
							<TD colspan="2" class="view_item">
								<bean:message key="7410" />
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
						<table width="100%">
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
								<html:text property="rveh_cada_cdm" onkeyup="isNatural(this);" onblur="isNatural(this);" maxlength="3" size="10" styleClass="sel" onfocus="this.select()" disabled="true" />
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
						</table>
						<TR>
							<TD colspan="2">&nbsp;
							</TD>
						</TR>
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
	
	<script type="text/javascript">habilitar()
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
