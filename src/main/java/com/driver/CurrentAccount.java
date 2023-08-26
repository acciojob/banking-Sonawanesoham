package com.driver;

import java.util.Arrays;

public class CurrentAccount extends BankAccount {
    private String tradeLicenseId;

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        super(name, balance, 5000);
        this.tradeLicenseId = tradeLicenseId;
        if (balance < 5000) {
            throw new Exception("Insufficient Balance");
        }
    }

    public void validateLicenseId() throws Exception {
        char[] licenseChars = tradeLicenseId.toCharArray();
        boolean valid = true;
        for (int i = 0; i < licenseChars.length - 1; i++) {
            if (licenseChars[i] == licenseChars[i + 1]) {
                valid = false;
                break;
            }
        }
        if (!valid) {
            Arrays.sort(licenseChars);
            String sortedLicenseId = new String(licenseChars);
            System.out.println("Rearranged License ID: " + sortedLicenseId);
        }
    }
}
