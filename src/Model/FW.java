package Model;

import java.util.List;

public class FW extends FieldPlayer{
    private final Position curPosition = Position.FORWARD;

    /**
     * Empty Constructor
     */
    public FW() {
        super();
        super.setOverall(calcOverall());
    }

    /**
     * Constructor with field player
     * @param fp Field Player
     */
    public FW(FieldPlayer fp) {
        super(fp);
        super.setPosition(fp.getPosition());
        super.setOverall(calcOverall());
    }

    /**
     * Constructor with player ID, name, current team name and historic
     * @param id Player ID
     * @param name Player name
     * @param currentTeam Player current team name
     * @param historic Player historic
     */
    public FW(String id, String name, String currentTeam, List<String> historic) {
        super(id, name, currentTeam, historic);
        super.setPosition(curPosition);
        super.setOverall(calcOverall());
    }

    /**
     * Constructor with player ID, name and current team name
     * @param id Player ID
     * @param name Player name
     * @param currentTeam Player current team name
     */
    public FW(String id, String name, String currentTeam) {
        super(id, name, currentTeam);
        super.setPosition(curPosition);
        super.setOverall(calcOverall());
    }

    /**
     * Constructor with player, attributes and position
     * @param p Player
     * @param velocity Player velocity
     * @param endurance Player endurance
     * @param skill Player skill
     * @param impulsion Player impulsion
     * @param heading Player heading
     * @param finishing Player finishing
     * @param passing Player passing
     * @param crossing Player crossing
     * @param ballRecovery Player ball recovery
     * @param positioning Player positioning
     * @param creativity Player creativity
     * @param aggressiveness Player aggressiveness
     * @param tackling Player tackling
     * @param vision Player vision
     * @param position Player position
     */
    public FW(Player p, int velocity, int endurance, int skill, int impulsion, int heading, int finishing, int passing, int crossing, int ballRecovery, int positioning, int creativity, int aggressiveness, int tackling, int vision, Position position) {
        super(p, velocity, endurance, skill, impulsion, heading, finishing, passing, crossing, ballRecovery, positioning, creativity, aggressiveness, tackling, vision, position);
        super.setOverall(calcOverall());
    }

    /**
     * Constructor with player ID, name, current team name and historic
     * @param id Player ID
     * @param name Player name
     * @param currentTeam Player current team
     * @param historic Player historic
     * @param velocity Player velocity
     * @param endurance Player endurance
     * @param skill Player skill
     * @param impulsion Player impulsion
     * @param heading Player heading
     * @param finishing Player finishing
     * @param passing Player passing
     * @param crossing Player crossing
     * @param ballRecovery Player ball recovery
     * @param positioning Player positioning
     * @param creativity Player creativity
     * @param aggressiveness Player aggressiveness
     * @param tackling Player tackling
     * @param vision Player vision
     * @param position Player position
     */
    public FW(String id, String name, String currentTeam, List<String> historic, int velocity, int endurance, int skill, int impulsion, int heading, int finishing, int passing, int crossing, int ballRecovery, int positioning, int creativity, int aggressiveness, int tackling, int vision, Position position) {
        super(id, name, currentTeam, historic, velocity, endurance, skill, impulsion, heading, finishing, passing, crossing, ballRecovery, positioning, creativity, aggressiveness, tackling, vision, position);
        super.setOverall(calcOverall());
    }

    /**
     * Constructor with Player ID, name, current team name, attributes and position
     * @param id Player ID
     * @param name Player name
     * @param currentTeam Player current team name
     * @param velocity Player velocity
     * @param endurance Player endurance
     * @param skill PLayer skill
     * @param impulsion Player impulsion
     * @param heading Player heading
     * @param finishing Player finishing
     * @param passing Player passing
     * @param crossing Player crossing
     * @param ballRecovery Player ball recovery
     * @param positioning Player positioning
     * @param creativity Player creativity
     * @param aggressiveness Player aggressiveness
     * @param tackling Player tackling
     * @param vision Player vision
     * @param position Player position
     */
    public FW(String id, String name, String currentTeam, int velocity, int endurance, int skill, int impulsion, int heading, int finishing, int passing, int crossing, int ballRecovery, int positioning, int creativity, int aggressiveness, int tackling, int vision, Position position) {
        super(id, name, currentTeam, velocity, endurance, skill, impulsion, heading, finishing, passing, crossing, ballRecovery, positioning, creativity, aggressiveness, tackling, vision, position);
        super.setOverall(calcOverall());
    }

