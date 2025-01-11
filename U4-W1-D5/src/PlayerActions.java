public record PlayerActions(int numberOfActions, String mediaActions) {

	/**
	 * Get the number of actions
	 *
	 * @return the number of actions
	 */
	public int getNumberOfActions () {
		return this.numberOfActions;
	}

	/**
	 * Check if the action is valid.
	 * An action is valid if it is greater than 0 and less than or equal to the number of actions.
	 *
	 * @param action the action to check
	 * @return true if the action is valid, false otherwise
	 */
	public boolean isValidAction (int action) {
		return 0 < action && action <= this.numberOfActions;
	}

	@Override
	public String toString () {
		return this.mediaActions;
	}
}
