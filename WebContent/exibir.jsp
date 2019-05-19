<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="css/estilos.css">	
     <% String contato = (String)request.getAttribute("contatos");
     
     System.out.print(contato);
		     
     String [] contatos = contato.split(";");
   	   
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
        <h1>AGENDA</h1>
        <h2>Exibir contatos</h2>
        <div class="listaNomes">
        <table>
            
            <%
            if (contato != null){            
	            for(int i = 0; i < contatos.length; i++) {
	            	String [] pessoa = contatos[i].split(",");
	            	out.println("<tr>");
	            	out.println("<td class='nomes'><span id='nome"+i+"'>"+pessoa[0].trim()+"</td>");
	            //	out.println("<td class='fones'><span id='not1"+i+"'>"+pessoa[1].trim()+"</td>");
	            //	out.println("<td class='fones'><span id='not2"+i+"'>"+pessoa[2].trim()+"</td>");
	            	out.println("</tr>"); 
	            }
            }
            %>       	
           
        </table>
        </div>    
            <form action="Exibir" method="get">
                <input type="button" value="Voltar início" onclick="inicio()">
            </form>
    </div> 

</body>

</html>