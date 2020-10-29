import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Home extends HttpServlet {
private static final long serialVersionUID = 1L;
 
 
 public Home() {
 super();
 
 }
 
 
 
protected void service(HttpServletRequest request, HttpServletResponse 
response) throws ServletException, IOException {
PrintWriter out=response.getWriter();
response.setContentType("text/html");
out.print("<!DOCTYPE html>\r\n"
+ "<html lang=\"en\">\r\n"
+ "\r\n"
+ "<head>\r\n"
+ " <meta charset=\"UTF-8\">\r\n"
+ " <meta name=\"viewport\" content=\"width=device-
width, initial-scale=1.0\">\r\n"
+ " <title>Document</title>\r\n"
+ " <link rel=\"stylesheet\" 
href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css\"\r
\n"
+ " integrity=\"sha384-
TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2\" 
crossorigin=\"anonymous\">\r\n"
+ "\r\n"
+ "</head>\r\n"
+ "\r\n"
+ "<body>\r\n"
+ " <br><br>\r\n"
+ "\r\n"
+ " <div class=\"container\" style=\"text-align: 
center;\">\r\n"
+ " <h5> Create a Blog</h5>\r\n"
+ " </div>\r\n"
+ " <div class=\"container\">\r\n"
+ " <form action=\"preview\" 
method=\"post\">\r\n"
+ " <div class=\"form-group\">\r\n"
+ " <label 
for=\"title\">Title</label>\r\n"
+ " <input type=\"text\" class=\"form-
control\" id=\"title\" name=\"title\" required>\r\n"
+ " </div>\r\n"
+ " <div class=\"form-group\">\r\n"
+ " <label 
for=\"exampleFormControlTextarea1\">Body</label>\r\n"
+ " <textarea class=\"form-control\" 
id=\"exampleFormControlTextarea1\" required rows=\"10\" 
name=\"body\"></textarea>\r\n"
+ " </div>\r\n"
+ " <button type=\"submit\" class=\"btn btn-
primary\">Preview</button>\r\n"
+ " </form>\r\n"
+ " </div>\r\n"
+ " <br>");
Connection con=Save.connect();
Statement smt = null;
ResultSet rs=null;
if(con==null)
out.print("Connection Error");
try {
smt=con.createStatement();
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
try {
rs=smt.executeQuery("SELECT * FROM blogs");
out.print("<div class='container'>");
out.print("<h5>Blogs List</h5>");
out.print("<ul>");
while(rs.next())
{
out.print("<li><a 
href='view?id="+rs.getInt(1)+"'>"+rs.getString(2)+"</a></li>");
}
out.print("</ul>");
out.print("</div>");
} catch (SQLException e) {
out.print(" <div class='container'>\r\n"
+ " Could not fetch Blogs from 
DataBase\r\n"
+ " </div>");
// TODO Auto-generated catch block
// e.printStackTrace();
}
out.print("<script src=\"https://code.jquery.com/jquery-
3.5.1.slim.min.js\"\r\n"
+ " integrity=\"sha384-
DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj\"\r\n"
+ " crossorigin=\"anonymous\"></script>\r\n"
+ " <script 
src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js
\"\r\n"
+ " integrity=\"sha384-
ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx\"\r\n"
+ " crossorigin=\"anonymous\"></script>\r\n"
+ "\r\n"
+ "</body>\r\n"
+ "\r\n"
+ "</html>");
}
}