public class Fee {
    private String feeType;
    private double amount;
    private String dueDate;

    // Constructor
    public Fee(String feeType, double amount, String dueDate) {
        this.feeType = feeType;
        this.amount = amount;
        this.dueDate = dueDate;
    }

    // Getters and setters
    public String getFeeType() {
        return feeType;
    }

    public double getAmount() {
        return amount;
    }

    public String getDueDate() {
        return dueDate;
    }
}
