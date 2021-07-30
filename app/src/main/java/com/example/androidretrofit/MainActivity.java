package com.example.androidretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.androidretrofit.interfaces.ProductoAPI;
import com.example.androidretrofit.models.Producto;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    EditText edtCodigo;
    TextView tvNombre;
    TextView tvDescripcion;
    TextView tvPrecio;
    ImageView imgProducto;
    Button btnBuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtCodigo=findViewById(R.id.edtCodigo);
        tvNombre=findViewById(R.id.tvNombre);
        tvDescripcion=findViewById(R.id.tvDescripcion);
        tvPrecio=findViewById(R.id.tvPrecio);
        imgProducto=findViewById(R.id.imgProducto);
        btnBuscar=findViewById(R.id.btnBuscar);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                find(edtCodigo.getText().toString());

            }
        });
    }
    private void find(String codigo){
        Retrofit retrofit=new Retrofit.Builder().baseUrl("")
                .addConverterFactory(GsonConverterFactory.create()).build();

        ProductoAPI productoAPI=retrofit.create(ProductoAPI.class);
        Call<Producto> call=productoAPI.find(codigo);
        call.enqueue(new Callback<Producto>() {
            @Override
            public void onResponse(Call<Producto> call, Response<Producto> response) {
                try {

                    if (response.isSuccessful()){
                        Producto P=response.body();
                        String URL_IMG=""+P.getPro_codigo()+".JPG";
                        tvNombre.setText(P.getPro_nombre());
                        tvDescripcion.setText(P.getPro_descripcion());
                        tvPrecio.setText(P.getPro_precio().toString());
                        Glide.with(getApplication()).load(URL_IMG).into(imgProducto);

                    }

                }catch (Exception ex){
                    Toast.makeText(MainActivity.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Producto> call, Throwable t) {
                Toast.makeText(this, "Error de conexión", Toast.LENGTH_SHORT).show();

            }
        });
    }

}