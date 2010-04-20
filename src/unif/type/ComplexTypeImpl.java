package unif.type;

/** ComplexTypeImpl.java
	*
	* @author <a href="mailto:joque@me.com">Jose Ghislain Quenum</a>
	* @version 0.9 - 11/2009
*/

import java.util.HashSet;
import java.util.Set;

public abstract class ComplexTypeImpl implements Type {
	protected String name;
	protected TypeConnector connector;
	protected TypeMapper substitutions;
		
	public ComplexTypeImpl(final String connectorName){
		this.connector = TypeConnector.getTypeConnectorInstance(connectorName);
		this.substitutions = TypeMapper.getReference();
	}
	
	public ComplexTypeImpl(final String name, final String connectorName){
		this(connectorName);
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(final String name){
		this.name = name;
	}
	
	public int hashCode() {
		int hashCodeValue = 17;
		hashCodeValue = (37 * hashCodeValue) + name.hashCode();
		hashCodeValue = (37 * hashCodeValue) + connector.hashCode();
		hashCodeValue = (37 * hashCodeValue) + substitutions.hashCode();	
		return hashCodeValue;
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