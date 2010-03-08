package unif.type;

/** SimpleType.java
	*
	* This is a simple Java Enum class for all types of simple types
	* @author <a href="mailto:joque@cit.mak.ac.ug">Jose Ghislain Quenum</a>
	* @version 0.9 - 11/2009
*/

public enum SimpleType {
	STRING("String"),
	DECIMAL("Number"),
	INTEGER("number"),
	DATE("Date"),
	GYEARMONTH("Date");
	//complete the list
	
	private final String typeName;
	
	SimpleType(String typeName){
		this.typeName = typeName;
	}
	
	public String getTypeName(){
		return typeName;
	}
	
	//add a hash code method here
	
	public static SimpleType getSimpleTypeInstance(final String typeName){
		SimpleType simpleTypeInst = null;		
		for(SimpleType simpleType: SimpleType.values()){
			if(typeName.equals(simpleType.getTypeName())){
				simpleTypeInst = simpleType;
				break;
			}
		}
		return simpleTypeInst;
	}
}