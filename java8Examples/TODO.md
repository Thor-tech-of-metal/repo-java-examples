1)  Hacer import static uk.gov.hmcts.ccd.config.JacksonUtils.MAPPER;
2)  Hacer generics en metodos ejemplos tipo como en scala 



public static <T> T convertGenericValue(Object from) {
        return MAPPER.convertValue(from, getNewTypeReference());
    }

    public static final <T> TypeReference<T> getNewTypeReference() {
        return new TypeReference<T>() {
        };
    }
