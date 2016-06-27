package br.edu.ufcg.splab.rest;

public abstract class UriResources {

	public static final String ROOT = "/";
	
	public static final String PRODUCT = "/product";
	
	public static final String CLIENT = "/client";
	
	public static final String CLIENT_ID_PARAM = "clientId";

	public static final String CLIENT_ID = "/{clientId}";

	public static final String CART = "/cart";

	public static final String HISTORY = CLIENT_ID + "/history";

	public static final String HISTORY_ID = "/{historyId}";

	public static final String HISTORY_ID_PARAM = "historyId";
}
