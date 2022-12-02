package ma.fstt.business;

import java.io.IOException;
import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.fstt.business.EtudiantRemote;
import ma.fstt.persistence.Etudiant;

@WebServlet("")
public class EtudiantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EtudiantServlet() {
	}

	@EJB(mappedName="java:global/GestionEtudiantEJB/ManageEtudiantBean!ma.fstt.business.EtudiantRemote")
    EtudiantRemote ejb ;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Etudiant etudiant = ejb.getEtudiant(1l);
		System.out.println(etudiant.getNom());
		request.setAttribute("nom", etudiant.getNom());
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
