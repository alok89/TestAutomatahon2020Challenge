package com.tests.TestAutomatahon2020Challenge.scope;

import java.util.Objects;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.SimpleThreadScope;

//Custom Scope Definition for WebDriver Bean
public class BrowserScope extends SimpleThreadScope {

	@Override
	public Object get(String name, ObjectFactory<?> objectFactory) {
		Object obj = super.get(name, objectFactory);
		SessionId sessionId = ((RemoteWebDriver)obj).getSessionId();
		if(Objects.isNull(sessionId)) {
			super.remove(name);
			obj = super.get(name, objectFactory);
		}
		return obj;
	}

	@Override
	public void registerDestructionCallback(String name, Runnable callback) {
		// Default behavior should not get executed
	}
}
