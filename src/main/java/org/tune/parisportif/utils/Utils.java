package org.tune.parisportif.utils;

public class Utils {
	private static Long phaseId = 2L;
	private static Long userId = 1L;
	
	public static Long getActivePhaseId() {
		return phaseId;
	}
	
	public static void setActivePhaseId(Long phaseId) {
		Utils.phaseId=phaseId;
	}

	public static Long getUserId() {
		return userId;
	}

	public static void setUserId(Long userId) {
		Utils.userId = userId;
	}
}
