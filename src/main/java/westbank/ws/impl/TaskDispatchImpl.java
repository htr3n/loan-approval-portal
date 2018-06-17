package westbank.ws.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import westbank.db.dao.DataAccess;
import westbank.db.entity.Role;
import westbank.mvc.Constants;
import westbank.ws.business.taskdispatch._2009._11.TaskDispatch;
import westbank.ws.business.taskdispatch._2009._11.TaskDispatchRequest;
import westbank.ws.business.taskdispatch._2009._11.TaskDispatchResponse;

@javax.jws.WebService(serviceName = "TaskDispatch", portName = "TaskDispatchPort", targetNamespace = "urn:westbank:ws:business:TaskDispatch:2009:11", endpointInterface = "westbank.ws.business.taskdispatch._2009._11.TaskDispatch")
public class TaskDispatchImpl implements TaskDispatch {

	static final Logger log = LoggerFactory.getLogger(TaskDispatchImpl.class);

	protected DataAccess dataAccessObject;

	protected double threshold = Constants.LOAN_THRESHOLD;

	public void setDataAccessObject(DataAccess dataAccessObject) {
		this.dataAccessObject = dataAccessObject;
	}

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
