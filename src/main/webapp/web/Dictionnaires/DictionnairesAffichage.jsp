<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Metier.*"%>
<%@page import="Metier.Dictionnaires"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%!
    ArrayList<Dictionnaires> diction ;
    Biblio ges;
    
%>
    <body>
        <%
        ges=new Biblio();
        diction = ges.Select("dictionnaires");
        %>
        <center>
    <h1>La liste des Dictionnaires</h1>
     
<table border="1">
    <tr>
        <th>Reference</th>
        <th>Titre</th>
        <th>Nombre de Mots</th>
        <th colspan="3"><a href="Dictionnaire?action=form&id=">>>Ajouter</a></th>

    </tr>
    
<%
for(Dictionnaires i : diction){
%>
    <tr>
        <td><%= i.getReference() %></td>
        <td><%= i.getTitre() %></td>
        <td><%= i.getMotsDefinitions() %></td>
        <td><a href="Dictionnaire?action=form&id=<%= i.getReference() %>">Editer</a></td>
        <td><a href="Dictionnaire?action=delete&id=<%= i.getReference() %>"> Supp</a></td>


    </tr>
<% 
}
%>
</table>
<a href="index.html">Retour</a>

</center>
    </body>
</html>