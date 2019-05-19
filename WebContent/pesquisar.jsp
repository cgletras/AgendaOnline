<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="css/estilos.css">	
     <% String contato = (String)request.getAttribute("contatos");
		     
     String [] contatos = contato.split(";");
        
     %>
     
     <script>

     
     function inicio(){
    	 window.location.href = 'index.html'
     }
     
     function pesquisarSubmit(){
    	 
    	var pesquisado = document.getElementById("pesquisado").value;
    	pesquisado = pesquisado.trim();
    	if (pesquisado!="") {
    		document.getElementById("formExc").submit();
    	} else
    		alert("Digite um nome para pesquisar")
     }
        
     </script>
     
    <style>
    
    
    </style>
</head>
<body>


    <div class="tamanho">
        <h1>AGENDA</h1>
        <h2>Pesquisar contatos</h2>
        <div class="listaNomes">
        
        <form action="Pesquisar" id="formExc" method="get">
	        <label>Digite o nome que quer pesquisar: </label>
	        <input type="text" id="pesquisado" name="pesquisar">
        </form>
        
        <table>
            
            <%
            if (contato != null){            
	            for(int i = 0; i < contatos.length; i++) {
	            	String [] pessoa = contatos[i].split(",");
	            	out.println("<tr>");
	            	out.println("<td class='nomes'><span id='nome"+i+"'>"+pessoa[0].trim()+"</td>");
	            	out.println("<td class='fones'><span id='fone"+i+"'>"+pessoa[1].trim()+"</td>");
	            	out.println("</tr>"); 
	            }
            } 
            %>       	
           
        </table>
        </div>    
            <form>
            	<input type="button" value="Pesquisar" onclick="pesquisarSubmit()">
                <input type="button" value="Voltar início" onclick="inicio()">
            </form>
    </div> 

</body>

</html>