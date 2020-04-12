package br.com.roque.integration.release;

public class ReleaseRequest {
	
	private String name;
	
	private String tag_name;
	
	private String target_commitish;
	
	private String body;
	
	private Boolean draft;
	
	private Boolean prerelease;

	public ReleaseRequest(String name, String tagName, String targetCommitsh, String body, Boolean draft, Boolean prerelease) {
		
		this.name = name;
		this.tag_name = tagName;
		this.target_commitish = targetCommitsh;
		this.body = body;
		this.draft = draft;
		this.prerelease = prerelease;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTag_name() {
		return tag_name;
	}

	public void setTag_name(String tag_name) {
		this.tag_name = tag_name;
	}

	public String getTarget_commitish() {
		return target_commitish;
	}

	public void setTarget_commitish(String target_commitish) {
		this.target_commitish = target_commitish;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Boolean getDraft() {
		return draft;
	}

	public void setDraft(Boolean draft) {
		this.draft = draft;
	}

	public Boolean getPrerelease() {
		return prerelease;
	}

	public void setPrerelease(Boolean prerelease) {
		this.prerelease = prerelease;
	}
	
}
