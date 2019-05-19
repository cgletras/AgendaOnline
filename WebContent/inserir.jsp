<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    
    <link rel="stylesheet" href="css/estilos.css">
    
    <%
    
    String nome = (String)request.getAttribute("nome");
       
    %>

    <script>
    function inicio(){
   	 window.location.href = 'index.html'
    }
                
    </script>
    <style>
    
      
    
    </style>
</head>
<body>
   
   
   <div class="tamanho">
      <h1>PROVA 2</h1>
      <h2>Cadastrar Usuario</h2>
      
      <form action="Gravar" method="get">
                 
         <label for="insereNome">Nome:</label>
         <input id="insereNome" required name="nome" type="text">
         <br>
         <label for="insereFone">Nota 1:</label>
         <input id="insereFone" required name="nota1" type="text">
         <br>
         <br>
         <label for="insereFone">Nota 2:</label>
         <input id="insereFone" required name="nota2" type="text">
         <br>
         <input type="button" value="Voltar início" onclick="inicio()">
         <input type="submit" value="Gravar dados">
      </form>
   </div>
    
</body>
</html>