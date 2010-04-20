package unif.type;

/** AllComplexType.java
	*
	* @author <a href="mailto:joque@me.com">Jose Ghislain Quenum</a>
	* @version 0.9 - 11/2009
*/

import java.util.HashSet;
import java.util.Set;

public final class AllComplexType extends ComplexTypeImpl {
	public static final String CLS_NAME = "AllComplexType";
	private final TypeSet typeElements;
	
	public AllComplexType(){
		super("all");
		typeElements = new TypeSet();
	}
	
	public TypeSet getElements(){
		return typeElements;
	}
	
	public int hashCode() {
		int hashCodeValue = 17;
		hashCodeValue = (37 * hashCodeValue) + super.hashCode();	
		hashCodeValue = (37 * hashCodeValue) + typeElements.hashCode();					
		return hashCodeValue;
	}
		
	public boolean equals(final Object secondArgType){
		boolean result = true ;
		
		if(! (secondArgType instanceof AllComplexType)){
			result =  false;			
		} else {
			final AllComplexType complexTypeObject = (AllComplexType) secondArgType;
			final TypeSet complexTypeObjectElements = complexTypeObject.getElements();
			
			if(! complexTypeObjectElements.equals(this.getElements())) {
				result = false;
			}
		}
		
		return result;
	}
	
	public boolean isEquivalentToSimple(final SimpleTypeImpl secondTypeArg){
		return false;
	}
	
	public boolean isEquivalentToComplex(final ComplexTypeImpl secondTypeArg){
		boolean result = false;
		
		if(this.equals(secondTypeArg)) {
			result = true;
		} else {
			final String secondTypeClsName = secondTypeArg.getClass().getSimpleName();
			if(secondTypeClsName.equals(CLS_NAME)){
				final AllComplexType allSecondArgType = (AllComplexType) secondTypeArg;
				final TypeSet secondArgElements = allSecondArgType.getElements();
				if(typeElements.equals(secondArgElements)){
					result = true;
				}
			} else {
				if(secondTypeClsName.equals(SequenceComplexType.CLS_NAME)){
					final SequenceComplexType seqSecondArgType = (SequenceComplexType) secondTypeArg;
					final TypeList secondArgElements = seqSecondArgType.getElements();
					if(secondArgElements.equalSet(typeElements)){
						result = true;
					}
				}
			}
		}
				
		return result;
	}
	
	public boolean checkIntersection(final Type secondTypeArg){
		return IntersectionChecker.getReference().checkIntersection(secondTypeArg,typeElements.getElements());
	}	
}
