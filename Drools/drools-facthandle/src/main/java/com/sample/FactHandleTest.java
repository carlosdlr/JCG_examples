package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

import com.sample.model.Person;

public class FactHandleTest {

	public static void main(String[] args) {
		try {
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();

			//drools session base on the xml configuration kmodule.xml
			KieSession kSession = kContainer.newKieSession("ksession-facthandle");

			//fact creation (model pojo class), that will not match with the current rule
			Person person = new Person(1, "carlos");

			//we obtain the fact handle and at this moment the evaluation against the rule happens 
			FactHandle personFactHandle = kSession.insert(person);
            
			//here the rule is fired
			kSession.fireAllRules();
			System.out.println("Nothing is printing by the rule");
			
			//modification fact in order to match this fact with the rule
			person.setId(12467);
			
			//here we use the FactHandle obtained by the insertion operation and the modified fact in order to get the rule reprocessed  
			kSession.update(personFactHandle, person);
			//here the rule is fired
			kSession.fireAllRules();
			
			//here we remove the fact from the current working memory 
			//kSession.retract(personFactHandle);
			
			//the representation still there but the rules associated to this fact will be cancelled 
			//System.out.println(personFactHandle.toExternalForm());
			
            /*here the rule never execute the print statement, 
			because the fact was already removed from current working memory so is cancelled*/  
			//kSession.fireAllRules();

			//here we print the fact representation of this object inside the rules engine
			//System.out.println(personFactHandle.toExternalForm());
			//here the rule is fired
			//kSession.fireAllRules();

		} catch (Throwable t) {
			t.printStackTrace();
		}

	}

}
