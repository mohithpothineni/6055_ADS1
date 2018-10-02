/**
 * Class for teams.
 */
class Teams {
	/**
	 * teams array.
	 */
	CricketTeam[] teams;
	
	/**
	 * size of list.
	 */
	private int size;
	
	/**
	 * Constructs the object.
	 */
	Teams() {
		teams = new CricketTeam[10];
		size = 0;
	}
	
	/**
	 * Adds a cricket team.
	 *
	 * @param      t     team to be added.
	 * 
	 * Time complexity : O(1)
	 * it requores constant time to add the element.
	 */
	public void addCricketTeam(CricketTeam team) {
		teams[size++] = team;
	}
	
	/**
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
	public String toString() {
		String s = "";
		for (int i = 0; i < size; i++) {
			s += teams[i].getName()+",";
		}
		return s.substring(0, s.length() - 1);
	}
	
	

}