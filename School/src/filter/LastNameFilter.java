package filter;

import schoolSystem.Person;

public class LastNameFilter extends EqualFilter{

	public LastNameFilter(String name) {
		super.attribute = name;
	}
	

	protected String getAttr(Person p) {
		return p.getLastName();
	}

}
