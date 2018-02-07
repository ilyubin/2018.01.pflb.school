package ok.automation.suites;

import ok.automation.features.api.GroupGetCountersStory;
import ok.automation.features.api.GroupGetInfoStory;
import ok.automation.features.api.SearchTagMentionsStory;
import ok.automation.features.api.UsersGetCurrentUserStory;
import org.junit.Test;
import org.junit.experimental.ParallelComputer;
import org.junit.runner.JUnitCore;

public class RunAllApiTestsInParallel {
    @Test
    public void test() {
        Class[] cls = {
                GroupGetCountersStory.class,
                GroupGetInfoStory.class,
                SearchTagMentionsStory.class,
                UsersGetCurrentUserStory.class};
        JUnitCore.runClasses(ParallelComputer.methods(), cls);
    }
}
