import java.util.ArrayList;
import java.util.Scanner;

public class Detail {
    private int income;
    private int balance;
    private String comment;
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    //show記帳選單
    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Detail> A = new ArrayList<>();
        while (true) {
            System.out.println("======記帳選單======");
            System.out.println("1 顯示明細");
            System.out.println("2 收益入帳");
            System.out.println("3 消費金額");
            System.out.println("4 退   出");
            System.out.println("輸入功能 (1~4)");
            int function = sc.nextInt();
            switch (function) {
                case 1:
                    //顯示明細
                    this.showdetail(A);
                    break;
                case 2:
                    //收益入帳
                    this.income(A, sc);
                    break;
                case 3:
                    //消費金額
                    this.comsume(A, sc);
                    break;
                case 4:
                    //退出
                    break;
                default:
                    System.out.println("輸入有誤");
            }
            //退出
            if (function == 4 && this.exit(function, sc)) {
                System.out.println("退出APP");
                break;
            }
        }
    }
    //顯示明細方法,把array顯示
    public void showdetail(ArrayList<Detail> A) {
        System.out.println("=======明細========");
        System.out.println("資訊\t\t金額\t\t餘額\t\t時間");
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) != null) {
                System.out.print(A.get(i).comment +"\t");
                System.out.print(A.get(i).income +"\t");
                System.out.print(A.get(i).balance +"\t");
                System.out.print(A.get(i).date +"\t");
                System.out.println("");
            }else {
                break;
            }
        }
    }

    //收益入帳方法
    public void income(ArrayList<Detail> A, Scanner sc) {
        Detail detail = new Detail();
        DateForamtion dateForamtion = new DateForamtion();
        System.out.println("輸入收入金額");
        int incomemoney = sc.nextInt();
        if (incomemoney > 0) {
            System.out.println("輸入原因");
            String comment = sc.next();
            //賦值
            detail.setIncome(incomemoney);
            detail.setComment(comment);
            balance += incomemoney;
            detail.setBalance(balance);
            detail.setDate(dateForamtion.set());
            A.add(detail);
            System.out.println("添加成功~");
        }else {
            System.out.println("輸入錯誤!");
        }
    }

    // 消費金額
    public void comsume(ArrayList<Detail> A, Scanner sc){
        Detail detail = new Detail();
        DateForamtion dateForamtion = new DateForamtion();
        System.out.println("輸入消費金額");
        int comsumemoney = sc.nextInt();
        if (comsumemoney > 0) {
            System.out.println("輸入原因");
            String comment = sc.next();
            //賦值
            detail.setIncome(0- comsumemoney);//呈現負數在消費上
            balance +=(0- comsumemoney);
            detail.setDate(dateForamtion.set());
            detail.setComment(comment);
            detail.setBalance(balance);
            A.add(detail);
            System.out.println("添加成功~");
        }else {
            System.out.println("輸入錯誤!");
        }
    }

    //退出
    public boolean exit(int function , Scanner sc){
        String exit = "";
        while (true) {
            System.out.println("是否退出  y/n");
            exit = sc.next();
            if(exit.equals("y") || exit.equals("n")){
                break;
            }
        }
        if (exit.equals("y")){
            return true;
        }else {
            return false;
        }
    }



}
