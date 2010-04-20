package unif.type;

/** TypeList.java
	*
	* @author <a href="mailto:joque@me.com">Jose Ghislain Quenum</a>
	* @version 0.9 - 11/2009
*/

import java.util.LinkedList;
import java.util.List;

public final class TypeList {
	private final List<Type> elements = new LinkedList<Type>();
	
	public void addComponent(final Type tComp){
		elements.add(tComp);
	}	
	
	public void removeComponent(final Type tComp){
		elements.remove(tComp);
	}
	
	public List<Type> getElements(){
		return elements;
	}
	
	public int hashCode() {
		int hashCodeValue = 17;
		hashCodeValue = (37 * hashCodeValue) + elements.hashCode();			
		return hashCodeValue;
	}
	
	public boolean equals(Object anotherTypeList){
		final Class objClass = anotherTypeList.getClass();
		final String objClassName = objClass.getName();
		if(!(objClassName.equals("TypeList"))){
			return false;
		}
		
		final TypeList otherTypeList = (TypeList) anotherTypeList;
		return otherTypeList.getElements().equals(getElements());
	}
	
	public boolean equalSet(final TypeSet aTypeSet){
		//define the content of the method
		
		return false;
	}
}