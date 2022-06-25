package com.emrizkiem.myfirstapps.learn.room.ui.insert;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.emrizkiem.myfirstapps.R;
import com.emrizkiem.myfirstapps.databinding.ActivityNoteAddUpdateBinding;
import com.emrizkiem.myfirstapps.learn.room.database.Note;
import com.emrizkiem.myfirstapps.learn.room.utils.DateHelper;
import com.emrizkiem.myfirstapps.learn.room.utils.ViewModelFactory;

public class NoteAddUpdateActivity extends AppCompatActivity {

    public static final String EXTRA_NOTE = "extra_note";
    private final int ALERT_DIALOG_CLOSE = 10;
    private final int ALERT_DIALOG_DELETE = 20;

    private boolean isEdit = false;
    private Note note;

    private NoteAddUpdateViewModel viewModel;
    private ActivityNoteAddUpdateBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNoteAddUpdateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = obtainViewModel(NoteAddUpdateActivity.this);

        note = getIntent().getParcelableExtra(EXTRA_NOTE);
        if (note != null) {
            isEdit = true;
        } else {
            note = new Note();
        }

        String actionBarTitle;
        String btnTitle;

        if (isEdit) {
            actionBarTitle = getString(R.string.change);
            btnTitle = getString(R.string.update);

            if (note != null) {
                binding.edtTitle.setText(note.getTitle());
                binding.edtDescription.setText(note.getDescription());
            }
        } else {
            actionBarTitle = getString(R.string.add);
            btnTitle = getString(R.string.save);
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(actionBarTitle);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        binding.btnSubmit.setText(btnTitle);
        btnClicked();
    }

    private void btnClicked() {
        binding.btnSubmit.setOnClickListener(view -> {
            String title = binding.edtTitle.getText().toString().trim();
            String description = binding.edtDescription.getText().toString().trim();

            if (title.isEmpty()) {
                binding.edtTitle.setError(getString(R.string.empty));
            } else if (description.isEmpty()) {
                binding.edtDescription.setError(getString(R.string.empty));
            } else {
                note.setTitle(title);
                note.setDescription(description);

                if (isEdit) {
                    viewModel.update(note);
                    showToast(getString(R.string.changed));
                } else {
                    note.setDate(DateHelper.getCurrentDate());
                    viewModel.insert(note);
                    showToast(getString(R.string.added));
                }
                finish();
            }
        });
    }

    private void showToast(String msg) {
        Toast toast = new Toast(getApplicationContext());

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast_success, findViewById(R.id.toastSuccess));

        TextView textView = layout.findViewById(R.id.tvMessage);
        textView.setText(msg);

        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0, 0);
        toast.setView(layout);
        toast.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (isEdit) {
            getMenuInflater().inflate(R.menu.menu_delete, menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.actionDelete) {
            showAlertDialog(ALERT_DIALOG_DELETE);
        } else if (item.getItemId() == androidx.appcompat.R.id.home) {
            showAlertDialog(ALERT_DIALOG_CLOSE);
        } else {
            return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }

    private void showAlertDialog(int type) {
        final boolean isDialogClose = type == ALERT_DIALOG_CLOSE;
        String dialogTitle, dialogMsg;

        if (isDialogClose) {
            dialogTitle = getString(R.string.cancel);
            dialogMsg = getString(R.string.message_cancel);
        } else {
            dialogTitle = getString(R.string.delete);
            dialogMsg = getString(R.string.message_delete);
        }

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle(dialogTitle);
        alert.setMessage(dialogMsg)
                .setCancelable(false)
                .setPositiveButton(getString(R.string.yes), (dialog, id) -> {
                    if (!isDialogClose) {
                        viewModel.delete(note);
                        showToast(getString(R.string.deleted));
                    }
                    finish();
                })
                .setNegativeButton(getString(R.string.no), (dialog, id) -> {
                    dialog.cancel();
                });

        AlertDialog alertDialog = alert.create();
        alertDialog.show();
    }

    @Override
    public void onBackPressed() {
        showAlertDialog(ALERT_DIALOG_CLOSE);
    }

    @NonNull
    private static NoteAddUpdateViewModel obtainViewModel(AppCompatActivity activity) {
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        return new ViewModelProvider(activity, factory).get(NoteAddUpdateViewModel.class);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}