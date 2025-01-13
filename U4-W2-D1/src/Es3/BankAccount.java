package Es3;

public class BankAccount {
	protected static final int MAX_MOVEMENTS = 50;
	private static final double WITHDRAW_FEE = 0.5;

	protected String owner;
	protected int numberOfMovements = 0;
	protected double balance;

	public BankAccount(String owner, double balance) {
		this.owner = owner;
		this.balance = balance;
	}

	public void withdraw (double money) {
		double preview = this.previewWithdraw(money);
		if (preview < 0) throw new BankException("Balance cannot be negative!");
		else this.balance = preview;
		this.numberOfMovements++;
	}

	public double previewWithdraw (double money) {
		return this.balance - money -
			(this.numberOfMovements >= BankAccount.MAX_MOVEMENTS ? BankAccount.WITHDRAW_FEE : 0);
	}

	public double getBalance () {
		return this.balance;
	}
}
