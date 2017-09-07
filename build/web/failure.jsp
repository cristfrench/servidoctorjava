<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ page import="com.servidoctor.seguridad.model.UsuarioFamily"%>

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
                      <td>
                        <img src="<%=request.getContextPath()%>/images/int_tit_family.gif">
                        <hr>
                      </td>
                    </tr>
                    <tr>
                      <td class="tdNameOption">
                        <bean:message key="errors.sorry" />
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
 