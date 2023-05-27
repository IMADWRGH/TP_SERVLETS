package Metier;

import DAO.DAO;
import DAO.IDAO;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Biblio extends  DAO implements IDAO<Documents>{
    String sql=null;
    @Override
    public int insert(Documents D) {
      int res=0;
    try {
        if(D instanceof Livres ) {
            sql="insert into livres(reference,titre,autheur,pages) values("+D.getReference()+",'"+D.getTitre()+"','"+((Livres) D).getAutheur()+"',"+((Livres) D).getPages()+")"   ;
        } else {
            sql="insert into dictionnaires(reference,titre,motsDefinitions) values("+D.getReference()+",'"+D.getTitre()+"',"+((Dictionnaires) D).getMotsDefinitions()+")"   ;
        }
        res=super.Set(sql);
    } catch (Exception ex) {
     System.out.println("Erreur liée à l'éxecution de la req !!!");
    }
    return res;
    }

    @Override
    public int update(Documents D) {
        int res=0;
    try {
        if(D instanceof Livres ) {
         sql="update livres set titre='"+D.getTitre()+"',autheur='"+((Livres) D).getAutheur()+"',pages='"+((Livres) D).getPages()+"' where reference="+D.getReference()+"";

        } else {
         sql="update dictionnaires set titre='"+D.getTitre()+"',motsDefinitions="+((Dictionnaires) D).getMotsDefinitions()+" where reference="+D.getReference()+"";
        }
                res=super.Set(sql);
         } catch (Exception ex) {
             System.out.println("Erreur liée à l'éxecution de la req !!!");
         }
    return res;
    }

    @Override
    public int delete(Documents D) {
        int res=0;
    try {
        if(D instanceof Livres ) {
          sql="delete from livres  where reference="+D.getReference()+"";  
        }else{
          sql="delete from dictionnaires  where reference="+D.getReference()+"";  
        }  
        res=super.Set(sql);
    } catch (Exception ex) {
     System.out.println("Erreur liée à l'éxecution de la req !!!");
    }
    return res;
    }

    @Override
    public ArrayList Select(String type) {
         ArrayList<Dictionnaires> DictionList = new ArrayList();
         ArrayList<Livres> LiverList = new ArrayList();

         if(type.equals("livre") ) {
         try{
            ResultSet rs;
           
            sql="select * from livres";
            
            rs=super.Get(sql);
             while(rs.next())
         {
             LiverList.add(new Livres(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
         }

        }catch(Exception ex){
           System.out.println("errur requete select dans gestion livres"); 
        }
        
        return LiverList;
    }else if (type.equals("dictionnaires")){
        
        
        try{
            ResultSet rs;
            
            sql="select * from dictionnaires";  
            rs=super.Get(sql);
            while(rs.next())
         {
             DictionList.add(new Dictionnaires(rs.getInt(1),rs.getString(2),rs.getInt(3)));
         }
            

        }catch(Exception ex){
           System.out.println("errur requete select dans gestion dictionnaires"); 
        }
        
        return DictionList;
       }
         return DictionList;
    }
    
    public Documents find(Documents D) {
    Documents document = null;
    int reference = D.getReference();
    try {
        if (D instanceof Livres) {
            sql = "SELECT * FROM livres WHERE reference = " + reference;
            ResultSet rs = super.Get(sql);
            if (rs.next()) {
                String titre = rs.getString("titre");
                String autheur = rs.getString("autheur");
                int pages = rs.getInt("pages");
                document = new Livres(reference, titre, autheur, pages);
            }
            rs.close();
        } else if (D instanceof Dictionnaires) {
            sql = "SELECT * FROM dictionnaires WHERE reference = " + reference;
            ResultSet rs = super.Get(sql);
            if (rs.next()) {
                String titre = rs.getString("titre");
                int motsDefinitions = rs.getInt("motsDefinitions");
                document = new Dictionnaires(reference, titre, motsDefinitions);
            }
            rs.close();
        }
    } catch (Exception ex) {
        System.out.println("Error occurred while executing the query!");
    }
    return document;
}

    
    
}
