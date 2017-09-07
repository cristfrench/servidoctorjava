<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ page import="com.servidoctor.constantes.IConstantes"%>
<%@ page import="org.apache.struts.util.MessageResources"%>
<%!MessageResources res = MessageResources.getMessageResources( "com.servidoctor.resources.ApplicationResources" );%>
<SCRIPT>
function enviar(){

	if(document.forms[0].odou_destratamiento.value=='' && document.forms[0].odou_odo_cod.value == <%=IConstantes.CODIGO_NO_EXISTE.toString()%>){
         alert('<bean:message key="6150" />');
         document.forms[0].odou_destratamiento.focus();
         return false;
    }if((document.forms[0].odou_edaddesdemes.value=='' || document.forms[0].odou_edaddesdemes.value=='0')&& (document.forms[0].odou_edaddesdeanio.value=='' || document.forms[0].odou_edaddesdeanio.value=='0')){
         alert('<bean:message key="6151" />');
         document.forms[0].odou_edaddesdemes.focus();
         return false;
    }if((document.forms[0].odou_edadhastames.value=='' || document.forms[0].odou_edadhastames.value=='0') && (document.forms[0].odou_edadhastaanio.value=='' || document.forms[0].odou_edadhastaanio.value=='0')){
         alert('<bean:message key="6152" />');
         document.forms[0].odou_edadhastames.focus();
         return false;
    }if(document.forms[0].odou_frecuencia.value=='' || document.forms[0].odou_frecuencia.value=='0'){
         alert('<bean:message key="6153" />');
         document.forms[0].odou_frecuencia.focus();
         return false;
    }if((document.forms[0].odou_edaddesdeanio.value - document.forms[0].odou_edadhastaanio.value > 0) && (document.forms[0].odou_edaddesdeanio.value - (document.forms[0].odou_edadhastames.value / 12) > 0)){
		document.forms[0].odou_edaddesdeanio.value='0';
		alert('<bean:message key="6151" />');
        document.forms[0].odou_edaddesdemes.focus();
        return false;
	}if((document.forms[0].odou_edaddesdemes.value - document.forms[0].odou_edadhastames.value > 0) && (document.forms[0].odou_edaddesdemes.value - (document.forms[0].odou_edadhastaanio.value * 12) > 0)){
		document.forms[0].odou_edaddesdemes.value='0';
		alert('<bean:message key="6151" />');
        document.forms[0].odou_edaddesdemes.focus();
		return false;
	}
	
	document.forms[0].action="<%=request.getContextPath()%>/Control_Odont/Popup/transferir_tabla.do"
	document.forms[0].target='a3'
	top.close();
	actualiza_popup_abierto();
	document.forms[0].submit();

}

function calculaEdadMeses(){
	if(document.forms[0].odou_edaddesdemes.value!=0){
		document.forms[0].odou_edaddesdeanio.value=0;
	}
	if(document.forms[0].odou_edadhastames.value!=0){
		document.forms[0].odou_edadhastaanio.value=0;
	}
}

function calculaEdadAnios(){
	if(document.forms[0].odou_edaddesdeanio.value!=0){
		document.forms[0].odou_edaddesdemes.value=0;
	}
	if(document.forms[0].odou_edadhastaanio.value!=0){
		document.forms[0].odou_edadhastames.value=0;
	}
}
</SCRIPT>



