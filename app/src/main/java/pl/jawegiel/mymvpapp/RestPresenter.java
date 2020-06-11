package pl.jawegiel.mymvpapp;

public class RestPresenter {
    private RestData restData;
    private ViewMvpRest viewMvpRest;

    public RestPresenter(ViewMvpRest viewMvpRest) {
        restData = new RestData();
        this.viewMvpRest = viewMvpRest;
    }

    public void updateRestDataResponse() {
        viewMvpRest.configureProgressDialog();
        viewMvpRest.showProgressDialog();
        restData.getRestDataList(viewMvpRest);
    }
}
