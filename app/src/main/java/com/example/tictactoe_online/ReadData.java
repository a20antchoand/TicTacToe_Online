package com.example.tictactoe_online;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

public interface ReadData {

    /**
     * Funcio per recuperar un unic document
     *
     * @param docRef referencia del document
     * @param action acció a fer un cop es reben les dades
     */
    default void getOneDocument(DocumentReference docRef, OnCompleteListener<DocumentSnapshot> action) {

        docRef.get().
                addOnCompleteListener(action);

    }

    default void getListenerDocument(Query docRef, EventListener<QuerySnapshot> action) {

        docRef.
                addSnapshotListener(action);

    }


    /**
     * Funcio per agafar multiples documnets de firebase
     *
     * @param query query amb les caracteristiques dels documents
     * @param action acció a fer un cop es reben les dades
     */
    default void getMultipldeDocuments(Query query, OnCompleteListener<QuerySnapshot> action) {

        query.get()
                .addOnCompleteListener(action);


    }



}