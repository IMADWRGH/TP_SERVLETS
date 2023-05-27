<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Metier.*"%>
<%@page import="Metier.Livres"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of </title>
    </head>
    <%!
    ArrayList<Livres> diction ;
    Biblio ges;
    
%>
    <body>
        <%
        ges=new Biblio();
        diction = ges.Select("livre");
        %>
        <center>
    <h1>La liste des livre</h1>
     
<table border="1">
    <tr>
        <th>Reference</th>
        <th>Titre</th>
        <th>Autheur</th>
        <th>Pages</th>
        <th colspan="3"><a href="Livre?action=form&id=">>>Ajouter</a></th>

    </tr>
    
<%
for(Livres i : diction){
%>
    <tr>
        <td><%= i.getReference() %></td>
        <td><%= i.getTitre() %></td>
        <td><%= i.getAutheur() %></td>
        <td><%= i.getPages() %></td>
        <td><a href="Livre?action=form&id=<%= i.getReference() %>">Editer</a></td>
        <td><a href="Livre?action=delete&id=<%= i.getReference() %>"> Supp</a></td>


    </tr>
<% 
}
%>
</table>
<a href="index.html">Retour</a>

</center>
    </body>
</html>
