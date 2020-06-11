package pl.jawegiel.mymvpapp;

import java.util.List;

public interface ViewMvpRest {
    void configureProgressDialog();
    void showProgressDialog();
    void setDataInRecyclerView(List<RestDataModel> userListResponseData);
    void dismissProgressDialogWithSuccess();
    void dismissProgressDialogWithError();
}
