package ok.automation.tech.extensions;

import org.apache.commons.lang3.builder.ToStringBuilder;

public abstract class BaseModel {
    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this).split(".models.")[1];
    }
}
