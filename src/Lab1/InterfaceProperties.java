package lab1;

interface Manager{
	public void hired();
	public void fired();
	static void Decision(){
		System.out.println("");
	}
	default void ConductMeeting() {
		System.out.println("Conduct meeting with team");
	}
}
interface Employee{
	void Detail();
}

class TeamManager implements Manager, Employee{
	public void hired() {
		System.out.println("Prabesh was hired");
	}
	
	public void fired() {
		System.out.println("Panta was fired");
	}
	
	@Override
	public void ConductMeeting() {
		System.out.println("Conduct detail meeting with the team member");
	}
	
	public void Detail() {
		System.out.println("I am the employee of XYZ company");
	}
}
public class InterfaceProperties {
    public static void main(String[] args) {
        Manager.Decision();
        TeamManager manager = new TeamManager();
        
        // Use the TeamManager object
        manager.hired();
        manager.fired();
        manager.ConductMeeting();
        manager.Detail();
    }
}