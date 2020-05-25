package br.com.roque.integration.release;

import java.util.Objects;

import br.com.roque.integration.conf.EnumValidationException;
import lombok.Getter;

public enum ReleasePathEnum {
	
//	PATH_RELEASE("https://api.github.com/repos/%owner/%repo/releases");
	PATH_RELEASE("/release");
	
	@Getter
	private String path;
	
	private ReleasePathEnum(String path) {
		
		this.path = path;
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
