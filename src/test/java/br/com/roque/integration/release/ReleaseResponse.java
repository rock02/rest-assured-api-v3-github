package br.com.roque.integration.release;

public class ReleaseResponse {

    private Long id;
    
    public ReleaseResponse(Long id) {
    	this.id = id;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
