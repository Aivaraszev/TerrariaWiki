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
//import com.zevzikovas.aivaras.terraria.adapters.HswordsListAdapter;
//import com.zevzikovas.aivaras.terraria.models.Hswords;
//import com.zevzikovas.aivaras.terraria.repositories.HSwordsRepository;
//
//import java.util.List;
//
//
//public class PickaxeActivity extends Activity {
//
//    ListView pickaxesListView;
//    PickaxesListAdapter pickaxesListAdapter;
//    List<Pickaxes> pickaxe;
//    PickaxesRepository pickaxeRepository;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_pickaxes);
//
//        pickaxeRepository = new PickaxesRepository(this);
//
//        pickaxe = pickaxeRepository.getAllPickaxe();
//
//        pickaxesListAdapter = new PickaxessListAdapter(this, R.layout.pickaxes_list_item, pickaxe);
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