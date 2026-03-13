import java.beans.Expression;

public class AddNonTerminalExpression implements AbstractExpression {
    private final AbstractExpression rightExpression;
    private final AbstractExpression leftExpression;
    public AddNonTerminalExpression(AbstractExpression rightExpression, AbstractExpression leftExpression) {
        this.rightExpression = rightExpression;
        this.leftExpression = leftExpression;
    }

    @Override
    public int interpret(Context context) {
        return leftExpression.interpret(context) + rightExpression.interpret(context);
    }
}
