package root;

public class Actor {

    public String firstName;
    public String lastName;
    public int dayShooting;
    public boolean promoTeam;
    public String role;

    public Actor(String f, String l, int s, boolean p, String r) {
        firstName = f;
        lastName = l;
        dayShooting = s;;
        promoTeam = p;
        role = r;
    }
    
    public String toString() {
    	return String.format("%s %s played %s, shot on day %d, and was%s in a promotional team"
    			, firstName, lastName, role, dayShooting, promoTeam 
    			? 
    					"" 
    					: " not");
    }

}
