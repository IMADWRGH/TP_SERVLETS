<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liver form </title>
    </head>
    <body>
        <center>
    <fieldset>
    <form action="Livre?action=<%=request.getAttribute("action")%>" method="post">
        
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
        <td>Autheur:</td>
        <td><input type="text" name="autheur" value="<%=request.getAttribute("autheur")%>"></td>
    </tr>
    <tr>
        <td>Pages:</td>
        <td><input type="number" name="pages" value="<%=request.getAttribute("pages")%>"></td>
    </tr>
    
    <tr>
        <td><input type="submit" name="submit" value="Envoyer"></td>
        <td><input type="reset" name="rest" value="Annuler"></td>
    </tr>
    </table>

</form> 
    
</fieldset>
    <a href="Livre">Retour</a>
</center>
    </body>
</html>
