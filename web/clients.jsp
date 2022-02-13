<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="./styles/global.css">
  <style><%@include file="/styles/global.css"%></style>
</head>

<body>

  <header>
    <h1><span>Pobre</span>flix</h1>

    <div class="options">
      <a href="/locadora" class="option">
        <ion-icon class="icon" name="videocam-outline"></ion-icon>
        <p>Filmes</p>
      </a>

      <a href="/locadora/bills" class="option">
        <ion-icon class="icon" name="logo-usd"></ion-icon>
        <p>Contas</p>
      </a>

      <a href="/locadora/rentals" class="option">
        <ion-icon class="icon" name="add-circle-outline"></ion-icon>
        <p>Alugar</p>
      </a>

      <a href="#" class="option" id="selected">
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


      <form class="form" action="/locadora/devolution" method="POST">
      <h1 class="title">Novo cliente:</h1>

      <div class="inputs">
        <input name="name" placeholder="Nome" type="text" />
        <input name="address" placeholder="Bairro" type="text" />
        <input name="district" placeholder="Endereço" type="text" />
        <input name="phone" placeholder="Número de celular" type="text" />
        <input name="cpf" placeholder="CPF" type="text" />

        <button type="submit">
          <ion-icon class="icon" name="send-outline"></ion-icon>
          <p>
            Enviar
          </p>
        </button>
      </div>
    </form>

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