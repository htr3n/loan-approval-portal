package com.westbank.domain;

/**
 * The statuses cover the whole life cycle of a loan file:
 */
public enum LoanFileStatus {
	INITIALIZED, UNDER_CONSIDERATION, WORTHINESS_ANALYSIS, RISK_ANALYSIS, APPROVED, REJECTED, CANCELED, ACCEPTED
}
