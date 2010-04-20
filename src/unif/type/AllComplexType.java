package unif.type;

/** AllComplexType.java
	*
	* @author <a href="mailto:joque@me.com">Jose Ghislain Quenum</a>
	* @version 0.9 - 11/2009
*/

import java.util.HashSet;
import java.util.Set;

public final class AllComplexType extends ComplexTypeImpl {
	private static final String CLS_NAME = "AllComplexType";
	private final TypeSet typeElements;
	
	public AllComplexType(){
		super("all");
		typeElements = new TypeSet();
	}
	
	public TypeSet getElements(){
		return typeElements;
	}
	
	//add equals and hashCode methods
	
	public boolean isEquivalentToSimple(final SimpleTypeImpl secondTypeArg){
		return false;
	}
	
	public boolean isEquivalentToComplex(final ComplexTypeImpl secondTypeArg){
		boolean result = false;

		
		//should determine the actual content of this method
		return result;
	}
	
	public boolean checkIntersection(final Type secondTypeArg){
		//should determine the actual content of this method		
		return false;
	}
	
}
