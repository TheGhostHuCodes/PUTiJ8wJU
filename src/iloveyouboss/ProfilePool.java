package iloveyouboss;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProfilePool {

    private List<Profile> profiles;

    public ProfilePool() { this.profiles = new ArrayList<>(); }

    public void add(Profile profile) { profiles.add(profile); }
    public void score(Criteria criteria) {
        for (Profile profile : profiles) {
            profile.matches(criteria);
        }
    }
    public List<Profile> ranked() {
        // Sort in descending order.
        Collections.sort(
            profiles, (p1, p2) -> ((Integer)p2.score()).compareTo(p1.score()));
        return profiles;
    }
}
