public class Main {
    public static void main(String[] args) throws LimitException {
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(10000);
        while (true) {
            try {
                bankAccount.withDraw(5000);
            } catch (LimitException e) {
                try {
                    bankAccount.withDraw(e.getRemainingAmount());
                } catch (LimitException ex) {
                    ex.printStackTrace();
                }
            }
            break;
        }
    }
}