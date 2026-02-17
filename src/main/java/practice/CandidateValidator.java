package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MIN_AGE = 35;
    private static final int MIN_RESIDENCY_YEARS_UKRAINE = 10;

    private int livedYearsInUkraine(Candidate candidate) {
        String[] parts = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(parts[1])
                - Integer.parseInt(parts[0]);
    }

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                        && candidate.isAllowedToVote()
                        && candidate.getNationality().equalsIgnoreCase(REQUIRED_NATIONALITY)
                        && livedYearsInUkraine(candidate) >= MIN_RESIDENCY_YEARS_UKRAINE;
    }
}
