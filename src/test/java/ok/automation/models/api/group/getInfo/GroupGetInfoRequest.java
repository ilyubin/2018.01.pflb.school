package ok.automation.models.api.group.getInfo;

import ok.automation.tech.extensions.BaseModel;

public class GroupGetInfoRequest extends BaseModel {
    public String method;
    public String[] uids;
    public boolean move_to_top;
    public String[] fields;
}
