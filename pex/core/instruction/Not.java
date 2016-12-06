package pex.core.instruction;

// TODO: remove these if we're to put Expression right under core/
import pex.core.expression.*;


public class Not extends UnaryExpression {
	public Not(Expression arg) {
		super(arg);
	}

	public String getAsText() {
		return "(not " + getArgument().getAsText() + ")";
	}

	public Literal evaluate() {
		// FIXME
		return null;
	}
}
