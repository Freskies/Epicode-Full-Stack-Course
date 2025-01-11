public record PlayerActions(int numberOfActions, String mediaActions) {

	/**
	 * Get the number of actions
	 *
	 * @return the number of actions
	 */
	public int getNumberOfActions () {
		return this.numberOfActions;
	}

	public boolean isValidAction (int action) {
		return 0 < action && action <= this.numberOfActions;
	}

	@Override
	public String toString () {
		return this.mediaActions;
	}
}
