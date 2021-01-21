package pl.javastart.bootcamp.lekcia21zadaniespringmvcprodukty;

public enum Category {

    GROCERIES("spozywcze"),
    HOUSEHOLD_ITEMS("domowe"),
    OTHER("inne");

    private String value;

    Category(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
