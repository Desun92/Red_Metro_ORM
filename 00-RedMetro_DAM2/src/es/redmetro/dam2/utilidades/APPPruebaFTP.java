package es.redmetro.dam2.utilidades;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPSClient;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class APPPruebaFTP {
	public static void main(String[] args){
	//pruebaFTPsClient();
	
    String server = "dam2.actividad.cf";
    int port = 21;
    String user = "dam2_g4";
    String pass = "adjj41218";

//    FTPClient ftpClient = new FTPClient();
    FTPSClient ftpClient = new FTPSClient("TLS", false);
    FTPFile[] ficherosRaiz=null;
    try {
		ftpClient.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out))); // outputs all conversation to the console
		
        ftpClient.connect(server, port);

        ftpClient.enterLocalPassiveMode();
        boolean success = ftpClient.login(user, pass);

        if (!success) {
            System.out.println("Could not login to the server");
            return;
        }
		// Set protection buffer size
		ftpClient.execPBSZ(0);
		// Set data channel protection to private
		ftpClient.execPROT("P");

//        FTPFile[] ftpFiles = ftpClient.listFiles();
        boolean cambio= ftpClient.changeToParentDirectory();
        if(cambio)
        		ficherosRaiz=ftpClient.listFiles();
        for (FTPFile ftpFile : ficherosRaiz) {
        	System.out.println(ftpFile.getName());
		}
        	
        	
        
        

     // configuration code for ftpclient port, server etc
        InputStream in = ftpClient.retrieveFileStream("./datos.xml");
        Document documento = readXml(in);
		// Se obtiene la lista de nodos relacionado con 'departamento'
		NodeList nListIni = documento.getElementsByTagName("tren");
		System.out.println("N� de departamentos: " + nListIni.getLength());
		for(int temp = 0; temp < nListIni.getLength(); temp++) {
			Node nNode = nListIni.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			    Element elemento = (Element) nNode;
		    	String numeroID= elemento.getAttribute("id");
		    	int numDpto=Integer.parseInt(numeroID);
		    	String tipo= elemento.getAttribute("tipo");
		    	String ordenPerfil= elemento.getAttribute("orden");
		    	int nOrdenPerfil=Integer.parseInt(ordenPerfil);
		    	System.out.println(numDpto + tipo + nOrdenPerfil);
			}
		}
		        
    } catch (IOException | ParserConfigurationException | SAXException ex) {
        System.out.println("Oops! Something wrong happened");
        ex.printStackTrace();
    } finally {
        try {
            if (ftpClient.isConnected()) {
                ftpClient.logout();
                ftpClient.disconnect();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

	 public static Document readXml(InputStream is) throws ParserConfigurationException, SAXException, IOException  {
     DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

     dbf.setValidating(false);
     dbf.setIgnoringComments(false);
     dbf.setIgnoringElementContentWhitespace(true);
     dbf.setNamespaceAware(true);
     // dbf.setCoalescing(true);
     // dbf.setExpandEntityReferences(true);

     DocumentBuilder db = null;
     db = dbf.newDocumentBuilder();
     // db.setErrorHandler( new MyErrorHandler());

     return db.parse(is);
 }
}