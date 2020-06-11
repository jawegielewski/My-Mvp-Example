package pl.jawegiel.mymvpapp.presenter;

import pl.jawegiel.mymvpapp.model.User;
import pl.jawegiel.mymvpapp.view.ViewMvpSimpleTextView;

public class SimpleTextViewPresenter {
    private ViewMvpSimpleTextView viewMvpSimpleTextView;
    private User user;

    public SimpleTextViewPresenter(ViewMvpSimpleTextView viewMvpSimpleTextView) {
        this.user = new User();
        this.viewMvpSimpleTextView = viewMvpSimpleTextView;
    }

    public void updateUserName(String newName) {
        user.setName(newName);
        viewMvpSimpleTextView.showNewTextView(user.getName());
    }
}
