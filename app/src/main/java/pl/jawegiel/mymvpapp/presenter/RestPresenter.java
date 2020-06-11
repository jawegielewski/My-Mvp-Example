package pl.jawegiel.mymvpapp.presenter;

import pl.jawegiel.mymvpapp.model.RestData;
import pl.jawegiel.mymvpapp.view.ViewMvpRest;

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
