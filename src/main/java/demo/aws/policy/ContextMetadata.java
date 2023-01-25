package demo.aws.policy;

public class ContextMetadata {
    private String region;
    private String accountId;
    private String apiId;
    private String stage;

    public ContextMetadata(final String region, final String accountId, final String apiId, final String stage) {
        this.region = region;
        this.accountId = accountId;
        this.apiId = apiId;
        this.stage = stage;
    }

    public String getRegion() {
        return region;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getApiId() {
        return apiId;
    }

    public String getStage() {
        return stage;
    }
}
