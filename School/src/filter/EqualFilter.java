package filter;

import schoolSystem.Person;

public abstract class EqualFilter implements Filter{

	protected Object attribute;
	
	protected abstract String getAttr(Person p);
	
	public boolean applyFilter(Person p) {
		if(attribute.equals(getAttr(p)))
				return true;
		return false;
	}
}
