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
      <a href="/locadora" class="option" id="selected">
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


      <form class="form" action="/locadora/movies" method="POST">
      <a class="link" href="/locadora">
        <ion-icon name="arrow-back-outline"></ion-icon>
        <p>Voltar</p>
      </a>

      <h1 class="title">Novo filme:</h1>

      <div class="inputs">
        <input name="title" placeholder="Titulo" type="text" />
        <input name="rate" placeholder="Avaliação de 1 a 10" type="text" />
        <input name="duration" placeholder="Duração em horas e minutos" type="text" />
        <input name="fine_amount" placeholder="Valor da multa" type="text" />
        <input name="daily_rate" placeholder="Valor da diária" type="text" />
        <input name="image_url" placeholder="URL do cartaz" type="text" />

        <button type="submit">
          <ion-icon class="icon" name="send-outline"></ion-icon>
          <p>
            Enviar
          </p>
        </button>
      </div>
    </form>

  </div>

  <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
  <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</body>

</html>