import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.json.*;

@WebServlet("/createuser")
public class createUser extends HttpServlet {

   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response)
               throws ServletException, IOException {
      // Set the MIME type for the response message
      response.setContentType("application/json");
      // Get a output writer to write the response message into the network socket
      PrintWriter out = response.getWriter();
      response.setHeader("Access-Control-Allow-Origin", "*");


      try (
         Connection conn = DriverManager.getConnection(
               "jdbc:mysql://localhost:3306/lowdingshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
               "myuser", "xxxx");
         Statement stmt = conn.createStatement();
      ) {
         String sqlStr2 = "insert into users (fullname, email, user_address, user_password) values ('"+ request.getParameter("fullname") +"', '"+ request.getParameter("email") +"', '"+ request.getParameter("user_address") +"', '"+  request.getParameter("user_password") + "');"; 
         int rset2 = stmt.executeUpdate(sqlStr2);
         String sqlStr = "select * from users ";
         ResultSet rset = stmt.executeQuery(sqlStr);

         JSONArray jsonArr = new JSONArray();
         while(rset.next()) {
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("id", rset.getInt("id"));
            jsonObj.put("fullname", rset.getString("fullname"));
            jsonObj.put("email", rset.getString("email"));
            jsonObj.put("user_address", rset.getString("user_address"));
            jsonObj.put("user_password", rset.getString("user_password"));
            jsonArr.put(jsonObj);
         }
         out.print(jsonArr);
      } catch(Exception ex) {
         out.println("<p>Error: " + ex.getMessage() + "</p>");
         out.println("<p>Check Tomcat console for details.</p>");
         ex.printStackTrace();
      }
      
      out.close();
   }
}