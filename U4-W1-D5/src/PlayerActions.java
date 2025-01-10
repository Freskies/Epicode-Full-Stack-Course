public record PlayerActions(int numberOfActions, String mediaActions) {

	/**
	 * Get the number of actions
	 *
	 * @return the number of actions
	 */
	public int getNumberOfActions () {
		return this.numberOfActions;
	}

	@Override
	public String toString () {
		return this.mediaActions;
	}
}
