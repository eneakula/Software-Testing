package org.example1;


public class BankAccount {
    private String name;

    private String surname;

    private double amount;

    public BankAccount(String name, String surname, double amount) {
        this.name = name;
        this.surname = surname;
        this.amount = amount;
    }

    public BankAccount() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    //1. deposit
    public void deposit(double amount) {
        if(amount > 0){
            this.amount += amount;
            return;
        }

        System.out.println("Invalid amount");
    }

    //2. withdraw
    public boolean withdraw(double amount) {
        if (amount <= 0){
            System.out.println("Invalid amount!");
            return false;
        }

        if (this.amount < amount){
            System.out.println("Not enough funds");
            return false;
        }

        this.amount -= amount;
        return true;
    }

    //3. transferTo
    public void transferTo(BankAccount bankAccount, double amount) {
        if (this.withdraw(amount)){
            bankAccount.deposit(amount);
            return;
        }

        System.out.println("Veprimi nuk eshte kryer me sukses");
    }

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("Gledis", "Lami", 1000);

        BankAccount account2 = new BankAccount("Kristian", "Lico", 500);

        account1.deposit(500);
        System.out.println("Gjendja e llogarise per " + account1.getName()
                + " pas depozite: " + account1.amount); // DUHET TE JETE 1500


        account1.withdraw(200);
        System.out.println("Gjendja e llogarise per " + account1.getName()
                + " pas withdraw 1: " + account1.amount); // DUHET TE JETE 1300

        account1.withdraw(1500);
        System.out.println("Gjendja e llogarise per " + account1.getName()
                + " pas withdraw 2: " + account1.amount); // DUHET TE JETE 1300

        account1.deposit(-1500);
        System.out.println("Gjendja e llogarise per " + account1.getName()
                + " pas deposit negativ: " + account1.amount); // DUHET TE JETE 1300

        account1.withdraw(-100);
        System.out.println("Gjendja e llogarise per " + account1.getName()
                + " pas withdraw negativ: " + account1.amount); // DUHET TE JETE 1300

        account1.transferTo(account2, 300);

        System.out.println("Gjendja e llogarise per " + account1.getName()
                + " pas transfer to: " + account1.amount); // DUHET TE JETE 1000

        System.out.println("Gjendja e llogarise per " + account2.getName()
                + " pas transfer to: " + account2.amount); // DUHET TE JETE 800


        account1.transferTo(account2, 2000);

        System.out.println("Gjendja e llogarise per " + account1.getName()
                + " pas transfer to: " + account1.amount); // DUHET TE JETE 1000

        System.out.println("Gjendja e llogarise per " + account2.getName()
                + " pas transfer to: " + account2.amount); // DUHET TE JETE 800


        account1.transferTo(account2, -100);

        System.out.println("Gjendja e llogarise per " + account1.getName()
                + " pas transfer to: " + account1.amount); // DUHET TE JETE 1000

        System.out.println("Gjendja e llogarise per " + account2.getName()
                + " pas transfer to: " + account2.amount); // DUHET TE JETE 800


    }
}

