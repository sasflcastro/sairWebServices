package ec.com.rgt.sair.controller;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


/**
 * This program demonstrates how to encrypt/decrypt input
 * using the Blowfish Cipher with the Java Cryptograhpy.
 *
 */
public class BlowfishCipher {
  public static String encripta2(String cadena)
  {
      try
      {
          SecretKeySpec key = new SecretKeySpec("123456portocarre".getBytes(),"Blowfish");
          byte[] salt = {
                (byte)0xc7, (byte)0x73, (byte)0x21, (byte)0x8c,
                (byte)0x7e, (byte)0xc8, (byte)0xee, (byte)0x99};
          Cipher cipher = Cipher.getInstance("Blowfish/CTR/NoPadding");
            IvParameterSpec ivs;
            ivs = new javax.crypto.spec.IvParameterSpec(salt);
            // initialise cipher to with secret key
            cipher.init(Cipher.ENCRYPT_MODE, key,ivs);
            byte[] encrypted = cipher.doFinal(cadena.getBytes("ISO-8859-1"));
            //for(int i =0; i< encrypted.length;i++ )
            //{System.out.println("exit"+ encrypted[i]);}
            return new String(encrypted,"ISO-8859-1");
      }catch(Exception ex){
          return ex.getMessage();
      }
      
  }
  
  
  public static String desencripta2(String cadena)
  {
      try
      {
          /*for(int i =0; i< cadena.length();i++ )
            {System.out.println("ex"+ cadena.getBytes()[i]);}*/
          SecretKeySpec key = new SecretKeySpec("123456portocarre".getBytes(),"Blowfish");
          byte[] salt = {
                (byte)0xc7, (byte)0x73, (byte)0x21, (byte)0x8c,
                (byte)0x7e, (byte)0xc8, (byte)0xee, (byte)0x99};
          Cipher cipher = Cipher.getInstance("Blowfish/CTR/NoPadding");
          IvParameterSpec ivs;
          ivs = new javax.crypto.spec.IvParameterSpec(salt);
            // initialise cipher to with secret key
            cipher.init(Cipher.DECRYPT_MODE, key,ivs);
            int cantidad=cadena.length();
            byte[]byOri= new byte[cantidad];  
            // decrypt message
            for(int i =0; i< cantidad;i++ )
            {
                
                byOri[i]=String.valueOf(cadena.charAt(i)).getBytes("ISO-8859-1")[0];
                //System.out.println(byOri[i]);
                }
                  
            //byte[] b={25,-61,102,69,119,-82,-123,-127,98};
            byte[] decrypted = cipher.doFinal(byOri);
              return new String(decrypted,"ISO-8859-1");
              }catch(Exception ex){
          return ex.getMessage();
      }
      
  }
  public static void main(String[] args)  {
	  System.out.println(desencripta2("¿Ña?P©ªy"));
	  System.out.println(desencripta2("§¿2Áôù4äÀ"));
	  
	  System.out.println(encripta2("k123456789"));
	  //System.out.print(LdapAutenticationWS.authenticate(null, null));
	  /*ConexionADAM  conexion=new ConexionADAM();
	  List<String> lis= conexion.Sqlquery("select 's' from dual");
	  System.out.println("fecha= "+lis.get(0));*/
	  //System.out.print(Conexion.CallProcess());
      /*BlowfishCipher blow = new BlowfishCipher();
      
      String inputText = JOptionPane.showInputDialog("Input your message: ");
      System.out.println(blow.encripta(inputText));
     System.out.println(blow.desencripta(blow.encripta(inputText)));
    System.exit(0);*/
  }
}