package SplitWise.services.settleup;

import SplitWise.models.Expense;
import SplitWise.models.ExpenseOwingUser;
import SplitWise.models.ExpensePayingUser;
import SplitWise.models.Group;
import SplitWise.repositories.ExpenseOwingUserRepository;
import SplitWise.repositories.ExpensePayingUserRepository;
import SplitWise.repositories.GroupRepository;
import SplitWise.services.settleup.strategies.SettleUpTransactionsCalculatorStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SettleUpService {

    private SettleUpTransactionsCalculatorStrategy settleUpTransactionsCalculatorStrategy;
    private GroupRepository groupRepository;
    private ExpenseOwingUserRepository expenseOwingUserRepository;
    private ExpensePayingUserRepository expensePayingUserRepository;

    @Autowired
    public SettleUpService(SettleUpTransactionsCalculatorStrategy settleUpTransactionsCalculatorStrategy){
        this.settleUpTransactionsCalculatorStrategy =settleUpTransactionsCalculatorStrategy;
    }

    public List<Transaction> settleUpUser(Long userId){

        return null;
    }


    public List<Transaction> settleUpGroup(Long groupId){

        /*
            1. Get all the expense paying users and expense owing users of the group
            2. Do the required calculation to compute the transaction
         */

        Optional<Group> groupOptional = groupRepository.findById(groupId);

        if(!groupOptional.isPresent()){
//            Throw some exception
            System.out.println("No Such Group");
        }

        Group group = groupOptional.get();

        List<ExpensePayingUser> expensePayingUsers = new ArrayList<>();
        List<ExpenseOwingUser> expenseOwingUsers = new ArrayList<>();

        for(Expense expense: group.getExpenses()){
            expensePayingUsers.addAll(expensePayingUserRepository.findAllByExpense(expense));
            expenseOwingUsers.addAll(expenseOwingUserRepository.findAllByExpense(expense));
        }

        return settleUpTransactionsCalculatorStrategy.getTransaction(expensePayingUsers,expenseOwingUsers);
    }

}
