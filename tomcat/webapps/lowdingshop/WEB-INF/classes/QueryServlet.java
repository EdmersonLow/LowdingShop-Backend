import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.json.*;

@WebServlet("/query")
public class QueryServlet extends HttpServlet {

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
         String sqlStr = "select * from products ";
         ResultSet rset = stmt.executeQuery(sqlStr);

         JSONArray jsonArr = new JSONArray();
         while(rset.next()) {
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("_id", rset.getString("_id"));
            jsonObj.put("title", rset.getString("title"));
            jsonObj.put("isNew", rset.getInt("isNew"));
            jsonObj.put("oldPrice", rset.getInt("oldPrice"));
            jsonObj.put("price", rset.getDouble("price"));
            jsonObj.put("description", rset.getString("description"));
            jsonObj.put("category", rset.getString("category"));
            jsonObj.put("image", rset.getString("image"));
            jsonObj.put("rating", rset.getDouble("rating"));
            jsonObj.put("qty", rset.getInt("qty"));
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
