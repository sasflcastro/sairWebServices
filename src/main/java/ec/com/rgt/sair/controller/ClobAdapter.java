package ec.com.rgt.sair.controller;

import java.io.BufferedReader;
import java.sql.Clob;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import ec.com.rgt.sair.dao.DAO;


public class ClobAdapter extends XmlAdapter<String, Clob> {

    @SuppressWarnings("deprecation")
	@Override
    public Clob unmarshal(String v) throws Exception {
    	Clob b=DAO.getSession().connection().createClob();
    	b.setString(1, v);
    	//new SerialClob(v.toCharArray());//
    	
		return b;
        // Convert String to Clob
    }

    @Override
    public String marshal(Clob v) throws Exception {
    	if(v==null){
    		return "";
    	}else{
    		StringBuffer sb=new StringBuffer();
    		String aux;
    		BufferedReader br=new BufferedReader(v.getCharacterStream());
    		while ((aux=br.readLine())!=null) {
				sb.append(aux);
				
			}
    		//SanearString s=new SanearString();
    		return sb.toString();

    	}
		        // Convert Clob to String
    }

}
