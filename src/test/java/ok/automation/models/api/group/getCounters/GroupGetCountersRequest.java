package ok.automation.models.api.group.getCounters;

import ok.automation.tech.extensions.BaseModel;

public class GroupGetCountersRequest extends BaseModel {
    public String groupId;
    public String[] counterTypes;
}
