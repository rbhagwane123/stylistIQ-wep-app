package com.stylistiq.service;

import com.stylistiq.model.entity.User;

public interface AuditLogService {
	void logSuccess(User user, String action, String message);

	void logFailure(User user, String action, String message);
}
