package automation.exercise.helpers;

import automation.exercise.models.Gender;

public class GenderFormatter {
    private GenderFormatter() {
        // private constructor — щоб ніхто не створював екземпляр
    }

    /**
     * Повертає відформатований префікс для імені користувача згідно з UI.
     * Наприклад:
     *  - MR  -> "Mr."
     *  - MRS -> "Mrs."
     */
    public static String format(Gender gender) {
        if (gender == null) {
            throw new IllegalArgumentException("Gender cannot be null");
        }

        return switch (gender) {
            case MR -> "Mr.";
            case MRS -> "Mrs.";
        };
    }
}
