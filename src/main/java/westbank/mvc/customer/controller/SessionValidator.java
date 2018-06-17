package westbank.mvc.customer.controller;

import javax.servlet.http.HttpSession;

public class SessionValidator {

	/**
	 * Check if the customer has logged in via the session variable
	 * 
	 * @param session
	 *            -- the customer's session
	 * @return <code>null</code> if the customer has not logged, otherwise, the
	 *         session ID
	 */
	public static Object validateSession(HttpSession session, String sessionName) {
		try {
			final Object id = session.getAttribute(sessionName);
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
