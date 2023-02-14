<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="AutentificaMagazin" method="post">
          <label for="utilizator">Utilizator:</label>
            <br>
          <input type="text" id="utilizator" name="utilizator" value="Vlad">
            <br>
          <label for="parola">Parola:</label>
            <br>
          <input type="text" id="parola" name="parola">
            <br><br>
          <input type="submit" value="Login">
        </form> 
    </body>
</html>
