<%@ page contentType="text/html; charset=iso-8859-1" language="java" %>
<%@ page import="com.servidoctor.util.AES"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.*"%>
import java.text.*;
<%
Connection canal = null;
Connection canal2 = null;
ResultSet tabla= null;
ResultSet rs = null;
Statement instruccion=null;
Statement statement=null;
String strcon = "jdbc:mysql://localhost:3306/sdoctor?user=root&password=root";
String strcon2 = "jdbc:mysql://localhost:3306/vega_sdoctor?user=root&password=root";
try {
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	canal=DriverManager.getConnection(strcon);
	canal2=DriverManager.getConnection(strcon2);
	instruccion = canal2.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	statement = canal.createStatement();
} catch(java.lang.ClassNotFoundException e){
} catch(SQLException e) {
};

//connection = DriverManager.getConnection(connectionURL, "", "");
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
String str1 = request.getParameter("arreglo");  
String[] tokens = str1.split(",");
String pdato=new AES().encrypt("lamisma");
 %>
<% 
String servicio[]=new String[tokens.length];
String login[]=new String[tokens.length];
String password[]= new String[tokens.length];
int n=0;
for (int i=0;i<tokens.length-1;i=i+3){
	servicio[n]=tokens[i];
	n++;
}
n=0;
for (int j=1;j<tokens.length-1;j=j+3){
	login[n]=tokens[j];
	n++;
}
n=0;
for (int k=2;k<=tokens.length-1;k=k+3){
	password[n]=tokens[k];
	n++;
}

//Consulta general y cambios en la BD
String q="";
String sql="";
String serv,logi,pass;
int max=(servicio.length)/3;
for (int r=0;r<max;r++){
	serv = servicio[r]!=null?servicio[r]:"";
	if (serv==""){
	
	}else{
		Integer ser=new Integer(serv);
		switch(ser.intValue()){
			case 1: 
				q="SELECT usuf_licencia as numero FROM usuariofamily WHERE usuf_usuario= '";
				logi=login[r]!=null?login[r]:"";
				q=q+logi+"'";
				q=q+" and usuf_clave='";
				pass=password[r]!=null?new AES().encrypt(password[r]):"";			
				q=q+pass+"'";
				try {
					// agregando renglon (insert)
					//int n=instruccion.executeUpdate(q);
					rs = statement.executeQuery(q);
					int rows = 0;
					while (rs.next())	rows++;
					rs.first();
					
					if (rows>0){
							sql="UPDATE compras_licencias SET compras_licencias_dattl='";
							Date hoy= new Date();
							String fecha=sdf.format(hoy);
							sql=sql+fecha+"' WHERE compras_licencias_codact='"+rs.getString("numero")+"'";
							try{
								int h=instruccion.executeUpdate(sql);
							}catch(SQLException s){
								System.out.println(s);
							}
							
					}

					//avisando que se hizo la instruccion
					//out.println("REGISTRO INSERTADO");
				} catch(SQLException e) {
					System.out.println(e);
				};
			break;
			case 2:
				q="SELECT usuc_licencia as numero FROM usuariocar WHERE usuc_usuario= '";
				logi=login[r]!=null?login[r]:"";
				q=q+logi+"'";
				q=q+" and usuc_clave='";
				pass=password[r]!=null?new AES().encrypt(password[r]):"";			
				q=q+pass+"'";
				try {
					// agregando renglon (insert)
					//int n=instruccion.executeUpdate(q);
					rs = statement.executeQuery(q);
					int rows = 0;
					while (rs.next())	rows++;
					rs.first();
					if (rows>0){
							sql="UPDATE compras_licencias SET compras_licencias_dattl='";
							Date hoy= new Date();
							String fecha=sdf.format(hoy);
							sql=sql+fecha+"' WHERE compras_licencias_codact='"+rs.getString("numero")+"'";
							try{
								int h=instruccion.executeUpdate(sql);
							}catch(SQLException s){
								System.out.println(s);
							}
							
					}
					
					//avisando que se hizo la instruccion
					//out.println("REGISTRO INSERTADO");
				} catch(SQLException e) {
					System.out.println(e);
				};
			break;
			case 3:				
				q="SELECT usup_licencia as numero FROM usuariopets WHERE usup_usuario= '";
				logi=login[r]!=null?login[r]:"";
				q=q+logi+"'";
				q=q+" and usup_clave='";
				pass=password[r]!=null?new AES().encrypt(password[r]):"";			
				q=q+pass+"'";
				try {
					// agregando renglon (insert)
					//int n=instruccion.executeUpdate(q);
					rs = statement.executeQuery(q);
					int rows = 0;
					while (rs.next())	rows++;
					rs.first();
					if (rows>0){
							sql="UPDATE compras_licencias SET compras_licencias_dattl='";
							Date hoy= new Date();
							String fecha=sdf.format(hoy);
							sql=sql+fecha+"' WHERE compras_licencias_codact='"+rs.getString("numero")+"'";
							try{
								int h=instruccion.executeUpdate(sql);
							}catch(SQLException s){
								System.out.println(s);
							}
							
					}
				
					//avisando que se hizo la instruccion
					//out.println("REGISTRO INSERTADO");
				} catch(SQLException e) {
					System.out.println(e);
				};
				break;
		}
	}
	

	
}



System.out.print("You'd figured it out!! ");










try{
	// tabla.close();
	instruccion.close();
	canal.close();
	canal2.close();
	rs.close();
} catch(SQLException e) {
	out.println(e);
};





%>