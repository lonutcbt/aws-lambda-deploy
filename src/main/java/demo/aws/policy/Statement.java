package demo.aws.policy;

import java.io.Serializable;

public class Statement implements Serializable {

    private static final String ALLOW_ALL = "*";
    private static final String EXECUTE_API_ARN_FORMAT = "arn:aws:execute-api:%s:%s:%s/%s/%s/%s";

    private String effect;
    private String action = "execute-api:Invoke";
    private String resource;

    public Statement(String effect) {
        this.effect = effect;
    }

    public Statement() {

    }

    public String getEffect() {
        return effect;
    }

    public String getAction() {
        return action;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(final ContextMetadata contextMetadata) {
        this.resource = String.format(EXECUTE_API_ARN_FORMAT,
                contextMetadata.getRegion(),
                contextMetadata.getAccountId(),
                contextMetadata.getApiId(),
                contextMetadata.getStage(),
                ALLOW_ALL,
                ALLOW_ALL);
    }
}
