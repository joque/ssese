package unif.type;

/** SequenceComplexType.java
	*
	* @author <a href="mailto:joque@me.com">Jose Ghislain Quenum</a>
	* @version 0.9 - 11/2009
*/

import java.util.HashSet;
import java.util.Set;

public final class SequenceComplexType extends ComplexTypeImpl {
	private static final String CLS_NAME = "ComplexTypeImpl";
	private final TypeList typeElements;
	
	
	public SequenceComplexType(){
		super("choice");
		typeElements = new TypeList();
	}
	
	//add equals and hashCode methods
	
	public boolean isEquivalentToSimple(final SimpleTypeImpl secondTypeArg){
		return false;
	}
	
	public boolean isEquivalentToComplex(final ComplexTypeImpl secondTypeArg){
		//should determine the content of this method as well
		
		return false;
	}
	
	public boolean checkIntersection(final Type secondTypeArg){
		return false;
	}
	
}
