<head>
    <title>OPERATIONS GET REQUEST</title>
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
<h2 style="font-size:50px; text-align: center;"> Operations table </h2>

<div style="text-align: center;">
    <table border="1" style="font-size:30px; display: inline-block;" class = "table table-striped">
        <colgroup>
            <col span="1" style="background:#b6b5ae">
            <col span="1" style="background:#a7d7af">
            <col span="1" style="background:#8fd366">
            <col span="1" style="background:#f66262">
            <col span="1" style="background:#f1e8b9">
            <col span="1" style="background-color:#94c9e1">
        </colgroup>
        <tr>
            <th>Id</th>
            <th>Article id</th>
            <th>Debit</th>
            <th>Credit</th>
            <th>Create date</th>
            <th>Balance id</th>
        </tr>

        <tr th:each="operation : ${list}">
            <td th:text="${operation.getId}"></td>
            <td th:text="${operation.getArticle_id}"></td>
            <td th:text="${operation.getDebit}"></td>
            <td th:text="${operation.getCredit}"></td>
            <td th:text="${operation.getCreateDate}"></td>
            <td th:text="${operation.getBalance_id}"></td>
        </tr>
    </table>
</div>
</body>
<h1 style="text-align: center;"><a href="http://localhost:8080/operations">Go to Operations</a></h1>
<h1 style="text-align: center;"><a href="http://localhost:8080/">Go to start page</a></h1>
</html>