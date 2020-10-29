package examplePackage;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
* Servlet implementation class ServletExample
*/
@WebServlet("/ServletExample")
public class insertToDB extends HttpServlet {
private static final long serialVersionUID = 1L;
/**
* @see HttpServlet#HttpServlet()
*/
public insertToDB() {
super();

 TODO Auto-generated constructor stub
}
/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException {
try {
PrintWriter writer = response.getWriter();
String rollnum= request.getParameter("id");
String name= request.getParameter("name");
String dept= request.getParameter("dept");
mydb db=new mydb();
Connection con = db.getCon();
Statement stmt = con.createStatement();
stmt.executeUpdate("insert into users(roll_num,name,dept_name)
values('"+rollnum+"','"+name+"','"+dept+"')");
response.sendRedirect("details.html");
} catch (Exception e) {
// TODO: handle exception
e.printStackTrace();
}
}
/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException {
// TODO Auto-generated method stub
doGet(request, response);
}
}
mydb.java
package examplePackage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class mydb {
Connection con;
public Connection getCon() {
try {
Class.forName("com.mysql.cj.jdbc.Driver");
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","");
} catch (ClassNotFoundException e) {
// TODO Auto-generated catch block
e.printStackTrace(); } catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
return con;
}
}
