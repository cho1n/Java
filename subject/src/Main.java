class Wallet {

    private int balance; // 캡슐화
    private int incryption;

    Wallet(Coin coin, int balance, String passwd) {
        this.balance = coin.coinWorth() * balance;
        if (passwd.equals("")) {
            incryption = -1;
        } else {
            incryption = passwd.length() + (int)passwd.charAt(0)  + (int)passwd.charAt(passwd.length() - 1) - 1;
        }
    }

    void show() {
        System.out.println("현재 잔고: " + balance + "원");
    }

    void transfer(Coin coin, Wallet toWallet, int num, String passwd) {
        int tmp = passwd.length() + (int)passwd.charAt(0) + (int)passwd.charAt(passwd.length() - 1) - 1;
        if (tmp == this.incryption) {
            if (this.balance >= coin.coinWorth() * num) {
                this.balance -= coin.coinWorth() * num;
                toWallet.balance += coin.coinWorth() * num;
            } else {
                System.out.println("현재 지갑의 잔고가 부족합니다.");
            }
        } else {
            System.out.println("비밀번호가 올바르지 않습니다.");
        }
    }
}

class Coin {

    private int worth; // 캡슐화
    private String name;

    Coin(int worth, String name) {
        this.name = name;
        this.worth = worth;
    }

    int coinWorth() {
        return this.worth;
    }

    void show() {
        System.out.println("현재 " + this.name + "의 가치는 " + this.worth + "원 입니다.");
    }
}

public class Main {

    public static void main(String[] args) {
        Coin cryptoCoin = new Coin(3540, "cryptoCoin");
        Wallet myWallet = new Wallet(cryptoCoin, 3, "12343210");
        Wallet anotherWallet = new Wallet(cryptoCoin, 5, "00009999");

        cryptoCoin.show();
        myWallet.show();
        anotherWallet.show();

        myWallet.transfer(cryptoCoin, anotherWallet, 2, "12343210");
        anotherWallet.transfer(cryptoCoin, myWallet, 2, "12343210");
        myWallet.transfer(cryptoCoin, anotherWallet, 6, "12343210");
        anotherWallet.transfer(cryptoCoin, myWallet, 6, "00009999");

        myWallet.show();
        anotherWallet.show();
    
    }
}