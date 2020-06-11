package pl.jawegiel.mymvpapp.model;

import java.util.ArrayList;
import java.util.List;

import pl.jawegiel.mymvpapp.Api;
import pl.jawegiel.mymvpapp.view.ViewMvpRest;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class RestData {

    private List<RestDataModel> userListResponseData;

    public void getRestDataList(final ViewMvpRest viewMvpRest) {
        Api.getClient().getUsersList(new Callback<List<RestDataModel>>() {

            @Override
            public void success(List<RestDataModel> userListResponses, Response response) {
                viewMvpRest.dismissProgressDialogWithSuccess();
                userListResponseData = userListResponses;
                viewMvpRest.setDataInRecyclerView(userListResponseData);
            }

            @Override
            public void failure(RetrofitError error) {
                viewMvpRest.dismissProgressDialogWithError();
                userListResponseData = new ArrayList<>();
            }
        });
    }
}
