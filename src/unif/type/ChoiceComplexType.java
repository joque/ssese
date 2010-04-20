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
	
	public TypeSet getElements(){
		return typeElements;
	}
	
	//add equals and hashCode methods
	
	public int hashCode() {
		int hashCodeValue = 17;
		hashCodeValue = (37 * hashCodeValue) + typeElements.hashCode();			
		return hashCodeValue;
	}
	
	public boolean equals(final Object secondTypeArg){
		boolean result = true ;
		
		if(! (secondTypeArg instanceof ChoiceComplexType)){
			result =  false;			
		} else {
			final ChoiceComplexType complexTypeObject = (ChoiceComplexType) secondTypeArg;
			final TypeSet complexTypeObjectElements = complexTypeObject.getElements();
			
			if(! complexTypeObjectElements.equals(this.getElements())) {
				result = false;
			}
		}
		return result;
	}
	
	public boolean isEquivalentToSimple(final SimpleTypeImpl secondTypeArg){
		boolean equivResult = true;
		
		if((! substitutions.checkDirectMapping(this, secondTypeArg)) || (! checkIntersection(secondTypeArg))){
			equivResult = false;
		} 
		
		return equivResult;
	}
	
	public boolean checkIntersection(final Type secondArgument){
		boolean result = false;
		final Set<Type> myElements = typeElements.getElements();
		
		for(Type curEltType: myElements){
			if(curEltType.equals(secondArgument)){
				substitutions.addEntry(this, secondArgument);
				result = true;
				break;
			}
		}
		return result;
	}
	
	public boolean isEquivalentToComplex(final ComplexTypeImpl secondTypeArg){
		boolean result = false;
		
		if(this.equals(secondTypeArg)) {
			result = true;			
		} else {
			final String secondTypeClsName = secondTypeArg.getClass().getSimpleName();
			if(secondTypeClsName.equals(CLS_NAME)){
				if(checkIntersection(secondTypeArg)){
					final Type myTypeMapper = substitutions.getValue(this);
					final Type secondTypeArgMapper = substitutions.getValue(secondTypeArg);
					
					if((myTypeMapper != null) && (secondTypeArgMapper != null)) {
						if(myTypeMapper.equals(secondTypeArgMapper)) {
							result = true;
						}
					}
				}		
			}
		}

		return result;
	}
	
}
