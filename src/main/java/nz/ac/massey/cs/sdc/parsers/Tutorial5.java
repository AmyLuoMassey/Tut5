package nz.ac.massey.cs.sdc.parsers;


import nz.ac.massey.cs.sdc.parsers.Rss.*;
import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Tutorial5 {

	public static void main(String[] args) 
    {
        String fileName = "src/main/resources/nzhrsscid_000000005.xml";
        try {
			URL url = new URL("http://rss.nzherald.co.nz/rss/xml/nzhrsscid_000000005.xml");
			jaxbXmlFileToObject(fileName,url);
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
 
        
       
   
    }
 
    private static void jaxbXmlFileToObject(String fileName,URL url) {
         
       // File xmlFile = new File(fileName);
    	
      
    	
        JAXBContext jaxbContext;
        try
        {
            jaxbContext = JAXBContext.newInstance(Rss.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
             
            //Rss rssFeed = (Rss) jaxbUnmarshaller.unmarshal(xmlFile);
            Rss rssFeed = (Rss) jaxbUnmarshaller.unmarshal(url);
             
            Channel channel = rssFeed.getChannel();
            List<Channel.Item> items = channel.getItem();
            for (Channel.Item item: items) {
                System.out.println("Title: " + item.getTitle());
                System.out.println("Link: " + item.getLink());
                System.out.println("Description: " + item.getDescription());
                
            }
            
        }
        catch (JAXBException e) 
        {
            e.printStackTrace();
        }
    }

}
