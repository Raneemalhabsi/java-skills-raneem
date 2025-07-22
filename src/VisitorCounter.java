public class VisitorCounter {
    // Static variable to count total visitors
    private static int totalVisitors = 0;
    // Non-static variable for individual session
    private int sessionVisits;
    private String visitorName;

    // Constructor
    public VisitorCounter(String name) {
        this.visitorName = name;
        this.sessionVisits = 0;
        totalVisitors++; // Increment total when new visitor is created
    }
    // Non-static method
    public void recordVisit() {
        sessionVisits++;
        System.out.println(visitorName + " visited. Session visits: " +
                sessionVisits);
    }
    // Static method
    public static void displayTotalVisitors() {
        System.out.println("Total visitors today: " + totalVisitors);
    }
    // Static method to get total (getter)
    public static int getTotalVisitors() {
        return totalVisitors;
    }
    public static void main(String[] args) {
        VisitorCounter Ali = new VisitorCounter("Ali");
        VisitorCounter Amal = new VisitorCounter("Amal");
        VisitorCounter Reem = new VisitorCounter("Reem");

        Ali.recordVisit();
        Ali.recordVisit();
        Ali.recordVisit();
        Amal.recordVisit();
        Reem.recordVisit();
        Reem.recordVisit();

        displayTotalVisitors();
    }
}
