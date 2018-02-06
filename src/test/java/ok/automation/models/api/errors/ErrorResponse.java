package ok.automation.models.api.errors;

import ok.automation.tech.extensions.BaseModel;

public class ErrorResponse extends BaseModel {
    public int error_code;
    public String error_msg;
    public Object error_data;
}
