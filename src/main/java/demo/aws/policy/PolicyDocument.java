package demo.aws.policy;

import java.io.Serializable;

public class PolicyDocument implements Serializable {

    private String version = "2012-10-17";
    private Statement statement;

    public PolicyDocument(final Statement statement) {
        this.statement = statement;
    }

    public String getVersion() {
        return version;
    }

    public Statement getStatement() {
        return statement;
    }
}
