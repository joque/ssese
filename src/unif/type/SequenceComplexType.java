package unif.type;

/** SequenceComplexType.java
	*
	* @author <a href="mailto:joque@me.com">Jose Ghislain Quenum</a>
	* @version 0.9 - 11/2009
*/

public final class SequenceComplexType extends ComplexTypeImpl {
	public static final String CLS_NAME = "SequenceComplexType";
	private final TypeList typeElements;	
	
	public SequenceComplexType(){
		super("sequence");
		typeElements = new TypeList();
	}
	
	public TypeList getElements(){
		return typeElements;
	}
	
	public boolean equals(final Object secondArgType){
		boolean result = true ;
		
		if(! (secondArgType instanceof SequenceComplexType)){
			result =  false;			
		} else {
			final SequenceComplexType complexTypeObject = (SequenceComplexType) secondArgType;
			final TypeList complexTypeObjectElements = complexTypeObject.getElements();
			
			if(! complexTypeObjectElements.equals(this.getElements())) {
				result = false;
			}
		}
		
		return result;
	}
	
	public int hashCode() {
		int hashCodeValue = 17;
		hashCodeValue = (37 * hashCodeValue) + super.hashCode();	
		hashCodeValue = (37 * hashCodeValue) + typeElements.hashCode();					
		return hashCodeValue;
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
				final SequenceComplexType seqSecondArgType = (SequenceComplexType) secondTypeArg;
				final TypeList secondArgElements = seqSecondArgType.getElements();
				if(typeElements.equals(secondArgElements)){
					result = true;
				}
			} else {
				if(secondTypeClsName.equals(AllComplexType.CLS_NAME)){
					final AllComplexType allSecondArgType = (AllComplexType) secondTypeArg;
					final TypeSet secondArgElements = allSecondArgType.getElements();
					if(typeElements.equalSet(secondArgElements)){
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
