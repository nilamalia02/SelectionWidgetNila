package com.example.selectionwidgetnila;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AliasActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.selectionwidgetnila.R;

import java.text.DateFormatSymbols;
public class MainActivity extends AppCompatActivity {
    /*membuat array list data makanan, data buah, dan data minuman*/

    String[] data_makanan = {"Mie Goreng","Mie Kuah","Tempe Penyet","Pecel" , "Lalapan" ,"Ayam Geprek", "Soto", "Bakso",
            "Mie Ayam", "Seblak", "Rawon" };
    ListView listview;

    String[] data_minuman = {"Es Teh","Es Campur","Dawet","Soda Gembira","Es Tebu" , "Kopi" , "Cocacola", "Es Buah",
            "Lemon Tea", "Es Jeruk"};
    Spinner spinner;

    String[] data_buah = {"Apel","Anggur","Alpukat","Belimbing","Bengkuang","Ceri", "Cermai","Durian","Duku", "Jambu",
            "Jeruk","Kedondong","Kelengkeng","Leci", "Lemon","Mangga", "Manggis","Nanas","Nangka","Pepaya","Pisang",
            "Pir","Rambutan","Rasberi","Sawo","Semangka","Salak"};
    AutoCompleteTextView autoCompleteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //menginputkan data array
        listview = findViewById(R.id.listmakanan);
        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item, data_makanan);

        spinner= findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapterspinner = new ArrayAdapter(this, android.R.layout.simple_spinner_item, data_minuman);
        listview.setAdapter(adapter);
        spinner.setAdapter(adapterspinner);

        autoCompleteTextView = findViewById(R.id.buah);
        ArrayAdapter<CharSequence> adapteractv = new ArrayAdapter(this, android.R.layout.simple_spinner_item, data_buah);
        listview.setAdapter(adapter);
        autoCompleteTextView.setAdapter(adapteractv);

        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //membuat onclick sehingga saat menekan data mucul verifikasi
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), " Anda Memilih : " + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }
        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(getApplicationContext(), " Anda Memilih : " + adapterView.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), " Anda Memilih : " + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
}