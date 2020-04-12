package br.com.roque.integration.release;

import java.util.Objects;

import br.com.roque.integration.conf.EnumValidationException;

public enum ReleasePathEnum {
	
	PATH_RELEASE("https://api.github.com/repos/%owner/%repo/releases");
	
	private String path;
	
	private ReleasePathEnum(String path) {
		
		this.path = path;
	}

	public String getPath() {
		return path;
	}

	public static String getPath(String path) throws EnumValidationException {
		
		if (Objects.isNull(path)) 
			throw new EnumValidationException(path, "ReleasePathEnum");
		
		for (ReleasePathEnum r : ReleasePathEnum.values()) {
			
			if (path.equals(r.name())) 
				return r.getPath();
		}
		
		throw new EnumValidationException(path, "ReleasePathEnum");
	}
}
