package MyProject.services;

import MyProject.entities.Operations;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import MyProject.repositories.OperationsRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OperationsService {

    private final OperationsRepository operationsRepository;

    public void save(Operations operations) {
        operationsRepository.save(operations);
        operationsRepository.applyOpById(operations.getId());
    }

    public void saveAll(List<Operations> operations) {
        operationsRepository.saveAll(operations);
        for (Operations op : operations) {
            operationsRepository.applyOpById(op.getId());
        }
    }

    public void saveByParameters(Integer article_id, Double debit, Double credit, String timestamp, Integer balance_id) throws ParseException {
        timestamp = timestamp.replace('T', ' ');
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        java.util.Date parsedDate = dateFormat.parse(timestamp);
        java.sql.Timestamp realTimestamp = new java.sql.Timestamp(parsedDate.getTime());
        Operations newOp = new Operations()
                .setArticle_id(article_id)
                .setDebit(debit)
                .setCredit(credit)
                .setCreateDate(realTimestamp)
                .setBalance_id(balance_id);
        operationsRepository.save(newOp);
        operationsRepository.applyOpById(newOp.getId());
    }

    public Operations getOperationById(Integer id) {
        return operationsRepository.getById(id);
    }

    public List<Operations> getAllByArticleName(String name) {
        return operationsRepository.getAllByArticlesName(name);
    }

    public List<Operations> getAllByBalanceId(Integer id) {
        return operationsRepository.getAllByBalance_id(id);
    }

    public List<Operations> getAll() {
        return operationsRepository.findAllByOrderByIdAsc();
    }

    public void updateBalance_id(Integer id, Integer balance_id) {
        if (operationsRepository.getBalancesIdById(balance_id).equals(balance_id)) {
            operationsRepository.undoOp(id);
            operationsRepository.updateBalance_id(id, balance_id);
            operationsRepository.applyOpById(id);
        }
    }

    public void deleteById(Integer id) {
        operationsRepository.undoOp(id);
        operationsRepository.deleteById(id);
    }

    public void deleteAll() {
        List<Operations> operations = operationsRepository.findAll();
        for (Operations op : operations) {
            operationsRepository.undoOp(op.getId());
        }
        operationsRepository.deleteAll();
    }
}
