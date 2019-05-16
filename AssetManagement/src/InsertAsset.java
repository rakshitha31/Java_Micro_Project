

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
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class InsertAsset
 */
@WebServlet("/InsertAsset")
public class InsertAsset extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertAsset() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String ac=req.getParameter("ac");
				String pid=req.getParameter("pid");
				String pname=req.getParameter("pname");
				String model=req.getParameter("model");
				String dop=req.getParameter("dop");
				String assetlife=req.getParameter("assetlife");
				float cost=Float.parseFloat(req.getParameter("cost"));
				String supplier=req.getParameter("supplier");
				String salvage=req.getParameter("salvage");
				String warranty=req.getParameter("warranty");
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
					Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/asset_management","root", "");
					Statement stmt=(Statement) con.createStatement();
					stmt.executeUpdate("insert into assets values('"+ac+"','"+pid+"','"+pname+"','"+model+"','"+dop+"','"+assetlife+"',"+cost+",'"+supplier+"','"+salvage+"','"+warranty+"');");
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				resp.setContentType("text/html");
				PrintWriter out=resp.getWriter();
				out.println("<html>"
						+ "<head><title>Inserting into Database</title></head>"
						+ "<body>"
						+ "<h2>Data Inserted Successfully</h2>"
						+ "<a href=\"FixedAsset.html\">Insert More Data</a><br>"
						+ "<a href=\"DisplayAsset\">Display Assets</a><br>"
						+ "</body>"
						+ "</html>");
				out.close();
			}
}

