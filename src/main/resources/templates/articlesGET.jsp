<head>
<title>ARTICLE GET REQUEST</title>
</head>
<style>
    body {
        background-image: url("https://phonoteka.org/uploads/posts/2021-04/1618834549_8-phonoteka_org-p-krasivii-belii-fon-dlya-saita-10.jpg");
        background-attachment: fixed;
        background-repeat: no-repeat;
        background-size: cover;
    }
</style>
<body>
    <!--/*@thymesVar id="list" type="java.util.List<MyProject.entities.Articles>"*/-->
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <h2 style="font-size:50px; text-align: center;"> Articles table </h2>

    <div style="text-align: center;">
        <table border="1" style="font-size:30px; display: inline-block;" class = "table table-striped">
            <colgroup>
                <col span="1" style="background:#a7d7af">
                <col span="1" style="background-color:#efd6e5">
            </colgroup>
            <tr>
                <th>Id</th>
                <th>Name</th>
            </tr>

            <tr th:each="article : ${list}">
            <td th:text="${article.getArtId}"></td>
            <td th:text="${article.getName}"></td>
            </tr>
        </table>
    </div>
</body>
<h1 style="text-align: center;"><a href="http://localhost:8080/articles">Go to Articles</a></h1>
<h1 style="text-align: center;"><a href="http://localhost:8080/">Go to start page</a></h1>
</html>