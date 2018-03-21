package com.nif.enrichment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;

import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;

public class Utitlities {
	
	
	
	
	
	public BZip2CompressorInputStream readBZ2file(File input) {
		BZip2CompressorInputStream article = null;
		
		try{
			InputStream inputArticle = FileManager.get().open(input.getAbsolutePath());
	    article = new BZip2CompressorInputStream(inputArticle);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return article;
	}
	
	public Model readModel(BZip2CompressorInputStream input) {
		Model model = ModelFactory.createDefaultModel();
		
		return model.read(input, null, "TURTLE");
	}
	
	public void writeModel(Model model, String outputPath, String fileName) {
		OutputStreamWriter osw;
		File path = new File(outputPath);
		
		if(!path.exists())
			path.mkdirs();
		try {
			osw = new OutputStreamWriter(new BZip2CompressorOutputStream(new FileOutputStream(outputPath+"/"+fileName+".ttl.bz2",true)));
			model.write(osw,"TURTLE");
			osw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
