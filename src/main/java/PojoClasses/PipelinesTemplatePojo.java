package PojoClasses;

import java.util.List;
import java.util.Locale;

import com.github.javafaker.Faker;

import PojoClasses.WorkflowPojo.Pipelines;

public class PipelinesTemplatePojo {
	
	Faker fake = new Faker(new Locale("en-IND"));
	private List<Pipelines> pipelines;
	private String temp_name;
	public List<Pipelines> getPipelines() {
		return pipelines;
	}
	public void setPipelines(List<Pipelines> pipelines) {
		this.pipelines = pipelines;
	}
	public String getTemp_name() {
		return temp_name;
	}
	public void setTemp_name() {
		this.temp_name = "PipelineTemp_"+fake.numerify("##")+"_RestAssured";
	}

}
