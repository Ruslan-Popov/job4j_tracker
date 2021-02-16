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

//    public void addAccount(String passport, Account account) {
//        User user = findByPassport(passport);
//        Optional<User> rsl = Optional.of(user);
//        if (rsl.isPresent()) {
//            if (!users.get(user).contains(account)) {
//                users.get(user).add(account);
//            }
//        }
//    }

    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst();
    }

//    public User findByPassport(String passport) {
//        return users.keySet()
//                .stream()
//                .filter(user -> user.getPassport().equals(passport))
//                .findFirst()
//                .orElse(null);
//    }

    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> rst = this.findByPassport(passport);
        if (rst.isPresent()) {
            for (Account acc : users.get(rst.get())) {
                if (acc.getRequisite().equals(requisite)) {
                    return Optional.of(acc);
                }
            }
        }
        return Optional.empty();
    }

//    public Account findByRequisite(String passport, String requisite) {
//        User user = this.findByPassport(passport);
//        if (user != null) {
//            for (Account acc : users.get(user)) {
//                if (acc.getRequisite().equals(requisite)) {
//                    return acc;
//                }
//            }
//        }
//        return null;
//    }

//    public Account findByRequisite(String passport, String requisite) {
//        User user = findByPassport(passport);
//        if (user != null) {
//            return users.get(user)
//                    .stream()
//                    .filter(account -> account.getRequisite().equals(requisite))
//                    .findFirst()
//                    .orElse(null);
//        }
//        return null;
//    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> srcAccountOpt = this.findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccountOpt = this.findByRequisite(destPassport, destRequisite);
        Account srcAccount = srcAccountOpt.get();
        Account destAccount = destAccountOpt.get();

        if (amount <= srcAccount.getBalance()) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
