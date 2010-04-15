package unif.type;

/** ChoiceComplexType.java
	*
	* @author <a href="mailto:joque@me.com">Jose Ghislain Quenum</a>
	* @version 0.9 - 11/2009
*/

import java.util.HashSet;
import java.util.Set;

public final class ChoiceComplexType extends ComplexTypeImpl {
	private static final String CLS_NAME = "ChoiceComplexType";
	private final TypeSet typeElements;	
	
	public ChoiceComplexType(){
		super("choice");
		typeElements = new TypeSet();
	}
	
	//add equals and hashCode methods
	
	public boolean isEquivalentToSimple(final SimpleTypeImpl secondTypeArg){
		boolean equivResult = true;
		
		if((! substitutions.checkDirectMapping(this, secondTypeArg)) || (! checkIntersection(secondTypeArg))){
			equivResult = false;
		} 
		
		return equivResult;
	}
	
	public boolean checkIntersection(final Type secondArgument){
		final Set<Type> myElements = typeElements.getElements();
		
		for(Type curEltType: myElements){
			if(curEltType.equals(secondArgument)){
				substitutions.addEntry(this, secondArgument);
				return true;
			}
		}
		return false;
	}
	
	public boolean isEquivalentToComplex(final ComplexTypeImpl secondTypeArg){
		//Might have to dig a little more

		return false;
	}
	
}
