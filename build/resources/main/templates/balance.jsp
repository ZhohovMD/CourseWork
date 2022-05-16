<html>

<title>BALANCE</title>
</head>
<style>
    body {
        background-image: url("https://phonoteka.org/uploads/posts/2021-04/1618834549_8-phonoteka_org-p-krasivii-belii-fon-dlya-saita-10.jpg");
        background-attachment: fixed;
        background-repeat: no-repeat;
        background-size: cover;
    }
</style>
<h1 style="text-align: center;">&nbsp;</h1>
<h1 style="font-size:50px; text-align: center;">Balance</h1>
<p>&nbsp;</p>
<h3 style="text-align: left; padding-left: 700px;">Save new balance
    <form action="http://localhost:8080/balance/save" method="GET">
        create date =
        <input type="datetime-local" name="timestamp" step="0.001">
        <input type="submit">
    </form>
</h3>

<p style="text-align: left; padding-left: 700px;">&nbsp;</p>
<h3 style="text-align: left; padding-left: 700px;"> Get by id
    <form action="http://localhost:8080/balance/get/byId" method="GET">
        id =
        <input type="text" name="id">
        <input type="submit">
    </form>
</h3>

<h3 style="text-align: left; padding-left: 700px;">Get by create date
    <form action="http://localhost:8080/balance/get/byCreateDate" method="GET">
        create date =
        <input type="datetime-local" name="timestamp" step="0.001">
        <input type="submit">
    </form>
</h3>

<h3 style="text-align: left; padding-left: 700px;">Get All
    <form action="http://localhost:8080/balance/get/all" method="GET">
        <input type="submit">
    </form>
</h3>

<h3 style="text-align: left; padding-left: 700px;">&nbsp;</h3>
<h3 style="text-align: left; padding-left: 700px;">Delete by id
    <form action="http://localhost:8080/balance/delete/byId" method="GET">
        id =
        <input type="text" name="id">
        <input type="submit">
    </form>
</h3>

<h3 style="text-align: left; padding-left: 700px;">Delete by create date
    <form action="http://localhost:8080/balance/delete/all/byCreateDate" method="GET">
        create date =
        <input type="datetime-local" name="timestamp" step="0.001">
        <input type="submit">
    </form>
</h3>

<h3 style="text-align: left; padding-left: 700px;">Delete all
    <form action="http://localhost:8080/balance/delete/all" method="GET">
        <input type="submit">
    </form></h3>

<p>&nbsp;</p>
<h1 style="font-size:50px; text-align: center;"><a href="http://localhost:8080/">Go to start page</a></h1>
<p style="font-size: 1.5em;">&nbsp;</p>
</html>