<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ page language="java" contentType="text/html; utf-8" pageEncoding="utf-8"%>


<logic:iterate id="ciudad" name="CIUDADES" scope="request">
	<option value="<bean:write name="ciudad" property="ciu_cod"/>">
		<bean:write name="ciudad" property="ciu_des" />
	</option>
</logic:iterate>
