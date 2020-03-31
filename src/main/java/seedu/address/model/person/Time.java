package seedu.address.model.person;

/**
 * Represents the time object that tracks the time spent for the user.
 */
public class Time {

    public static final String MINUTES_RANGE_ERROR = "Minutes must be within 0-59 (inclusive).";
    public static final String HOURS_RANGE_ERROR = "Hours must be 0 or more";
    public final String value;
    private int minutes;
    private int hours;

    public Time(int minutes, int hours) throws IllegalArgumentException {
        if (!(minutes <= 59 && minutes >= 0)) {
            throw new IllegalArgumentException(MINUTES_RANGE_ERROR);
        } else if (hours < 0) {
            throw new IllegalArgumentException(HOURS_RANGE_ERROR);
        } else {
            this.minutes = minutes;
            this.hours = hours;
        }
        if (minutes < 10) {
            value = hours + "0" + minutes;
        } else {
            value = "" + hours + minutes;
        }
    }

    public int getMinutes() {
        return this.minutes;
    }

    public int getHours() {
        return this.hours;
    }

    public void setMinutes(int minutes) throws IllegalArgumentException {
        if (!(minutes <= 59 && minutes >= 0)) {
            throw new IllegalArgumentException(MINUTES_RANGE_ERROR);
        } else {
            this.minutes = minutes;
        }
    }

    public void setHours(int hours) throws IllegalArgumentException {
        if (hours < 0) {
            throw new IllegalArgumentException(HOURS_RANGE_ERROR);
        } else {
            this.hours = hours;
        }
    }

    /**
     * Adds the input mins and hrs to the current Time
     */
    public Time addTime(int mins, int hrs) {
        int newMins;
        int newHrs;
        if (mins + this.getMinutes() >= 60) {
            newMins = (mins + this.getMinutes()) - 60;
            newHrs = (hrs + this.getHours()) + 1;
        } else {
            newMins = mins + this.getMinutes();
            newHrs = hrs + this.getHours();
        }
        return new Time(newMins, newHrs);
    }

    @Override
    public String toString() {
        return String.format("%s:%s", this.hours, this.minutes);
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Time)) {
            return false;
        }

        // state check
        Time t = (Time) other;
        return this.value.equals(t.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
