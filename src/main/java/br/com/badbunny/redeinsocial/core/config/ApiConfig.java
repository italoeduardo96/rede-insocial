package br.com.badbunny.redeinsocial.core.config;

public final class ApiConfig {
	
	public static class Path {
		
		public static final String API_V1 = "/api/v1";
		
		public static class ClientController {
			public static final String USERS = "/users";
			public static final String POSTS = "/posts";
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
