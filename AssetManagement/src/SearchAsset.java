

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class SearchAsset
 */
@WebServlet("/SearchAsset")
public class SearchAsset extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAsset() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		Statement stmt = null;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/asset_management","root", "");
			stmt=(Statement) con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String pid=request.getParameter("pid");
		PrintWriter out=response.getWriter();
			try {
				ResultSet rs=stmt.executeQuery("select * from assets where pid='"+pid+"';");
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
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
