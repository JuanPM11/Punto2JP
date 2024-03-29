package com.example.punto2jp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.Toast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MyAdapter myAdapter;
    private RecyclerView myRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            GetData service = RetrofitClient.getRetrofitInstance().create(GetData.class);

            Call<List<RetroUsers>> call = service.getAllUsers();

            call.enqueue(new Callback<List<RetroUsers>>() {

                @Override
                public void onResponse(Call<List<RetroUsers>> call, Response<List<RetroUsers>> response) {
                    loadDataList(response.body());
                }
                @Override
                public void onFailure(Call<List<RetroUsers>> call, Throwable throwable) {
                    Toast.makeText(MainActivity.this, "No se puede cargar los datos", Toast.LENGTH_SHORT).show();
                }
            });
        }
        private void loadDataList(List<RetroUsers> usersList) {
            myRecyclerView = findViewById(R.id.myRecyclerView);
            myAdapter = new MyAdapter(usersList);

            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
            myRecyclerView.setLayoutManager(layoutManager);
            myRecyclerView.setAdapter(myAdapter);
    }
}
