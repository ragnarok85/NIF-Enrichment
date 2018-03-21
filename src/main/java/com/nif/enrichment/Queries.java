package com.nif.enrichment;

public enum Queries {
	ALLANNOTATIONS("PREFIX nif:<http://persistence.uni-leipzig.org/nlp2rdf/ontologies/nif-core#> "
			+ "    PREFIX itsrdf:<http://www.w3.org/2005/11/its/rdf#>"
			+ "	SELECT DISTINCT ?type ?bindex ?eindex ?anchorOf ?uri WHERE{"
			+ " ?annotation a ?type."
			+ " FILTER (?type == nif:Word || ?type == nif:Phrase"
			+ " ?annotation nif:anchorOf ?anchorOf;"
			+ "	       	    nif:beginIndex ?bindex;"
			+ "			    nif:endIndex ?eindex;"
			+ "             itsrdf:taIdentRef ?uri. "
			+ " }"),
	PARAGRAPH(" PREFIX nif: <http://persistence.uni-leipzig.org/nlp2rdf/ontologies/nif-core#> "
			+ " SELECT ?bi ?ei WHERE { "
			+ " <**PARAGRAPH**> nif:beginIndex ?bi; "
			+ "  				nif:endIndex ?ei. "
			+ " } "),
	SECTION(" PREFIX nif: <http://persistence.uni-leipzig.org/nlp2rdf/ontologies/nif-core#> "
			+ " SELECT ?bi ?ei WHERE { "
			+ " <**SECTION**> nif:beginIndex ?bi; "
			+ "               nif:endIndex ?ei. "
			+ " } ");
	
	
	String annotation;
	
	public String query() {
		return annotation;
	}
	Queries(String annotation) {
		this.annotation = annotation;
	}
	
	
}
