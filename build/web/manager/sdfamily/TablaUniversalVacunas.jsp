<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<table border="0" width="100%">
<tr>
	<td>
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
			<tr>
				<TD width="44">&nbsp;				</TD>
			</tr>
			<tr>
			  <TD colspan="30" class="view_item">
					<bean:message key="7243" />
				    <div align="justify"></div></TD>
			</tr>
			<tr>
				<TD class="tdNameOption" align="center">
					<bean:message key="558" />
				</TD>
				<TD colspan="30" class="tdNameOption" align="center">
					<bean:message key="554" />
				</TD>
			</tr>
			<tr>
				<td></td>
				<%
				int z = 0;
				%>
				<%
						while (z < 24) {
						z++;
						if (z % 2 == 0) {
				%>
				<td width="17" class="tdtitle" style="background: #ffffff" align="center">
					<%=z%>				</td>
				<%
				} else {
				%>
				<td width="17" class="tdtitle" style="background: #F1F5FA" align="center">
					<%=z%>				</td>
				<%
					}
					}
				%>
			</tr>
			<logic:iterate indexId="ind" id="usuariovacunas" name="VACUNAS" type="com.servidoctor.parametros.model.Vacunas">
				<%
				z = 1;
				%>
				<tr>
					<td class="view_item" nowrap="nowrap">
						<bean:write name="usuariovacunas" property="vac_des" scope="page" />
					</td>
					<logic:equal value="1" name="usuariovacunas" property="vac_edad_mes1">
						<td>
							<html:img page="/img/checkbox_checked.jpg"/>
						</td>
					</logic:equal>
					<logic:equal value="0" name="usuariovacunas" property="vac_edad_mes1">
						<td>
							<html:img page="/img/checkbox_unchecked.jpg"/>
						</td>
					</logic:equal>
					<%
					z++;
					%>
					<logic:equal value="1" name="usuariovacunas" property="vac_edad_mes2">
						<td width="11">
							<html:img page="/img/checkbox_checked.jpg"/>
					  </td>
					</logic:equal>
					<logic:equal value="0" name="usuariovacunas" property="vac_edad_mes2">
						<td width="11">
							<html:img page="/img/checkbox_unchecked.jpg"/>
					  </td>
					</logic:equal>
					<%
					z++;
					%>
					<logic:equal value="1" name="usuariovacunas" property="vac_edad_mes3">
						<td width="11">
							<html:img page="/img/checkbox_checked.jpg"/>
					  </td>
					</logic:equal>
					<logic:equal value="0" name="usuariovacunas" property="vac_edad_mes3">
						<td width="11">
							<html:img page="/img/checkbox_unchecked.jpg"/>
					  </td>
					</logic:equal>
					<%
					z++;
					%>
					<logic:equal value="1" name="usuariovacunas" property="vac_edad_mes4">
						<td width="11">
							<html:img page="/img/checkbox_checked.jpg"/>
					  </td>
					</logic:equal>
					<logic:equal value="0" name="usuariovacunas" property="vac_edad_mes4">
						<td width="11">
							<html:img page="/img/checkbox_unchecked.jpg"/>
					  </td>
					</logic:equal>
					<%
					z++;
					%>
					<logic:equal value="1" name="usuariovacunas" property="vac_edad_mes5">
						<td width="11">
							<html:img page="/img/checkbox_checked.jpg"/>
					  </td>
					</logic:equal>
					<logic:equal value="0" name="usuariovacunas" property="vac_edad_mes5">
						<td width="11">
							<html:img page="/img/checkbox_unchecked.jpg"/>
					  </td>
					</logic:equal>
					<%
					z++;
					%>
					<logic:equal value="1" name="usuariovacunas" property="vac_edad_mes6">
						<td width="11">
							<html:img page="/img/checkbox_checked.jpg"/>
					  </td>
					</logic:equal>
					<logic:equal value="0" name="usuariovacunas" property="vac_edad_mes6">
						<td width="11">
							<html:img page="/img/checkbox_unchecked.jpg"/>
					  </td>
					</logic:equal>
					<%
					z++;
					%>
					<logic:equal value="1" name="usuariovacunas" property="vac_edad_mes7">
						<td width="11">
							<html:img page="/img/checkbox_checked.jpg"/>
					  </td>
					</logic:equal>
					<logic:equal value="0" name="usuariovacunas" property="vac_edad_mes7">
						<td width="11">
							<html:img page="/img/checkbox_unchecked.jpg"/>
					  </td>
					</logic:equal>
					<%
					z++;
					%>
					<logic:equal value="1" name="usuariovacunas" property="vac_edad_mes8">
						<td width="11">
							<html:img page="/img/checkbox_checked.jpg"/>
					  </td>
					</logic:equal>
					<logic:equal value="0" name="usuariovacunas" property="vac_edad_mes8">
						<td width="11">
							<html:img page="/img/checkbox_unchecked.jpg"/>
					  </td>
					</logic:equal>
					<%
					z++;
					%>
					<logic:equal value="1" name="usuariovacunas" property="vac_edad_mes9">
						<td width="11">
							<html:img page="/img/checkbox_checked.jpg"/>
					  </td>
					</logic:equal>
					<logic:equal value="0" name="usuariovacunas" property="vac_edad_mes9">
						<td width="11">
							<html:img page="/img/checkbox_unchecked.jpg"/>
					  </td>
					</logic:equal>
					<%
					z++;
					%>
					<logic:equal value="1" name="usuariovacunas" property="vac_edad_mes10">
						<td width="11">
							<html:img page="/img/checkbox_checked.jpg"/>
					  </td>
					</logic:equal>
					<logic:equal value="0" name="usuariovacunas" property="vac_edad_mes10">
						<td width="11">
							<html:img page="/img/checkbox_unchecked.jpg"/>
					  </td>
					</logic:equal>
					<%
					z++;
					%>
					<logic:equal value="1" name="usuariovacunas" property="vac_edad_mes11">
						<td width="11">
							<html:img page="/img/checkbox_checked.jpg"/>
					  </td>
					</logic:equal>
					<logic:equal value="0" name="usuariovacunas" property="vac_edad_mes11">
						<td width="11">
							<html:img page="/img/checkbox_unchecked.jpg"/>
					  </td>
					</logic:equal>
					<%
					z++;
					%>
					<logic:equal value="1" name="usuariovacunas" property="vac_edad_mes12">
						<td width="11">
							<html:img page="/img/checkbox_checked.jpg"/>
					  </td>
					</logic:equal>
					<logic:equal value="0" name="usuariovacunas" property="vac_edad_mes12">
						<td width="11">
							<html:img page="/img/checkbox_unchecked.jpg"/>
					  </td>
					</logic:equal>
					<%
					z++;
					%>
					<logic:equal value="1" name="usuariovacunas" property="vac_edad_mes13">
						<td width="11">
							<html:img page="/img/checkbox_checked.jpg"/>
					  </td>
					</logic:equal>
					<logic:equal value="0" name="usuariovacunas" property="vac_edad_mes13">
						<td width="11">
							<html:img page="/img/checkbox_unchecked.jpg"/>
					  </td>
					</logic:equal>
					<%
					z++;
					%>
					<logic:equal value="1" name="usuariovacunas" property="vac_edad_mes14">
						<td width="11">
							<html:img page="/img/checkbox_checked.jpg"/>
					  </td>
					</logic:equal>
					<logic:equal value="0" name="usuariovacunas" property="vac_edad_mes14">
						<td width="11">
							<html:img page="/img/checkbox_unchecked.jpg"/>
					  </td>
					</logic:equal>
					<%
					z++;
					%>
					<logic:equal value="1" name="usuariovacunas" property="vac_edad_mes15">
						<td width="21">
							<html:img page="/img/checkbox_checked.jpg"/>
					  </td>
					</logic:equal>
					<logic:equal value="0" name="usuariovacunas" property="vac_edad_mes15">
						<td width="1">
							<html:img page="/img/checkbox_unchecked.jpg"/>
					  </td>
					</logic:equal>
					<%
					z++;
					%>
					<logic:equal value="1" name="usuariovacunas" property="vac_edad_mes16">
					  <td width="11">
							<html:img page="/img/checkbox_checked.jpg"/>
					        <div align="justify"></div></td>
					</logic:equal>
					<logic:equal value="0" name="usuariovacunas" property="vac_edad_mes16">
						<td width="11">
							<html:img page="/img/checkbox_unchecked.jpg"/>
					  </td>
					</logic:equal>
					<%
					z++;
					%>
					<logic:equal value="1" name="usuariovacunas" property="vac_edad_mes17">
						<td width="11">
							<html:img page="/img/checkbox_checked.jpg"/>
					  </td>
					</logic:equal>
					<logic:equal value="0" name="usuariovacunas" property="vac_edad_mes17">
						<td width="11">
							<html:img page="/img/checkbox_unchecked.jpg"/>
					  </td>
					</logic:equal>
					<%
					z++;
					%>
					<logic:equal value="1" name="usuariovacunas" property="vac_edad_mes18">
						<td width="11">
							<html:img page="/img/checkbox_checked.jpg"/>
					  </td>
					</logic:equal>
					<logic:equal value="0" name="usuariovacunas" property="vac_edad_mes18">
						<td width="11">
							<html:img page="/img/checkbox_unchecked.jpg"/>
					  </td>
					</logic:equal>
					<%
					z++;
					%>
					<logic:equal value="1" name="usuariovacunas" property="vac_edad_mes19">
						<td width="11">
							<html:img page="/img/checkbox_checked.jpg"/>
					  </td>
					</logic:equal>
					<logic:equal value="0" name="usuariovacunas" property="vac_edad_mes19">
						<td width="11">
							<html:img page="/img/checkbox_unchecked.jpg"/>
					  </td>
					</logic:equal>
					<%
					z++;
					%>
					<logic:equal value="1" name="usuariovacunas" property="vac_edad_mes20">
						<td width="11">
							<html:img page="/img/checkbox_checked.jpg"/>
					  </td>
					</logic:equal>
					<logic:equal value="0" name="usuariovacunas" property="vac_edad_mes20">
						<td width="11">
							<html:img page="/img/checkbox_unchecked.jpg"/>
					  </td>
					</logic:equal>
					<%
					z++;
					%>
					<logic:equal value="1" name="usuariovacunas" property="vac_edad_mes21">
						<td width="11">
							<html:img page="/img/checkbox_checked.jpg"/>
					  </td>
					</logic:equal>
					<logic:equal value="0" name="usuariovacunas" property="vac_edad_mes21">
						<td width="11">
							<html:img page="/img/checkbox_unchecked.jpg"/>
					  </td>
					</logic:equal>
					<%
					z++;
					%>
					<logic:equal value="1" name="usuariovacunas" property="vac_edad_mes22">
						<td width="11">
							<html:img page="/img/checkbox_checked.jpg"/>
					  </td>
					</logic:equal>
					<logic:equal value="0" name="usuariovacunas" property="vac_edad_mes22">
						<td width="11">
							<html:img page="/img/checkbox_unchecked.jpg"/>
					  </td>
					</logic:equal>
					<%
					z++;
					%>
					<logic:equal value="1" name="usuariovacunas" property="vac_edad_mes23">
						<td width="11">
							<html:img page="/img/checkbox_checked.jpg"/>
					  </td>
					</logic:equal>
					<logic:equal value="0" name="usuariovacunas" property="vac_edad_mes23">
						<td width="11">
							<html:img page="/img/checkbox_unchecked.jpg"/>
					  </td>
					</logic:equal>
					<%
					z++;
					%>
					<logic:equal value="1" name="usuariovacunas" property="vac_edad_mes24">
						<td width="11">
							<html:img page="/img/checkbox_checked.jpg"/>
					  </td>
					</logic:equal>
					<logic:equal value="0" name="usuariovacunas" property="vac_edad_mes24">
						<td width="22">
							<html:img page="/img/checkbox_unchecked.jpg"/>
					  </td>
					</logic:equal>
				</tr>
			</logic:iterate>
			<tr>
				<TD colspan="10"></TD>
			</tr>
		</table>
	</td>
