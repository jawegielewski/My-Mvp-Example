package pl.jawegiel.mymvpapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewMvpSimpleTextView, ViewMvpRest {

    private TextView textView;
    private ProgressDialog progressDialog;
    private SimpleTextViewPresenter simpleTextViewPresenter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        textView = findViewById(R.id.tv);
        EditText editText = findViewById(R.id.et);
        progressDialog = new ProgressDialog(MainActivity.this);
        simpleTextViewPresenter = new SimpleTextViewPresenter(this);
        RestPresenter restPresenter = new RestPresenter(this);

        restPresenter.updateRestDataResponse();

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                simpleTextViewPresenter.updateUserName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    @Override
    public void setDataInRecyclerView(List<RestDataModel> userListResponseData) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        UsersAdapter usersAdapter = new UsersAdapter(MainActivity.this, userListResponseData);
        recyclerView.setAdapter(usersAdapter);
    }

    @Override
    public void showNewTextView(String text) {
        textView.setText(text);
    }


    @Override
    public void configureProgressDialog() {
        progressDialog.setCancelable(false); // set cancelable to false
        progressDialog.setMessage("Please Wait"); // set message
    }

    @Override
    public void showProgressDialog() {
        progressDialog.show();
    }

    @Override
    public void dismissProgressDialogWithSuccess() {
        progressDialog.dismiss();
        Toast.makeText(MainActivity.this, "ok", Toast.LENGTH_LONG).show();
    }

    @Override
    public void dismissProgressDialogWithError() {
        progressDialog.dismiss();
        Toast.makeText(MainActivity.this, "error", Toast.LENGTH_LONG).show();
    }
}