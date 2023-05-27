package Controleur;

import DAO.Connexion;
import Metier.Biblio;
import Metier.Livres;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "ControllerLiver", urlPatterns = {"/Livre"}, initParams = {
    @WebInitParam(name = "driver", value = "com.mysql.jdbc.Driver")
    , @WebInitParam(name = "url", value = "jdbc:mysql://localhost:3306/biblio")
    , @WebInitParam(name = "user", value = "root")
    , @WebInitParam(name = "password", value = "")})
public class ControllerLiver extends HttpServlet {

     Biblio ges ;
    String action=null;
    int reference;
    Livres livObject;
    ArrayList<Livres> Liv;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        action=req.getParameter("action");
        Liv = ges.Select("livre");
        if(req.getMethod().equals("GET")){
            doGet(req,resp);
        }else{
        switch(action){
            case "insert": doPost(req,resp);break;
            case "update": doPut(req,resp);break;
        }
        }
     }

     @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int ref = Integer.parseInt(req.getParameter("id"));
        ges.delete(new Livres(ref));
        resp.sendRedirect("/gestion_Servlet_bi/Livre");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        ges.update(new Livres(Integer.parseInt(req.getParameter("reference")),req.getParameter("titre"),req.getParameter("autheur"),Integer.parseInt(req.getParameter("pages"))));
        resp.sendRedirect("/gestion_Servlet_bi/Livre");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        ges.insert(new Livres(Integer.parseInt(req.getParameter("reference")),req.getParameter("titre"),req.getParameter("autheur"),Integer.parseInt(req.getParameter("pages"))));
       resp.sendRedirect("/gestion_Servlet_bi/Livre");
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      if(action==null){
          req.getRequestDispatcher("/Livres/LivresAffichage.jsp").forward(req, resp);
      }else{
           
         switch (action) {
    case "form":
        String idParameter = req.getParameter("id");
        boolean isUpdate = !idParameter.isEmpty();
        req.setAttribute("action", isUpdate ? "update" : "insert");
        req.setAttribute("type", isUpdate ? "readonly" : "");
        
        int reference = isUpdate ? Integer.parseInt(idParameter) : 0;
        livObject=  (Livres) ges.find(new Livres(reference));        
        req.setAttribute("reference", isUpdate ? idParameter : "");
        req.setAttribute("titre", isUpdate ? livObject.getTitre() : "");
        req.setAttribute("autheur", isUpdate ?livObject.getAutheur(): "");
        req.setAttribute("pages", isUpdate ? livObject.getPages() : "");
        req.getRequestDispatcher("/Livres/Form.jsp").forward(req, resp);
        break;
    case "delete":
        doDelete(req, resp);
        break;
        }
      }             
    }

    @Override
    public void init() throws ServletException {
        ges = new Biblio();
        Connexion.driver=getInitParameter("driver"); 
        Connexion.url=getInitParameter("url"); 
        Connexion.user=getInitParameter("user"); 
        Connexion.password=getInitParameter("password"); 
        
        }
}
