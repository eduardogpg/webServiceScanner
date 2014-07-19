
package org.scanner;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author eduardo
 */
public class priceHistory {
    
    Hashtable<String,String> dictionariUsers =new Hashtable<String,String>();
    ArrayList<String> listUsers = new ArrayList();
    
    private priceHistory(){}
    
    
    private static priceHistory chumlee = null;
    
    public static priceHistory getInstance() {
        if(priceHistory.chumlee ==null)
            chumlee = new priceHistory();
        return chumlee;
    }
    
    public boolean imFirst(String userName, String ip){
        if(this.listUsers.size()==0)
            return true;
        else{
            if(this.listUsers.get(0).equals(userName))
                return true;
            else
                return false;
        }
        
    }
    
    public void addUser(String userName, String ip){
        if(!this.dictionariUsers.containsKey(userName))
            this.dictionariUsers.put(userName, ip);
        
        if(!this.listUsers.contains(userName))
            this.listUsers.add(userName);
    }
    
    public String getFirstIP(){
       return this.dictionariUsers.get( this.listUsers.get(0));
    }
    
    public String getFirstUserName(){
       return this.listUsers.get(0);
    }
    
    public boolean removeServer(String userName){
        try{

            this.dictionariUsers.remove( this.listUsers.indexOf(userName));
            this.listUsers.remove(userName);
            return true;
            
        }catch(Exception ex){
            return false;
        }
        
    }
    
    
    
}
