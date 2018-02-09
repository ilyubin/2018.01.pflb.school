package ok.automation.models.api.group.getUserGroupsByIds;

import ok.automation.tech.extensions.BaseModel;

public class GroupGetUserGroupsByIdsRequest extends BaseModel {
    public String method;
    public String group_id;
    public String[] uids;
}
