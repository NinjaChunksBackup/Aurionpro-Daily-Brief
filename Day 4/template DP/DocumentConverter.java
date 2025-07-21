package com.ap.TemplateDP.one;

public abstract class DocumentConverter {
	
	public final void CovertDoc() {
		readDocument();
		 convertFile();
		 saveToFile();
		
	}

	

	abstract void convertFile();



	void readDocument() {
		 System.out.println("Reading a document ");
	 }
	
	void saveToFile() {
		 System.out.println(" Saved the file");
	 }


}
