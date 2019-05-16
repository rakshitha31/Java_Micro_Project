

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class DisplayAsset
 */
@WebServlet("/DisplayAsset")
public class DisplayAsset extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAsset() {
        super();
        // TODO Auto-generated constructor stub
    }

	
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

			
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/asset_management","root", "");
			Statement stmt=(Statement) conn.createStatement();
	
			
			ResultSet rs=(ResultSet) stmt.executeQuery("select * from assets;");
			
			out.println("<html><head><title>Assets</title></head><body><h1>Databases</h1>");
			out.println("<table border=1px><tr><th>Asset Code</th><th>Product ID</th><th>Product Name</th><th>Model</th><th>Date of Purchase</th><th>Asset Life</th><th>Cost</th><th>Supplier</th><th>Product Salvage</th><th>Warranty</th></tr>");
			while(rs.next()) {
				out.println("<tr>"
						+ "<td>"+rs.getString(1)+"</td>"
						+ "<td>"+rs.getString(2)+"</td>"
						+ "<td>"+rs.getString(3)+"</td>"
						+ "<td>"+rs.getString(4)+"</td>"
						+ "<td>"+rs.getString(5)+"</td>"
						+ "<td>"+rs.getString(6)+"</td>"
						+ "<td>"+rs.getFloat(7)+"</td>"
						+ "<td>"+rs.getString(8)+"</td>"
						+ "<td>"+rs.getInt(9)+"</td>"
						+ "<td>"+rs.getString(10)+"</td>"
							
						+ "</tr>");
			}
			out.println("<a href=FixedAsset.html>Go Back</a><br>");
			out.println("<a href=DeleteAsset.html>Delete an Asset</a><br><br>");
			out.println("</table></body></html>");
			out.close();
		}
		catch (ClassNotFoundException e) {
			// TODO: handle exception
		}
		catch (SQLException e) {
			// TODO: handle exception
		}
				
	}
   
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   doGet(req,resp);
   }
   
   }

