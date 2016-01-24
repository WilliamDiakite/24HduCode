
import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;

/**
 *
 * @author carlos
 *
 * Classe utilizada para extração de textos
 */
public class TextExtract {
	public void main(String[] args)
	{
		File rtfFile = null;
		getRtfText("C:\\Users\\Alexis\\Documents\\ENSIM\\24HDuCode_Interface\\src\\WILLIAM_SHAKESPEARE-Romeo_et_juliette-Atramenta.net", rtfFile);
	}

	public String getRtfText(String fileName, File rtfFile) {
	   
	   WordExtractor rtfExtractor = null ;

	   try {
	    rtfFile = new File("C:\\Users\\Alexis\\Documents\\ENSIM\\24HDuCode_Interface\\src\\WILLIAM_SHAKESPEARE-Romeo_et_juliette-Atramenta.net");

	    //A FileInputStream obtains input bytes from a file.
	    FileInputStream inStream = new FileInputStream(rtfFile.getAbsolutePath());

	    //A HWPFDocument used to read document file from FileInputStream
	    HWPFDocument doc=new HWPFDocument(inStream);

	    rtfExtractor = new WordExtractor(doc);
	   }
	   catch(Exception ex)
	   {
	    System.out.println(ex.getMessage());
	   }

	    //This Array stores each line from the document file.
	    String [] rtfArray = rtfExtractor.getParagraphText();

	    String rtfString = "";

	    for(int i=0; i < rtfArray.length; i++) rtfString += rtfArray[i];

	    System.out.println(rtfString);
	    return rtfString;
	 }
}