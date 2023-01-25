package demo.aws;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayV2HTTPEvent;
import demo.aws.policy.AuthPolicy;
import demo.aws.policy.ContextMetadata;
import demo.aws.policy.PolicyDocument;
import demo.aws.policy.Statement;

public class LambdaAuthorizer implements RequestHandler<APIGatewayV2HTTPEvent, AuthPolicy> {

    private static final String ALLOW_STATEMENT = "Allow";
    private static final String DENY_STATEMENT = "Deny";
    private static final String MEMBER = "ionutCbt";
    private static final String REGION = "us-east-1";

    @Override
    public AuthPolicy handleRequest(APIGatewayV2HTTPEvent event, Context context) {
        String principalId = MEMBER;
        ContextMetadata contextMetadata = getContextMetadata(event);
        PolicyDocument policyDocument = getPolicyDocument(contextMetadata, ALLOW_STATEMENT);

        return new AuthPolicy(principalId, policyDocument);
    }

    private ContextMetadata getContextMetadata(final APIGatewayV2HTTPEvent event) {
        String accountId = event.getRequestContext().getAccountId();
        String stage = event.getRequestContext().getStage();
        String apiId = event.getRequestContext().getApiId();

        return new ContextMetadata(REGION, accountId, apiId, stage);
    }

    private PolicyDocument getPolicyDocument(final ContextMetadata contextMetadata, final String statementType) {
        Statement statement = new Statement(statementType);
        statement.setResource(contextMetadata);

        return new PolicyDocument(statement);
    }
}
