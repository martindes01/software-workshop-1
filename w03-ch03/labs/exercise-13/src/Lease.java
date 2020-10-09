/**
 * Lease
 */
public class Lease {

    private String tenantName;
    private int apartmentNumber;
    private int monthlyRent;
    private int termMonths;

    public Lease(String tenantName, int apartmentNumber, int monthlyRent, int termMonths) {
        this.tenantName = tenantName;
        this.apartmentNumber = apartmentNumber;
        this.monthlyRent = monthlyRent;
        this.termMonths = termMonths;
    }

    public Lease() {
        this("XXX", 0, 1000, 12);
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public int getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(int monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public int getTermMonths() {
        return termMonths;
    }

    public void setTermMonths(int termMonths) {
        this.termMonths = termMonths;
    }

    public void addPetFee() {
        monthlyRent += 10;
    }

    public static void explainPetPolicy() {
        System.out.println("A charge of $10 is added to the monthly rent for tenants who keep pets.");
    }

}
