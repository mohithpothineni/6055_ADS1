/**
 * Class for cricket team.
 */
class CricketTeam implements Comparable<CricketTeam> {
    /**
     * name of the team.
     */
    private String name;

    /**
     * number of wins.
     */
    private int wins;

    /**
     * number of losses.
     */
    private int losses;

    /**
     * number of draws.
     */
    private int draws;

    /**
     * Constructs the object.
     *
     * @param      namee    The name of team.
     * @param      winss    no of wins of team.
     * @param      lossess  no of losses of team.
     * @param      drawss   no of drawss of team.
     */
    CricketTeam(final String namee, final String winss,
        final String lossess, final String drawss) {
        this.name = namee;
        this.wins = Integer.parseInt(winss);
        this.losses = Integer.parseInt(lossess);
        this.draws = Integer.parseInt(drawss);
    }

    /**
     * Getter for the name.
     *
     * @return     The name of team.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter for the wins.
     *
     * @return     no of wins of team.
     */
    public int getWins() {
        return this.wins;
    }

    /**
     * Getter for the losses.
     *
     * @return     The losses of the team.
     */
    public int getLosses() {
        return this.losses;
    }

    /**
     * Getter for the draws.
     *
     * @return    The draws of the team.
     */
    public int getDraws() {
        return this.draws;
    }

    /**
     * comparator defines the comparision methodology
     * and returns a number based on comaparision.
     *
     * @param      otherteam     other team to be compared with.
     *
     * @return    int flag based on comparision.
     */
    public int compareTo(final CricketTeam otherteam) {
        if (this.wins > otherteam.wins) {
            return 1;
        }
        if (this.wins < otherteam.wins) {
            return -1;
        }
        if (this.losses < otherteam.losses) {
            return 1;
        }
        if (this.losses > otherteam.losses) {
            return -1;
        }
        if (this.draws > otherteam.draws) {
            return 1;
        }
        if (this.draws < otherteam.draws) {
            return -1;
        }
        return 0;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return this.name;
    }

}
