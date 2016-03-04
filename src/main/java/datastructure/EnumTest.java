package datastructure;

import com.google.common.base.Enums;

/**
 * Created by agupta2 on 3/1/16.
 */
public class EnumTest {

    public static void main(String[] args){

        System.out.println("Hello Enum: " + OntologyType.RXNORM.value.toString());
        //System.out.println("Hello Enum: " + OntologyType.valueOf(OntologyType.class, "RxNorm"));
        System.out.println("Hello Enum: " + EnumUtil.from(OntologyType.class,"RxNorm"));
        System.out.println("Enum location: " + OntologyType.RXNORM.value);
        System.out.println("String: "+OntologyType.RXNORM);
    }


    public enum OntologyType {
        SNOMEDCT("SNOMEDCT"),
        HPO("HPO"),
        OMIM("OMIM"),
        ICD10("ICD10"),
        ICD9("ICD9"),
        CUSTOM("CUSTOM"),
        GEL("GEL"),
        ICD9CM("ICD9CM"),
        ICD10CM("ICD10CM"),
        JUPITER("JUPITER"),
        RXNORM("RxNorm")
        ;
        public String value;

        OntologyType(){}

        OntologyType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }


    }

}


