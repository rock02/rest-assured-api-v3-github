package br.com.roque.integration.release;

import br.com.roque.integration.conf.EnumValidationException;
import lombok.Getter;

import java.util.Objects;

public enum ReleasePathEnum {
    PATH_RELEASE("/release");
    @Getter
    private String path;


    ReleasePathEnum(String path){
        this.path = path;
    }

    public static String getPath( String path) throws EnumValidationException {
        if( Objects.isNull(path)){
            throw new EnumValidationException( path, "ReleasePathEnum" );
        }
        for (ReleasePathEnum r: ReleasePathEnum.values()){
            if ( path.equalsIgnoreCase( r.name() )){
                return r.getPath();
            }
        }
        throw new EnumValidationException( path, "Não localizado path na ReleasePathEnum" );
    }

}