    /**
     * Copy Constructor
     * @param f Forward to copy
     */
    public FW(FW f){
        super(f.getId(), f.getName(), f.getCurrentTeamName(), f.getHistoric(), f.getVelocity(), f.getEndurance(), f.getSkill(), f.getImpulsion(), f.getHeading(), f.getFinishing(), f.getPassing(), f.getCrossing(), f.getBallRecovery(), f.getPositioning(), f.getCreativity(), f.getAggressiveness(), f.getTackling(), f.getVision(), f.getPosition());
        super.setOverall(calcOverall());
    }

    /**
     * Cloning method
     * @return Cloned forward
     */
    public FW clone(){
        return new FW(this);
    }

    /**
     * Current player position getter
     * @return Current player position
     */
    public Position getCurPosition(){
        return this.curPosition;
    }

    /**
     * Method to calculate player overall playing as forward
     * @return Player overall playing as forward
     */
    public int calcOverall() {
        int newPositioning;
        if (this.getPosition().equals(this.curPosition))
            newPositioning = this.getPositioning();

        else if (this.getPosition().equals(Position.WINGER))
            newPositioning = (int) (this.getPositioning() * 0.75);

        else if (this.getPosition().equals(Position.MIDFIELDER))
            newPositioning = (int) (this.getPositioning() * 0.5);

        else
            newPositioning = (int) (this.getPositioning() * 0.25);

        return (int) ((this.getTackling() * 0.01) + (this.getAggressiveness() * 0.05) + (this.getCreativity() * 0.03) +
                (this.getFinishing() * 0.25) + (this.getCrossing() * 0.01) + (this.getBallRecovery() * 0.01) +
                (newPositioning * 0.09) + (this.getVision() * 0.08) + (this.getPassing() * 0.05) +
                (this.getHeading() * 0.1) + (this.getImpulsion() * 0.07) + (this.getSkill() * 0.1) +
                (this.getEndurance() * 0.04) + (this.getVelocity() * 0.11));
    }

    /**
     * Updates an attribute to a new value
     * @param attribute Attribute signature
     * @param newValue New value
     */
    public void updateAttribute(int attribute, int newValue) throws InvalidAttributeException
    {
        switch (attribute)
        {
            case 1:
                this.setVelocity(newValue);
                this.calcOverall();
                break;

            case 2:
                this.setEndurance(newValue);
                this.calcOverall();
                break;

            case 3:
                this.setSkill(newValue);
                this.calcOverall();
                break;

            case 4:
                this.setImpulsion(newValue);
                this.calcOverall();
                break;

            case 5:
                this.setHeading(newValue);
                this.calcOverall();
                break;

            case 6:
                this.setFinishing(newValue);
                this.calcOverall();
                break;

            case 7:
                this.setPassing(newValue);
                this.calcOverall();
                break;

            case 8:
                this.setCrossing(newValue);
                this.calcOverall();
                break;

            case 9:
                this.setBallRecovery(newValue);
                this.calcOverall();
                break;

            case 10:
                this.setPositioning(newValue);
                this.calcOverall();
                break;

            case 11:
                this.setCreativity(newValue);
                this.calcOverall();
                break;

            case 12:
                this.setAggressiveness(newValue);
                this.calcOverall();
                break;

            case 13:
                this.setTackling(newValue);
                this.calcOverall();
                break;

            case 14:
                this.setVision(newValue);
                this.calcOverall();
                break;

            default:
                throw new InvalidAttributeException("The attribute your inserted doesn't exist.");
        }
    }

    /**
     * Method to get Forward as String
     * @return Forward as String
     */
    public String toString(){
        StringBuilder sb = new StringBuilder(super.toString())
                .append(" | Forward\n");
        return sb.toString();
    }
}
