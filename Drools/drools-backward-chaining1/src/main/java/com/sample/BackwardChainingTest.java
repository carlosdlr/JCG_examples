package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.sample.model.Location;

public class BackwardChainingTest {

	public static void main(String[] args) {
		try {
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			KieSession kSession = kContainer.newKieSession("ksession-backward-chaining");
			
			kSession.insert(new Location("desk", "office"));
			kSession.insert(new Location("flashlight", "desk"));
			kSession.insert(new Location("envelop", "desk"));
			kSession.insert(new Location("key", "envelop"));
			
			kSession.insert("go1");
			kSession.fireAllRules();
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

}
