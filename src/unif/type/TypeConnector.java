package unif.type;

/** TypeConnector.java
	*
	* @author <a href="mailto:joque@me.com">Jose G. Quenum</a>
	* @version 0.9 - 11/2009
*/

public enum TypeConnector {
	ALL("all"),
	SEQUENCE("sequence"),
	CHOICE("choice");
	
	private final String connectorName;
	
	TypeConnector(String connectorName){
		this.connectorName = connectorName;
	}
	
	public String getConnectorName(){
		return connectorName;
	}
	
	public static TypeConnector getTypeConnectorInstance(final String connectorName){
		TypeConnector typeConnectorInst = null;		
		for(TypeConnector typeConnector: TypeConnector.values()){
			if(connectorName.equals(typeConnector.getConnectorName())){
				typeConnectorInst = typeConnector;
				break;
			}
		}
		return typeConnectorInst;
	}
}