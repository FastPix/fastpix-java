package io.fastpix.sdk;

/**
 * TEMPORARY probe to verify that SonarCloud CI analysis actually reports issues.
 * This class intentionally contains code smells/bugs. DELETE after confirming the
 * issues show up on the SonarCloud dashboard.
 */
public class SonarProbe {

    public int check(int value) {
        int unused = 42;          // S1481: unused local variable
        String s = "dup";         // S1192 candidate + below
        System.out.println(s);    // S106: replace standard output by a logger
        System.out.println("dup");
        System.out.println("dup");
        if (value == value) {     // S1764: identical operands / S2589: always true
            return 1;
        }
        return 0;
    }

    public void empty() {
        // S1186: empty method body
    }
}
