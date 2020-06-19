package account;

import java.util.List;

public class AccountImpl implements Account {

    List<Account> currentAccount;
    List<Account> savingAccount;

    @Override
    public List<Account> getCurrentAccounts() {
        return currentAccount;
    }

    @Override
    public List<Account> getSavingAccounts() {
        return null;
    }

    @Override
    public List<Account> setCurrentAccounts() {
        return null;
    }

    /**
     *
     * @param accounts - account value to set in customer's saving account
     */
    @Override
    public void setSavingAccounts(List<Account> accounts) {
        // TODO this should be removed and method implemented
    }

    @Override
    public void setCurrentAccounts(List<Account> accounts) {

    }
}
