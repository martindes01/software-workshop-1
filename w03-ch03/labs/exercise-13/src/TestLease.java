/**
 * TestLease
 */
public class TestLease {

    public static void main(String[] args) {
        Lease lease1 = new Lease("Alice", 1, 500, 12);
        Lease lease2 = new Lease("Bob", 2, 450, 12);
        Lease lease3 = new Lease("Eve", 3, 550, 6);
        Lease lease4 = new Lease();

        showValues(lease1);
        showValues(lease2);
        showValues(lease3);
        showValues(lease4);

        lease4.addPetFee();

        showValues(lease4);
    }

    public static void showValues(Lease lease) {
        System.out.println("Tenant: " + lease.getTenantName() + ", Apartment: " + lease.getApartmentNumber()
                + ", Monthly rent: $" + lease.getMonthlyRent() + ", Term: " + lease.getTermMonths() + " months");
    }

}
