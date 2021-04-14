package com.br.redeinsocial.core.config;

public final class ApiConfig {
	
	public static class Path {
		
		public static final String API_V1 = "/api/v1";
		
		public static class ClientController {
			public static final String CUSTOMERS = "/customers";
		}
		
		public static class CompletionController {
			public static final String COMPLETIONS = "/completions";
		}
		
		public static class DataLogController {
			public static final String DATALOGS = "/data-logs";
			public static final String DATALOGS_MASSIVE = "/massive";
			public static final String DATALOGS_EXECUTE = "/execute";
		}
		
		public static class DomainController {
			public static final String DOMAINS = "/domains";
		}
		
		public static class DriverController {
			public static final String DRIVERS = "/drivers";
		}
		
		public static class ExpressionController {
			public static final String EXPRESSIONS = "/expressions";
		}
		
		public static class RuleController {
			public static final String RULES = "/rules";
			public static final String RULES_VALIDATE = "/validate";
			public static final String RULES_DEFINITIONS = "/definitions";
			public static final String RULES_EXAMPLES = "/examples";
		}
		
		public static class SpecificRuleController {
			public static final String SPECIFIC_RULES = "/specific-rules";
		}
		
		public static class AdviseController {
			public static final String ADVISES = "/advises";
		}
		
	}
	
	public class Param {
		
		public static final String PAGE = "page";
		public static final String PAGE_SIZE = "pageSize";
		
		public static final String PAGE_DEFAULT_VALUE = "1";
		public static final String PAGE_SIZE_DEFAULT_VALUE = "10";
		
		public static final int MAX_PAGE_SIZE = 100;
		public static final int MIN_PAGE_SIZE = 1;
		
	}
}
