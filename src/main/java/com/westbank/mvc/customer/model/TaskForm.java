package com.westbank.mvc.customer.model;

public class TaskForm {

	protected String loanFileId;
	protected String contractId;
	protected String action;

	public String getLoanFileId() {
		return loanFileId;
	}

	public void setLoanFileId(String loanFileId) {
		this.loanFileId = loanFileId;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
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
