package com.westbank.web.form;

import org.springframework.stereotype.Component;

@Component
public class TaskForm {

	protected Long loanFileId;
	protected Long contractId;
	protected String action;

	public Long getLoanFileId() {
		return loanFileId;
	}

	public void setLoanFileId(Long loanFileId) {
		this.loanFileId = loanFileId;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Long getContractId() {
		return contractId;
	}

	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TaskForm [action=").append(action).append(", contractId=").append(contractId)
				.append(", loanFileId=").append(loanFileId).append("]");
		return builder.toString();
	}

}
