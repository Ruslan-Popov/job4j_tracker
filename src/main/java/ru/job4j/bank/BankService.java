package ru.job4j.bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        Optional<User> rsl = findByPassport(passport);
        if (rsl.isPresent()) {
            if (!users.get(rsl.get()).contains(account)) {
                users.get(rsl.get()).add(account);
            }
        }
    }

    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst();
    }

    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> rst = this.findByPassport(passport);
        if (rst.isPresent()) {
            return users.get(rst.get())
                    .stream()
                    .filter(account -> account.getRequisite().equals(requisite))
                    .findFirst();
        }
        return Optional.empty();
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> srcAccountOpt = this.findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccountOpt = this.findByRequisite(destPassport, destRequisite);
        Account srcAccount = null;
        if (srcAccountOpt.isPresent()) {
            srcAccount = srcAccountOpt.get();
        }
        Account destAccount = null;
        if (destAccountOpt.isPresent()) {
            destAccount = destAccountOpt.get();
        }

        if (srcAccount != null && amount <= srcAccount.getBalance() && destAccount != null) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
