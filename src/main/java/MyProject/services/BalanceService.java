package MyProject.services;

import MyProject.entities.Balance;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import MyProject.repositories.BalanceRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BalanceService {

    private final BalanceRepository balanceRepository;

    public void save(Balance balance) {
        balanceRepository.save(balance);
    }

    public void saveAll(List<Balance> balance) {
        balanceRepository.saveAll(balance);
    }

    public void saveByParameters(String timestamp) throws ParseException {
        timestamp = timestamp.replace('T', ' ');
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        java.util.Date parsedDate = dateFormat.parse(timestamp);
        java.sql.Timestamp realTimestamp = new java.sql.Timestamp(parsedDate.getTime());
        balanceRepository.save(new Balance()
                                    .setCreateDate(realTimestamp));
    }

    public Balance getById(Integer id) {
        return balanceRepository.getById(id);
    }

    public List<Balance> getAll() {
        return balanceRepository.findAllByOrderByBalIdAsc();
    }

    public List<Balance> getAllByCreateDate(String timestamp) throws ParseException {
        timestamp = timestamp.replace('T', ' ');
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        java.util.Date parsedDate = dateFormat.parse(timestamp);
        java.sql.Timestamp realTimestamp = new java.sql.Timestamp(parsedDate.getTime());
        return balanceRepository.getAllByCreateDate(realTimestamp);
    }

    public void deleteById(Integer id) {
        balanceRepository.deleteById(id);
    }

    public void deleteAllByCreateDate(String timestamp) throws ParseException {
        timestamp = timestamp.replace('T', ' ');
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        java.util.Date parsedDate = dateFormat.parse(timestamp);
        java.sql.Timestamp realTimestamp = new java.sql.Timestamp(parsedDate.getTime());
        balanceRepository.deleteAllByCreateDate(realTimestamp);
    }

    public void deleteAll() {
        balanceRepository.deleteAll();
    }
}
