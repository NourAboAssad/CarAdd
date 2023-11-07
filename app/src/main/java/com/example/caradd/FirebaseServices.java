package com.example.caradd;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthMultiFactorException;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;

public class FirebaseServices {
  private static FirebaseServices instance;
  private FirebaseAuth auth;
  private FirebaseFirestore fire;

  private FirebaseStorage storge;

  public FirebaseFirestore getFire() {
        return fire;
    }
  public FirebaseAuth getAuth() {
        return auth;
    }
  public FirebaseStorage getStorge() {
        return storge;
    }

  public FirebaseServices()
    {
        auth=FirebaseAuth.getInstance();
        fire=FirebaseFirestore.getInstance();
        storge=FirebaseStorage.getInstance();
    }
  public static FirebaseServices getInstance() {
      if (instance == null) {
          instance = new FirebaseServices();
      }
      return instance;
  }
}
