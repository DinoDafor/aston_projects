package model;

public class ClientsCats {
    private int ClientId;
    private int CatId;

    public ClientsCats(int clientId, int catId) {
        ClientId = clientId;
        CatId = catId;
    }

    public ClientsCats() {

    }

    public int getClientId() {
        return ClientId;
    }

    public void setClientId(int clientId) {
        ClientId = clientId;
    }

    public int getCatId() {
        return CatId;
    }

    public void setCatId(int catId) {
        CatId = catId;
    }
}
