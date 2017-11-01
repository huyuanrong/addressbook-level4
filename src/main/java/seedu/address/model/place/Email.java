package seedu.address.model.place;

import seedu.address.commons.exceptions.IllegalValueException;

/**
 * Represents a Place's phone number in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidEmail(String)}
 */
public class Email {

    public static final String MESSAGE_EMAIL_CONSTRAINTS =
            "Place emails should be 2 alphanumeric/period strings separated by '@'";
    public static final String EMAIL_VALIDATION_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public static final String EMAIL_UNKNOWN = "-";

    public final String value;

    /**
     * Validates given email.
     *
     * @throws IllegalValueException if given email address string is invalid.
     */
    public Email(String email) throws IllegalValueException {
        //@@author aungmyin23
        if (email == null) {
            this.value = EMAIL_UNKNOWN;
        } else {
            String trimmedEmail = email.trim();
            if (!isValidEmail(trimmedEmail)) {
                throw new IllegalValueException((MESSAGE_EMAIL_CONSTRAINTS));
            }
            this.value = trimmedEmail;
        }
    }

    /**
     * Returns if a given string is a valid place email.
     */
    public static boolean isValidEmail(String test) {
        return test.matches(EMAIL_VALIDATION_REGEX) || test.equals(EMAIL_UNKNOWN);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Email // instanceof handles nulls
                && this.value.equals(((Email) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}