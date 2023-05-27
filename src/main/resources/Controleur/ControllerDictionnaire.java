package Controleur;

import DAO.Connexion;
import Metier.Biblio;
import Metier.Dictionnaires;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
@WebServlet(name = "ControllerDictionnaire", urlPatterns = {"/Dictionnaire"}, initParams = {
    @WebInitParam(name = "driver", value = "com.mysql.jdbc.Driver")
    , @WebInitParam(name = "url", value = "jdbc:mysql://localhost:3306/biblio")
    , @WebInitParam(name = "user", value = "root")
    , @WebInitParam(name = "password", value = "")})
public class ControllerDictionnaire extends HttpServlet {

    Biblio ges ;
    String action=null;
    int reference, motsDefinitions;
    String titre;
    Dictionnaires dictObject;
    ArrayList<Dictionnaires> diction;
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        action=req.getParameter("action");
        diction = ges.Select("dictionnaires");
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
        ges.delete(new Dictionnaires(ref));
        resp.sendRedirect("/gestion_Servlet_bi/Dictionnaire");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {        
        ges.update(new Dictionnaires(Integer.parseInt(req.getParameter("reference")),req.getParameter("titre"),Integer.parseInt(req.getParameter("motsDefinitions"))));
        resp.sendRedirect("/gestion_Servlet_bi/Dictionnaire");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ges.insert(new Dictionnaires(Integer.parseInt(req.getParameter("reference")),req.getParameter("titre"),Integer.parseInt(req.getParameter("motsDefinitions"))));
       resp.sendRedirect("/gestion_Servlet_bi/Dictionnaire");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       if(action==null){
          req.getRequestDispatcher("/Dictionnaires/DictionnairesAffichage.jsp").forward(req, resp);
      }else{
         switch (action) {
    case "form":
        String idParameter = req.getParameter("id");
        boolean isUpdate = !idParameter.isEmpty();
        req.setAttribute("action", isUpdate ? "update" : "insert");
        req.setAttribute("type", isUpdate ? "readonly" : "");
        
        int reference = isUpdate ? Integer.parseInt(idParameter) : 0;
        dictObject = (Dictionnaires) ges.find(new Dictionnaires(reference));
        
        req.setAttribute("reference", isUpdate ? idParameter : "");
        req.setAttribute("titre", isUpdate ? dictObject.getTitre() : "");
        req.setAttribute("motsDefinitions", isUpdate ? dictObject.getMotsDefinitions() : "");
        req.getRequestDispatcher("/Dictionnaires/Form.jsp").forward(req, resp);
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
