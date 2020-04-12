package br.com.roque.integration.login;

import java.util.Objects;

import br.com.roque.integration.conf.EnumValidationException;

public enum LoginPathEnum {

	PATH_LOGIN("https://api.github.com");

	private String path;

	LoginPathEnum(String path) {

		this.path = path;
	}

	public String getPath() {
		return path;
	}

	public static String getPath(String path) throws EnumValidationException {

		if (Objects.isNull(path))
			throw new EnumValidationException(path, "LoginPathEnum");

		for (LoginPathEnum p : LoginPathEnum.values()) {

			if (path.equals(p.name()))
				return p.getPath();

		}

		throw new EnumValidationException(path, "LoginPathEnum");
	}
}
