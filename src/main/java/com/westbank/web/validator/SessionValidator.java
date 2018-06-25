package com.westbank.web.validator;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Component
public class SessionValidator {

	public static Object validateSession(HttpSession session, String sessionName) {
		try {
			final Object id = session.getAttribute(sessionName);
			StringBuilder builder = new StringBuilder();
			builder.append(session.getAttribute(sessionName));
			if (id != null) {
				if (id instanceof String && !((String) id).isEmpty()) {
					return id;
				} else if (id instanceof Number) {
					return id;
				}
			}
		} catch (final Throwable e) {
		}
		return null;
	}

}
