package SplitWise.services.settleup.strategies;

import SplitWise.models.Expense;
import SplitWise.models.ExpenseOwingUser;
import SplitWise.models.ExpensePayingUser;
import SplitWise.services.settleup.Transaction;

import java.util.List;

public interface SettleUpTransactionsCalculatorStrategy {

    List<Transaction> getTransaction(List<ExpensePayingUser> expensePayingUsers, List<ExpenseOwingUser> expenseOwingUsers);

}
