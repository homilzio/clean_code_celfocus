package account;

import java.util.List;

public interface Account {
    List<Account> getCurrentAccounts();
    List<Account> getSavingAccounts();
    List<Account> setCurrentAccounts();
    void setSavingAccounts(List<Account> accounts);
    void setCurrentAccounts(List<Account> accounts);
}
