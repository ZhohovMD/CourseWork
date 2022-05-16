package MyProject.utils;

import MyProject.entities.Articles;
import MyProject.entities.Balance;
import MyProject.entities.Operations;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import MyProject.services.ArticlesService;
import MyProject.services.BalanceService;
import MyProject.services.OperationsService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InitiateUtils implements CommandLineRunner {

    private final ArticlesService articlesService;
    private final BalanceService balanceService;
    private final OperationsService operationsService;

    @Override
    public void run(String... args) throws Exception {

        java.sql.Timestamp timestamp = new Timestamp(new java.util.Date().getTime());

        List<Articles> articles = new ArrayList<>(
                Arrays.asList( new Articles()
                                        .setName("Taxes"),
                                new Articles()
                                        .setName("Salary"),
                                new Articles()
                                        .setName("Shopping"),
                                new Articles()
                                        .setName("Stocks"),
                                new Articles()
                                        .setName("Donations")
                )
        );

        List<Balance> balances = new ArrayList<>(
                Arrays.asList(  new Balance()
                                        .setCreateDate(timestamp)
                                        .setCredit(0)
                                        .setDebit(0)
                                        .setAmount(0),
                                new Balance()
                                        .setCreateDate(timestamp)
                                        .setCredit(0)
                                        .setDebit(0)
                                        .setAmount(0)
                )
        );

        List<Operations> operations = new ArrayList<>(
                Arrays.asList( new Operations()
                                        .setCreateDate(timestamp)
                                        .setArticle_id(2)
                                        .setCredit(0)
                                        .setDebit(30000)
                                        .setBalance_id(1),
                                new Operations()
                                        .setCreateDate(timestamp)
                                        .setArticle_id(1)
                                        .setCredit(5000)
                                        .setDebit(0)
                                        .setBalance_id(1),
                                new Operations()
                                        .setCreateDate(timestamp)
                                        .setArticle_id(3)
                                        .setCredit(7800)
                                        .setDebit(0)
                                        .setBalance_id(1),
                                new Operations()
                                        .setCreateDate(timestamp)
                                        .setArticle_id(3)
                                        .setCredit(189)
                                        .setDebit(0)
                                        .setBalance_id(1),
                                new Operations()
                                        .setCreateDate(timestamp)
                                        .setArticle_id(3)
                                        .setCredit(300)
                                        .setDebit(0)
                                        .setBalance_id(1),
                                new Operations()
                                        .setCreateDate(timestamp)
                                        .setArticle_id(4)
                                        .setCredit(0)
                                        .setDebit(820)
                                        .setBalance_id(2),
                                new Operations()
                                        .setCreateDate(timestamp)
                                        .setArticle_id(5)
                                        .setCredit(9500)
                                        .setDebit(200000)
                                        .setBalance_id(2)
                )
        );

        articlesService.deleteAll();
        balanceService.deleteAll();

        articlesService.saveAll(articles);
        balanceService.saveAll(balances);
        operationsService.saveAll(operations);

        System.out.println("\n----------------------------");
        System.out.println("Приложение успешно запущено!");
        System.out.println("----------------------------\n");
    }
}
