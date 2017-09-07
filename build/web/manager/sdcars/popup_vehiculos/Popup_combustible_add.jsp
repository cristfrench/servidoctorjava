
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>


<SCRIPT>

function enviar()
{
      if(document.forms[0].com_fechaini.value==''){
         alert('<bean:message key="5112" />');
         document.forms[0].com_fechaini.focus();
         return false;
      }
      if(document.forms[0].com_lecturaini.value==''){
         alert('<bean:message key="5113" />');
         document.forms[0].com_lecturaini.focus();
         return false;
      }
      if(document.forms[0].com_fechafin.value==''){
         alert('<bean:message key="5114" />');
         document.forms[0].com_fechafin.focus();
         return false;
      }      
      if(document.forms[0].com_lecturafin.value==''){
         alert('<bean:message key="5115" />');
         document.forms[0].com_lecturafin.focus();
         return false;
      }      
      if(document.forms[0].com_cantidadconsumo.value==''){
         alert('<bean:message key="5116" />');
         document.forms[0].com_cantidadconsumo.focus();
         return false;
      }
      if(document.forms[0].com_costocombustible.value==''){
         alert('<bean:message key="5117" />');
         document.forms[0].com_costocombustible.focus();
         return false;
      }

	var cadena=validateDate(document.forms[0].dia.value+'/'+document.forms[0].mes.value+'/'+document.forms[0].ano.value);
	if(cadena!=''){
	   alert(cadena+', para la lectura inicial');
	   return false;
	}
	document.forms[0].com_fechaini.value=document.forms[0].ano.value+'-'+document.forms[0].mes.value+'-'+document.forms[0].dia.value;
	cadena=validateDate(document.forms[0].dia2.value+'/'+document.forms[0].mes2.value+'/'+document.forms[0].ano2.value);
	if(cadena!=''){
	   alert(cadena+', para la lectura inicial');
	   return false;
	}
	document.forms[0].com_fechafin.value=document.forms[0].ano2.value+'-'+document.forms[0].mes2.value+'-'+document.forms[0].dia2.value;
  
         
	document.forms[0].action="<%=request.getContextPath()%>/DatosVehiculo/Popup/transferir_combustible.do"
	document.forms[0].target='a3'
	top.close();
	actualiza_popup_abierto();
	document.forms[0].submit();
}

</SCRIPT>

<html:form target="_self" action="/DatosVehiculo/Popup/add_gastosanuales.do">
	<TABLE border="0" cellpadding="0" cellspacing="0" align="center" width="100%">
		<TBODY>
			<TR>
				<TD>
					<TABLE width="95%" border="0" id="tab2" cellspacing="0" cellpadding="0">
						<TBODY>
							<TR>
								<TD colspan="2" width="286">
									<IMG src="<%=request.getContextPath()%>/images/int_tit_car.gif">
								</TD>
							</TR>
							<TR>
								<TD colspan="2" class="tdtitle" width="100%">
									<HR>
								</TD>
							</TR>
							<TR>
								<TD class="tdOverNameOption" width="286">
									<bean:message key="6188" />
									&nbsp;<%=( String ) request.getAttribute( "num_combustible" )%></TD>
								<TD class="tdOverNameOption">
									<bean:message key="global.button.adicionar" />
									&nbsp;
									<bean:message key="3521" />
								</TD>
							</TR>
							<TR>
								<TD colspan="2" width="286">
									&nbsp;
								</TD>
							</TR>
							<TR>
								<TD class="view_item">
									<bean:message key="5064" />
									&nbsp;&nbsp;
								</TD>
								<td>
									<html:hidden name="combustibleForm" property="com_fechaini" />
									<SCRIPT language="JavaScript">obtenerCamposFecha('dia', 'mes', 'ano', 'com_fechaini');
							    </SCRIPT>
								</td>
							</TR>
							<TR>
								<TD class="view_item">
									<bean:message key="5065" />
									&nbsp;&nbsp;
								</TD>
								<TD>
									<html:text name="combustibleForm" property="com_lecturaini" styleClass="sel" maxlength="6" size="20" onkeyup="isNatural(this);"
										onblur="isNatural(this);" />
								</TD>
							</TR>
							<TR>
								<TD class="view_item">
									<bean:message key="5079" />
									&nbsp;&nbsp;
								</TD>
								<td>
									<html:hidden name="combustibleForm" property="com_fechafin" />
									<SCRIPT language="JavaScript">obtenerCamposFecha('dia2', 'mes2', 'ano2', 'com_fechafin');
							    </SCRIPT>
								</td>
							</TR>
							<TR>
								<TD class="view_item">
									<bean:message key="5080" />
									&nbsp;&nbsp;
								</TD>
								<TD>
									<html:text name="combustibleForm" property="com_lecturafin" styleClass="sel" maxlength="6" size="20" onkeyup="isNatural(this);"
										onblur="isNatural(this);" />
								</TD>
							</TR>
							<TR>
								<TD class="view_item">
									<bean:message key="5067" />
									&nbsp;&nbsp;
								</TD>
								<TD>
									<html:text name="combustibleForm" property="com_cantidadconsumo" styleClass="sel" maxlength="8" size="20" onkeyup="isFloat(this, 8, 2);"
										onblur="isFloat(this, 8, 2);" />
								</TD>
							</TR>
							<TR>
								<TD class="view_item">
									<bean:message key="5068" />
									&nbsp;&nbsp;
								</TD>
								<TD>
									<html:text name="combustibleForm" property="com_costocombustible" styleClass="sel" maxlength="10" size="20" onkeyup="isFloat(this, 10, 2);"
										onblur="isFloat(this, 10, 2);" />
								</TD>
							</TR>
							<TR>
								<TD colspan="2">
									<HR>
								</TD>
							</TR>
							<TR>
								<TD colspan="2" align="center">
									<INPUT type="button" onclick="enviar()" class="sbttn" value="<bean:message key="global.button.aceptar"/>">
								</TD>
							</TR>
						</TBODY>
					</TABLE>
				</TD>
			</TR>
		</TBODY>
	</TABLE>
</html:form>