<html:form target="_self" action="/Control_Odont/Popup/transferir_tabla.do">
	<table border="0" width="100%">
		<tr>
			<td valign=top>
				<table class="tablag" align="center" cellpadding="0" cellspacing="0" border="0" width="600">
					<tr>
						<td>
							<table align="center" cellpadding="0" cellspacing="0" border="0" width="100%">
								<tr>
									<td>
										<table cellpadding="0" cellspacing="0" border="0" width="100%">
											<tr>
												<td colspan="3">
													<img src="<%=request.getContextPath()%>/images/int_tit_family.gif">
													<hr>
												</td>
											</tr>
											<tr>
												<td class="tdOverNameOption" colspan="3">
													<bean:message key="514" />
												</td>
											</tr>
											<tr>
												<td class="tdNameOption" colspan="3">
													<bean:message key="global.button.adicionar" />
													&nbsp;
													<bean:message key="112" />
												</td>
											</tr>
											<tr>
												<td colspan="3">

													<table border="0" id="tab2" cellspacing="0" cellpadding="0" width="100%">
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD colspan="2" class ="view_item">
																&nbsp;
																<bean:message key="7231" arg0="<%=res.getMessage( "parametro_adicion_odonto" )%>" />
															</TD>
														</tr>
														<tr>
															<TD colspan="2">
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="148" />
																:&nbsp;
															</TD>
															<td>
																<html:select property="odou_odo_cod" onchange="disableDinamique(document.forms[0].odou_destratamiento,document.forms[0].odou_odo_cod)">
																	<html:option value="<%=IConstantes.CODIGO_NO_EXISTE.toString()%>">
																		<bean:message key="579" />
																	</html:option>
																	<html:options collection="LISTAUNIVERSAL" property="odo_cod" labelProperty="odo_destratamiento" />
																</html:select>
															</td>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="579" />
																:&nbsp;
															</TD>
															<td>
																<html:text property="odou_destratamiento" maxlength="40" size="40" styleClass="sel" />
															</td>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD colspan="2" class="view_item">
																<bean:message key="103" />
															</TD>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="106" />
															</TD>
															<TD class="view_item">
																<bean:message key="107" />
															</TD>
														</tr>
														<tr>
															<td>
																<html:text property="odou_edaddesdemes" maxlength="2" size="3" styleClass="selNum" onkeyup="isNatural(this); calculaEdadMeses()"
																	onblur="isNatural(this)" />
															</td>
															<td>
																<html:text property="odou_edaddesdeanio" maxlength="3" size="3" styleClass="selNum" onkeyup="isNatural(this); calculaEdadAnios()"
																	onblur="isNatural(this)" />
															</td>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD colspan="2" class="view_item">
																<bean:message key="104" />
															</TD>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="106" />
															</TD>
															<TD class="view_item">
																<bean:message key="107" />
															</TD>
														</tr>
														<tr>
															<td>
																<html:text property="odou_edadhastames" maxlength="2" size="3" styleClass="selNum" onkeyup="isNatural(this); calculaEdadMeses()"
																	onblur="isNatural(this)" />
															</td>
															<td>
																<html:text property="odou_edadhastaanio" maxlength="3" size="3" styleClass="selNum" onkeyup="isNatural(this); calculaEdadAnios()"
																	onblur="isNatural(this)" />
															</td>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
														<tr>
															<TD class="view_item">
																<bean:message key="105" />
															</TD>
															<td>
																<html:text property="odou_frecuencia" maxlength="3" size="3" styleClass="selNum" onkeyup="isNatural(this)" onblur="isNatural(this)" />
															</td>
														</tr>
														<tr>
															<TD>
																&nbsp;
															</TD>
														</tr>
													</table>
												</TD>
											</tr>
											<tr>
												<td colspan="3">
													<table height="30" cellpadding="0" cellspacing="0" border="0" width="100%">
														<tr>
															<td align="center">
																<hr>
															</td>
														</tr>
														<tr align="center" valign="middle">
															<td>
																<INPUT type="button" onclick="enviar()" class="sbttn" value="<bean:message key="global.button.aceptar"/>">
															</td>
														</tr>
														<tr>
															<td>
																<div align="right" class="imprimir">
																	<img alt="<bean:message key="global.imprimiralt"/>" src="<%=request.getContextPath()%>/images/print.gif" border="0" height="22"
																		width="20">
																	&nbsp;
																	<a href="javascript: self.print();"><b><bean:message key="global.imprimir" />
																	</b>
																	</a>
																</div>
															</td>
														</tr>
													</table>
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</html:form>
<script>
	disableDinamique(document.forms[0].odou_destratamiento,document.forms[0].odou_odo_cod)
</script>



