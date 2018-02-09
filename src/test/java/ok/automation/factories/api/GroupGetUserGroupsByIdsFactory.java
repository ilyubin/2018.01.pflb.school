package ok.automation.factories.api;

import ok.automation.models.api.group.getUserGroupsByIds.GroupGetUserGroupsByIdsRequest;

public abstract class GroupGetUserGroupsByIdsFactory {
    public static final String METHOD = "group.getUserGroupsByIds";
    public static final String GROUP_ID = "53038939046008";
    public static final String[] UIDS = {"591420938271", "585960467204", "566211137494"};

    public static GroupGetUserGroupsByIdsRequest withAllUids() {
        GroupGetUserGroupsByIdsRequest data = new GroupGetUserGroupsByIdsRequest();
        data.method = METHOD;
        data.group_id = GROUP_ID;
        data.uids = UIDS;
        return data;
    }
}
