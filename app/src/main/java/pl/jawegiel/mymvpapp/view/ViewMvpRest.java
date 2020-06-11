package pl.jawegiel.mymvpapp.view;

import java.util.List;

import pl.jawegiel.mymvpapp.model.RestDataModel;

public interface ViewMvpRest {
    void configureProgressDialog();
    void showProgressDialog();
    void setDataInRecyclerView(List<RestDataModel> userListResponseData);
    void dismissProgressDialogWithSuccess();
    void dismissProgressDialogWithError();
}
