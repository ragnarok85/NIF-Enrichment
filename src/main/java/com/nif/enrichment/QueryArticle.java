package com.nif.enrichment;

import java.util.ArrayList;
import java.util.List;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Model;

import com.nif.enrichment.pojo.Annotation;

public class QueryArticle {
	
	public List<Annotation> extractAnnotations(Model model) {
		String queryString = Queries.ALLANNOTATIONS.query();
		Query query = QueryFactory.create(queryString);
		List<Annotation> listAnnotations = new ArrayList<Annotation>();
		try(QueryExecution qexec = QueryExecutionFactory.create(query, model)){
			ResultSet rs = qexec.execSelect();
			while(rs.hasNext()) {
				QuerySolution qs = rs.next();
				Annotation ann = new Annotation();
				ann.setAnchorOf(qs.getLiteral("?anchorOf").toString());
				ann.setType(qs.getResource("?type").getURI());
				ann.setBindex(qs.getLiteral("?bindes").getInt());
				ann.setEindex(qs.getLiteral("?eindex").getInt());
				ann.setUri(qs.getResource("?uri").getURI());
				listAnnotations.add(ann);
			}
		}
		return listAnnotations;
	}

}
