package pex.core;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.io.Serializable;

import pex.core.expression.*;

public class Program implements Serializable {
	private String _name = "";
	private List<Expression> _exps = new ArrayList<Expression>();

	public Program(String name) {
		_name = name;
	}

	public String getName() {
		return _name;
	}

	public void add(int idx, Expression exp) {
		_exps.add(idx, exp);
	}

	public void replace(int idx, Expression exp) {
		_exps.set(idx, exp);
	}

	public void set(Collection<Expression> exps) {
		_exps.clear();
		_exps.addAll(exps);
	}

	public void setIdentifierValue(Identifier id, Literal value) {
		// FIXME: what do we do here?
	}

	public Literal getIdentifierValue(Identifier id) {
		return id.evaluate();
	}

	public Literal execute() {
		Literal retval = null;
		for (Expression line : _exps) {
			retval = line.evaluate();
		}
		return retval;
	}

	public String getAsText() {
		String result = "";
		for (Expression exp : _exps) {
			result += exp.getAsText() + "\n";
		}
		return result;
	}

	public int getNumExpressions() {
		return _exps.size();
	}
}
