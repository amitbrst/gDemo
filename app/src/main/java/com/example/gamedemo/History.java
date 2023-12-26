package com.example.gamedemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.gamedemo.adapter.HistoryListAdapter;
import com.example.gamedemo.models.HistoryList;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class History extends AppCompatActivity {
    private RecyclerView recyclerView;
    HistoryListAdapter adapter; // Create Object of the Adapter class
    FirebaseFirestore mbase;
    List<HistoryList> HL=new ArrayList<HistoryList>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        Initt();
    }

    void Initt(){
        mbase= FirebaseFirestore.getInstance();
        CollectionReference Coll = mbase.collection("SpinnerTimerBools").document("TeenPatti").collection("Results");
        Query QC=Coll.orderBy("time", Query.Direction.DESCENDING).limit(10);

        QC.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                List<DocumentSnapshot> DOCS =queryDocumentSnapshots.getDocuments();
                for (DocumentSnapshot D:DOCS) {
                    HistoryList TempHL=new HistoryList("Fail",R.drawable.historyfailbg,"Fail",R.drawable.historyfailbg,"Fail",R.drawable.historyfailbg);
                    long Res= (long) D.get("Area");
                    int A=(int)Res;
                    if(1 == A)
                    {
                        TempHL.setB1("Win");
                        TempHL.setWF1(R.drawable.historywinbg);
                    }
                    else  if(2 == A)
                    {
                        TempHL.setB2("Win");
                        TempHL.setWF2(R.drawable.historywinbg);
                    }
                    else  if(3 == A)
                    {
                        TempHL.setB3("Win");
                        TempHL.setWF3(R.drawable.historywinbg);
                    }
                    HL.add(TempHL);
                }
                adapter=new HistoryListAdapter(HL);
                Done();
            }
        });
    }
    void Done()
    {
        recyclerView = findViewById(R.id.historyview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}