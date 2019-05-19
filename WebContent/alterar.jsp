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
  	
     var contatosMod = "";
     
     function inicio(){
    	 window.location.href = 'index.html'
     }
     
     function excluir(id){
    	 var contatos = "<%=contato%>";
    	     	 
    	 contatos = contatos.split(";");
    	     	 
    	 id = id.slice(4);
    	 id = parseInt(id);
    	     	 
    	 for (var i = 0; i < contatos.length; i++) {
		 		 
		 		 if(i!= contatos.length-1) {
		 			if (i == id) {
		 				var novoNome = prompt("Digite o novo nome").trim();
		 				while (novoNome=="" || novoNome == "undefined") {
		 					alert("Voce precisa digitar um nome");
		 					novoNome = prompt("Digite o novo nome").trim();
		 				}
		 				contatos[i] = contatos[i].replace(contatos[i].split(",")[0], novoNome);
		 			}
		 			contatosMod += contatos[i].trim()+";";
		 		 } else
		 			contatosMod += contatos[i].trim(); 
    		 
    	 }
    	 document.getElementById("contatosMod").value = contatosMod;
    	 contatosMod = "";
    	 document.getElementById("formExc").submit();
    	 
     }
     </script>
     
    <style>
    
    	span {
    		cursor: pointer;
    	}
    	
    	.nomes:hover {
    	background-color: lightgreen;
    }
    
    </style>
</head>
<body>


    <div class="tamanho">
        <h1>AGENDA</h1>
        <h2>Alterar contatos</h2>
        <h4>Clique no nome que deseja alterar</h4>
        <div class="listaNomes">
        <table>
            
            <%
            if (contato != null){
	            for(int i = 0; i < contatos.length; i++) {
	            	String [] pessoa = contatos[i].split(",");
	            	out.println("<tr>");
	            	out.println("<td class='nomes'><span id='nome"+i+"'onclick='excluir(this.id)'>"+pessoa[0]+"</td>");
	            	out.println("<td class='fones'><span id='fone"+i+"'>"+pessoa[1]+"</td>");
	            	out.println("</tr>"); 
	            }
            } 
            %>   
                      
        </table>
        </div>    
            <form action="Alterar" method="get" id="formExc" name="formExc">
            	<input type="hidden" id="contatosMod" name="mod" value="">
                <input type="button" value="Voltar início" onclick="inicio()">
                
            </form>
    </div> 

</body>

</html>