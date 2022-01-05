package interviewbit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EditDistanceTest {

    private static final String A1 = "b";
    private static final String B1 = "a";
    private static final int SOL1 = 1;

    private static final String A2 = "aac";
    private static final String B2 = "abac";
    private static final int SOL2 = 1;

    private static final String A3 = "babaaabaaab";
    private static final String B3 = "ababaabbab";
    private static final int SOL3 = 4;

    private static final String A4 = "baababaabababbaaabbbbbbababaaabbbbbbbabbabbababaaaabbbbabbbabaaababbabbbbabbab" +
            "aaaabababaaabbaababbababbaabbabaabaaabaaaaaabbaaababbabbbaababbbbbbbababaaabaabbabbaaba";
    private static final String B4 = "aaabababbbaaabaaaabbaabababbbababbabaabbbbbaabbabbabaaababbaaaabaaababaabaabaa" +
            "aaabbbaababbabaabaaaaabbaabaaabbbbbbbabbbababaabaaaabaabaaabbbbbbabbbbbabaaababbaaabbbabbabbaabaaababaa" +
            "aabbbbabaababbbaabbbbaabbbbbaaabbbbaaababbbaaaabbbbbbbbabbbabaabbabbbabaabbbbbbaabbabaabbbbbabbabbabbaa" +
            "bbbabbaaabaaababbaabaababbaabbaaabababbbaabbbbabaabbaababbabbabbabbbababaaaaaaaaaaaaaaaaabbaababbaaaabb" +
            "baaabbbbaabaaaaabaaabbbaabaaaababbaaba";
    private static final int SOL4 = 260;

    @Test
    public void testMinDistance() {
        EditDistance editDistance = new EditDistance();
        assertEquals(SOL1, editDistance.minDistance(A1, B1));
        assertEquals(SOL2, editDistance.minDistance(A2, B2));
        assertEquals(SOL3, editDistance.minDistance(A3, B3));
    }

    @Test
    public void testEfficientMinDistance() {
        assertEquals(SOL1, EditDistance.efficientMinDistance(A1, B1));
        assertEquals(SOL2, EditDistance.efficientMinDistance(A2, B2));
        assertEquals(SOL3, EditDistance.efficientMinDistance(A3, B3));
        assertEquals(SOL4, EditDistance.efficientMinDistance(A4, B4));
    }
}