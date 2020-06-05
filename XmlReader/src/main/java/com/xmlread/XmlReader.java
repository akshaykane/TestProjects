package com.xmlread;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class XmlReader {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        
        Document doc = null;
        
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        doc = db.parse("xmlFiles/testng-results.xml");
        doc.getDocumentElement().normalize();



        if(doc != null)
        {
            NodeList nList = doc.getElementsByTagName("test-method");
            for (int i = 0; i < nList.getLength(); i++) 
            {
                Node nNode = nList.item(i);
                Element eElement = (Element) nNode;
                //System.out.println("test-method count is - " + i);
                //System.out.println("test-method status is - " + eElement.getAttribute("status"));
                if(eElement.getAttribute("status").equals("FAIL"))
                {
                    System.out.println("Failed Test - " + eElement.getAttribute("signature"));
                }
                
                if(eElement.getAttribute("status").equals("SKIP"))
                {
                    System.out.println("Skipped Test - " + eElement.getAttribute("signature"));
                }
                    
            }
        }
    }

        

  }

