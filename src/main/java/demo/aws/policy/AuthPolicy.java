package demo.aws.policy;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class AuthPolicy implements Serializable {

    public static final String VERSION = "Version";
    public static final String STATEMENT = "Statement";
    public static final String EFFECT = "Effect";
    public static final String ACTION = "Action";
    public static final String RESOURCE = "Resource";

    private String principalId;
    private PolicyDocument policyDocument;

    public AuthPolicy(final String principalId, final PolicyDocument policyDocument) {
        this.principalId = principalId;
        this.policyDocument = policyDocument;
    }

    public String getPrincipalId() {
        return principalId;
    }

    public Map<String, Object> getPolicyDocument() {
        Statement statement = policyDocument.getStatement();
        Map<String, Object> serializableStatement = new HashMap<>();
        serializableStatement.put(EFFECT, statement.getEffect());
        serializableStatement.put(ACTION, statement.getAction());
        serializableStatement.put(RESOURCE, statement.getResource());

        Map<String, Object> serializablePolicy = new HashMap<>();
        serializablePolicy.put(VERSION, policyDocument.getVersion());
        serializablePolicy.put(STATEMENT, serializableStatement);

        return serializablePolicy;
    }
}
