/**********************************************/
/*           CMSI Writer library              */
/**********************************************/

Description of the library
++++++++++++++++++++++++++

CMSIWriter is a java library used to perform CMS Interface insertion.
It prevents the developer from knowing how the XML should be formated, thus decreasing the amount of syntax errors. 

HOWTO use the library
+++++++++++++++++++++

First step
----------
Get an instance of the XmlGFactory

XmlGFactory factory = XmlGFactory.getInstance();

Second step
-----------
Get a client object from the factory

Properties properties = new Properties();
properties.setProperty("cmsi.db.url","jdbc:oracle:thin:@ip:port:sid"); // The URL where the CMS Interface module is installed
properties.setProperty("cmsi.db.username","user");  // A user that has access to the CMS Interface module
properties.setProperty("cmsi.db.password","pwd");
properties.setProperty("cmsi.parent.request.id.activated","true");	// set to 'false' if the column PARENT_REQ_ID doesn't exist in your CMS Interface installation (default value if not set is 'true')

XmlGeneratorI client = factory.createXmlGenerator(properties);

Third step
----------
Instantiate a CMSI object to be sent, according to the action you aim to execute

/* Example of CMSI for contract suspension */
ObjectFactory objFactory = new ObjectFactory(); // Get the object factory
com.alu.cmsi.writer.beans.changeContractStatus.Customer customer = objFactory.createCustomer(); // Create the client from the factory
ContractIdType contractId = new ContractIdType(); // Create the necessary elements for the Customer
contractId.setType("co_id");
contractId.setValue(1578596);
Contract contract = new Contract();
contract.setId(contractId);    			// Set the contractId to the contract                  
contract.setReason(1);					// Set the reason to the contract status modification
customer.setContract(contract);

Fourth step
-----------
Instantiate a CMSIParameters object to specify the parameters of the CMS Interface action

/* Example of CMSI parameters */
CMSIParameters cmsiP = new CMSIParameters();
cmsiP.setOrigin("ORIGIN");  					// Mandatory         
cmsiP.setOriginalId(123);						// Optional, used to keep a link between the action in CMS Interface and the external id of the application.
cmsiP.setInsertionDate(new java.util.Date());	// Optional, used to make a planification of the action. Default value is SYSDATE.
cmsiP.setPriority(1);							// Optional, default value is 1.
cmsiP.setParentRequestId(12);					// Optional, used to make a hierarchy between different actions.

Fifth step
----------
Execute the action

/* Example of CMSI for contract suspension */
client.suspendContract(customer, cmsiP);