</tr>
<tr>
	<td>&nbsp;
		
	</td>
</tr>
<tr>
	<td>
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
			<tr>
				<TD class="tdNameOption" align="center">
					<bean:message key="558" />
				</TD>
				<TD colspan="24" class="tdNameOption" align="center">
					<bean:message key="555" />
				</TD>
			</tr>
			<tr>
				<td></td>
				<%
					z = 2;
					while (z < 18) {
						z++;
						if (z % 2 == 0) {
				%>
				<td width="10" class="tdtitle" style="background: #ffffff" align="center">
					<%=z%>
				</td>
				<%
				} else {
				%>
				<td width="10" class="tdtitle" style="background: #F1F5FA" align="center">
					<%=z%>
				</td>
				<%
					}
					}
					z = 1;
				%>
				<td width="10" class="tdtitle" style="background: #F1F5FA" align="center">
					20
				</td>
				<td width="10" class="tdtitle" style="background: #ffffff" align="center">
					30
				</td>
				<td width="10" class="tdtitle" style="background: #F1F5FA" align="center">
					40
				</td>
				<td width="10" class="tdtitle" style="background: #ffffff" align="center">
					50
				</td>
				<td width="10" class="tdtitle" style="background: #F1F5FA" align="center">
					60
				</td>
				<td width="10" class="tdtitle" style="background: #ffffff" align="center">
					70
				</td>
				<td width="10" class="tdtitle" style="background: #F1F5FA" align="center">
					80
				</td>
				<td width="10" class="tdtitle" style="background: #ffffff" align="center">
					90
				</td>
			</tr>
			<logic:iterate indexId="ind" id="usuariovacunas" name="VACUNAS" type="com.servidoctor.parametros.model.Vacunas">
				<tr>
					<td class="view_item" nowrap="nowrap">
						<bean:write name="usuariovacunas" property="vac_des" scope="page" />
					</td>
					<%
					z = 3;
					%>
					<logic:equal value="1" name="usuariovacunas" property="vac_edad_anno3">
						<td>
							<html:img page="/img/checkbox_checked.jpg"/>
						</td>
					</logic:equal>
					<logic:equal value="0" name="usuariovacunas" property="vac_edad_anno3">
						<td>
							<html:img page="/img/checkbox_unchecked.jpg"/>
						</td>
					</logic:equal>
					<%
					z++;
					%>
					<logic:equal value="1" name="usuariovacunas" property="vac_edad_anno4">
						<td>
							<html:img page="/img/checkbox_checked.jpg"/>
						</td>
					</logic:equal>
					<logic:equal value="0" name="usuariovacunas" property="vac_edad_anno4">
						<td>
							<html:img page="/img/checkbox_unchecked.jpg"/>
						</td>
					</logic:equal>
					<%
					z++;
					%>
					<logic:equal value="1" name="usuariovacunas" property="vac_edad_anno5">
						<td>
							<html:img page="/img/checkbox_checked.jpg"/>
						</td>
					</logic:equal>
					<logic:equal value="0" name="usuariovacunas" property="vac_edad_anno5">
						<td>
							<html:img page="/img/checkbox_unchecked.jpg"/>
						</td>
					</logic:equal>
					<%
					z++;
					%>
					<logic:equal value="1" name="usuariovacunas" property="vac_edad_anno6">
						<td>
							<html:img page="/img/checkbox_checked.jpg"/>
						</td>
					</logic:equal>
					<logic:equal value="0" name="usuariovacunas" property="vac_edad_anno6">
						<td>
							<html:img page="/img/checkbox_unchecked.jpg"/>
						</td>
					</logic:equal>
					<%
					z++;
					%>
					<logic:equal value="1" name="usuariovacunas" property="vac_edad_anno7">
						<td>
							<html:img page="/img/checkbox_checked.jpg"/>
						</td>
					</logic:equal>
					<logic:equal value="0" name="usuariovacunas" property="vac_edad_anno7">
						<td>
							<html:img page="/img/checkbox_unchecked.jpg"/>
						</td>
					</logic:equal>
					<%
					z++;
					%>
					<logic:equal value="1" name="usuariovacunas" property="vac_edad_anno8">
						<td>
							<html:img page="/img/checkbox_checked.jpg"/>
						</td>
					</logic:equal>
					<logic:equal value="0" name="usuariovacunas" property="vac_edad_anno8">
						<td>
							<html:img page="/img/checkbox_unchecked.jpg"/>
						</td>
					</logic:equal>
					<%
					z++;
					%>
					<logic:equal value="1" name="usuariovacunas" property="vac_edad_anno9">
						<td>
							<html:img page="/img/checkbox_checked.jpg"/>
						</td>
					</logic:equal>
					<logic:equal value="0" name="usuariovacunas" property="vac_edad_anno9">
						<td>
							<html:img page="/img/checkbox_unchecked.jpg"/>
						</td>
					</logic:equal>
					<%
					z++;
					%>
					<logic:equal value="1" name="usuariovacunas" property="vac_edad_anno10">
						<td>
							<html:img page="/img/checkbox_checked.jpg"/>
						</td>
					</logic:equal>
					<logic:equal value="0" name="usuariovacunas" property="vac_edad_anno10">
						<td>
							<html:img page="/img/checkbox_unchecked.jpg"/>
						</td>
					</logic:equal>
					<%
					z++;
					%>
					<logic:equal value="1" name="usuariovacunas" property="vac_edad_anno11">
						<td>
							<html:img page="/img/checkbox_checked.jpg"/>
						</td>
					</logic:equal>
					<logic:equal value="0" name="usuariovacunas" property="vac_edad_anno11">
						<td>
							<html:img page="/img/checkbox_unchecked.jpg"/>
						</td>
					</logic:equal>
					<%
					z++;
					%>
					<logic:equal value="1" name="usuariovacunas" property="vac_edad_anno12">
						<td>
							<html:img page="/img/checkbox_checked.jpg"/>
						</td>
					</logic:equal>
					<logic:equal value="0" name="usuariovacunas" property="vac_edad_anno12">
						<td>
							<html:img page="/img/checkbox_unchecked.jpg"/>
						</td>
					</logic:equal>
					<%
					z++;
					%>
					<logic:equal value="1" name="usuariovacunas" property="vac_edad_anno13">
						<td>
							<html:img page="/img/checkbox_checked.jpg"/>
						</td>
					</logic:equal>
					<logic:equal value="0" name="usuariovacunas" property="vac_edad_anno13">
						<td>
							<html:img page="/img/checkbox_unchecked.jpg"/>
						</td>
					</logic:equal>
					<%
					z++;
					%>
					<logic:equal value="1" name="usuariovacunas" property="vac_edad_anno14">
						<td>
							<html:img page="/img/checkbox_checked.jpg"/>
						</td>
					</logic:equal>
					<logic:equal value="0" name="usuariovacunas" property="vac_edad_anno14">
						<td>
							<html:img page="/img/checkbox_unchecked.jpg"/>
						</td>
					</logic:equal>
					<%
					z++;
					%>
					<logic:equal value="1" name="usuariovacunas" property="vac_edad_anno15">
						<td>
							<html:img page="/img/checkbox_checked.jpg"/>
						</td>
					</logic:equal>
					<logic:equal value="0" name="usuariovacunas" property="vac_edad_anno15">
						<td>
							<html:img page="/img/checkbox_unchecked.jpg"/>
						</td>
					</logic:equal>
					<%
					z++;
					%>
					<logic:equal value="1" name="usuariovacunas" property="vac_edad_anno16">
						<td>
							<html:img page="/img/checkbox_checked.jpg"/>
						</td>
					</logic:equal>
					<logic:equal value="0" name="usuariovacunas" property="vac_edad_anno16">
						<td>
							<html:img page="/img/checkbox_unchecked.jpg"/>
						</td>
					</logic:equal>
					<%
					z++;
					%>
					<logic:equal value="1" name="usuariovacunas" property="vac_edad_anno17">
						<td>
							<html:img page="/img/checkbox_checked.jpg"/>
						</td>
					</logic:equal>
					<logic:equal value="0" name="usuariovacunas" property="vac_edad_anno17">
						<td>
							<html:img page="/img/checkbox_unchecked.jpg"/>
						</td>
					</logic:equal>
					<%
					z++;
					%>
					<logic:equal value="1" name="usuariovacunas" property="vac_edad_anno18">
						<td>
							<html:img page="/img/checkbox_checked.jpg"/>
						</td>
					</logic:equal>
					<logic:equal value="0" name="usuariovacunas" property="vac_edad_anno18">
						<td>
							<html:img page="/img/checkbox_unchecked.jpg"/>
						</td>
					</logic:equal>
					<%
					z = z + 2;
					%>
					<logic:equal value="1" name="usuariovacunas" property="vac_edad_anno20">
						<td>
							<html:img page="/img/checkbox_checked.jpg"/>
						</td>
					</logic:equal>
					<logic:equal value="0" name="usuariovacunas" property="vac_edad_anno20">
						<td>
							<html:img page="/img/checkbox_unchecked.jpg"/>
						</td>
					</logic:equal>
					<%
					z = z + 10;
					%>
					<logic:equal value="1" name="usuariovacunas" property="vac_edad_anno30">
						<td>
							<html:img page="/img/checkbox_checked.jpg"/>
						</td>
					</logic:equal>
					<logic:equal value="0" name="usuariovacunas" property="vac_edad_anno30">
						<td>
							<html:img page="/img/checkbox_unchecked.jpg"/>
						</td>
					</logic:equal>
					<%
					z = z + 10;
					%>
					<logic:equal value="1" name="usuariovacunas" property="vac_edad_anno40">
						<td>
							<html:img page="/img/checkbox_checked.jpg"/>
						</td>
					</logic:equal>
					<logic:equal value="0" name="usuariovacunas" property="vac_edad_anno40">
						<td>
							<html:img page="/img/checkbox_unchecked.jpg"/>
						</td>
					</logic:equal>
					<%
					z = z + 10;
					%>
					<logic:equal value="1" name="usuariovacunas" property="vac_edad_anno50">
						<td>
							<html:img page="/img/checkbox_checked.jpg"/>
						</td>
					</logic:equal>
					<logic:equal value="0" name="usuariovacunas" property="vac_edad_anno50">
						<td>
							<html:img page="/img/checkbox_unchecked.jpg"/>
						</td>
					</logic:equal>
					<%
					z = z + 10;
					%>
					<logic:equal value="1" name="usuariovacunas" property="vac_edad_anno60">
						<td>
							<html:img page="/img/checkbox_checked.jpg"/>
						</td>
					</logic:equal>
					<logic:equal value="0" name="usuariovacunas" property="vac_edad_anno60">
						<td>
							<html:img page="/img/checkbox_unchecked.jpg"/>
						</td>
					</logic:equal>
					<%
					z = z + 10;
					%>
					<logic:equal value="1" name="usuariovacunas" property="vac_edad_anno70">
						<td>
							<html:img page="/img/checkbox_checked.jpg"/>
						</td>
					</logic:equal>
					<logic:equal value="0" name="usuariovacunas" property="vac_edad_anno70">
						<td>
							<html:img page="/img/checkbox_unchecked.jpg"/>
						</td>
					</logic:equal>
					<%
					z = z + 10;
					%>
					<logic:equal value="1" name="usuariovacunas" property="vac_edad_anno80">
						<td>
							<html:img page="/img/checkbox_checked.jpg"/>
						</td>
					</logic:equal>
					<logic:equal value="0" name="usuariovacunas" property="vac_edad_anno80">
						<td>
							<html:img page="/img/checkbox_unchecked.jpg"/>
						</td>
					</logic:equal>
					<%
					z = z + 10;
					%>
					<logic:equal value="1" name="usuariovacunas" property="vac_edad_anno90">
						<td>
							<html:img page="/img/checkbox_checked.jpg"/>
						</td>
					</logic:equal>
					<logic:equal value="0" name="usuariovacunas" property="vac_edad_anno90">
						<td>
							<html:img page="/img/checkbox_unchecked.jpg"/>
						</td>
					</logic:equal>
					<%
					z = 1;
					%>
				</tr>
			</logic:iterate>
		</table>
	</td>
</tr>
</table>
