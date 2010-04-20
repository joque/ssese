package unif.type;

/** SimpleType.java
	*
	* This is a Java Enum class for all simple types
	* @author <a href="mailto:joque@me.com">Jose G. Quenum</a>
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