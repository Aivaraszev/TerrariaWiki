//package com.zevzikovas.aivaras.terraria.activities;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ListView;
//
//import com.zevzikovas.aivaras.terraria.R;
//import com.zevzikovas.aivaras.terraria.adapters.PickaxesListAdapter;
//import com.zevzikovas.aivaras.terraria.models.Pickaxes;
//import com.zevzikovas.aivaras.terraria.repositories.PickaxesRepository;
//import com.zevzikovas.aivaras.terraria.repositories.RepositoryManager;
//
//import java.util.List;
//
//
//public class PickaxesActivity extends Activity {
//
//    ListView pickaxesListView;
//    PickaxesListAdapter pickaxesListAdapter;
//    List<Pickaxes> pickaxe;
//    RepositoryManager repositoryManager;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_pickaxes);
//
//        repositoryManager = new RepositoryManager(this);
//
//        pickaxe = repositoryManager.pickaxesRepository.getAllPickaxe();
//
//        pickaxesListAdapter = new PickaxesListAdapter(this, R.layout.pickaxes_list_item, pickaxe);
//
//        pickaxesListView = findViewById(R.id.PickaxeList);
//        pickaxesListView.setAdapter(pickaxesListAdapter);
//        pickaxesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//                Intent i = new Intent(getApplicationContext(), PickaxesDescriptionActivity.class);
//
//                int pickaxesId = pickaxe.get(position).id;
//                i.putExtra("pickaxesId", pickaxesId);
//
//                startActivity(i);
//            }
//        });
//    }
//}