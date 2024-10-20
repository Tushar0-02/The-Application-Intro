package com.example.introo001;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class firebaseController {

    private FirebaseFirestore firestore;


    public firebaseController() {
        firestore = FirebaseFirestore.getInstance();
    }

    public void checkLoginCredentials(String EmailOrPhone, String Password, final LoginCallback callback) {

        firestore.collection("users")
                .document(EmailOrPhone)
                .get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            DocumentSnapshot document = task.getResult();
                            if (document.exists()) {
                                String storedPassword = document.getString("password");
                                if (storedPassword != null && storedPassword.equals(Password)) {
                                    callback.onSuccess(true);
                                } else {
                                    callback.onSuccess(false);
                                }
                            } else {
                                callback.onSuccess(false);
                            }
                        } else {
                            callback.onFailure(task.getException());
                        }
                    }
                });
    }

    // Callback interface for async operations
    public interface LoginCallback {
        void onSuccess(boolean isValid);
        void onFailure(Exception e);
    }
}
