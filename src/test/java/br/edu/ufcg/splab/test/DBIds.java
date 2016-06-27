package br.edu.ufcg.splab.test;

public enum DBIds {

	PRODUCT_PC_ASUS(1L), PRODUCT_PC_MAC(2L), PRODUCT_CHAIR_SIMPLE(3L), PRODUCT_CHAIR_BOSS(4L), PRODUCT_LAMP_SIMPLE(
			5L), PRODUCT_LAMP_FANCY(6L);

	private Long id;

	private DBIds(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
}
