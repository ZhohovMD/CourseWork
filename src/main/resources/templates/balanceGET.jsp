<head>
    <title>BALANCE GET REQUEST</title>
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
<h2 style="font-size:50px; text-align: center;"> Balances table </h2>

<div style="text-align: center;">
    <table border="1" style="font-size:30px; display: inline-block;" class = "table table-striped">
        <colgroup>
            <col span="1" style="background:#94c9e1">
            <col span="1" style="background:#f1e8b9">
            <col span="1" style="background:#8fd366">
            <col span="1" style="background:#f66262">
            <col span="1" style="background-color:#e5b881">
        </colgroup>
        <tr>
            <th>Id</th>
            <th>Create date</th>
            <th>Debit</th>
            <th>Credit</th>
            <th>Amount</th>
        </tr>

        <tr th:each="balance : ${list}">
            <td th:text="${balance.getBalId}"></td>
            <td th:text="${balance.getCreateDate}"></td>
            <td th:text="${balance.getDebit}"></td>
            <td th:text="${balance.getCredit}"></td>
            <td th:text="${balance.getAmount}"></td>
        </tr>
    </table>
</div>
</body>
<h1 style="text-align: center;"><a href="http://localhost:8080/balance">Go to Balance</a></h1>
<h1 style="text-align: center;"><a href="http://localhost:8080/">Go to start page</a></h1>
</html>