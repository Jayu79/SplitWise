package SplitWise.services.settleup.strategies;

import SplitWise.models.Expense;
import SplitWise.models.ExpenseOwingUser;
import SplitWise.models.ExpensePayingUser;
import SplitWise.models.User;
import SplitWise.services.settleup.Transaction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GiveToNextSettleUpTransactionCalculationStrategy implements SettleUpTransactionsCalculatorStrategy{
    @Override
    public List<Transaction> getTransaction(List<ExpensePayingUser> expensePayingUsers, List<ExpenseOwingUser> expenseOwingUsers) {

        Map<User,Double> extraAmounts = new HashMap<>();

        for(ExpensePayingUser expensePayingUser : expensePayingUsers){
            if(!extraAmounts.containsKey(expensePayingUser.getUser())){
                extraAmounts.put(expensePayingUser.getUser(),0.);
            }

            extraAmounts.put(expensePayingUser.getUser(), extraAmounts.get(expensePayingUser.getUser())+ expensePayingUser.getAmount());
        }

        for(ExpenseOwingUser expenseOwingUser : expenseOwingUsers){
            if(!extraAmounts.containsKey(expenseOwingUser.getUser())){
                extraAmounts.put(expenseOwingUser.getUser(),0.);
            }

            extraAmounts.put(expenseOwingUser.getUser(), extraAmounts.get(expenseOwingUser.getUser()) - expenseOwingUser.getAmount());
        }

        List<Map.Entry<User, Double>> entries = new ArrayList<>(extraAmounts.entrySet());

        List<Transaction> answer = new ArrayList<>();

        int n = entries.size();
        for(int i = 0;i<n-1;++i){
            Transaction transaction = new Transaction();
            if(entries.get(i).getValue()<0){
                transaction.setFrom(entries.get(i).getKey());
                transaction.setTo(entries.get(i+1).getKey());
                transaction.setAmount(Math.abs(entries.get(i).getValue()));

                entries.get(i+1).setValue(entries.get(i+1).getValue()-Math.abs(entries.get(i).getValue()));
            } else if (entries.get(i).getValue()>0) {
                transaction.setFrom(entries.get(i+1).getKey());
                transaction.setTo(entries.get(i).getKey());
                transaction.setAmount(Math.abs(entries.get(i).getValue()));

                entries.get(i+1).setValue(entries.get(i+1).getValue() + Math.abs(entries.get(i).getValue()));
                
            }
        }

        return answer;
    }
}
