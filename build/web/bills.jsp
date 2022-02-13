<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
  <style><%@include file="/styles/global.css"%></style>
  <style><%@include file="/styles/bills.css"%></style>
  <title>Document</title>
</head>

<body>

  <header>
    <h1><span>Pobre</span>flix</h1>

    <div class="options">
      <a href="/locadora" class="option">
        <ion-icon class="icon" name="videocam-outline"></ion-icon>
        <p>Filmes</p>
      </a>

      <a href="#" class="option" id="selected">
        <ion-icon class="icon" name="logo-usd"></ion-icon>
        <p>Contas</p>
      </a>

      <a href="/locadora/rentals" class="option">
        <ion-icon class="icon" name="add-circle-outline"></ion-icon>
        <p>Alugar</p>
      </a>

      <a href="/locadora/clients" class="option">
        <ion-icon class="icon" name="person-add-outline"></ion-icon>
        <p>Clientes</p>
      </a>
    </div>
  </header>

  <div class="content">
    <div class="welcome">
      <h2 class="title">Bem Vindo</h2>
      <p>Sistema da locadora de filmes.</p>
    </div>

      <form method="POST">
      <h1 class="title">Devolver Filme:</h1>

      <div class="inputs">
        <input name="rental_id" placeholder="Protocolo do aluguel" type="text" />
        <input name="end_date" placeholder="Data de entrega DD/MM/AAAA" type="text" />

        <button type="submit">
          <ion-icon class="icon" name="send-outline"></ion-icon>
          <p>
            Enviar
          </p>
        </button>
      </div>
    </form>
      
    <div class="table-container">
      <h1 class="title">Todos os aluguéis</h1>

      <table>
        <thead>
          <tr>
            <th>Protocolo</th>
            <th>Filme</th>
            <th>Alugado por</th>
            <th>Status</th>
            <th>Data final</th>
            <th>Valor</th>
          </tr>
        </thead>

        <tbody>
            <c:forEach var="bill" items="${bills}">
                <tr>
                  <td>${bill.id}</td>
                  <td>${bill.movie_title}</td>
                  <td>${bill.client_name}</td>
                    <c:if test="${bill.status == 'entregue'}">
                        <td class="status-entregue">${bill.status}</td>
                    </c:if>
                    <c:if test="${bill.status == 'pendente'}">
                        <td class="status-pendente">${bill.status}</td>
                    </c:if>
                        
                    <td>${bill.end_date}</td>
                    <c:if test="${bill.total <= 0}">
                        <td>R$${bill.daily_rate}</td>
                    </c:if>
                    <c:if test="${bill.total > 0}">
                        <td>R$${bill.total}</td>
                    </c:if>
                </tr>
            </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
    <c:if test="${param.mensagem != null}">
        <script type="text/javascript">
            window.alert('${param.mensagem}');           
        </script>
    </c:if>
    
  <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
  <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</body>

</html>