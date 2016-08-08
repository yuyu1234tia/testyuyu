package com.ibm.devworks.examples.java.lll;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispatchServlet
 */
@WebServlet({  "/home", "/printdisp"})
public class DispatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final WebsiteTitle myapp = new WebsiteTitle();
	private static final String PERSISTENCE_UNIT = "LaurenLandscapesJava";


    /**
     * Default constructor. 
     */
    public DispatchServlet() {
        // TODO Auto-generated constructor stub
    	
   
    }

    public List<Print> getAllPrints() {
    	List<Print> prints = new ArrayList<Print>();
    	try {
    	EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
    	EntityManager em = factory.createEntityManager();
    	em.getTransaction().begin();
    	prints = em.createQuery("SELECT p FROM Print p ORDER BY p.id").getResultList();
    	em.getTransaction().commit();
    	em.close();
    	factory.close();
    	System.out.println("There are " + prints.size() + " prints.");
    	} catch(Exception ex) {
    		System.out.println("problem : " + ex.getMessage());
    	}
    	return prints;	
    }
    
    public Print getPrint(long id) {
    	EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
         	
    	EntityManager em = factory.createEntityManager();   
    
    	Print print = em.find(Print.class, id);
    	em.close();
    	factory.close();
    	System.out.println("Print is " + print.getTitle() + ".");
    	return print;	
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getRequestURI().substring(request.getContextPath().length());
	
		System.out.println(path);
		request.setAttribute("myapp", myapp);
		if (path.equals("/home")) {
			List<Print> prints = getAllPrints();	
			request.setAttribute("prints", prints);
			System.out.println("path is home");
		} else {  
			// for path = printdisp
			System.out.println("id from request is " + request.getParameter("id"));
			Print print = getPrint(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("print", print);
		}
		// TODO Auto-generated method stub
		RequestDispatcher view = request.getRequestDispatcher(path + ".jsp");
        view.forward(request, response); 		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
