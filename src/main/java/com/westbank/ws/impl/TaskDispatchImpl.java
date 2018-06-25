package com.westbank.ws.impl;

import com.westbank.domain.Role;
import com.westbank.web.Constants;
import com.westbank.ws.business.taskdispatch._2018._06.TaskDispatch;
import com.westbank.ws.business.taskdispatch._2018._06.TaskDispatchRequest;
import com.westbank.ws.business.taskdispatch._2018._06.TaskDispatchResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@javax.jws.WebService(
		serviceName = "TaskDispatch",
		portName = "TaskDispatchPort",
		targetNamespace = "urn:com:westbank:ws:business:TaskDispatch:2018:06",
		endpointInterface = "com.westbank.ws.business.taskdispatch._2018._06.TaskDispatch")
public class TaskDispatchImpl implements TaskDispatch {

	static final Logger log = LoggerFactory.getLogger(TaskDispatchImpl.class);

	protected double threshold = Constants.LOAN_THRESHOLD;

	public void setThreshold(double threshold) {
		this.threshold = threshold;
	}

	@Override
	public TaskDispatchResponse dispatch(TaskDispatchRequest request) {
		log.info("Executing operation dispatch: " + request);
		try {
			final TaskDispatchResponse response = new TaskDispatchResponse();
			final double loanAmount = request.getLoanAmount();
			if (loanAmount < threshold)
				response.setRole(Role.POST_PROCESSING_CLERK);
			else
				response.setRole(Role.SUPERVISOR);
			log.info(" Response: " + response);
			return response;
		} catch (final Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}

}
