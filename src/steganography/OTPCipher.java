package steganography;

import java.util.*;

public class OTPCipher{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      String text = "merhaba";
     
      String key = scan.nextLine();
      String key2="";
      
    	  
	  for(int i=1; i<=text.length()/key.length(); i++) {

    	  key2 += key;

    	  }
    
      key2 += key.substring(0, text.length()%key.length());
      System.out.println("key 2:"+key2);

   
      String enc = OTPEncryption(text,key2);
      System.out.println("Plaintext : "+text);
      System.out.println("Encrypted : "+enc);
      System.out.println("Decrypted : "+OTPDecryption(enc,key2));
   }
   public static String KeyExtender(String text,String key){
	   
	   String key2="";
	      for(int i=1; i<=text.length()/key.length(); i++) {

	    	  key2 += key;

	    	  }
	      key2 += key.substring(0, text.length()%key.length());
	   return key2;
   }
   
   public static String OTPEncryption(String text,String key){
      String alphaU = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
      String alphaL = "abcdefghijklmnopqrstuvwxyz";
      
      int len = text.length();
      
      String sb = "";
      for(int x=0;x<len;x++){
         char get = text.charAt(x);
         char keyget = key.charAt(x);
         if(Character.isUpperCase(get)){
            int index = alphaU.indexOf(get);
            int keydex = alphaU.indexOf(Character.toUpperCase(keyget));
            
            int total = (index + keydex) % 26;
            
            sb = sb+ alphaU.charAt(total);
         }
         else if(Character.isLowerCase(get)){
            int index = alphaL.indexOf(get);
            int keydex = alphaL.indexOf(Character.toLowerCase(keyget));
            
            int total = (index + keydex) % 26;
            sb = sb+ alphaL.charAt(total);
         }
         else{
            sb = sb + get;
         }
      }
      
      return sb;
   }
   public static String OTPDecryption(String text,String key){
      String alphaU = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
      String alphaL = "abcdefghijklmnopqrstuvwxyz";
      
      int len = text.length();
      
      String sb = "";
      for(int x=0;x<len;x++){
         char get = text.charAt(x);
         char keyget = key.charAt(x);
         if(Character.isUpperCase(get)){
            int index = alphaU.indexOf(get);
            int keydex = alphaU.indexOf(Character.toUpperCase(keyget));

            int total = (index - keydex) % 26;
            total = (total<0)? total + 26 : total;
            
            sb = sb+ alphaU.charAt(total);
         }
         else if(Character.isLowerCase(get)){
            int index = alphaL.indexOf(get);
            int keydex = alphaL.indexOf(Character.toLowerCase(keyget));
            
            int total = (index - keydex) % 26;
            total = (total<0)? total + 26 : total;
            
            sb = sb+ alphaL.charAt(total);
         }
         else{
            sb = sb + get;
         }
      }
      
      return sb;
   }
   
}