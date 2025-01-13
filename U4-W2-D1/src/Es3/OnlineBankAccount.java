package Es3;

public class OnlineBankAccount extends BankAccount {
	private double maxWithdraw;

	public OnlineBankAccount (String owner, double balance, double maxWithdraw) {
		super(owner, balance);
		this.maxWithdraw = maxWithdraw;
	}

	public void printBalance () {
		System.out.printf("""
			%s:
			- Balance: %.2f
			- Number of movements: %d
			- Max movements: %d
			- Max Withdraw: %.2f
			""",
			this.owner,
			this.balance,
			this.numberOfMovements,
			BankAccount.MAX_MOVEMENTS,
			this.maxWithdraw
		);
	}

	@Override
	public void withdraw(double money) {
		if (money <= this.maxWithdraw) super.withdraw(money);
		else throw new BankException("Withdraw not available!");
	}

	@Override
	public String toString () {
		return "OnlineBankAccount{" +
			"maxWithdraw=" + maxWithdraw +
			", owner='" + owner + '\'' +
			", balance=" + balance +
			", numberOfMovements=" + numberOfMovements +
			'}';
	}
}
