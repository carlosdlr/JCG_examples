package com.sample;

import org.kie.api.KieServices;
import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.event.rule.DefaultAgendaEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.sample.model.Message;

public class AgendaEventListenerTest {

	public static void main(String[] args) {
		try {
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			
			//drools session base on the xml configuration kmodule.xml
			KieSession kSession = kContainer.newKieSession("ksession-agendaeventlistenerrule");
			
			/*add the event listener in this case we'll use the DefaultAgendaEventListener, 
			that is a implementation of AgendaEventListener*/ 
			kSession.addEventListener(new DefaultAgendaEventListener() {
			    
				//this event will be executed after the rule matches with the model data
				public void afterMatchFired(AfterMatchFiredEvent event) {
			        super.afterMatchFired(event);
			        System.out.println(event.getMatch().getRule().getName());//prints the rule name that fires the event 
			    }
			});
			
			//add the model with the data that will match with the rule condition
			kSession.insert(new Message(20, "agenda example rule"));
			
			//fire all the rules
			//kSession.fireAllRules();
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
}

