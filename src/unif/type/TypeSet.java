package unif.type;

/** TypeSet.java
	*
	* @author <a href="mailto:joque@me.com">Jose Ghislain Quenum</a>
	* @version 0.9 - 11/2009
*/

import java.util.HashSet;
import java.util.Set;

public final class TypeSet {
	private final Set<Type> elements = new HashSet<Type>();
	
	public void addComponent(final Type tComp){
		elements.add(tComp);
	}	
	
	public void removeComponent(final Type tComp){
		elements.remove(tComp);
	}
	
	public Set<Type> getElements(){
		return elements;
	}
	
	public boolean equals(Object anotherTypeSet){
		final Class objClass = anotherTypeSet.getClass();
		final String objClassName = objClass.getName();
		if(!(objClassName.equals("TypeSet"))){
			return false;
		}
		
		final TypeSet otherTypeSet = (TypeSet) anotherTypeSet;
		return otherTypeSet.getElements().equals(getElements());
	}
}