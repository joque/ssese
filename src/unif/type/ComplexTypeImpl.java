package unif.type;

/** ComplexTypeImpl.java
	*
	* @author <a href="mailto:joque@cit.mak.ac.ug">Jose Ghislain Quenum</a>
	* @version 0.9 - 11/2009
*/

import java.util.HashSet;
import java.util.Set;

public abstract class ComplexTypeImpl implements Type {
	protected TypeConnector connector;
	protected TypeMapper substitutions;
		
	public ComplexTypeImpl(final String connectorName){
		connector = Connector.getTypeConnectorInstance(connectorName);
		substitutions = TypeMapper.getReference();
	}
	
	public boolean isEquivalent(final Type secondTypeArg){
		final Class argClass = secondTypeArg.getClass();
		final String argClassName = argClass.getSimpleName();
		
		if(argClassName.equals("SimpleTypeImpl")){
			final SimpleTypeImpl simpleSecondArg = (SimpleTypeImpl) secondTypeArg;
			return isEquivalentToSimple(simpleSecondArg);
		} else {
			final ComplexTypeImpl complexSecondArg = (ComplexTypeImpl) secondTypeArg;
			return isEquivalentToComplex(complexSecondArg);
		}
	}
	
	public abstract boolean isEquivalentToSimple(final SimpleTypeImpl secondTypeArg);
	public abstract boolean isEquivalentToComplex(final ComplexTypeImpl secondTypeArg);
	public abstract boolean checkIntersection(final Type secondTypeArg);
}