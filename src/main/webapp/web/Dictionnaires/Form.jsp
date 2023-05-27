<%-- 
    Document   : form
    Created on : Mar 5, 2023, 10:39:12 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <center>
    <fieldset>
    <form action="Dictionnaire?action=<%=request.getAttribute("action")%>" method="post">
        
    <table>
    <tr>
       <td>Reference:</td>
       <td><input type="number" name="reference" value="<%=request.getAttribute("reference")%>" <%=request.getAttribute("type")%>></td>     
    </tr>   
    <tr>
        <td>Titre:</td>
        <td><input type="text" name="titre" value="<%=request.getAttribute("titre")%>"></td>
    </tr>
    <tr>
        <td>Nombre de Mots:</td>
        <td><input type="number" name="motsDefinitions" value="<%=request.getAttribute("motsDefinitions")%>"></td>
    </tr>
    
    <tr>
        <td><input type="submit" name="submit" value="Envoyer"></td>
        <td><input type="reset" name="rest" value="Annuler"></td>
    </tr>
    </table>

</form> 
</fieldset>
    <a href="Dictionnaire">Retour</a>
</center>
    </body>
</html>
