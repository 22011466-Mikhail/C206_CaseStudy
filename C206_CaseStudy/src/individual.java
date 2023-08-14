import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

/*
	 
		while (functionOption != 4) {
			feeMenu();
			functionOption = Helper.readInt("Insert option > ");

			if (functionOption == 1) {
				String feeType = Helper.readString("Enter Fee Type (Tuition Fee/Exam Fee): ");
				double amount = Helper.readDouble("Enter Amount: ");
				String dueDate = Helper.readString("Enter Due Date(YYYY-mm-dd): ");

				C206_CaseStudy.addFee(feeList, feeType, amount, dueDate);
			} else if (functionOption == 2) {
				int feeIndexToDelete = Helper.readInt("Enter the index of the fee to delete: ");
				C206_CaseStudy.deleteFee(feeList, feeIndexToDelete);
			} else if (functionOption == 3) {
				viewAllFees(feeList);
			}
		}
	public static void feeMenu() {
		setHeader("FEE MENU");
		System.out.println("1. Add Fee");
		System.out.println("2. Remove Fee");
		System.out.println("3. View Fee");
		System.out.println("4. Quit");
		Helper.line(80, "-");
	}
	public static void viewAllFees(ArrayList<Fee> feeList) {
		System.out.println(String.format("%-20s %-10s %-15s", "FEE TYPE", "AMOUNT", "DUE DATE"));

		for (Fee fee : feeList) {
			System.out
					.println(String.format("%-20s %-10.2f %-15s", fee.getFeeType(), fee.getAmount(), fee.getDueDate()));
		}
		public static void addFee(ArrayList<Fee> feeList, String feeType, double amount, String dueDate) {
		Fee newFee = new Fee(feeType, amount, dueDate);
		feeList.add(newFee);
		System.out.println("Fee added successfully.");
	}
	public static void deleteFee(ArrayList<Fee> feeList, int feeIndex) {
		if (feeIndex >= 0 && feeIndex < feeList.size()) {
			feeList.remove(feeIndex);
			System.out.println("Fee deleted successfully.");
		} else {
			System.out.println("Invalid fee index.");
		}
		@Test
    public void testAddFee() {
        // Test that feeList is initially empty
        assertEquals("Test that feeList is empty", 0, feeList.size());

        // Add a fee
        C206_CaseStudy.addFee(feeList, "Tuition Fee", 1000.0, "2023-09-01");
        assertEquals("Test that feeList size is 1", 1, feeList.size());

        // Add another fee
        C206_CaseStudy.addFee(feeList, "Exam Fee", 500.0, "2023-10-01");
        assertEquals("Test that feeList size is 2", 2, feeList.size());
        
    }
	@Test
	public void testViewAllFees() {
	    // After adding 1 fee, test that size of list is 1 - normal
	    feeList.add(new Fee("Tuition Fee", 1000.0, "2023-09-01"));
	    assertEquals("Test that the size of list is 1", 1, feeList.size());

	    C206_CaseStudy.viewAllFees(feeList);
		}
		

    @Test
    public void testDeleteFee() {
        // Add fees to feeList
        feeList.add(new Fee("Tuition Fee", 1000.0, "2023-09-01"));
        feeList.add(new Fee("Exam Fee", 500.0, "2023-10-01"));

        // Delete a fee
        C206_CaseStudy.deleteFee(feeList, 0);
        assertEquals("Test that feeList size is 1 after deleting", 1, feeList.size());

        // Delete another fee
        C206_CaseStudy.deleteFee(feeList, 0);
        assertEquals("Test that feeList size is 0 after deleting", 0, feeList.size());
    }
    */
