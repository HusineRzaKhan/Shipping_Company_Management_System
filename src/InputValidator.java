public class InputValidator {
    public static int getIntegerInput(String message, String fieldName) {
        while (true) {
            String input = javax.swing.JOptionPane.showInputDialog(message);
            if (input == null || input.trim().isEmpty()) {
                int choice = javax.swing.JOptionPane.showConfirmDialog(null, 
                    "Do you want to cancel the operation?",
                    "Cancel Operation",
                    javax.swing.JOptionPane.YES_NO_OPTION);
                if (choice == javax.swing.JOptionPane.YES_OPTION) {
                    return -1;
                }
                continue;
            }
            try {
                int value = Integer.parseInt(input.trim());
                if (value < 0) {
                    javax.swing.JOptionPane.showMessageDialog(null,
                        fieldName + " cannot be negative",
                        "Invalid Input",
                        javax.swing.JOptionPane.ERROR_MESSAGE);
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                javax.swing.JOptionPane.showMessageDialog(null,
                    "Please enter a valid number for " + fieldName,
                    "Invalid Input",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static String getStringInput(String message, String fieldName, boolean allowEmpty) {
        while (true) {
            String input = javax.swing.JOptionPane.showInputDialog(message);
            if (input == null) {
                int choice = javax.swing.JOptionPane.showConfirmDialog(null,
                    "Do you want to cancel the operation?",
                    "Cancel Operation",
                    javax.swing.JOptionPane.YES_NO_OPTION);
                if (choice == javax.swing.JOptionPane.YES_OPTION) {
                    return null;
                }
                continue;
            }
            input = input.trim();
            if (!allowEmpty && input.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(null,
                    fieldName + " cannot be empty",
                    "Invalid Input",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
                continue;
            }
            return input;
        }
    }

    public static long getPhoneInput(String message) {
        while (true) {
            String input = javax.swing.JOptionPane.showInputDialog(message);
            if (input == null || input.trim().isEmpty()) {
                int choice = javax.swing.JOptionPane.showConfirmDialog(null,
                    "Do you want to cancel the operation?",
                    "Cancel Operation",
                    javax.swing.JOptionPane.YES_NO_OPTION);
                if (choice == javax.swing.JOptionPane.YES_OPTION) {
                    return -1;
                }
                continue;
            }
            try {
                input = input.trim().replaceAll("[^0-9]", "");
                if (input.length() != 11) {
                    javax.swing.JOptionPane.showMessageDialog(null,
                        "Phone number must be 11 digits",
                        "Invalid Input",
                        javax.swing.JOptionPane.ERROR_MESSAGE);
                    continue;
                }
                return Long.parseLong(input);
            } catch (NumberFormatException e) {
                javax.swing.JOptionPane.showMessageDialog(null,
                    "Please enter a valid phone number",
                    "Invalid Input",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static String getCNICInput(String message) {
        while (true) {
            String input = javax.swing.JOptionPane.showInputDialog(message);
            if (input == null || input.trim().isEmpty()) {
                int choice = javax.swing.JOptionPane.showConfirmDialog(null,
                    "Do you want to cancel the operation?",
                    "Cancel Operation",
                    javax.swing.JOptionPane.YES_NO_OPTION);
                if (choice == javax.swing.JOptionPane.YES_OPTION) {
                    return null;
                }
                continue;
            }
            input = input.trim().replaceAll("[^0-9]", "");
            if (input.length() != 13) {
                javax.swing.JOptionPane.showMessageDialog(null,
                    "CNIC must be 13 digits",
                    "Invalid Input",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
                continue;
            }
            return input;
        }
    }
}