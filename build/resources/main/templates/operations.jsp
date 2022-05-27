<html>

<title>OPERATIONS</title>
</head>
<style>
    body {
        background-image: url("https://phonoteka.org/uploads/posts/2021-04/1618834549_8-phonoteka_org-p-krasivii-belii-fon-dlya-saita-10.jpg");
        background-attachment: fixed;
        background-repeat: no-repeat;
        background-size: cover;
    }
</style>
<h1 style="font-size: 1pt;">&nbsp;</h1>
<h1 style="font-size:50px; text-align: center;">Operations</h1>
<p style="font-size: 2pt;">&nbsp;</p>
<h3 style="text-align: left; padding-left: 700px;">Save new operation</h3>
    <h3><form style="text-align: center;" action="http://localhost:8080/operations/save" method="GET">
        article id =
        <input type="number" name="article_id" step="1">
        debit =
        <input type="number" name="debit" step="0.1">
        credit =
        <input type="number" name="credit" step="0.1">
        <p style="font-size:2pt;">&nbsp;</p>
        create date =
        <input type="datetime-local" name="timestamp" step="0.001">
        balance id =
        <input type="number" name="balance_id" step="1">
        <input type="submit">
    </form></h3>

<p style="text-align: left; padding-left: 700px;">&nbsp;</p>
<h3 style="text-align: left; padding-left: 700px;"> Get by id
    <form action="http://localhost:8080/operations/get/byId" method="GET">
        id =
        <input type="text" name="id">
        <input type="submit">
    </form>
</h3>

<h3 style="text-align: left; padding-left: 700px;">Get by article name
    <form action="http://localhost:8080/operations/get/all/byArticleName" method="GET">
        article name =
        <input type="text" name="name">
        <input type="submit">
    </form>
</h3>

<h3 style="text-align: left; padding-left: 700px;">Get by balance id
    <form action="http://localhost:8080/operations/get/all/byBalanceId" method="GET">
        balance id =
        <input type="text" name="id">
        <input type="submit">
    </form>
</h3>

<h3 style="text-align: left; padding-left: 700px;">Get All
    <form action="http://localhost:8080/operations/get/all" method="GET">
        <input type="submit">
    </form>
</h3>

<p style="text-align: left; padding-left: 700px;">&nbsp;</p>
<h3 style="text-align: left; padding-left: 700px;">Put new balance id
    <form action="http://localhost:8080/operations/put/balance_id" method="GET">
        id =
        <input type="number" name="id" step="1">
        new balance id =
        <input type="number" name="balance_id" step="1">
        <input type="submit">
    </form>
</h3>

<h3 style="text-align: left; padding-left: 700px;">&nbsp;</h3>
<h3 style="text-align: left; padding-left: 700px;">Delete by id
    <form action="http://localhost:8080/operations/delete/byId" method="GET">
        id =
        <input type="text" name="id">
        <input type="submit">
    </form>
</h3>

<h3 style="text-align: left; padding-left: 700px;">Delete all
    <form action="http://localhost:8080/operations/delete/all" method="GET">
        <input type="submit">
    </form></h3>

<h1 style="font-size:50px; text-align: center;"><a href="http://localhost:8080/">Go to start page</a></h1>
<p style="font-size: 2pt;">&nbsp;</p>
</html>