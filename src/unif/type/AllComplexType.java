package unif.type;

/** AllComplexType.java
	*
	* @author <a href="mailto:joque@cit.mak.ac.ug">Jose Ghislain Quenum</a>
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
	
	//add equals and hashCode methods
	
	public abstract boolean isEquivalentToSimple(final SimpleTypeImpl secondTypeArg){
		return false;
	}
}
