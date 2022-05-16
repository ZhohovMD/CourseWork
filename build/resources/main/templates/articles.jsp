<html>
    <head>
    <title>ARTICLES</title>
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
    <h1 style="font-size:50px; text-align: center;">Articles</h1>
    <h3 style="text-align: left; padding-left: 700px;">Save new article
        <form action="http://localhost:8080/articles/save" method="GET">
            name =
            <input type="text" name="name">
            <input type="submit">
        </form>
    </h3>
     <p style="text-align: left; padding-left: 700px;">&nbsp;</p>

    <h3 style="text-align: left; padding-left: 700px;"> Get by id
        <form action="http://localhost:8080/articles/get/byId" method="GET">
                id =
            <input type="text" name="id">
            <input type="submit">
        </form>
    </h3>

    <h3 style="text-align: left; padding-left: 700px;">Get by name
        <form action="http://localhost:8080/articles/get/byName" method="GET">
                name =
            <input type="text" name="name">
            <input type="submit">
        </form>
    </h3>

    <h3 style="text-align: left; padding-left: 700px;">Get All
        <form action="http://localhost:8080/articles/get/all" method="GET">
            <input type="submit">
        </form>
    </h3>

    <h3 style="text-align: left; padding-left: 700px;">&nbsp;</h3>
    <h3 style="text-align: left; padding-left: 700px;">Put new name
        <form action="http://localhost:8080/articles/put" method="GET">
            id =
            <input type="text" name="id">
            name =
            <input type="text" name="name">
            <input type="submit">
        </form>
    </h3>

    <h3 style="text-align: left; padding-left: 700px;">&nbsp;</h3>
    <h3 style="text-align: left; padding-left: 700px;">Delete by id
        <form action="http://localhost:8080/articles/delete/byId" method="GET">
            id =
            <input type="text" name="id">
            <input type="submit">
        </form>
    </h3>

    <h3 style="text-align: left; padding-left: 700px;">Delete by name
        <form action="http://localhost:8080/articles/delete/byName" method="GET">
            name =
            <input type="text" name="name">
            <input type="submit">
        </form>
    </h3>
    <h3 style="text-align: left; padding-left: 700px;">Delete all
        <form action="http://localhost:8080/articles/delete/all" method="GET">
            <input type="submit">
        </form></h3>
    <h1 style="font-size:50px; text-align: center;"><a href="http://localhost:8080/">Go to start page</a></h1>
    <p>&nbsp;</p>
</html>