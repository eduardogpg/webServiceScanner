

package org.scanner;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author eduardo
 */
@WebService(serviceName = "scanner")
public class scanner {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ImFirst")
    public boolean ImFirst(@WebParam(name = "userName") String userName, @WebParam(name = "ip") String ip) {
        
        priceHistory pH = priceHistory.getInstance();
        
        boolean flag =pH.imFirst(userName, ip);
        pH.addUser(userName, ip);
        return flag;
        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getFisrtIp")
    public String getFisrtIp() {
        priceHistory pH = priceHistory.getInstance();
        return pH.getFirstIP();
        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getFirstUserName")
    public String getFirstUserName() {
       priceHistory pH = priceHistory.getInstance();
        return pH.getFirstUserName();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "removeUser")
    public boolean removeUser(@WebParam(name = "UserName") String UserName) {
        priceHistory pH = priceHistory.getInstance();
        return pH.removeServer(UserName);
    }
}
