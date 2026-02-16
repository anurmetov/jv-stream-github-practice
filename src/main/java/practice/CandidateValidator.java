package practice;

import model.Candidate;

import java.util.List;
import java.util.function.Predicate;

public class CandidateValidator {
    private static final String REQUIUERED_NATIONALITY = "Ukrainian";
    private static final int MIN_AGE = 35;
    private static final int MIN_RESIDENCY_YEARS_UKRAINE = 10;

    public List<String> areEligibleToApplyForPresidentPosition(List<Candidate> candidatesList) {
        Predicate<Candidate> isEligibleForPresident = candidate ->
                candidate.getAge() >= MIN_AGE
                        && candidate.isAllowedToVote()
                        && candidate.getNationality().equalsIgnoreCase(REQUIUERED_NATIONALITY)
                        && livedYearsInUkraine(candidate) >= MIN_RESIDENCY_YEARS_UKRAINE;

        return candidatesList
                .stream()
                .filter(isEligibleForPresident)
                .map(Candidate::getName)
                .sorted()
                .toList();
    }

    private int livedYearsInUkraine(Candidate candidate) {
        return Integer.parseInt(candidate.getPeriodsInUkr().split("-")[1])
                - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[0]);
    }
}
