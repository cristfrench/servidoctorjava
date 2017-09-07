<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<html>
  <head>
    <title><bean:message key="servidoctor.title" />
    </title>
    <meta http-equiv="pragma" content="no-cache" />
    <meta http-equiv="cache-control" content="no-cache" />
    <meta http-equiv="expires" content="0" />
    <SCRIPT LANGUAGE="JavaScript">
function oP(){
  ww = Math.round((screen.width)-0);
  hh = Math.round((screen.height)-27);
  top.resizeTo(ww,hh);
  top.moveTo(0,0);
}
oP();
</SCRIPT>
  </head>
  <frameset name="fr" cols="200,*" frameborder="NO" border="0" framespacing="0" rows="*">
    <frameset rows="110',*" frameborder="NO" border="0" framespacing="0">
      <frame name="a0" scrolling="NO" noresize
        src="<%=request.getContextPath()%>/template/a0Family.htm" marginwidth="0" marginheight="0"
        frameborder="0" border="0">
      <frame name="a1" noresize src="<%=request.getContextPath()%>/template/menuFamily.jsp"
        frameborder="0" marginwidth="4" marginheight="0" border="0">
    </frameset>
    <frameset rows="50,*" frameborder="NO" border="0" framespacing="0" cols="*">
      <frame name="a2" noresize src="<%=request.getContextPath()%>/template/a2Family.jsp"
        frameborder="0" marginwidth="0" marginheight="0" scrolling="NO" border="0">
      <frame name="a3" src="<%=request.getContextPath()%>/template/mainFamily.jsp" marginwidth="0"
        marginheight="0" frameborder="0" scrolling="YES">
    </frameset>
  </frameset>
  <noframes>
    <body bgcolor="#FFFFFF" text="#000000">
<script type="text/javascript">
// MAIN FUNCTION: new switchcontent("class name", "[optional_element_type_to_scan_for]") REQUIRED
// Call Instance.init() at the very end. REQUIRED

var bobexample=new switchcontent("switchgroup1", "div") //Limit scanning of switch contents to just "div" elements
bobexample.setStatus('<img src="<%=request.getContextPath()%>/images/opencq8.png" /> ', '<img src="<%=request.getContextPath()%>/images/closedy2.png" /> ')
bobexample.setColor('darkred', 'black')
bobexample.setPersist(true)
bobexample.collapsePrevious(true) //Only one content open at any given time
bobexample.init()
</script>


    </body>
  </noframes>
</html>